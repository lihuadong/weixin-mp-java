/**
 * 包打听全知道-微信H5版本
 * weixin.msg
 * RequestMsg.java
 * Ver0.0.1
 * 2016年6月20日-下午1:56:27
 *  2016全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.builder;

import java.util.List;

import org.jdom.Element;

import weixin.msg.model.base.WeixinMsgBase;
import weixin.msg.model.common.Image;
import weixin.msg.model.common.Link;
import weixin.msg.model.common.Location;
import weixin.msg.model.common.Text;
import weixin.msg.model.common.Video;
import weixin.msg.model.common.Voice;

/**
 * 
 * RequestMsg
 * 
 * 李华栋
 * 李华栋
 * 2016年6月20日 下午1:56:27
 * 
 * @version 0.0.1
 * 
 */
public class RequestMsgBuilder {
	
	private String toUserName;
	private String fromUserName;
	private String createTime;
	private String msgType;
	private String msgId;
	
	private String content;
	private String mediaId;
	private String thumbMediaId;
	private String picUrl;
	private String format;
	private String recognition;
	private String loc_x;
	private String loc_y;
	private String scale;
	private String label;
	private String title;
	private String description;
	private String url;
	
	/**
	 * getRegularMessage 构建普通微信消息对象
	 * @param list
	 *WeixinMsg
	 * @exception 
	 * @since  0.0.1
	 */
	public WeixinMsgBase getRegularMessage(List<Object> list){
		
		WeixinMsgBase wxmsg = null;
		//获取请求信息
		Element element = null;
		recognition = "";	//区分有无开通语音识别
		for(int i=0;i<list.size();i++){
			element = (Element)list.get(i);
			if(element.getName().equals("ToUserName")){
				toUserName = element.getValue().trim();
			} else if(element.getName().equals("FromUserName")){
				fromUserName = element.getValue().trim();
			} else if(element.getName().equals("CreateTime")){
				createTime = element.getValue().trim();
			} else if(element.getName().equals("MsgType")){
				msgType = element.getValue().trim();
			} else if(element.getName().equals("MsgId")){
				msgId = element.getValue().trim();
			} else if(element.getName().equals("Content")){
				content = element.getValue().trim();
			} else if(element.getName().equals("MediaId")){
				mediaId = element.getValue().trim();
			} else if(element.getName().equals("ThumbMediaId")){
				thumbMediaId = element.getValue().trim();
			} else if(element.getName().equals("PicUrl")){
				picUrl = element.getValue().trim();
			} else if(element.getName().equals("Format")){
				format = element.getValue().trim();
			} else if(element.getName().equals("Recognition")){
				recognition = element.getValue().trim();
			} else if(element.getName().equals("Location_X")){
				loc_x = element.getValue().trim();
			} else if(element.getName().equals("Location_Y")){
				loc_y = element.getValue().trim();
			} else if(element.getName().equals("Scale")){
				scale = element.getValue().trim();
			} else if(element.getName().equals("Label")){
				label = element.getValue().trim();
			} else if(element.getName().equals("Title")){
				title = element.getValue().trim();
			} else if(element.getName().equals("Description")){
				description = element.getValue().trim();
			} else if(element.getName().equals("Url")){
				url = element.getValue().trim();
			}
		}
		
		//构造普通微信消息对象
		if(msgType.equals("text")){
			wxmsg = getText();
		} else if(msgType.equals("image")){
			wxmsg = getImage();
		} else if(msgType.equals("voice")){
			wxmsg = getVoice();
		} else if(msgType.equals("video")){
			wxmsg = getVideo();
		} else if(msgType.equals("shortvideo")){
			wxmsg = getShortVideo();
		} else if(msgType.equals("location")){
			wxmsg = getLocation();
		} else if(msgType.equals("link")){
			wxmsg = getLink();
		}
		
		return wxmsg;
	}
	
	/**
	 *构造 Text对象 
	 **/
	private Text getText(){
		Text text = new Text();
		
		text.setToUserNameGID(toUserName);
		text.setFromUserNameOpenID(fromUserName);
		text.setCreateTime(createTime);
		text.setMsgType(msgType);
		text.setMsgId(msgId);
		text.setContent(content);
		
		return text;
	}
	
	/**
	 *构造 Image对象 
	 **/
	private Image getImage(){
		Image image = new Image();
		
		image.setToUserNameGID(toUserName);
		image.setFromUserNameOpenID(fromUserName);
		image.setCreateTime(createTime);
		image.setMsgType(msgType);
		image.setMsgId(msgId);
		image.setMediaId(mediaId);
		image.setPicUrl(picUrl);
		
		return image;
	}
	
	/**
	 *构造 Voice对象
	 **/
	private Voice getVoice(){
		Voice voice = new Voice();
		
		voice.setToUserNameGID(toUserName);
		voice.setFromUserNameOpenID(fromUserName);
		voice.setCreateTime(createTime);
		voice.setMsgType(msgType);
		voice.setMsgId(msgId);
		voice.setFormat(format);
		voice.setMediaId(mediaId);
		if(recognition.length()>0){
			voice.setRecognition(recognition);
		}
		
		return voice;
	}
	
	/**
	 *构造 Video对象 
	 **/
	private Video getVideo(){
		Video video = new Video();
		
		video.setToUserNameGID(toUserName);
		video.setFromUserNameOpenID(fromUserName);
		video.setCreateTime(createTime);
		video.setMsgType(msgType);
		video.setMsgId(msgId);
		video.setMediaId(mediaId);
		video.setThumbMediaId(thumbMediaId);
		
		return video;
	}
	
	/**
	 *构造 shortvideo对象 
	 **/
	private Video getShortVideo(){
		Video video = new Video();
		
		video.setToUserNameGID(toUserName);
		video.setFromUserNameOpenID(fromUserName);
		video.setCreateTime(createTime);
		video.setMsgType(msgType);
		video.setMsgId(msgId);
		video.setMediaId(mediaId);
		video.setThumbMediaId(thumbMediaId);
		
		return video;
	}
	
	/**
	 *构造 Location对象 
	 **/
	private Location getLocation(){
		Location location = new Location();
		
		location.setToUserNameGID(toUserName);
		location.setFromUserNameOpenID(fromUserName);
		location.setCreateTime(createTime);
		location.setMsgType(msgType);
		location.setMsgId(msgId);
		location.setLocation_X(loc_x);
		location.setLocation_Y(loc_y);
		location.setScale(scale);
		location.setLabel(label);
		
		return location;
	}
	
	/**
	 *构造 Link对象 
	 **/
	private Link getLink(){
		Link link = new Link();
		
		link.setToUserNameGID(toUserName);
		link.setFromUserNameOpenID(fromUserName);
		link.setCreateTime(createTime);
		link.setMsgType(msgType);
		link.setMsgId(msgId);
		link.setDescription(title);
		link.setTitle(description);
		link.setUrl(url);
		
		return link;
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
