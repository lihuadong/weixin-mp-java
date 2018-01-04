/**
 * 包打听全知道-微信H5版本
 * weixin.msg.model.event
 * LocationSelectEvent.java
 * Ver0.0.1
 * 2016年6月24日-下午5:47:14
 *  2016全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.model.event;

import weixin.msg.model.base.WeixinEventMsg;

/**
 * 
 * LocationSelectEvent 弹出地理位置选择器的事件推送
 * 
 * 李华栋
 * 李华栋
 * 
 * @version 0.0.1
 * 
 */
public class LocationSelectEvent extends WeixinEventMsg{
	
	//ToUserName	开发者微信号(From WeixinMsg)
	//FromUserName	发送方帐号（一个OpenID）(From WeixinMsg)
	//CreateTime	消息创建时间 （整型）(From WeixinMsg)
	//MsgType		消息类型，event(From WeixinMsg)
	//Event			事件类型，location_select(From WeixinEventMsg)
	//EventKey		事件KEY值，由开发者在创建菜单时设定(From WeixinEventMsg)
	
	private String sendLocationInfo;	//发送的位置信息
	private String location_X;			//X坐标信息
	private String location_Y;			//Y坐标信息
	private String scale;				//精度，可理解为精度或者比例尺、越精细的话 scale越高
	private String label;				//地理位置的字符串信息
	private String poiname;				//朋友圈POI的名字，可能为空
	
	public LocationSelectEvent(){
		setMsgType("event");
		setEvent("location_select");
	}
	
	/**
	 * @return the sendLocationInfo
	 */
	public String getSendLocationInfo() {
		return sendLocationInfo;
	}
	/**
	 * @param sendLocationInfo the sendLocationInfo to set
	 */
	public void setSendLocationInfo(String sendLocationInfo) {
		this.sendLocationInfo = sendLocationInfo;
	}
	/**
	 * @return the location_X
	 */
	public String getLocation_X() {
		return location_X;
	}
	/**
	 * @param location_X the location_X to set
	 */
	public void setLocation_X(String location_X) {
		this.location_X = location_X;
	}
	/**
	 * @return the location_Y
	 */
	public String getLocation_Y() {
		return location_Y;
	}
	/**
	 * @param location_Y the location_Y to set
	 */
	public void setLocation_Y(String location_Y) {
		this.location_Y = location_Y;
	}
	/**
	 * @return the scale
	 */
	public String getScale() {
		return scale;
	}
	/**
	 * @param scale the scale to set
	 */
	public void setScale(String scale) {
		this.scale = scale;
	}
	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	/**
	 * @return the poiname
	 */
	public String getPoiname() {
		return poiname;
	}
	/**
	 * @param poiname the poiname to set
	 */
	public void setPoiname(String poiname) {
		this.poiname = poiname;
	}
	
	
}
