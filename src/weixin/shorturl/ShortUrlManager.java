/**
 * 
 * 微信-公众号-封装接口JAVA版本
 * weixin.shorturl
 * ShortUrlManager.java
 * Ver0.0.1
 * 2016年6月27日-下午3:17:14
 * 2014-2019 全智道(北京)科技有限公司
 * 
 */
package weixin.shorturl;

import org.json.JSONException;
import org.json.JSONObject;

import weixin.util.HTTPSDataManager;

/**
 * 
 * ShortUrlManager
 * 
 * 李华栋
 * 李华栋
 * 2016年6月27日 下午3:17:14
 * 
 * @version 0.0.1
 * 
 */
public class ShortUrlManager {

	private String at;
	public ShortUrlManager(String accesstoken){
		this.at  = accesstoken;
	}
	
	public  String getShortUrl(String longurl){
		
	    String shorturl ="";
		String url = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token="+ this.at; 
	    String data ="{\"action\":\"long2short\",\"long_url\":\""+longurl+"\"}";

	    String res = HTTPSDataManager.sendData(url,data);
	    
	    JSONObject jsonObj;
		try {
			jsonObj = new JSONObject(res);
			shorturl =  jsonObj.getString("short_url"); 
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
	   return shorturl;
	}

}
