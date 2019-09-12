/**
 * 包到位小程序SaaS
 * weixin.base
 * AccessToken.java
 * Ver0.0.1
 * 2016年6月20日-下午3:06:02
 *  2014-2019 全智道(北京)科技有限公司
 * 
 */
package weixin.base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;

import org.json.JSONException;
import org.json.JSONObject;


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

	public AccessTokenManager(){
				try{
						String result  = sendHttpRequest();
				   		JSONObject  json   = new JSONObject(result);
					
						accesstoken  = json.getString("access_token");
						expires_in =  json.getInt("expires_in");
			
						logger.info("AccessTokenManager-accesstoken:"+accesstoken);
						logger.info("AccessTokenManager-expires_in:"+expires_in);
				} catch(JSONException e){
					e.printStackTrace();
				}
	}
	   
    /**
     * 
     * send(发送HTTPS请求)
     * (这里描述这个方法适用条件 – 可选)
     * @param url
     * @param paramsMap
     * @return 
     * String
     * @exception 
     * @since  0.0.1
     */
    private String sendHttpRequest(){
    	    
    		HttpClient httpClient = new HttpClient();    		
    		httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
    		
    		String url = APIBaseConfig.ACCESSTOKEN_GET_URL+appid+"&secret="+appsecret;
    		PostMethod postMethod = new PostMethod(url);

    		HttpClientParams httparams = new HttpClientParams();
    		httparams.setSoTimeout(60000);
    		postMethod.setParams(httparams);
    		
    		String result = null;
    		
    		try {
		    			int statusCode = httpClient.executeMethod(postMethod);
		    			if (statusCode == HttpStatus.SC_OK) {
		    				result = postMethod.getResponseBodyAsString();
		    			} else {
		    				logger.info("AccessTokenManager-sendHttpRequestFail:"+statusCode);
		    			}
    		} catch (HttpException e) {
    				e.printStackTrace();
    		} catch (IOException e) {
    				e.printStackTrace();
    		} finally {
	    			if (postMethod != null) {
	    				postMethod.releaseConnection();
	    			}
    		}
    	      
    	    return result;
    }
    
	/**
	 * accesstoken
	 *
	 * @return  the accesstoken
	 * @since   0.0.1
	*/
	
	public String getAccesstoken() {
		return accesstoken;
	}


	/**
	 * expires_in
	 *
	 * @return  the expires_in
	 * @since   0.0.1
	*/
	
	public int getExpires_in() {
		return expires_in;
	}
}
