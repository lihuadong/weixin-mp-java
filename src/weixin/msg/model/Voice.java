/**
 * 包打听全知道-微信H5版本
 * weixin.message
 * Voice.java
 * Ver0.0.1
 * 2014年9月5日-上午8:51:54
 *  2014全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.model;

import weixin.msg.model.base.WeixinMsg;

/**
 * 
 * Voice
 * 
 * 李华栋
 * 李华栋
 * 2014年9月5日 上午8:51:54
 * 
 * @version 0.0.1
 * 
 */
public class Voice extends WeixinMsg {

	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 *
	 * @since 0.0.1
	 */
	
	private static final long serialVersionUID = 3043586313316291567L;
	
	private String mediaId;		// 语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
	private String format;		// 语音格式，如amr，speex等
	private String recognition;	// 语音识别结果，UTF8编码，需要微信后台开启这个功能
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
	 * format
	 *
	 * @return  the format
	 * @since   0.0.1
	 */
	
	public String getFormat() {
		return format;
	}

	/**
	 * @param format the format to set
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * recognition
	 *
	 * @return  the recognition
	 * @since   0.0.1
	 */
	
	public String getRecognition() {
		return recognition;
	}

	/**
	 * @param recognition the recognition to set
	 */
	public void setRecognition(String recognition) {
		this.recognition = recognition;
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
