/**
 * 
 * 微信-公众号-封装接口JAVA版本
 * weixin.message
 * Text.java
 * Ver0.0.1
 * 2014年9月5日-上午8:45:58
 * 2014-2019 ©全智道(北京)科技有限公司
 * 
 */
package weixin.msg.model.normal;

import weixin.msg.model.base.WeixinMsgBase;

/**
 * 
 * Text
 * 
 * 李华栋
 * 李华栋
 * 2014年9月5日 上午8:45:58
 * 
 * @version 0.0.1
 * 
 */
public class Text extends WeixinMsgBase {

	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 *
	 * @since 0.0.1
	 */
	
	private static final long serialVersionUID = 7869410508301956045L;
	private String content; //文本消息内容
	
	/**
	 * content
	 *
	 * @return  the content
	 * @since   0.0.1
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
}
