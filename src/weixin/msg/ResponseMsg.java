/**
 * 
 * 微信-公众号-封装接口JAVA版本
 * weixin.msg
 * ResponseMsg.java
 * Ver0.0.1
 * 2016年6月20日-下午1:59:16
 * 2014-2019 全智道(北京)科技有限公司
 * 
 */
package weixin.msg;

import weixin.base.APIURL;
import weixin.util.HttpsDataManager;

/**
 * 
 * Response
 * 李华栋
 * 2016年6月20日 下午1:59:16
 * 
 * @version 0.0.1
 * 
 */
public class ResponseMsg {
	
	
	private String accesstoken;
	
	public ResponseMsg(String accesstoken){
		this.accesstoken = accesstoken;
	}
	
	/**
	 * sendCSMsg(统一发送客服消息)
	 * @param strJSON 
	 * String
	 * @exception 
	 * @since  0.0.1
	 */
	 public String sendCSMsg(String strJSON){
		 
			String url = APIURL.MSG_CS_URL+ this.accesstoken;
		    return HttpsDataManager.sendData(url, strJSON);
	 }
	
	/**
	 * sendTptMsg(统一发送模板消息)
	 * @param strJSON 
	 * String
	 * @exception 
	 * @since  0.0.1
	 */
	 public String sendTptMsg(String strJSON){
		 
			String url = APIURL.MSG_TMPT_URL+ this.accesstoken;			
		    return HttpsDataManager.sendData(url, strJSON);
	 }
	 
	 /**
	 * sendGroupMsg(统一根据标签发送群发消息)
	 * @param strJSON 
	 * String
	 * @exception 
	 * @since  0.0.1
	 */
	 public String sendGroupMsg_Tag(String strJSON){
		 
			String url = APIURL.MSG_GROUP_TAG_URL+ this.accesstoken;
		    return HttpsDataManager.sendData(url, strJSON);
	 }
	 
	 /**
	 * sendGroupMsg(统一根据OpenID列表发送群发消息)
	 * @param strJSON 
	 * String
	 * @exception 
	 * @since  0.0.1
	 */
	 public String sendGroupMsg_Openid(String strJSON){
		 
			String url = APIURL.MSG_GROUP_OPENID_URL+ this.accesstoken;
		    return HttpsDataManager.sendData(url, strJSON);
	 }

}
