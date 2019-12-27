/**
 * 
 * 微信-公众号-封装接口JAVA版本
 * weixin.message.kefu
 * Video.java
 * Ver0.0.1
 * 2014年10月1日-下午2:23:39
 * 2014-2019 ©全智道(北京)科技有限公司
 * 
 */
package weixin.msg.model.kefu;

import weixin.msg.model.base.KefuMsgBase;

/**
 * 
 * Video
 * 
 * 李华栋
 * 李华栋
 * 2014年10月1日 下午2:23:39
 * 
 * @version 0.0.1
 * 
 */
public class Video extends KefuMsgBase {

	private VideoDetail video;

	/**
	 * video
	 *
	 * @return  the video
	 * @since   0.0.1
	 */
	
	public VideoDetail getVideo() {
		return video;
	}

	/**
	 * @param video the video to set
	 */
	public void setVideo(VideoDetail video) {
		this.video = video;
	}
	
}
