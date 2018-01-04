/**
 * 包打听全知道-微信H5版本
 * weixin.message.kefu
 * Article.java
 * Ver0.0.1
 * 2014年9月30日-下午4:52:40
 *  2014全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.model.cs;

import weixin.msg.model.base.KefuMsgBase;

/**
 * 
 * Article
 * 
 * 李华栋
 * 李华栋
 * 2014年9月30日 下午4:52:40
 * 
 * @version 0.0.1
 * 
 */
public class Article extends KefuMsgBase{

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
	 * url
	 *
	 * @return  the url
	 * @since   0.0.1
	 */
	
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * picurl
	 *
	 * @return  the picurl
	 * @since   0.0.1
	 */
	
	public String getPicurl() {
		return picurl;
	}
	/**
	 * @param picurl the picurl to set
	 */
	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}
	
	
	/**
	 * @return the media_id
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


	//标题
	private String title;
	//描述 
	private String description;
	//点击跳转的链接
	private String url;
	//图文中的图片封面 支持JPG、PNG格式，较好的效果为大图640*320，小图80*80
	private String picurl;
	//图文消息（点击跳转到图文消息页）的媒体ID
	private String media_id;
}