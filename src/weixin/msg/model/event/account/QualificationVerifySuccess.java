/**
 * 
 * 微信-公众号-封装接口JAVA版本
 * weixin.msg.model.event.account
 * QualificationVerifySuccess.java
 * Ver0.0.1
 * 2016年6月27日-下午3:43:47
 * 2014-2019 ©全智道(北京)科技有限公司
 * 
 */
package weixin.msg.model.event.account;

import weixin.msg.model.base.WeixinMsg4Event;

/**
 * 
 * QualificationVerifySuccess 资质认证成功（此时立即获得接口权限）
 * 
 * 李华栋
 * 李华栋
 * 2016年6月27日 下午3:43:47
 * 
 * @version 0.0.1
 * 
 */
public class QualificationVerifySuccess extends WeixinMsg4Event{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String  expiredTime;

	/**
	 * expiredTime
	 *
	 * @return  the expiredTime
	 * @since   0.0.1
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
