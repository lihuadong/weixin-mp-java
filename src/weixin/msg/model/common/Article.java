/**
 * 包打听全知道-微信H5版本
 * weixin.msg.model
 * Articles.java
 * Ver0.0.1
 * 2016年6月20日-下午5:17:43
 *  2016全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.model.common;

import weixin.msg.model.base.WeixinMsgBase;

/**
 * 
 * Articles
 * 
 * 李华栋
 * 李华栋
 * 2016年6月20日 下午5:17:43
 * 
 * @version 0.0.1
 * 
 */
public class Article extends WeixinMsgBase{
	
	private String title;		//图文消息标题
	private String description;	//图文消息描述
	private String picUrl;		//图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
	private String url;			//点击图文消息跳转链接

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
	 * picUrl
	 *
	 * @return  the picUrl
	 * @since   0.0.1
	 */
	public String getPicUrl() {
		return picUrl;
	}

	/**
	 * @param picUrl the picUrl to set
	 */
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
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
