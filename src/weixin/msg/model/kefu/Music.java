/**
 * 
 * 微信-公众号-封装接口JAVA版本
 * weixin.message.kefu
 * Music.java
 * Ver0.0.1
 * 2014年9月30日-下午5:18:56
 * 2014-2019 ©全智道(北京)科技有限公司
 * 
 */
package weixin.msg.model.kefu;

import weixin.msg.model.base.KeFuMsgBase;

/**
 * 
 * Music
 * 
 * 李华栋
 * 李华栋
 * 2014年9月30日 下午5:18:56
 * 
 * @version 0.0.1
 * 
 */
public class Music extends KeFuMsgBase {

	private MusicDetail music;

	/**
	 * music
	 *
	 * @return  the music
	 * @since   0.0.1
	 */
	
	public MusicDetail getMusic() {
		return music;
	}

	/**
	 * @param music the music to set
	 */
	public void setMusic(MusicDetail music) {
		this.music = music;
	}
}
