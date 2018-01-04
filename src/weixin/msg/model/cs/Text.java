/**
 * 包打听全知道-微信H5版本
 * weixin.message.kefu
 * Text.java
 * Ver0.0.1
 * 2014年9月30日-下午2:09:44
 *  2014全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.model.cs;

import weixin.msg.model.base.KefuMsgBase;

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
public class Text extends  KefuMsgBase {

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



