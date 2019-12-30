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
import java.util.Date;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

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
public class TimeUtils {

	/**
	 * 获取当前时间(yyyyMMddHHmmss)
	 * @return String	当前时间戳
	 */
	public static String getCurrentTime(){
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
		return format.format(new Date());
	}
	
	
	
	/**
	 * 转换为XML格式字符串
	 * @return String	XML格式字符串
	 */
	public static String getXMLType(Element e){
		Document doc = new Document(e); 
		XMLOutputter XMLOut = new XMLOutputter();  
		return XMLOut.outputString(doc);
	}
}
