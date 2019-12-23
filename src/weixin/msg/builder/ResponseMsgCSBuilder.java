/**
 * 
 * 微信-公众号-封装接口JAVA版本
 * weixin.msg
 * ResponseCSMsg.java
 * Ver0.0.1
 * 2016年6月20日-下午2:00:15
 * 2014-2019 ©全智道(北京)科技有限公司
 * 
 */

package weixin.msg.builder;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import weixin.msg.model.kefu.Article;
import weixin.msg.model.kefu.Card;
import weixin.msg.model.kefu.Image;
import weixin.msg.model.kefu.Music;
import weixin.msg.model.kefu.Text;
import weixin.msg.model.kefu.Video;
import weixin.msg.model.kefu.Voice;

/**
 * 
 * ResponseCSMsg
 * 
 * 李华栋
 * 2016年6月20日 下午2:00:15
 * @version 0.0.1
 * 
 */
public class ResponseMsgCSBuilder {
	
	/**
	 * 客服发送文本消息
	 * @param text		发送的文本
	 * @param cs		指定客服账号(没有可设为"")
	 * @return String	json格式的数据
	 */
	public String text(Text text, String cs){

		String returnStr = null;
		
		//填充回复内容
		JSONObject rootJson = new JSONObject();
		try {
			rootJson.put("touser", text.getTouser());
			rootJson.put("msgtype", "text");
			
			//填充文本信息
			JSONObject subJson = new JSONObject();
			subJson.put("content", text.getText().getContent());
			rootJson.put("text", subJson);
			
			//指定客服账号
			if(cs.length()>0){
				subJson = new JSONObject();
				subJson.put("kf_account", cs);
				rootJson.put("customservice", subJson);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}		
		
		//转换为json格式字符串
		returnStr = rootJson.toString();
		return returnStr;
	}
	
	/**
	 * 客服发送图片消息
	 * @param image		发送的图片
	 * @param cs		指定客服账号(没有可设为"")
	 * @return String	json格式的数据
	 */
	public String image(Image image, String cs){

		String returnStr = null;
		
		//填充回复内容
		JSONObject rootJson = new JSONObject();
		try {
			rootJson.put("touser", image.getTouser());
			rootJson.put("msgtype", "image");
			
			//填充图片信息
			JSONObject subJson = new JSONObject();
			subJson.put("media_id", image.getImage().getMedia_id());
			rootJson.put("image", subJson);
			
			//指定客服账号
			if(cs.length()>0){
				subJson = new JSONObject();
				subJson.put("kf_account", cs);
				rootJson.put("customservice", subJson);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}		
		
		//转换为json格式字符串
		returnStr = rootJson.toString();
		return returnStr;
	}
	
	/**
	 * 客服发送语音消息
	 * @param voice		发送的语音
	 * @param cs		指定客服账号(没有可设为"")
	 * @return String	json格式的数据
	 */
	public String voice(Voice voice, String cs){

		String returnStr = null;
		
		//填充回复内容
		JSONObject rootJson = new JSONObject();
		try {
			rootJson.put("touser", voice.getTouser());
			rootJson.put("msgtype", "voice");
			
			//填充语音信息
			JSONObject subJson = new JSONObject();
			subJson.put("media_id", voice.getVoice().getMedia_id());
			rootJson.put("voice", subJson);
			
			//指定客服账号
			if(cs.length()>0){
				subJson = new JSONObject();
				subJson.put("kf_account", cs);
				rootJson.put("customservice", subJson);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}	
		
		//转换为json格式字符串
		returnStr = rootJson.toString();
		return returnStr;
	}
	
	/**
	 * 客服发送视频消息
	 * @param video		发送的视频
	 * @param cs		指定客服账号(没有可设为"")
	 * @return String	json格式的数据
	 */
	public String video(Video video, String cs){

		String returnStr = null;
		
		//填充回复内容
		JSONObject rootJson = new JSONObject();
		try {
			rootJson.put("touser", video.getTouser());
			rootJson.put("msgtype", "video");
			
			//填充视频信息
			JSONObject subJson = new JSONObject();
			subJson.put("media_id", video.getVideo().getMedia_id());
			subJson.put("thumb_media_id", video.getVideo().getThumb_media_id());
			subJson.put("title", video.getVideo().getTitle());
			subJson.put("description", video.getVideo().getDescription());
			rootJson.put("video", subJson);
			
			//指定客服账号
			if(cs.length()>0){
				subJson = new JSONObject();
				subJson.put("kf_account", cs);
				rootJson.put("customservice", subJson);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		//转换为json格式字符串
		returnStr = rootJson.toString();
		return returnStr;
		
	}
	
	/**
	 * 客服发送音乐消息
	 * @param music		发送的音乐
	 * @param cs		指定客服账号(没有可设为"")
	 * @return String	json格式的数据
	 */
	public String music(Music music, String cs){

		String returnStr = null;
		//填充回复内容
		JSONObject rootJson = new JSONObject();
		try {
			rootJson.put("touser", music.getTouser());
			rootJson.put("msgtype", "music");
			
			//填充音乐信息
			JSONObject subJson = new JSONObject();
			subJson.put("title", music.getMusic().getTitle());
			subJson.put("description", music.getMusic().getDescription());
			subJson.put("musicurl", music.getMusic().getMusicurl());
			subJson.put("hqmusicurl", music.getMusic().getHqmusicurl());
			subJson.put("thumb_media_id", music.getMusic().getThumb_media_id());
			
			rootJson.put("music", subJson);
			
			//指定客服账号
			if(cs.length()>0){
				subJson = new JSONObject();
				subJson.put("kf_account", cs);
				rootJson.put("customservice", subJson);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		//转换为json格式字符串
		returnStr = rootJson.toString();
		return returnStr;
	}
	
	/**
	 * 客服发送图文消息
	 * @param articles	发送的图文(不可超过8个)
	 * @param cs		指定客服账号(没有可设为"")
	 * @return String	json格式的数据
	 */
	public String articles(List<Article> articles, String cs){

		String returnStr = null;

		//图文消息限制8条以内
		if(articles.size()>8){
			return returnStr;
		}
		
		//填充回复内容
		JSONObject rootJson = new JSONObject();
		try {
			rootJson.put("touser", articles.get(0).getTouser());
			rootJson.put("msgtype", articles.get(0).getMsgtype());
			
			//填充图文信息
			JSONObject subJson = new JSONObject();
			
			//发送图文消息（点击跳转到外链） 
			if(articles.get(0).getMsgtype().equals("news")){
				List<JSONObject> artList = new ArrayList<JSONObject>();
				JSONObject artJson = null;
			
				for(int i=0;i<articles.size();i++){
					artJson = new JSONObject();
					artJson.put("title", articles.get(i).getTitle());
					artJson.put("description", articles.get(i).getDescription());
					artJson.put("url", articles.get(i).getUrl());
					artJson.put("picurl", articles.get(i).getPicurl());
					artList.add(artJson);
				}
				subJson.put("articles", artList);
			}
			//发送图文消息（点击跳转到图文消息页面） 
			else{
				subJson.put("media_id", articles.get(0).getMedia_id());
			}
			
			rootJson.put(articles.get(0).getMsgtype(), subJson);
			
			//指定客服账号
			if(cs.length()>0){
				subJson = new JSONObject();
				subJson.put("kf_account", cs);
				rootJson.put("customservice", subJson);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		//转换为json格式字符串
		returnStr = rootJson.toString();
		return returnStr;
	}
	
	/**
	 * 客服发送卡券
	 * @param card		发送的卡券
	 * @param cs		指定客服账号(没有可设为"")
	 * @return String	json格式的数据
	 */
	public String card(Card card, String cs){

		String returnStr = null;
		
		//填充回复内容
		JSONObject rootJson = new JSONObject();
		try {
			rootJson.put("touser", card.getTouser());
			rootJson.put("msgtype", "wxcard");
			
			//填充卡券信息
			JSONObject subJson = new JSONObject();
			subJson.put("card_id", card.getCard_id());
			
			JSONObject cardJson = new JSONObject();
			cardJson.put("code", card.getCode());
			cardJson.put("openid", card.getOpenid());
			cardJson.put("timestamp", card.getTimestamp());
			cardJson.put("signature", card.getSignature());
			String str = cardJson.toString().replaceAll("\"", "\\\\\"");
			
			subJson.put("card_ext", str);
			rootJson.put("wxcard", subJson);
			
			//指定客服账号
			if(cs.length()>0){
				subJson = new JSONObject();
				subJson.put("kf_account", cs);
				rootJson.put("customservice", subJson);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		//转换为json格式字符串
		returnStr = rootJson.toString().replaceAll("\\\\\\\\\\\\", "\\\\");
		return returnStr;
	}
	


}
