/**
 * 包打听全知道-微信H5版本
 * weixin.message.kefu
 * Music.java
 * Ver0.0.1
 * 2014年9月30日-下午5:18:56
 *  2014全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.model.cs;

import weixin.msg.model.base.KefuMsgBase;

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
public class Music extends KefuMsgBase {

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
