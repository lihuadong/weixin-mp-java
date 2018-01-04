/**
 * 包打听全知道-微信H5版本
 * weixin.msg
 * Response.java
 * Ver0.0.1
 * 2016年6月20日-下午1:59:16
 *  2016全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg;

import weixin.base.APIBaseConfig;
import weixin.util.HttpsDataManager;

/**
 * 
 * Response
 * 
 * 李华栋
 * 李华栋
 * 2016年6月20日 下午1:59:16
 * 
 * @version 0.0.1
 * 
 */
public class Response {
	
	
	private String accesstoken;
	
	public Response(String accesstoken){
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
		 
			String url = APIBaseConfig.MSG_CS_URL+ this.accesstoken;
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
		 
			String url = APIBaseConfig.MSG_TMPT_URL+ this.accesstoken;
			
			//System.out.println("APIConfig.MSG_TMPT_URL:"+APIConfig.MSG_TMPT_URL);
			
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
		 
			String url = APIBaseConfig.MSG_GROUP_TAG_URL+ this.accesstoken;
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
		 
			String url = APIBaseConfig.MSG_GROUP_OPENID_URL+ this.accesstoken;
		    return HttpsDataManager.sendData(url, strJSON);
		    
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
		Response  res   = new Response("at");
		res.sendTptMsg("AAAABBB");
	}

}
