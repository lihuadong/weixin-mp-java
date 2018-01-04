/**
 * 包打听全知道-微信H5版本
 * weixin.msg.model
 * Music.java
 * Ver0.0.1
 * 2016年6月20日-下午4:45:06
 *  2016全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.model.common;

import weixin.msg.model.base.WeixinMsgBase;

/**
 * 
 * Music
 * 
 * 李华栋
 * 李华栋
 * 2016年6月20日 下午4:45:06
 * 
 * @version 0.0.1
 * 
 */
public class Music extends WeixinMsgBase{
	
	private String title;			//音乐标题
	private String description;		//音乐描述
	private String musicURL;		//音乐链接
	private String HQMusicUrl;		//高质量音乐链接，WIFI环境优先使用该链接播放音乐
	private String thumbMediaId;	//缩略图的媒体id，通过素材管理接口上传多媒体文件，得到的id
	
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
	 * musicURL
	 *
	 * @return  the musicURL
	 * @since   0.0.1
	 */
	public String getMusicURL() {
		return musicURL;
	}
	
	/**
	 * @param musicURL the musicURL to set
	 */
	public void setMusicURL(String musicURL) {
		this.musicURL = musicURL;
	}
	
	/**
	 * HQMusicUrl
	 *
	 * @return  the HQMusicUrl
	 * @since   0.0.1
	 */
	public String getHQMusicUrl() {
		return HQMusicUrl;
	}
	
	/**
	 * @param HQMusicUrl the HQMusicUrl to set
	 */
	public void setHQMusicUrl(String HQMusicUrl) {
		this.HQMusicUrl = HQMusicUrl;
	}
	
	/**
	 * thumbMediaId
	 *
	 * @return  the thumbMediaId
	 * @since   0.0.1
	 */
	public String getThumbMediaId() {
		return thumbMediaId;
	}
	
	/**
	 * @param thumbMediaId the thumbMediaId to set
	 */
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
	
	/**
	 * main(这里用一句话描述这个方法的作用)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param args 
	 *void
	 * @exception 
	 * @since  0.0.1
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
