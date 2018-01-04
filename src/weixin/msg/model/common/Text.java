/**
 * 包打听全知道-微信H5版本
 * weixin.message
 * Text.java
 * Ver0.0.1
 * 2014年9月5日-上午8:45:58
 *  2014全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.model.common;

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
