/**
 * 包到位小程序SaaS
 * weixin.msg.model.event.account
 * AnnualRenew.java
 * Ver0.0.1
 * 2016年6月27日-下午5:47:25
 *  2014-2019 全智道(北京)科技有限公司
 * 
 */
package weixin.msg.model.event.account;

import weixin.msg.model.base.WeixinEventMsg;

/**
 * 
 * AnnualRenew 年审通知
 * 
 * 李华栋
 * 李华栋
 * 2016年6月27日 下午5:47:25
 * 
 * @version 0.0.1
 * 
 */
public class AnnualRenew extends WeixinEventMsg{
	
	//ToUserName	开发者微信号
	//FromUserName	发送方帐号（一个OpenID，此时发送方是系统帐号）
	//CreateTime	消息创建时间 （整型），时间戳
	//MsgType		消息类型，event
	//Event			事件类型 annual_renew，提醒公众号需要去年审了
	
	private String expiredTime;	//有效期 (整形)，指的是时间戳，将于该时间戳认证过期，需尽快年审

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
