/**
 * 包打听全知道-微信H5版本
 * weixin.msg.model.event.minapp
 * UserEnterTempsession.java
 * Ver0.0.1
 * 2018年2月2日-下午8:29:49
 *  2018全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.model.event.minapp;

import weixin.msg.model.base.WeixinEventMsg;

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
public class UserEnterTempsession extends WeixinEventMsg {

	
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
