/**
 * 包打听全知道-微信H5版本
 * weixin.msg.model.event.account
 * VerifyExpired.java
 * Ver0.0.1
 * 2016年6月27日-下午5:51:08
 *  2016全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.model.event.account;

import weixin.msg.model.base.WeixinEventMsg;

/**
 * 
 * VerifyExpired 认证过期失效通知
 * 
 * 李华栋
 * 李华栋
 * 2016年6月27日 下午5:51:08
 * 
 * @version 0.0.1
 * 
 */
public class VerifyExpired extends WeixinEventMsg{
	
	//ToUserName	开发者微信号
	//FromUserName	发送方帐号（一个OpenID，此时发送方是系统帐号）
	//CreateTime	消息创建时间 （整型），时间戳
	//MsgType		消息类型，event
	//Event			事件类型 verify_expired
	
	private String expiredTime;	//有效期 (整形)，指的是时间戳，表示已于该时间戳认证过期，需要重新发起微信认证

	/**
	 * @return the expiredTime
	 */
	public String getExpiredTime() {
		return expiredTime;
	}

	/**
	 * @param expiredTime the expiredTime to set
	 */
	public void setExpiredTime(String expiredTime) {
		this.expiredTime = expiredTime;
	}
	
}
