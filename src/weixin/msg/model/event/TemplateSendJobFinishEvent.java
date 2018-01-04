/**
 * 包打听全知道-微信H5版本
 * weixin.msg.model.event
 * TemlateSendJobFinishEvent.java
 * Ver0.0.1
 * 2016年6月20日-下午5:42:41
 *  2016全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.model.event;

import weixin.msg.model.base.WeixinEventMsg;

/**
 * 
 * TemplateSendJobFinishEvent
 * 
 * 李华栋
 * 李华栋
 * 2016年6月20日 下午5:42:41
 * 
 * @version 0.0.1
 * 
 */
public class TemplateSendJobFinishEvent extends WeixinEventMsg{
	
	//ToUserName	公众号微信号(From WeixinMsg)
	//FromUserName	接收模板消息的用户的openid(From WeixinMsg)
	//CreateTime	创建时间(From WeixinMsg)
	//MsgType		消息类型是事件(From WeixinMsg)
	//Event			事件为模板消息发送结束(From WeixinEventMsg)
	//MsgID			消息id(From WeixinMsg)
	
	private String status;	//发送状态（成功、用户拒绝接收、发送失败）
	
	public TemplateSendJobFinishEvent(){
		setMsgType("event");
		setEvent("TEMPLATESENDJOBFINISH");
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
}
