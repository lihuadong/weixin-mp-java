/**
 * 包打听全知道-微信H5版本
 * weixin.msg.model.base
 * Event.java
 * Ver0.0.1
 * 2016年6月21日-下午3:30:43
 *  2016全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.model.base;

/**
 * 
 * Event
 * 
 * 李华栋
 * 李华栋
 * 2016年6月21日 下午3:30:43
 * 
 * @version 0.0.1
 * 
 */
public class Event {
	public String toUserName;//开发者微信号
	public String fromUserName;//发送方帐号（一个OpenID）
	public String createTime;//消息创建时间 （整型）
	public String msgType;//消息类型，event
	
	
	public String getToUserName() {
		return toUserName;
	}
	
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	
	public String getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getMsgType() {
		return msgType;
	}
	
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	
	@Override
	public String toString() {
		return "Event [toUserName=" + toUserName + ", fromUserName=" + fromUserName + ", createTime=" + createTime
				+ ", msgType=" + msgType + "]";
	}
	

}
