/**
 * 包打听全知道-微信H5版本
 * weixin.msg.model.event
 * ClickEvent.java
 * Ver0.0.1
 * 2016年6月20日-下午5:30:14
 *  2016全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.model.event;

import weixin.msg.model.base.WeixinEventMsg;

/**
 * 
 * ClickEvent
 * 
 * 李华栋
 * 李华栋
 * 2016年6月20日 下午5:30:14
 * 
 * @version 0.0.1
 * @param <String>
 * @param <String>
 * @param <String>
 * 
 */
public class ClickEvent extends WeixinEventMsg{
	
	//ToUserName	开发者微信号(From WeixinMsg)
	//FromUserName	发送方帐号（一个OpenID）(From WeixinMsg)
	//CreateTime	消息创建时间 （整型）(From WeixinMsg)
	//MsgType		消息类型，event(From WeixinMsg)
	//Event			事件类型，CLICK(From WeixinEventMsg)
	//EventKey		事件KEY值，与自定义菜单接口中KEY值对应(From WeixinEventMsg)
	
	public ClickEvent(){
		setMsgType("event");
		setEvent("CLICK");
	}
}
