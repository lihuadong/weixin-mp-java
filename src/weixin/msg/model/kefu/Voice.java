/**
 * 
 * 微信-公众号-封装接口JAVA版本
 * weixin.message.kefu
 * Voice.java
 * Ver0.0.1
 * 2014年10月1日-下午2:28:57
 * 2014-2019 ©全智道(北京)科技有限公司
 * 
 */
package weixin.msg.model.kefu;

import weixin.msg.model.base.KeFuMsgBase;

/**
 * 
 * Voice
 * 
 * 李华栋
 * 李华栋
 * 2014年10月1日 下午2:28:57
 * 
 * @version 0.0.1
 * 
 */
public class Voice extends KeFuMsgBase {

	/**
	 * voice
	 *
	 * @return  the voice
	 * @since   0.0.1
	 */
	
	public VoiceDetail getVoice() {
		return voice;
	}

	/**
	 * @param voice the voice to set
	 */
	public void setVoice(VoiceDetail voice) {
		this.voice = voice;
	}

	private VoiceDetail voice;
	
}
