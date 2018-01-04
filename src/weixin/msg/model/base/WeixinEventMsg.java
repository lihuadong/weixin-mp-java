/**
 * 包打听全知道-微信H5版本
 * weixin.message
 * Event.java
 * Ver0.0.1
 * 2014年9月5日-上午10:05:43
 *  2014全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.model.base;

/**
 * 
 * Event
 * 
 * 李华栋
 * 李华栋
 * 2014年9月5日 上午10:05:43
 * 
 * @version 0.0.1
 * 
 */
public class WeixinEventMsg extends WeixinMsgBase {
	
	private static final long serialVersionUID = 3916977988990270964L;
	/**
	 * enent事件类型说明
	 * (关注)				subscribe
	 * (取消关注)		unsubscribe
	 * (扫描并关注)	subscribe，		eventKey＝qrscene_为前缀，后面为二维码的参数值
	 * (扫描已经关注)	SCAN，eventKey＝ 是一个32位无符号整数，即创建二维码时的二维码scene_id
	 * (上报地理位置)	LOCATION
	 * (点击菜单)		CLICK  
	 * (点击菜单并转到对应的URL)	VIEW
	 * (模板消息发送成功之后推送的消息)	TEMPLATESENDJOBFINISH
	 * 
	 * enentKey类型说明
	 * (扫描并关注)subscribe,	eventKey＝qrscene_为前缀，后面为二维码的参数值
	 * (扫描已经关注)SCAN,		eventKey＝ 是一个32位无符号整数，即创建二维码时的二维码scene_id
	 * (点击菜单)CLICK,			eventKey＝ 与自定义菜单接口中KEY值对应
	 * (点击菜单并转到对应的URL)VIEW, enentKey = url 
	 */
	
	private String event; 		//事件类型 subscribe unsubscribe SCAN LOCATION CLICK VIEW
							   	//TEMPLATESENDJOBFINISH(微信服务器给出的模板消息之后)
	private String eventKey;	 
		
	/**
	 * event
	 *
	 * @return  the event
	 * @since   0.0.1
	 */
	
	public String getEvent() {
		return event;
	}

	/**
	 * @param event the event to set
	 */
	public void setEvent(String event) {
		this.event = event;
	}

	/**
	 * eventKey
	 *
	 * @return  the eventKey
	 * @since   0.0.1
	 */
	
	public String getEventKey() {
		return eventKey;
	}

	/**
	 * @param eventKey the eventKey to set
	 */
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
}
