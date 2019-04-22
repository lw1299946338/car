package com.example.car.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	public static void main(String[] args) {
		String dxmb = smsCode("DXMB", "35");
		System.out.println(dxmb);
		System.out.println(getSerialNumber(10,4));
	}

	public static String smsCode(String className,String count){
		DecimalFormat df=new DecimalFormat("0000");
		StringBuffer sb = new StringBuffer();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String format = sdf.format(date);
		sb.append(className);
		sb.append(format);
		sb.append(df.format(Integer.parseInt(count)));
		return sb.toString();
	}


	/**
	 * 生成流水号
	 * @param code 流水号
	 * @param digits 流水号位数
	 * @return
	 */
	public static String getSerialNumber(int code, int digits){
		return getSerialNumber("", code, digits);
	}

	/**
	 * 生成流水号
	 * @param prefix 流水号前缀
	 * @param code 流水号
	 * @param digits 流水号位数
	 * @return
	 */
	public static String getSerialNumber(String prefix, int code, int digits){
		// 得到一个NumberFormat的实例
		NumberFormat nf = NumberFormat.getInstance();
		// 设置是否使用分组
		nf.setGroupingUsed(false);
		// 设置最大整数位数
		nf.setMaximumIntegerDigits(digits);
		// 设置最小整数位数
		nf.setMinimumIntegerDigits(digits);
		// 设置时间格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		return prefix + sdf.format(new Date()) + nf.format(code);
	}


	public static boolean isBlank(String str){
		return str == null || str.trim().length()<=0;
	}
	/**
	 * 为空返回true  不为空返回false
	  * TODO
	  * @CreateTime: 2017年6月12日 上午9:26:06
	  * @UpdateTime: 2017年6月12日 上午9:26:06
	  * @param object
	  * @return
	 */
	public static boolean isBlank(Object object){
		boolean flag = false;
        if (null == object) {
            flag = true;
        } else {
            if(isBlank(String.valueOf(object))){
            	 flag = true;
            }
        }
        return flag;
	}
	
	public static boolean isNotBlank(String str){
		return str != null && str.trim().length()>0; 
	}
	
	/**
	 * 格式化字符串
	 */
	public static String formatString(String text) {
		return (text == null ? "" : text.trim());
	}

	/**
	 * String2Integer
	 */
	public static int string2Int(String text) throws NumberFormatException {
		return text == null ? 0 : Integer.valueOf(text);
	}

	/**
	 * 处理字符串：隐藏部分内容
	 * @param text	目标字符串
	 * @param leftShowCount 左边显示位数
	 * @param rightShowCount 右边显示位数
	 * @return
	 */
	public static String hideString(String text, int leftShowCount, int rightShowCount) {
		StringBuffer sb = new StringBuffer();
		if(text != null && text.length() >= leftShowCount + rightShowCount ){
			sb.append(text.substring(0, leftShowCount));
			for (int i = 0; i < text.length() - leftShowCount - rightShowCount; i++) {
				sb.append("*");
			}
			sb.append(text.substring(text.length() - rightShowCount));
		}
		return sb.toString();
	}
	
	/**处理姓名*/
	public static String handleName(String text){
		return StringUtils.hideString(text, 0, 1);
	}
	
	/**处理证件号*/
	public static String handleIdCardNo(String text){
		return StringUtils.hideString(text, 2, 2);
	}
	
	/**处理银行卡号*/
	public static String handleBankCardNo(String text){
		return StringUtils.hideString(text, 3, 3);
	}
	
	/**处理手机号*/
	public static String handlePhoneNo(String text){
		return StringUtils.hideString(text, 0, 2);
	}
	
	/**
	  * @Description: 去空格
	  * @Param
	  * @Return String
	  * @Author:youhuiran
	  * @Datetime 2016年12月4日 下午10:04:36
	 */
	public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }
	
	public static String listToString(List<String> list, char separator) {
		if(list==null || list.size()<=0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append(separator);
		}
		return sb.toString().substring(0, sb.toString().length() - 1);
	}

    public static String getUUID() {

        return UUID.randomUUID().toString().replace("-","");
    }
}
