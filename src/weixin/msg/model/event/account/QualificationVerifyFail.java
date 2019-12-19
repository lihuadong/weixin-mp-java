/**
 * 
 * 微信-公众号-封装接口JAVA版本
 * weixin.msg.model.event.account
 * QualificationVerifyFail.java
 * Ver0.0.1
 * 2016年6月27日-下午5:33:27
 * 2014-2019 ©全智道(北京)科技有限公司
 * 
 */
package weixin.msg.model.event.account;

import weixin.msg.model.base.WeixinMsg4Event;

/**
 * 
 * QualificationVerifyFail 资质认证失败
 * 
 * 李华栋
 * 李华栋
 * 2016年6月27日 下午5:33:27
 * 
 * @version 0.0.1
 * 
 */
public class QualificationVerifyFail extends WeixinMsg4Event{
	
	//ToUserName	开发者微信号
	//FromUserName	发送方帐号（一个OpenID，此时发送方是系统帐号）
	//CreateTime	消息创建时间 （整型），时间戳
	//MsgType		消息类型，event
	//Event			事件类型 qualification_verify_fail
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String failTime;	//失败发生时间 (整形)，时间戳
	private String failReason;	//认证失败的原因
	
	/**
	 * @return the failTime
	 */
	public String getFailTime() {
		return failTime;
	}
	/**
	 * @param failTime the failTime to set
	 */
	public void setFailTime(String failTime) {
		this.failTime = failTime;
	}
	/**
	 * @return the failReason
	 */
	public String getFailReason() {
		return failReason;
	}
	/**
	 * @param failReason the failReason to set
	 */
	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}
	
}
