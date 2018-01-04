/**
 * 包打听全知道-微信H5版本
 * weixin.util
 * Utils.java
 * Ver0.0.1
 * 2016年6月20日-下午4:41:07
 *  2016全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

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
public class Utils {

	
	/**
	 * 获取当前时间(yyyyMMddHHmmss)
	 * @return String	当前时间戳
	 */
	public static String getCurrentTime(){
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
		return format.format(new Date());
	}
	
	/**
	 * 返回随机字符串
	 */
	public static String getNonce_str() {
		String nonce_str_temp = UUID.randomUUID().toString();
		return nonce_str_temp.substring(0, 32);
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
