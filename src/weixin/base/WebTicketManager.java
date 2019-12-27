/**
 * 
 * 微信-公众号-封装接口JAVA版本
 * weixin
 * JSTicketManager.java
 * Ver0.0.1
 * 2015年1月14日-下午4:01:52
 * 2015全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.base;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import weixin.util.HTTPSDataManager;

/**
 * 
 * JSTicketManager
 * 
 * 李华栋
 * 2015年1月14日 下午4:01:52
 * 
 * @version 0.0.1
 * 
 */
public class WebTicketManager {

	private static Logger logger = Logger.getLogger(WebTicketManager.class);   
	
	//JS Ticket 与微信服务器通讯的重要票据
	public 	 String jsTicket = null;
	public 	 int expires_in = 7200;//默认是7200秒过期
	
	/**
	 * jsTicket
	 *
	 * @return  the jsTicket
	 * @since   0.0.1
	*/
	
	public String getJsTicket() {
		return jsTicket;
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

	
	public WebTicketManager(String accesstoken){
        
		String url = APIURL.JSTICKET_URL+accesstoken+"&type=jsapi";
		//发送Https请求
		String result = HTTPSDataManager.sendData(url);
		
		if(result.contains("invalid credential")){
				logger.info("JSTicketManager-JS-Ticket:"+result);
		}else {

				try {
					JSONObject json = new JSONObject(result);
					jsTicket  = json.getString("ticket");
					expires_in =  json.getInt("expires_in");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				logger.info("JSTicketManager-JS-Ticket:"+jsTicket);
		}
	}
}
