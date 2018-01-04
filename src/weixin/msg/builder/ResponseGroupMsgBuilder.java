/**
 * 包打听全知道-微信H5版本
 * weixin.msg
 * ResponseGroupMsg.java
 * Ver0.0.1
 * 2016年6月20日-下午3:45:17
 *  2016全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.builder;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 * ResponseGroupMsg
 * 
 * 李华栋
 * 李华栋
 * 2016年6月20日 下午3:45:17
 * 
 * @version 0.0.1
 * 
 */
public class ResponseGroupMsgBuilder {
	
	/**
	 * articles_tag(根据标签群发图文消息)
	 * @param isToAll, tagId, mediaId
	 * String
	 * @exception 
	 * @since  0.0.1
	 */
	public String articles_tag(boolean isToAll, int tagId, String mediaId){
		JSONObject rootJson = new JSONObject();
		try{
			JSONObject filter = new JSONObject();
			filter.put("is_to_all", isToAll);
			filter.put("tag_id", tagId);
			rootJson.put("filter", filter);
			
			JSONObject subJson = new JSONObject();
			subJson.put("media_id", mediaId);
			rootJson.put("mpnews", subJson);
			
			rootJson.put("msgtype", "mpnews");
		} catch(JSONException e){
			e.printStackTrace();
		}
		return rootJson.toString();
	}
	
	/**
	 * text_tag(根据标签群发文本消息)
	 * @param isToAll, tagId, content
	 * String
	 * @exception 
	 * @since  0.0.1
	 */
	public String text_tag(boolean isToAll, int tagId, String content){
		JSONObject rootJson = new JSONObject();
		try{
			JSONObject filter = new JSONObject();
			filter.put("is_to_all", isToAll);
			filter.put("tag_id", tagId);
			rootJson.put("filter", filter);
			
			JSONObject subJson = new JSONObject();
			subJson.put("content", content);
			rootJson.put("text", subJson);
			
			rootJson.put("msgtype", "text");
		} catch(JSONException e){
			e.printStackTrace();
		}
		return rootJson.toString();
	}
	
	/**
	 * voice_tag(根据标签群发语音消息)
	 * @param isToAll, tagId, mediaId
	 * String
	 * @exception 
	 * @since  0.0.1
	 */
	public String voice_tag(boolean isToAll, int tagId, String mediaId){
		JSONObject rootJson = new JSONObject();
		try{
			JSONObject filter = new JSONObject();
			filter.put("is_to_all", isToAll);
			filter.put("tag_id", tagId);
			rootJson.put("filter", filter);
			
			JSONObject subJson = new JSONObject();
			subJson.put("media_id", mediaId);
			rootJson.put("voice", subJson);
			
			rootJson.put("msgtype", "voice");
		} catch(JSONException e){
			e.printStackTrace();
		}
		return rootJson.toString();
	}
	
	/**
	 * image_tag(根据标签群发图片消息)
	 * @param isToAll, tagId, mediaId
	 * String
	 * @exception 
	 * @since  0.0.1
	 */
	public String image_tag(boolean isToAll, int tagId, String mediaId){
		JSONObject rootJson = new JSONObject();
		try{
			JSONObject filter = new JSONObject();
			filter.put("is_to_all", isToAll);
			filter.put("tag_id", tagId);
			rootJson.put("filter", filter);
			
			JSONObject subJson = new JSONObject();
			subJson.put("media_id", mediaId);
			rootJson.put("image", subJson);
			
			rootJson.put("msgtype", "image");
		} catch(JSONException e){
			e.printStackTrace();
		}
		return rootJson.toString();
	}
	
	/**
	 * video_tag(根据标签群发视频消息)
	 * @param isToAll, tagId, mediaId
	 * String
	 * @exception 
	 * @since  0.0.1
	 */
	public String video_tag(boolean isToAll, int tagId, String mediaId){
		JSONObject rootJson = new JSONObject();
		try{
			JSONObject filter = new JSONObject();
			filter.put("is_to_all", isToAll);
			filter.put("tag_id", tagId);
			rootJson.put("filter", filter);
			
			JSONObject subJson = new JSONObject();
			subJson.put("media_id", mediaId);
			rootJson.put("mpvideo", subJson);
			
			rootJson.put("msgtype", "mpvideo");
		} catch(JSONException e){
			e.printStackTrace();
		}
		return rootJson.toString();
	}
	
