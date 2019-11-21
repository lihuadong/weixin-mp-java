/**
 * 包到位小程序SaaS
 * weixin
 * JSTicketManager.java
 * Ver0.0.1
 * 2015年1月14日-下午4:01:52
 * 2015全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.base;

import java.util.TimerTask;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import weixin.util.HttpsDataManager;

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
public class JSTicketManager {

	private static Logger logger = Logger.getLogger(JSTicketManager.class);   
	
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

	
	public JSTicketManager(String accesstoken){
        
		String url = APIConfig.JSTICKET_URL+accesstoken+"&type=jsapi";
		//发送Https请求
		String result = HttpsDataManager.sendData(url);
		
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

	/**
	 * main(这里用一句话描述这个方法的作用)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param args 
	 *void
	 * @exception 
	 * @since  0.0.1
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
