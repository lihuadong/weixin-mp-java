/**
 * 包打听全知道-微信H5版本
 * weixin.message
 * Image.java
 * Ver0.0.1
 * 2014年9月5日-上午8:48:00
 *  2014全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.model.common;

import weixin.msg.model.base.WeixinMsgBase;

/**
 * 
 * Image
 * 
 * 李华栋
 * 李华栋
 * 2014年9月5日 上午8:48:00
 * 
 * @version 0.0.1
 * 
 */
public class Image extends WeixinMsgBase {

	
	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 *
	 * @since 0.0.1
	 */
	
	private static final long serialVersionUID = -9036152655935965143L;
	
	private String picUrl;	//图片链接
	private String mediaId;	//图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
	
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
	 * mediaId
	 *
	 * @return  the mediaId
	 * @since   0.0.1
	 */
	
	public String getMediaId() {
		return mediaId;
	}

	/**
	 * @param mediaId the mediaId to set
	 */
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
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
