/**
 * 包打听全知道-微信H5版本
 * weixin.message.kefu
 * News.java
 * Ver0.0.1
 * 2014年9月29日-下午8:02:31
 *  2014全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.model.cs;

import weixin.msg.model.base.KefuMsgBase;

/**
 * 
 * News
 * 
 * 李华栋
 * 李华栋
 * 2014年9月29日 下午8:02:31
 * 
 * @version 0.0.1
 * 
 */
public class News extends KefuMsgBase {

	/**
	 * news
	 *
	 * @return  the news
	 * @since   0.0.1
	 */
	
	public Articles getNews() {
		return news;
	}

	/**
	 * @param news the news to set
	 */
	public void setNews(Articles news) {
		this.news = news;
	}

	private Articles news;

}




