/**
 * 包打听全知道-微信H5版本
 * weixin.msg.model.event
 * ViewEvent.java
 * Ver0.0.1
 * 2016年6月20日-下午5:40:41
 *  2016全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.model.event;

import weixin.msg.model.base.WeixinEventMsg;

/**
 * 
 * ViewEvent
 * 
 * 李华栋
 * 李华栋
 * 2016年6月20日 下午5:40:41
 * 
 * @version 0.0.1
 * 
 */
public class ViewEvent extends WeixinEventMsg{
	
	//ToUserName	开发者微信号(From WeixinMsg)
	//FromUserName	发送方帐号（一个OpenID）(From WeixinMsg)
	//CreateTime	消息创建时间 （整型）(From WeixinMsg)
	//MsgType		消息类型，event(From WeixinMsg)
	//Event			事件类型，VIEW(From WeixinEventMsg)
	//EventKey		事件KEY值，设置的跳转URL(From WeixinEventMsg)
	
	private String menuID;	//指菜单ID，如果是个性化菜单，则可以通过这个字段，知道是哪个规则的菜单被点击了
	
	public ViewEvent(){
		setMsgType("event");
		setEvent("VIEW");
	}
	
	/**
	 * @return the menuID
	 */
	public String getMenuID() {
		return menuID;
	}

	/**
	 * @param menuID the menuID to set
	 */
	public void setMenuID(String menuID) {
		this.menuID = menuID;
	}
}
