/**
 * 
 * 微信-公众号-封装接口JAVA版本
 * weixin.message.kefu
 * Text.java
 * Ver0.0.1
 * 2014年9月30日-下午2:09:44
 * 2014-2019 ©全智道(北京)科技有限公司
 * 
 */
package weixin.msg.model.kefu;

import weixin.msg.model.base.KeFuMsgBase;

/**
 * 
 * Text
 * 
 * 李华栋
 * 李华栋
 * 2014年9月30日 下午2:09:44
 * 
 * @version 0.0.1
 * 
 */
public class Text extends  KeFuMsgBase {

	private  Content text;

	/**
	 * text
	 *
	 * @return  the text
	 * @since   0.0.1
	 */
	
	public Content getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(Content text) {
		this.text = text;
	}
	
}



