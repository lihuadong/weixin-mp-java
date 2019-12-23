/**
 * 
 * 微信-公众号-封装接口JAVA版本
 * weixin.material
 * MaterialManager.java
 * Ver0.0.1
 * 2016年6月27日-下午4:09:23
 * 2014-2019 ©全智道(北京)科技有限公司
 * 
 */
package weixin.material;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import weixin.base.APIURL;
import weixin.msg.model.material.Article;
import weixin.util.HTTPSDataManager;
import weixin.util.HttpsFileUpload;

/**
 * 
 * MaterialManager 永久素材管理
 * 
 * 李华栋
 * 李华栋
 * 2016年6月27日 下午4:09:23
 * 
 * @version 0.0.1
 * 
 */
public class MaterialManager {
	
	private String accesstoken;
	private JSONObject resultJSON;
	  
	public MaterialManager(String accesstoken){
		this.accesstoken = accesstoken;
		resultJSON = null;
	}
	
	/**
	 * 新增永久素材-图文addNews 
	 * @param articles
	 * @return
	 */
	public JSONObject addMaterial4News(List<Article> articles){
		
		String url = APIURL.ADD_NEWS + this.accesstoken;
		try {
			JSONObject rootJson = new JSONObject();
			JSONArray artArray = new JSONArray();
			for(int i=0;i<articles.size();i++){
				JSONObject subJson = new JSONObject();
				subJson.put("title", articles.get(i).getTitle());
				subJson.put("thumb_media_id", articles.get(i).getThumb_media_id());
				subJson.put("author", articles.get(i).getAuthor());
				subJson.put("digest", articles.get(i).getDigest());
				subJson.put("show_cover_pic", articles.get(i).getShow_cover_pic());
				subJson.put("content", articles.get(i).getContent());
				subJson.put("content_source_url", articles.get(i).getContent_source_url());
				artArray.put(subJson);
			}
			rootJson.put("articles", artArray);
			String response = HTTPSDataManager.sendData(url, rootJson.toString());
			
			resultJSON = new JSONObject(response);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return resultJSON;
	}
	
	
	/**
	 * 新增永久素材-其他类型（除图文消息外）
	 * @param filePath
	 * @param type
	 * @param description（仅视频需要）
	 * 图片（image）: 2M，支持bmp/png/jpeg/jpg/gif格式
	 * 语音（voice）：2M，播放长度不超过60s，mp3/wma/wav/amr格式
	 * 视频（video）：10MB，支持MP4格式
	 * 缩略图（thumb）：64KB，支持JPG格式
	 */
	public JSONObject addMaterial(String filePath, String type, Map<String,String> description){

		String url = APIURL.ADD_MATERIAL + this.accesstoken+"&type="+type;
		
		try {
			Map<String, String> fileMap = new HashMap<String, String>();
			fileMap.put("media", filePath);
		
			Map<String, String> textMap = null;
			if(description!=null){
				textMap = new HashMap<String, String>();
				JSONObject rootJson = new JSONObject();
				rootJson.put("title", description.get("title"));
				rootJson.put("introduction", description.get("introduction"));
				textMap.put("description", rootJson.toString());
			}
			HttpsFileUpload hf = new HttpsFileUpload();
			String response = hf.formUpload(url, textMap, fileMap);
			resultJSON = new JSONObject(response);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return resultJSON;
	}
	
	
	/**
	 * 删除永久素材deleteMaterial 
	 * @param mediaId
	 * @return
	 */
	public JSONObject deleteMaterial(String mediaId){
		String url = APIURL.DELETE_MATERIAL + this.accesstoken;
		try {
			JSONObject rootJson = new JSONObject();
			rootJson.put("media_id", mediaId);
			String response = HTTPSDataManager.sendData(url, rootJson.toString());
			resultJSON = new JSONObject(response);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return resultJSON;
	}
	
	/**
	 * 获取永久素材getMaterial 
	 * @param mediaId
	 * @return
	 */
	public JSONObject getMaterial(String mediaId){

		String url = APIURL.GET_MATERIAL + this.accesstoken;
		try {
			JSONObject rootJson = new JSONObject();
			rootJson.put("media_id", mediaId);
			String response = HTTPSDataManager.sendData(url, rootJson.toString());
			
			resultJSON = new JSONObject(response);

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return resultJSON;
	}
		

	/**
	 * 修改永久图文素材updateMaterialNews 
	 * @param mediaId
	 * @param index 要更新的文章在图文消息中的位置（多图文消息时，此字段才有意义），第一篇为0
	 * @param article
	 * @return
	 */
	public JSONObject updateMaterialNews(String mediaId, int index, JSONObject articleJSON){
		String url = APIURL.UPDATE_NEWS + this.accesstoken;
		try {
			String response = HTTPSDataManager.sendData(url,articleJSON.toString());
			resultJSON  = new JSONObject(response);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return resultJSON;
	}
	
	/**
	 * 获取素材总数getMaterialCount
	 * 
	 *    "voice_count":COUNT,
	 *    "video_count":COUNT,
	 *    "image_count":COUNT,
	 *    "news_count":COUNT
	 */
	public JSONObject getMaterialCount(){

		String url = APIURL.GET_MATERIAL_COUNT + this.accesstoken;
		String response = HTTPSDataManager.sendData(url);
		try {
			resultJSON = new JSONObject(response);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return resultJSON;
	}
	
	/**
	 * getMaterilaBatch 分批获取素材列表
	 * @param type 素材的类型，图片（image）、视频（video）、语音 （voice）、图文（news）
	 * @param offset 从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
	 * @param count 返回素材的数量，取值在1到20之间
	 * @return
	 */
	public JSONObject getMaterilaBatch(String type, int offset, int count){
		
		String url = APIURL.GET_MATERIAL_LIST + this.accesstoken;
		try {
			JSONObject rootJson = new JSONObject();
			rootJson.put("type", type);
			rootJson.put("offset", offset);
			rootJson.put("count", count);
			String response = HTTPSDataManager.sendData(url, rootJson.toString());
			resultJSON = new JSONObject(response);

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return resultJSON;
	}
	
	
	
	
	/**
	 * 上传图文消息里的图片获取URLuploadImg 
	 * 本接口所上传的图片不占用公众号的素材库中图片数量的100000个的限制。图片仅支持jpg/png格式，大小必须在1MB以下。
	 * @param filePath
	 * @return
	 */
	public JSONObject uploadImg(String filePath){
		
		String url = APIURL.UPLOAD_IMG + this.accesstoken;
		
		HttpsFileUpload hf = new HttpsFileUpload();
		Map<String, String> fileMap = new HashMap<String, String>();
		fileMap.put("media", filePath);
		String response = hf.formUpload(url, null, fileMap);
		
		try {
			resultJSON = new JSONObject(response);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultJSON;
	}

}	

