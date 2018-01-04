/**
 * 包打听全知道-微信H5版本
 * weixin.message.kefu
 * MusicDetail.java
 * Ver0.0.1
 * 2014年9月30日-下午5:19:12
 *  2014全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.model.cs;

/**
 * 
 * MusicDetail
 * 
 * 李华栋
 * 李华栋
 * 2014年9月30日 下午5:19:12
 * 
 * @version 0.0.1
 * 
 */
public class MusicDetail {

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
	/**
	 * musicurl
	 *
	 * @return  the musicurl
	 * @since   0.0.1
	 */
	
	public String getMusicurl() {
		return musicurl;
	}
	/**
	 * @param musicurl the musicurl to set
	 */
	public void setMusicurl(String musicurl) {
		this.musicurl = musicurl;
	}
	/**
	 * hqmusicurl
	 *
	 * @return  the hqmusicurl
	 * @since   0.0.1
	 */
	
	public String getHqmusicurl() {
		return hqmusicurl;
	}
	/**
	 * @param hqmusicurl the hqmusicurl to set
	 */
	public void setHqmusicurl(String hqmusicurl) {
		this.hqmusicurl = hqmusicurl;
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
	//音乐标题
	private String title;
	//音乐描述
	private String description;
	//音乐链接
	private String musicurl;
	//高品质音乐链接，wifi环境优先使用该链接播放音乐
	private String hqmusicurl;
	//缩略图的媒体ID
	private String thumb_media_id;
}
