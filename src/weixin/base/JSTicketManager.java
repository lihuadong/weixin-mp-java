/**
 * 包打听全知道-微信H5版本
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
 * 李华栋
 * 2015年1月14日 下午4:01:52
 * 
 * @version 0.0.1
 * 
 */
public class JSTicketManager extends  TimerTask{

	private static Logger logger = Logger.getLogger(JSTicketManager.class);   
	
	//JS Ticket 与微信服务器通讯的重要票据
	public 	static String jsTicket = "";
	public 	static int expires_in = 7200;//默认是7200秒过期
	
	private String accesstoken;
  
	public JSTicketManager(String accesstoken){
		this.accesstoken = accesstoken;
		run();
	}

	/* (non-Javadoc)
	 * @see java.util.TimerTask#run()
	 */
	@Override
	public void run() {
		
        String url = APIBaseConfig.JSTICKET_URL+ this.accesstoken+"&type=jsapi";
		//发送Https请求
		String result = HttpsDataManager.sendData(url, "weixin js ticket");
		
		//如果出现 invalid credential 那么要进行重新的请求 accesstoken 
		if(result.contains("invalid credential")){
			//new AccessTokenManager();
			//result = HttpsDataManager.sendData(url, "weixin js ticket");
		}

			
			JSONObject json;
			try {
				json = new JSONObject(result);
				jsTicket  = json.getString("ticket");
				expires_in =  json.getInt("expires_in");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			logger.info("【通知5】JS-Ticket:"+JSTicketManager.jsTicket);

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
//		AccessTokenManager   accessTokenManager  = new AccessTokenManager();
//		JSTicketManager  jsm  = new JSTicketManager();
	}
}
