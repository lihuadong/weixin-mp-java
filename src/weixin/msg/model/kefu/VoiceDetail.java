/**
 * 
 * 微信-公众号-封装接口JAVA版本
 * weixin.message.kefu
 * VoiceDetail.java
 * Ver0.0.1
 * 2014年10月1日-下午2:29:13
 * 2014-2019 ©全智道(北京)科技有限公司
 * 
 */
package weixin.msg.model.kefu;

/**
 * 
 * VoiceDetail
 * 
 * 李华栋
 * 李华栋
 * 2014年10月1日 下午2:29:13
 * 
 * @version 0.0.1
 * 
 */
public class VoiceDetail {

	//发送的语音的媒体ID
	private String media_id;

	/**
	 * media_id
	 *
	 * @return  the media_id
	 * @since   0.0.1
	 */
	
	public String getMedia_id() {
		return media_id;
	}

	/**
	 * @param media_id the media_id to set
	 */
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	
}
