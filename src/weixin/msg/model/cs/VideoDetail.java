/**
 * 包打听全知道-微信H5版本
 * weixin.message.kefu
 * VideoDetail.java
 * Ver0.0.1
 * 2014年10月1日-下午2:24:01
 *  2014全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.model.cs;

/**
 * 
 * VideoDetail
 * 
 * 李华栋
 * 李华栋
 * 2014年10月1日 下午2:24:01
 * 
 * @version 0.0.1
 * 
 */
public class VideoDetail {

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
	/**
	 * thumb_media_id
	 *
	 * @return  the thumb_media_id
	 * @since   0.0.1
	 */
	
	public String getThumb_media_id() {
		return thumb_media_id;
	}
	/**
	 * @param thumb_media_id the thumb_media_id to set
	 */
	public void setThumb_media_id(String thumb_media_id) {
		this.thumb_media_id = thumb_media_id;
	}
	/**
	 * title
	 *
	 * @return  the title
	 * @since   0.0.1
	 */
	
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * description
	 *
	 * @return  the description
	 * @since   0.0.1
	 */
	
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	//发送的视频的媒体ID
	private  String media_id;
	//缩略图的媒体ID
	private  String thumb_media_id;
	//视频消息的标题
	private  String title;
	//视频消息的描述
	private  String description;
	
}
