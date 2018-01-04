/**
 * 包打听全知道-微信H5版本
 * weixin.msg.model.event
 * MassSendJobFinishEvent.java
 * Ver0.0.1
 * 2016年6月27日-下午5:07:41
 *  2016全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.model.event;

import weixin.msg.model.base.WeixinEventMsg;

/**
 * 
 * MassSendJobFinishEvent 事件推送群发结果
 * 
 * 李华栋
 * 李华栋
 * 2016年6月27日 下午5:07:41
 * 
 * @version 0.0.1
 * 
 */
public class MassSendJobFinishEvent extends WeixinEventMsg{
	
	//ToUserName	公众号的微信号(From WeixinMsg)
	//FromUserName	公众号群发助手的微信号，为mphelper(From WeixinMsg)
	//CreateTime	创建时间的时间戳(From WeixinMsg)
	//MsgType		消息类型，此处为event(From WeixinMsg)
	//Event			事件信息，此处为MASSSENDJOBFINISH(From WeixinEventMsg)
	//MsgID			群发的消息ID(From WeixinEventMsg)
	
	private String status;		//群发的结果，为"send success"或"send fail"或"err(num)"
	private String totalCount;	//tag_id下粉丝数；或者openid_list中的粉丝数
	private String filterCount;	//过滤后准备发送的粉丝数，原则上FilterCount = SentCount + ErrorCount
	private String sentCount;	//发送成功的粉丝数
	private String errorCount;	//发送失败的粉丝数
	
	public MassSendJobFinishEvent(){
		setMsgType("event");
		setEvent("MASSSENDJOBFINISH");
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

	/**
	 * @return the totalCount
	 */
	public String getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * @return the filterCount
	 */
	public String getFilterCount() {
		return filterCount;
	}

	/**
	 * @param filterCount the filterCount to set
	 */
	public void setFilterCount(String filterCount) {
		this.filterCount = filterCount;
	}

	/**
	 * @return the sentCount
	 */
	public String getSentCount() {
		return sentCount;
	}

	/**
	 * @param sentCount the sentCount to set
	 */
	public void setSentCount(String sentCount) {
		this.sentCount = sentCount;
	}

	/**
	 * @return the errorCount
	 */
	public String getErrorCount() {
		return errorCount;
	}

	/**
	 * @param errorCount the errorCount to set
	 */
	public void setErrorCount(String errorCount) {
		this.errorCount = errorCount;
	}
	
}
