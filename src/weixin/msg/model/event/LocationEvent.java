/**
 * 包打听全知道-微信H5版本
 * weixin.msg.model.event
 * LocationEvent.java
 * Ver0.0.1
 * 2016年6月20日-下午5:29:34
 *  2016全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.model.event;

import weixin.msg.model.base.WeixinEventMsg;

/**
 * 
 * LocationEvent
 * 
 * 李华栋
 * 李华栋
 * 2016年6月20日 下午5:29:34
 * 
 * @version 0.0.1
 * 
 */
public class LocationEvent extends WeixinEventMsg{
	
	//ToUserName	开发者微信号(From WeixinMsg)
	//FromUserName	发送方帐号（一个OpenID）(From WeixinMsg)
	//CreateTime	消息创建时间 （整型）(From WeixinMsg)
	//MsgType		消息类型，event(From WeixinMsg)
	//Event			事件类型，LOCATION(From WeixinEventMsg)
	
	private String latitude;	//地理位置纬度
	private String longitude;	//地理位置经度
	private String precision;	//地理位置精度
	
	public LocationEvent(){
		setMsgType("event");
		setEvent("LOCATION");
	}

	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the precision
	 */
	public String getPrecision() {
		return precision;
	}

	/**
	 * @param precision the precision to set
	 */
	public void setPrecision(String precision) {
		this.precision = precision;
	}
	
}
