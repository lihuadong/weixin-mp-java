/**
 * 
 * 微信-公众号-封装接口JAVA版本
 * weixin.message.kefu
 * News.java
 * Ver0.0.1
 * 2014年9月29日-下午8:02:31
 * 2014-2019 ©全智道(北京)科技有限公司
 * 
 */
package weixin.msg.model.kefu;

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