	/**
	 * card_tag(根据标签群发卡券消息)
	 * @param isToAll, tagId, cardId
	 * String
	 * @exception 
	 * @since  0.0.1
	 */
	public String card_tag(boolean isToAll, int tagId, String cardId){
		JSONObject rootJson = new JSONObject();
		try{
			JSONObject filter = new JSONObject();
			filter.put("is_to_all", isToAll);
			filter.put("tag_id", tagId);
			rootJson.put("filter", filter);
			
			JSONObject subJson = new JSONObject();
			subJson.put("card_id", cardId);
			rootJson.put("wxcard", subJson);
			
			rootJson.put("msgtype", "wxcard");
		} catch(JSONException e){
			e.printStackTrace();
		}
		return rootJson.toString();
	}
	
	/**
	 * articles_openid(根据OpenID列表群发图文消息)
	 * @param openids, mediaId
	 * String
	 * @exception 
	 * @since  0.0.1
	 */
	public String articles_openid(List<String> openids, String mediaId){
		JSONObject rootJson = new JSONObject();
		try{
			rootJson.put("touser", openids);
			
			JSONObject subJson = new JSONObject();
			subJson.put("media_id", mediaId);
			rootJson.put("mpnews", subJson);
			
			rootJson.put("msgtype", "mpnews");
		} catch(JSONException e){
			e.printStackTrace();
		}
		return rootJson.toString();
	}
	
	/**
	 * text_openid(根据OpenID列表群发文本消息)
	 * @param openids, content
	 * String
	 * @exception 
	 * @since  0.0.1
	 */
	public String text_openid(List<String> openids, String content){
		JSONObject rootJson = new JSONObject();
		try{
			rootJson.put("touser", openids);
			
			JSONObject subJson = new JSONObject();
			subJson.put("content", content);
			rootJson.put("text", subJson);
			
			rootJson.put("msgtype", "text");
		} catch(JSONException e){
			e.printStackTrace();
		}
		return rootJson.toString();
	}
	
	/**
	 * voice_openid(根据OpenID列表群发语音消息)
	 * @param openids, mediaId
	 * String
	 * @exception 
	 * @since  0.0.1
	 */
	public String voice_openid(List<String> openids, String mediaId){
		JSONObject rootJson = new JSONObject();
		try{
			rootJson.put("touser", openids);
			
			JSONObject subJson = new JSONObject();
			subJson.put("media_id", mediaId);
			rootJson.put("voice", subJson);
			
			rootJson.put("msgtype", "voice");
		} catch(JSONException e){
			e.printStackTrace();
		}
		return rootJson.toString();
	}
	
	/**
	 * image_openid(根据OpenID列表群发图片消息)
	 * @param openids, mediaId
	 * String
	 * @exception 
	 * @since  0.0.1
	 */
	public String image_openid(List<String> openids, String mediaId){
		JSONObject rootJson = new JSONObject();
		try{
			rootJson.put("touser", openids);
			
			JSONObject subJson = new JSONObject();
			subJson.put("media_id", mediaId);
			rootJson.put("image", subJson);
			
			rootJson.put("msgtype", "image");
		} catch(JSONException e){
			e.printStackTrace();
		}
		return rootJson.toString();
	}
	
	/**
	 * video_openid(根据OpenID列表群发视频消息)
	 * @param openids, mediaId, title, desc
	 * String
	 * @exception 
	 * @since  0.0.1
	 */
	public String video_openid(List<String> openids, String mediaId, String title, String desc){
		JSONObject rootJson = new JSONObject();
		try{
			rootJson.put("touser", openids);
			
			JSONObject subJson = new JSONObject();
			subJson.put("media_id", mediaId);
			subJson.put("title", title);
			subJson.put("description", desc);
			rootJson.put("video", subJson);
			
			rootJson.put("msgtype", "video");
		} catch(JSONException e){
			e.printStackTrace();
		}
		return rootJson.toString();
	}
	
	/**
	 * card_openid(根据OpenID列表群发卡券消息)
	 * @param openids, cardId
	 * String
	 * @exception 
	 * @since  0.0.1
	 */
	public String card_openid(List<String> openids, String cardId){
		JSONObject rootJson = new JSONObject();
		try{
			rootJson.put("touser", openids);
			
			JSONObject subJson = new JSONObject();
			subJson.put("card_id", cardId);
			rootJson.put("wxcard", subJson);
			
			rootJson.put("msgtype", "wxcard");
		} catch(JSONException e){
			e.printStackTrace();
		}
		return rootJson.toString();
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
