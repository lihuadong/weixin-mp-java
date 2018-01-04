/**
 * 包打听全知道-微信H5版本
 * weixin.message
 * Video.java
 * Ver0.0.1
 * 2014年9月5日-上午8:56:33
 *  2014全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.model.common;

import weixin.msg.model.base.WeixinMsgBase;

/**
 * 
 * Video
 * 
 * 李华栋
 * 李华栋
 * 2014年9月5日 上午8:56:33
 * 
 * @version 0.0.1
 * 
 */
public class Video extends WeixinMsgBase {

	
	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 *
	 * @since 0.0.1
	 */
	
	private static final long serialVersionUID = 320959138666213210L;

	private String title;			//视频消息的标题
	private String description;		//视频消息的描述
	private String mediaId;			//视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
	private String thumbMediaId;	//视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
	
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
	 * mediaId
	 *
	 * @return  the mediaId
	 * @since   0.0.1
	 */
	
	public String getMediaId() {
		return mediaId;
	}

	/**
	 * @param mediaId the mediaId to set
	 */
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
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
