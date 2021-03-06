/**
 * 
 * 微信-公众号-封装接口JAVA版本
 * weixin.msg.model.event.minapp
 * UserEnterTempsession.java
 * Ver0.0.1
 * 2018年2月2日-下午8:29:49
 * 2014-2019 ©全智道(北京)科技有限公司
 * 
 */
package weixin.msg.model.event.minapp;

import weixin.msg.model.base.WeixinMsg4Event;

/**
 * 
 * UserEnterTempsession
 * 
 * 李华栋
 * 李华栋
 * 2018年2月2日 下午8:29:49
 * 
 * @version 0.0.1
 * 
 */
public class UserEnterTempsession extends WeixinMsg4Event {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String SessionFrom;

	/**
	 * sessionFrom
	 *
	 * @return  the sessionFrom
	 * @since   0.0.1
	 */
	
	public String getSessionFrom() {
		return SessionFrom;
	}

	/**
	 * @param sessionFrom the sessionFrom to set
	 */
	public void setSessionFrom(String sessionFrom) {
		SessionFrom = sessionFrom;
	}
	
}
