/**
 * 包打听全知道-微信H5版本
 * weixin.msg.model.event.account
 * NamingVerifyFail.java
 * Ver0.0.1
 * 2016年6月27日-下午5:42:56
 *  2016全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.model.event.account;

import weixin.msg.model.base.WeixinEventMsg;

/**
 * 
 * NamingVerifyFail 名称认证失败
 * 
 * 李华栋
 * 李华栋
 * 2016年6月27日 下午5:42:56
 * 
 * @version 0.0.1
 * 
 */
public class NamingVerifyFail extends WeixinEventMsg{
	
	//ToUserName	开发者微信号
	//FromUserName	发送方帐号（一个OpenID，此时发送方是系统帐号）
	//CreateTime	消息创建时间 （整型），时间戳
	//MsgType		消息类型，event
	//Event			事件类型 naming_verify_fail
	
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
