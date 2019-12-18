/**
 * 微信-公众号-封装接口JAVA版本
 * weixin.base
 * AccessToken.java
 * Ver0.0.1
 * 2016年6月20日-下午3:06:02
 * 2014-2019 ©全智道(北京)科技有限公司
 * 
 */
package weixin.base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import weixin.util.HTTPSDataManager;


/**
 * 
 * AccessToken
 * 
 * 李华栋
 * 李华栋
 * 2016年6月20日 下午3:06:02
 * 
 * @version 0.0.1
 * 
 */
public class AccessTokenManager{

	private static Logger logger = Logger.getLogger(AccessTokenManager.class);   
	
	//微信开发者重要的凭证
	private final static String  appid;
	private final static String  appsecret; 
	
	//AccessToken 与微信服务器通讯的重要票据
	//默认是7200秒过期
	public  String accesstoken = null;
	public int expires_in = 7200;
	
	static{
		
		Properties prop = new Properties();  
		InputStream in = AccessTokenManager.class.getResourceAsStream("/weixin.properties"); 
		
		try {  
            prop.load(in);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  	

		appid = prop.getProperty("appid");  
		appsecret = prop.getProperty("appsecret");  
	}

	public AccessTokenManager() {
		try {
			String url = APIURL.ACCESSTOKEN_GET_URL + appid + "&secret=" + appsecret;
			String result = HTTPSDataManager.sendData(url);
			JSONObject json = new JSONObject(result);

			accesstoken = json.getString("access_token");
			expires_in = json.getInt("expires_in");

			logger.info("AccessTokenManager-accesstoken:" + accesstoken);
			logger.info("AccessTokenManager-expires_in:" + expires_in);

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	
	public String getAccesstoken() {
		return accesstoken;
	}
	
	public int getExpires_in() {
		return expires_in;
	}
}
