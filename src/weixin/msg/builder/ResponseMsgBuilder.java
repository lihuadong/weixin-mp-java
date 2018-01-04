/**
 * 包打听全知道-微信H5版本
 * weixin.msg
 * ResponseMsg.java
 * Ver0.0.1
 * 2016年6月20日-下午1:57:47
 *  2016全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.builder;

import java.util.List;

import org.jdom.Element;

import weixin.msg.model.common.Article;
import weixin.msg.model.common.Image;
import weixin.msg.model.common.Music;
import weixin.msg.model.common.Text;
import weixin.msg.model.common.Video;
import weixin.msg.model.common.Voice;
import weixin.util.Utils;

/**
 * 
 * ResponseMsg
 * 
 * 李华栋
 * 李华栋
 * 2016年6月20日 下午1:57:47
 * 
 * @version 0.0.1
 * 
 */
public class ResponseMsgBuilder {

	/**
	 * 被动回复文本消息
	 * @param text		发送的文本
	 * @return String	xml格式的数据
	 */
	public static String text(Text text){

		String returnStr = "";
		
		//填充回复内容
		Element rootXML = new Element("xml");
		rootXML.addContent(new Element("ToUserName").setText(text.getToUserNameGID()));
		rootXML.addContent(new Element("FromUserName").setText(text.getFromUserNameOpenID()));
		rootXML.addContent(new Element("CreateTime").setText(text.getCreateTime()));
		rootXML.addContent(new Element("MsgType").setText(text.getMsgType()));//"text"
		rootXML.addContent(new Element("Content").setText(text.getContent()));
		
		//转换为xml格式字符串
		returnStr = Utils.getXMLType(rootXML);
		return returnStr;
	}
	
	/**
	 * 被动回复图片消息
	 * @param image		发送的图片
	 * @return String	xml格式的数据
	 */
	public String image(Image image){

		String returnStr = "";
		
		//填充回复内容
		Element rootXML = new Element("xml");
		rootXML.addContent(new Element("ToUserName").setText(image.getToUserNameGID()));
		rootXML.addContent(new Element("FromUserName").setText(image.getFromUserNameOpenID()));
		rootXML.addContent(new Element("CreateTime").setText(image.getCreateTime()));
		rootXML.addContent(new Element("MsgType").setText(image.getMsgType()));//"image"
		
		//填充图片信息
		Element fXML = new Element("Image");
		fXML.addContent(new Element("MediaId").setText(image.getMediaId()));	
		rootXML.addContent(fXML);
		
		//转换为xml格式字符串
		returnStr = Utils.getXMLType(rootXML);
		return returnStr;
	}
	
	/**
	 * 被动回复语音消息
	 * @param voice		发送的语音
	 * @return String	xml格式的数据
	 */
	public String voice(Voice voice){
		
		String returnStr = "";
		
		//填充回复内容
		Element rootXML = new Element("xml");
		rootXML.addContent(new Element("ToUserName").setText(voice.getToUserNameGID()));
		rootXML.addContent(new Element("FromUserName").setText(voice.getFromUserNameOpenID()));
		rootXML.addContent(new Element("CreateTime").setText(voice.getCreateTime()));
		rootXML.addContent(new Element("MsgType").setText(voice.getMsgType()));//"voice"
		
		//填充语音信息
		Element fXML = new Element("Voice");
		fXML.addContent(new Element("MediaId").setText(voice.getMediaId()));	
		rootXML.addContent(fXML);
		
		//转换为xml格式字符串
		returnStr = Utils.getXMLType(rootXML);
		return returnStr;
	}
	
	/**
	 * 被动回复视频消息
	 * @param video		发送的视频
	 * @return String	xml格式的数据
	 */
	public String video(Video video){

		String returnStr = "";
		
		//填充回复内容
		Element rootXML = new Element("xml");
		rootXML.addContent(new Element("ToUserName").setText(video.getToUserNameGID()));
		rootXML.addContent(new Element("FromUserName").setText(video.getFromUserNameOpenID()));
		rootXML.addContent(new Element("CreateTime").setText(video.getCreateTime()));
		rootXML.addContent(new Element("MsgType").setText(video.getMsgType()));//"video"
		
		//填充视频信息
		Element mXML = new Element("Video");
		mXML.addContent(new Element("Title").setText(video.getTitle()));
		mXML.addContent(new Element("Description").setText(video.getDescription()));
		mXML.addContent(new Element("MediaId").setText(video.getMediaId()));
		rootXML.addContent(mXML);
		
		//转换为xml格式字符串
		returnStr = Utils.getXMLType(rootXML);
		return returnStr;
	}
	
	/**
	 * 被动回复音乐消息
	 * @param music		发送的音乐
	 * @return String	xml格式的数据
	 */
	public String music(Music music){

		String returnStr = "";
		
		//填充回复内容
		Element rootXML = new Element("xml");		
		rootXML.addContent(new Element("ToUserName").setText(music.getToUserNameGID()));
		rootXML.addContent(new Element("FromUserName").setText(music.getFromUserNameOpenID()));
		rootXML.addContent(new Element("CreateTime").setText(music.getCreateTime()));
		rootXML.addContent(new Element("MsgType").setText(music.getMsgType()));//"music"
		
		//填充音乐信息
		Element mXML = new Element("Music");
		mXML.addContent(new Element("Title").setText(music.getTitle()));
		mXML.addContent(new Element("Description").setText(music.getDescription()));
		mXML.addContent(new Element("MusicURL").setText(music.getMusicURL()));
		mXML.addContent(new Element("HQMusicUrl").setText(music.getHQMusicUrl()));
		mXML.addContent(new Element("ThumbMediaId").setText(music.getThumbMediaId()));
		rootXML.addContent(mXML);
		
		//转换为xml格式字符串
		returnStr = Utils.getXMLType(rootXML);
		return returnStr;
	}
	
	/**
	 * 被动回复图文消息
	 * @param articles	发送的图文(不可超过10个)
	 * @return String	xml格式的数据
	 */
	public String articles(List<Article> articles){
				
		String returnStr = "";
		
		//图文消息限制10条以内
		if(articles.size()>10)
			return returnStr;
		
		//填充回复内容
		Element rootXML = new Element("xml");
		rootXML.addContent(new Element("ToUserName").setText(articles.get(0).getToUserNameGID()));
		rootXML.addContent(new Element("FromUserName").setText(articles.get(0).getToUserNameGID()));
		rootXML.addContent(new Element("CreateTime").setText(articles.get(0).getCreateTime()));
		rootXML.addContent(new Element("MsgType").setText(articles.get(0).getMsgType()));//"news"
		rootXML.addContent(new Element("ArticleCount").setText(String.valueOf(articles.size())));
		
		//填充图文信息
		Element fXML = new Element("Articles");
		Element mXML = null;

		for(int i = 0 ;i<=articles.size();i++){
			mXML = new Element("item");
			mXML.addContent(new Element("Title").setText(((Article)articles.get(i)).getTitle()));
			mXML.addContent(new Element("Description").setText(((Article)articles.get(i)).getDescription()));
			mXML.addContent(new Element("PicUrl").setText(((Article)articles.get(i)).getPicUrl()));
			mXML.addContent(new Element("Url").setText(((Article)articles.get(i)).getUrl()));
			fXML.addContent(mXML);
			rootXML.addContent(fXML);
		}
		
		//转换为xml格式字符串
		returnStr = Utils.getXMLType(rootXML);
		return returnStr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
