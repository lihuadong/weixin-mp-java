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
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
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

import weixin.user.UserManager;
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
    		String at = accessTokenManager.accesstoken;
    		UserManager  userManager  = new UserManager(at);
    		List openidList  = userManager.getSubscribeList("");
    		for(int i=0;i<openidList.size();i++) {
//    			HashMap  hm = userManager.getUserInfoByOpenid((String)openidList.get(i));
    			
    			String openid  = (String)openidList.get(i);
    			String res = userManager.getUserInfo(openid);
    			try {
					JSONObject json  = new JSONObject(res);
					
					System.out.println(json.getString("openid"));
					System.out.println(json.getString("headimgurl"));
					System.out.println("headimgurl");
					
//					if(json.getString("remark")== "shaozi100" || json.getString("remark")=="shaozi200") {
//						System.out.println(userManager.getUserInfo(openid));
//					}
					
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			
    			
//    			System.out.println("openid: "+hm.get("openid"));
//    			System.out.println("nickname: "+hm.get("nickname"));
//    			System.out.println("image_url: "+hm.get("headimgurl"));
//    			System.out.println("unionid: "+hm.get("unionid"));
    			
    		}

    }
}
