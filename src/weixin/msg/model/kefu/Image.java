/**
 * 
 * 微信-公众号-封装接口JAVA版本
 * weixin.message.kefu
 * Image.java
 * Ver0.0.1
 * 2014年10月1日-下午2:33:46
 * 2014-2019 ©全智道(北京)科技有限公司
 * 
 */
package weixin.msg.model.kefu;

import weixin.msg.model.base.KeFuMsgBase;

/**
 * 
 * Image
 * 
 * 李华栋
 * 李华栋
 * 2014年10月1日 下午2:33:46
 * 
 * @version 0.0.1
 * 
 */
public class Image extends KeFuMsgBase {

	private ImageDetail image;

	/**
	 * image
	 *
	 * @return  the image
	 * @since   0.0.1
	 */
	
	public ImageDetail getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(ImageDetail image) {
		this.image = image;
	}
}
