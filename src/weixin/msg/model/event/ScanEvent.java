/**
 * 包打听全知道-微信H5版本
 * weixin.msg.model.event
 * ScanEvent.java
 * Ver0.0.1
 * 2016年6月20日-下午5:28:42
 *  2016全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.model.event;

import weixin.msg.model.base.WeixinEventMsg;

/**
 * 
 * ScanEvent
 * 
 * 李华栋
 * 李华栋
 * 2016年6月20日 下午5:28:42
 * 
 * @version 0.0.1
 * 
 */
public class ScanEvent extends WeixinEventMsg{
	
	//ToUserName	开发者微信号(From WeixinMsg)
	//FromUserName	发送方帐号（一个OpenID）(From WeixinMsg)
	//CreateTime	消息创建时间 （整型）(From WeixinMsg)
	//MsgType		消息类型，event(From WeixinMsg)
	//Event			事件类型，SCAN(From WeixinEventMsg)
	//EventKey		事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id(From WeixinEventMsg)
	
	private String ticket;	//二维码的ticket，可用来换取二维码图片
	
	public ScanEvent(){
		setMsgType("event");
		setEvent("SCAN");
	}

	/**
	 * @return the ticket
	 */
	public String getTicket() {
		return ticket;
	}

	/**
	 * @param ticket the ticket to set
	 */
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	
}
