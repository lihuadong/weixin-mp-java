/**
 * 
 * 微信-公众号-封装接口JAVA版本
 * weixin.msg.model.event
 * ScancodeWaitmsgEvent.java
 * Ver0.0.1
 * 2016年6月24日-下午5:47:14
 * 2014-2019 ©全智道(北京)科技有限公司
 * 
 */
package weixin.msg.model.event;

import weixin.msg.model.base.WeixinMsg4Event;

/**
 * 
 * ScancodeWaitmsgEvent 扫码推事件且弹出“消息接收中”提示框的事件推送
 * 
 * 李华栋
 * 李华栋
 * 
 * @version 0.0.1
 * 
 */

public class ScancodeWaitMsgEvent extends WeixinMsg4Event{
	
	//ToUserName	开发者微信号(From WeixinMsg)
	//FromUserName	发送方帐号（一个OpenID）(From WeixinMsg)
	//CreateTime	消息创建时间 （整型）(From WeixinMsg)
	//MsgType		消息类型，event(From WeixinMsg)
	//Event			事件类型，scancode_waitmsg(From WeixinEventMsg)
	//EventKey		事件KEY值，由开发者在创建菜单时设定(From WeixinEventMsg)
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1824761248661949733L;
	private String scanCodeInfo;	//扫描信息
	private String scanType;		//扫描类型，一般是qrcode
	private String scanResult;		//扫描结果，即二维码对应的字符串信息
	
	public ScancodeWaitMsgEvent(){
		setMsgType("event");
		setEvent("scancode_waitmsg");
	}

	/**
	 * @return the scanCodeInfo
	 */
	public String getScanCodeInfo() {
		return scanCodeInfo;
	}

	/**
	 * @param scanCodeInfo the scanCodeInfo to set
	 */
	public void setScanCodeInfo(String scanCodeInfo) {
		this.scanCodeInfo = scanCodeInfo;
	}

	/**
	 * @return the scanType
	 */
	public String getScanType() {
		return scanType;
	}

	/**
	 * @param scanType the scanType to set
	 */
	public void setScanType(String scanType) {
		this.scanType = scanType;
	}

	/**
	 * @return the scanResult
	 */
	public String getScanResult() {
		return scanResult;
	}

	/**
	 * @param scanResult the scanResult to set
	 */
	public void setScanResult(String scanResult) {
		this.scanResult = scanResult;
	}
		
}
