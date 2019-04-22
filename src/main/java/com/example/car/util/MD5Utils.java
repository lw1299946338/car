package com.example.car.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;


public class MD5Utils {

    private static Logger logger = LoggerFactory.getLogger(MD5Utils.class);

    public static String md5(String str) {
        MessageDigest md5;
        String msg="";
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] md5bytes = md5.digest(str.getBytes("ISO-8859-1"));
            StringBuilder sb = new StringBuilder(str.length()*4);
            for (byte b : md5bytes){
                String tmp = Integer.toHexString(b & 0xff);
                if(tmp.length()==1){
                    sb.append("0");
                }
                sb.append(tmp);
            }
            msg=sb.toString().toLowerCase();
        } catch (Exception e) {
            logger.error("md5加密异常",e);
        }
        return msg;
    }

    /***
     * MD5加码 生成32位md5码
     */
    public static String string2MD5(String inStr){
        MessageDigest md5 = null;
        try{
            md5 = MessageDigest.getInstance("MD5");
        }catch (Exception e){
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++){
            byteArray[i] = (byte) charArray[i];  }
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++){
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }

    /**
     * 加密解密算法
     */
    public static String convertMD5(String inStr){

        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++){
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;

    }



}
