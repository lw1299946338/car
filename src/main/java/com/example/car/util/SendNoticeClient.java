package com.example.car.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

/**
 * 短信接口通知
 */
@Component
public class SendNoticeClient {

    private static final Log logger = LogFactory.getLog(SendNoticeClient.class);
    private String charset = "utf-8";
    private String contentSign ="【聚宝小贷】";
    private static int iReadTimeOut = 3000;// default time out
    private static int iConnTimeOut = 1500;// default time out

    /*
     * webservice服务器定义
     */
    // 配置的参数
    //软件序列号
    @Value("${asmx.sn}")
    private String sn;
    //密码
    @Value("${asmx.password}")
    private String password;
    // 扩展码(否)
    @Value("${asmx.ext}")
    private String ext;
    //定时时间(否)
    @Value("${asmx.stime}")
    private String  stime;
    //唯一标志(否)
    @Value("${asmx.rrid}")
    private String  rrid;
    //内容编码(否)
    @Value("${asmx.msgfmt}")
    private String  msgfmt;

    // 短信接口地址
    @Value("${asmx.serviceURL}")
    private String serviceURL;
    @Value("${asmx.soapAction}")
    private  String soapAction;
    private String pwd = "";// 密码

    /**
     * 字符串MD5加密
     * @param sourceStr 待转换字符串
     * @return 加密之后字符串
     */
    public String getMD5(String sourceStr) {
        String resultStr = "";
        try {
            byte[] temp = sourceStr.getBytes();
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(temp);
            byte[] b = md5.digest();
            for (int i = 0; i < b.length; i++) {
                char[] digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
                        '9', 'A', 'B', 'C', 'D', 'E', 'F' };
                char[] ob = new char[2];
                ob[0] = digit[(b[i] >>> 4) & 0X0F];
                ob[1] = digit[b[i] & 0X0F];
                resultStr += new String(ob);
            }
            return resultStr;
        } catch (Exception e) {
            logger.error(e);
            return null;
        }
    }

    /**
     *
     * @param urlString
     * @return
     * @throws Exception
     */
    public String doPost(String urlString) throws Exception {
        String sData = urlString.substring(urlString.indexOf("?") + 1);
        byte[] data = sData.getBytes();
        String realurl = urlString.substring(0, urlString.indexOf("?"));
        URL url = new URL(realurl);
        HttpURLConnection httpURLConnection = getConnection(url);
        httpURLConnection.setReadTimeout(iReadTimeOut);
        httpURLConnection.setConnectTimeout(iConnTimeOut);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Accept-Charset", charset);
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(sData.length()));
        OutputStream outputStream = null;
        StringBuffer resultBuffer = new StringBuffer("");
        InputStream input = null;
        try {
            outputStream = httpURLConnection.getOutputStream();
            outputStream.write(data);
            outputStream.flush();
            if (httpURLConnection.getResponseCode() >= 300) {
                throw new RuntimeException("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (HttpURLConnection.HTTP_OK == responseCode) {
                input = httpURLConnection.getInputStream();
            } else {
                logger.info(String.format("响应码[%s],当前URL请求异常[%s]", responseCode, url));
                input = null;
            }
            if (input == null) {
                throw new RuntimeException("inputstream is null");
            }

            byte[] buf = new byte[1024];
            for (int n; (n = input.read(buf)) != -1;) {
                resultBuffer.append(new String(buf, 0, n, "UTF-8"));
            }


        }catch(Exception e){
            logger.error(String.format("Http connect Excception【%s】", e.getMessage()));
        }finally {

            if (outputStream != null) {
                outputStream.close();
            }
            if (input!= null) {
                input.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
                httpURLConnection = null;
            }
        }

        return resultBuffer.toString();
    }

    /**
     *
     * @param url
     * @return
     * @throws IOException
     */
    private static HttpURLConnection getConnection(URL url) throws IOException {
        HttpURLConnection conn = null;
        conn = (HttpURLConnection) url.openConnection();
        return conn;
    }

    /**
     *
     * @param phoneNumberList 手机号列表
     * @param templateContent 通知标题
     * @return
     */
    public String generateSMSRequest(List<String> phoneNumberList, String templateContent) {
        //发送多个手机号
        if (phoneNumberList == null || phoneNumberList.size() == 0) {
            logger.error("手机号为空");
        }
        if (StringUtils.isBlank(templateContent)) {
            logger.error("要发送的内容为空");
        }
        StringBuffer requestURL = new StringBuffer();//请求的完整url
        String contentStr="";//要发送的内容
        this.pwd = this.getMD5(sn + password);
        try {
            if (phoneNumberList.size() == 1) {
                // 单条手机号码时短信请求
                requestURL.append(serviceURL).append("?mobile=").append(phoneNumberList.get(0));
            } else {
                // 发送批量短信时的请求
                StringBuffer phoneBuffer = new StringBuffer();
                for (String phone : phoneNumberList) {
                    phoneBuffer.append(phone).append(",");
                }
                // 去除最后的逗号
                requestURL.append(serviceURL).append("?mobile=").append(phoneBuffer.substring(0, phoneBuffer.length()-1));
            }
            contentStr = templateContent + contentSign;
            String content = URLEncoder.encode(contentStr, "UTF-8");
            requestURL.append("&content=").append(content);
            requestURL.append("&sn=").append(this.sn).append("&pwd=").append(this.pwd)
                    .append("&ext=").append(this.ext).append("&stime=").append(this.stime)
                    .append("&rrid=").append(this.rrid).append("&msgfmt=").append(this.msgfmt);

        } catch (UnsupportedEncodingException e) {
            logger.error("can not find utf-8 charset ", e);
        }

        return requestURL.toString();
    }

    /**
     * 发送短剑验证码
     * @param phoneNumberList 短发信息的手机号,列表
     * @param templateName    通知标题
     * @param templateContent 通知内容
     * @return
     */
    public String sendMessage(List<String> phoneNumberList, String templateName, String templateContent){
        String urlString = generateSMSRequest(phoneNumberList,templateContent);
        logger.info("POST url : " + urlString);
        String result="";
        try {
            result = doPost(urlString);
        } catch (Exception e) {
            logger.error(e);
        }
        return result;
    }


    /**
     * 测试短信接口
     * @param args
     */
    public static void main(String[] args) {
        SendNoticeClient sendNoticeClient = new SendNoticeClient();
        List<String> phoneNumberList = new ArrayList<>();
        phoneNumberList.add("15010050865");
        String templateName = "客户验证码";
        String templateContent = "验证码为(2342)，(30秒内有效)。请勿向任何人提供您收到的验证码";
        String message = sendNoticeClient.sendMessage(phoneNumberList, templateName, templateContent);
        System.out.print(message);
    }

}
