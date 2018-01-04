/**
 * 包打听全知道-微信H5版本
 * weixin.msg.model.event
 * PicPhotoOrAlbumEvent.java
 * Ver0.0.1
 * 2016年6月24日-下午5:47:14
 *  2016全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.model.event;

import weixin.msg.model.base.WeixinEventMsg;

/**
 * 
 * PicPhotoOrAlbumEvent 弹出拍照或者相册发图的事件推送
 * 
 * 李华栋
 * 李华栋
 * 
 * @version 0.0.1
 * 
 */
public class PicPhotoOrAlbumEvent extends WeixinEventMsg{
	
	//ToUserName	开发者微信号(From WeixinMsg)
	//FromUserName	发送方帐号（一个OpenID）(From WeixinMsg)
	//CreateTime	消息创建时间 （整型）(From WeixinMsg)
	//MsgType		消息类型，event(From WeixinMsg)
	//Event			事件类型，pic_photo_or_album(From WeixinEventMsg)
	//EventKey		事件KEY值，由开发者在创建菜单时设定(From WeixinEventMsg)
	
	private String sendPicsInfo;	//发送的图片信息
	private String count;			//发送的图片数量
	private String picList;			//图片列表
	private String picMd5Sum;		//图片的MD5值，开发者若需要，可用于验证接收到图片
	
	public PicPhotoOrAlbumEvent(){
		setMsgType("event");
		setEvent("pic_photo_or_album");
	}
	
	/**
	 * @return the sendPicsInfo
	 */
	public String getSendPicsInfo() {
		return sendPicsInfo;
	}
	/**
	 * @param sendPicsInfo the sendPicsInfo to set
	 */
	public void setSendPicsInfo(String sendPicsInfo) {
		this.sendPicsInfo = sendPicsInfo;
	}
	/**
	 * @return the count
	 */
	public String getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(String count) {
		this.count = count;
	}
	/**
	 * @return the picList
	 */
	public String getPicList() {
		return picList;
	}
	/**
	 * @param picList the picList to set
	 */
	public void setPicList(String picList) {
		this.picList = picList;
	}
	/**
	 * @return the picMd5Sum
	 */
	public String getPicMd5Sum() {
		return picMd5Sum;
	}
	/**
	 * @param picMd5Sum the picMd5Sum to set
	 */
	public void setPicMd5Sum(String picMd5Sum) {
		this.picMd5Sum = picMd5Sum;
	}
	
}
