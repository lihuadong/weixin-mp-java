/**
 * 
 * 微信-公众号-封装接口JAVA版本
 * weixin.shorturl
 * ShortUrlManager.java
 * Ver0.0.1
 * 2016年6月27日-下午3:17:14
 * 2014-2019 ©全智道(北京)科技有限公司
 * 
 */
package weixin.shorturl;

import org.json.JSONException;
import org.json.JSONObject;

import weixin.util.HTTPSDataManager;

/**
 * 
 * ShortUrlManager
 * 需要转换的长链接，支持http://、https://、weixin://wxpay 格式的url
 * 李华栋
 * 2016年6月27日 下午3:17:14
 * 
 * @version 0.0.1
 * 
 */
public class ShortUrlManager {

	private String accesstoken;
	public ShortUrlManager(String accesstoken){
		this.accesstoken  = accesstoken;
	}
	
	public  JSONObject getShortUrlJSON(String longurl) {
			   
		String url = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token="+ this.accesstoken; 
	    //String data ="{\"action\":\"long2short\",\"long_url\":\""+longurl+"\"}";
   
		try {
		    JSONObject jsonData = new JSONObject();
		    jsonData.put("action", "long2short");
		    jsonData.put("long_url", longurl);
		    String res = HTTPSDataManager.sendData(url,jsonData.toString());
		    System.out.println(res);
			return new JSONObject(res);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public  String getShortUrl(String longurl){
		
	    String shorturl = null;

		try {
			JSONObject jsonObj = getShortUrlJSON(longurl);
			shorturl =  jsonObj.getString("short_url"); 
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
	    return shorturl;
	}

}
