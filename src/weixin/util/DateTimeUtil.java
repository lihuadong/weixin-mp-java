/**
 * 
 * 微信-公众号-封装接口JAVA版本
 * weixin.util
 * Utils.java
 * Ver0.0.1
 * 2016年6月20日-下午4:41:07
 * 2014-2019 全智道(北京)科技有限公司
 * 
 */
package weixin.util;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 
 * Utils
 * 
 * 李华栋
 * 李华栋
 * 2016年6月20日 下午4:41:07
 * 
 * @version 0.0.1
 * 
 */
public class DateTimeUtil {

	/**
	 * 获取当前时间(yyyyMMddHHmmss)
	 * @return String	当前时间戳
	 */
	public static String getCurrentTime(){
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
		return format.format(new Date());
	}
	
	/**
	 * 获取当前时间线程安全(yyyyMMddHHmmss)
	 * @return String	当前时间戳
	 */
	public static String getLocalCurrentTime(){
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter =   DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return localDateTime.format(dateTimeFormatter);
	}
	
	/**
	 * 获取当前日期
	 * @return String
	 */
	public static String getLocalDate(){
		LocalDate localDate = LocalDate.now();
		DateTimeFormatter dateTimeFormatter =   DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return localDate.format(dateTimeFormatter);
	}
	
	/**
	 * 获取当前时间
	 * @return String
	 */
	public static String getLocalTime(){
		LocalTime localTime = LocalTime.now();
		DateTimeFormatter dateTimeFormatter =   DateTimeFormatter.ofPattern("HH:mm:ss");
		return localTime.format(dateTimeFormatter);
	}
	
	/**
	 * 获取当前时间-秒
	 * @return String
	 */
	public static String getLocalSecond(){
		Instant instant = Instant.now();
		long currentSecond = instant.getEpochSecond();
		return String.valueOf(currentSecond);
	}
	
	/**
	 * 获取当前时间-毫秒
	 * @return String
	 */
	public static String getLocalMilli(){
		Instant instant = Instant.now();
		long currentMilli = instant.toEpochMilli();
		return String.valueOf(currentMilli);
	}
	
	
	
}
