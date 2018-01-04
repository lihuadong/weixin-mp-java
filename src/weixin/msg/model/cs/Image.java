/**
 * 包打听全知道-微信H5版本
 * weixin.message.kefu
 * Image.java
 * Ver0.0.1
 * 2014年10月1日-下午2:33:46
 *  2014全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.model.cs;

import weixin.msg.model.base.KefuMsgBase;

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
public class Image extends KefuMsgBase {

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
