/**
 * 包打听全知道-微信H5版本
 * weixin.base
 * AccessToken.java
 * Ver0.0.1
 * 2016年6月20日-下午3:06:02
 *  2016全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.base;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import weixin.util.Util4Properties;




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
public class AccessTokenManager extends   TimerTask {

	private static Logger logger = Logger.getLogger(AccessTokenManager.class);   
	
	//微信开发者重要的凭证
	public final static String  appid =Util4Properties.readPropertiesFile(AccessTokenManager.class.getResourceAsStream("/weixin.properties"), "appid"); 
	public final static String  appsecret =Util4Properties.readPropertiesFile(AccessTokenManager.class.getResourceAsStream("/weixin.properties"), "appsecret"); 
	 

	//AccessToken 与微信服务器通讯的重要票据
	public static String accesstoken = "";
	public static int expires_in = 7200;			//默认是7200秒过期

	/**
	 * 
	 * 创建一个新的实例 AccessTokenManager.
	 */
	public AccessTokenManager(){
		run();
	}
	

	
	@Override
	public void run() {
		try{
		String result  = sendData("get wechat access token");
   		JSONObject  json   = new JSONObject(result);
			
				accesstoken  = json.getString("access_token");
				expires_in =  json.getInt("expires_in");

				logger.info("【通知1】accesstoken:"+accesstoken);
				logger.info("【通知2】expires_in:"+expires_in);
				logger.info("【通知3】app id:"+AccessTokenManager.appid);
				logger.info("【通知4】app secret:"+AccessTokenManager.appsecret);	
				
		} catch(JSONException e){
			//System.out.println(e.toString());
		}
	}

	
    private String sendData(String data){
    	    
    	       String url = APIBaseConfig.ACCESSTOKEN_GET_URL+appid+"&secret="+appsecret;
    	       Map<String,String> paramsData = new HashMap<String,String>();
    	       paramsData.put("data", data);
    	       return send(url,paramsData);
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
    public String send(String url,Map<String,String> paramsMap){
    	    
    		String result = null;
    	      
    	  	PostMethod postMethod = null;
    		HttpClient httpClient = new HttpClient();
    		
    		httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
    		postMethod = new PostMethod(url);

    		HttpClientParams httparams = new HttpClientParams();
    		httparams.setSoTimeout(60000);
    		postMethod.setParams(httparams);
    		
    		try {
    			int statusCode = httpClient.executeMethod(postMethod);
    			if (statusCode == HttpStatus.SC_OK) {
    				result = postMethod.getResponseBodyAsString();
    			} else {
    				//System.out.println(" http response status is " + statusCode);
    			}

    		} catch (HttpException e) {
    			
    		} catch (IOException e) {
    			
    		} finally {
    			if (postMethod != null) {
    				postMethod.releaseConnection();
    			}
    		}
    	      
    	    return result;
    }
	
    
    /**
     * 
     * main(测试获取AccessToken的方法)
     * (参考文档 http://blog.csdn.net/java_huashan/article/details/9353903)
     * @param args 
     * void
     * @exception 
     * @since  0.0.1
     */
    public static void main(String args[]){
    	

    		AccessTokenManager   accessTokenManager  = new AccessTokenManager();
    		//Timer timer  = new Timer();
    		//timer.schedule(accessTokenManager, 0,10000);

    }
}
