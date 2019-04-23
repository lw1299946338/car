package com.example.car.redis;
/**
 * Redis缓存常量（数据类型，超时时间）
 * @author zhanghb
 *
 */
public class RedisKeyConstant {


	

	/**
	 * 短信发送url
	 */
	public static final  String KEY_DATATYPE_SENDMSG_URL = "SENDMSG_URL_";
	/**
	 * 短信验证码
	 */
	public static final  String KEY_DATATYPE_SENDMSG_VERIFICATIONCODE = "SENDMSG_VERIFICATIONCODE_";
	/**
	 * 重发发送短信锁定次数
	 */
	public static final  String KEY_DATATYPE_SENDMSG_LOCKCOUNT = "SENDMSG_LOCKCOUNT_";
	
	/**
	 * 其它
	 */
	public static final  String KEY_DATATYPE_OTHER = "OTHER";
	
	/**
	 * overtime
	 */
	
	/**
	 * 2分钟
	 */
	public static final  int OVERTIME_TWO_MINUTES=2*60;
	/**
	 * 10分钟
	 */
	public static final  int OVERTIME_TEN_MINUTES=10*60;
	/**
	 * 25分钟
	 */
	public static final  int OVERTIME_TWENTY_FIVE_MINUTES=25*60;
	/**
	 * 30分钟
	 */
	public static final  int OVERTIME_THIRTY_MINUTES=30*60;
	
	/**
	 * 1小时
	 */
	public static final  int OVERTIME_ONE_HOURS=1*60*60;
	/**
	 * 2小时
	 */
	public static final  int OVERTIME_TWO_HOURS=2*60*60;
	/**
	 * 3小时
	 */
	public static final  int OVERTIME_THREE_HOURS=3*60*60;
	
	/**
	 * 6小时
	 */
	public static final  int OVERTIME_SIX_HOURS=6*60*60;
	
}
