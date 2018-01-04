/**
 * 包打听全知道-微信H5版本
 * weixin.message
 * Link.java
 * Ver0.0.1
 * 2014年9月5日-上午9:10:52
 * 2014全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.model.common;

import weixin.msg.model.base.WeixinMsgBase;

/**
 * 
 * Link
 * 
 * 李华栋
 * 李华栋
 * 2014年9月5日 上午9:10:52
 * 
 * @version 0.0.1
 * 
 */
public class Link extends WeixinMsgBase {

	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 *
	 * @since 0.0.1
	 */
	
	private static final long serialVersionUID = -4986919327104082512L;
	
	private String title;		//消息标题
	private String description;	//消息描述
	private String url;			//消息链接

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
