/**
 * 包打听全知道-微信H5版本
 * weixin.material
 * MaterialManager.java
 * Ver0.0.1
 * 2016年6月27日-下午4:09:23
 *  2016全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.material;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import weixin.base.APIBaseConfig;
import weixin.msg.model.material.Article;
import weixin.util.HttpsDataManager;
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
	  
	public MaterialManager(String accesstoken){
		this.accesstoken = accesstoken;
	}
	
	/**
	 * addNews 新增永久图文素材
	 * @param articles
	 * @return
	 */
	public String addNews(List<Article> articles){
		String mediaId = "";
		
		String url = APIBaseConfig.ADD_NEWS + this.accesstoken;
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
			String response = HttpsDataManager.sendData(url, rootJson.toString());
			
			JSONObject resJson = new JSONObject(response);
			if(!response.contains("errcode")){
				mediaId = resJson.getString("media_id");
			} else{
				System.out.println(response);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return mediaId;
	}
	
	/**
	 * uploadImg 上传图文消息里的图片获取URL
	 * @param filePath
	 * @return
	 */
	public String uploadImg(String filePath){
		String imgUrl = "";
		
		String url = APIBaseConfig.UPLOAD_IMG + this.accesstoken;
		
		HttpsFileUpload hf = new HttpsFileUpload();
		Map<String, String> fileMap = new HashMap<String, String>();
		fileMap.put("media", filePath);
		String response = hf.formUpload(url, null, fileMap);
		
		try {
			JSONObject res = new JSONObject(response);
			if(response.contains("url")){
				imgUrl = res.getString("url");
			}
			else{
				System.out.println(response);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return imgUrl;
	}
	
	/**
	 * uploadImg 上传永久素材（除图文消息外）
	 * @param filePath
	 * @param type
	 * @param description（仅视频需要）
	 * @return
	 */
	public HashMap<String, String> addMaterial(String filePath, String type, Map<String,String> description){
		HashMap<String, String> hm = new HashMap<String, String>();
		
		String url = APIBaseConfig.ADD_MATERIAL + this.accesstoken+"&type="+type;
		
		try {
			HttpsFileUpload hf = new HttpsFileUpload();
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
			
			String response = hf.formUpload(url, textMap, fileMap);
			JSONObject res = new JSONObject(response);
			if(!response.contains("errcode")){
				hm.put("media_id", res.getString("media_id"));
				if(response.contains("url")){	//仅新增图片素材时会返回该字段
					hm.put("url", res.getString("url"));
				}
			} else{
				System.out.println(response);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return hm;
	}
	
	/**
	 * getMaterial_article 获取永久图文素材
	 * @param mediaId
	 * @return
	 */
	public List<Article> getMaterial_article(String mediaId){
		List<Article> list = new ArrayList<Article>();
		
		String url = APIBaseConfig.GET_MATERIAL + this.accesstoken;
		try {
			JSONObject rootJson = new JSONObject();
			rootJson.put("media_id", mediaId);
			String response = HttpsDataManager.sendData(url, rootJson.toString());
			
			JSONObject resJson = new JSONObject(response);
			if(response.contains("news_item")){
				JSONArray items = resJson.getJSONArray("news_item");
				for(int i=0;i<items.length();i++){
					JSONObject subJson = items.getJSONObject(i);
					Article article = new Article();
					article.setTitle(subJson.getString("title"));
					article.setThumb_media_id(subJson.getString("thumb_media_id"));
					article.setShow_cover_pic(subJson.getString("show_cover_pic"));
					article.setAuthor(subJson.getString("author"));
					article.setDigest(subJson.getString("digest"));
					article.setContent(subJson.getString("content"));
					article.setUrl(subJson.getString("url"));
					article.setContent_source_url(subJson.getString("content_source_url"));
					list.add(article);
				}
			} else{
				System.out.println(response);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * getMaterial_videoUrl 获取永久视频素材URL
	 * @param mediaId
	 * @return
	 */
	public HashMap<String,String> getMaterial_videoUrl(String mediaId){
		HashMap<String,String> hm = new HashMap<String,String>();
		
		String url = APIBaseConfig.GET_MATERIAL + this.accesstoken;
		try {
			JSONObject rootJson = new JSONObject();
			rootJson.put("media_id", mediaId);
			String response = HttpsDataManager.sendData(url, rootJson.toString());
			
			JSONObject resJson = new JSONObject(response);
			if(response.contains("title")){
				hm.put("title", resJson.getString("title"));
				hm.put("description", resJson.getString("description"));
				hm.put("down_url", resJson.getString("down_url"));
			} else{
				System.out.println(response);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return hm;
	}
	
	/**
	 * downMaterial 获取永久素材（除图文）
	 * @param mediaId
	 * @return
	 */
	public boolean downMaterial(String mediaId, String filePath, String fileName){
		boolean success = true;
		String url = APIBaseConfig.GET_MATERIAL+ this.accesstoken;
		
		try {
			JSONObject rootJson = new JSONObject();
			rootJson.put("media_id", mediaId);
			
			URL mediaUrl = new URL(url);
			HttpURLConnection mediaConn;
			mediaConn = (HttpURLConnection) mediaUrl.openConnection();
			mediaConn.setDoOutput(true);
			mediaConn.setRequestMethod("POST");
			mediaConn.connect();
			OutputStreamWriter osw = new OutputStreamWriter(mediaConn.getOutputStream());  
		    osw.write(rootJson.toString());  
		    osw.flush();  
		    osw.close(); 
			
			//获取媒体文件
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			BufferedInputStream bis = new BufferedInputStream(mediaConn.getInputStream());
			byte[] buf = new byte[8096];
			int size = 0;
			while ((size = bis.read(buf)) != -1) {
				outputStream.write(buf, 0, size);
			}
			
			//将媒体文件写到本地文件
			String response = outputStream.toString();
			
			//下载永久视频素材
			if(response.contains("down_url")){
				JSONObject videoJson = new JSONObject(response);
				String video_url = videoJson.getString("down_url");
				URL videoUrl = new URL(video_url);
				outputStream.close();
		        bis.close();
		        mediaConn.disconnect();
				mediaConn = (HttpURLConnection) videoUrl.openConnection();
				mediaConn.setDoOutput(true);
				mediaConn.setRequestMethod("GET");
				outputStream = new ByteArrayOutputStream();
				bis = new BufferedInputStream(mediaConn.getInputStream());
				buf = new byte[8096];
				size = 0;
				while ((size = bis.read(buf)) != -1) {
					outputStream.write(buf, 0, size);
				}
			} else if(response.contains("errcode")){
				fileName = "getMaterial_ErrorLog.txt";
				success = false;
			}
			//将文件保存到本地
			File file = new File(filePath + fileName);    
            FileOutputStream fops = new FileOutputStream(file);    
            fops.write(outputStream.toByteArray());    
            fops.flush();
            fops.close();
            outputStream.close();
            bis.close();
            mediaConn.disconnect();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			success = false;
			e.printStackTrace();
		}
		return success;
	}
	
	/**
	 * deleteMaterial 删除永久素材
	 * @param mediaId
	 * @return
	 */
	public boolean deleteMaterial(String mediaId){
		boolean success = false;
		
		String url = APIBaseConfig.DELETE_MATERIAL + this.accesstoken;
		try {
			JSONObject rootJson = new JSONObject();
			rootJson.put("media_id", mediaId);
			String response = HttpsDataManager.sendData(url, rootJson.toString());
			
			JSONObject resJson = new JSONObject(response);
			if(resJson.getInt("errcode")==0){
				success = true;
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return success;
	}
	
	/**
	 * updateNews 修改永久图文素材
	 * @param mediaId
	 * @param index
	 * @param article
	 * @return
	 */
	public boolean updateNews(String mediaId, int index, Article article){
		boolean success = false;
		
		String url = APIBaseConfig.UPDATE_NEWS + this.accesstoken;
		try {
			JSONObject rootJson = new JSONObject();
			rootJson.put("media_id", mediaId);
			rootJson.put("index", index);
			JSONObject subJson = new JSONObject();
			subJson.put("title", article.getTitle());
			subJson.put("thumb_media_id", article.getThumb_media_id());
			subJson.put("author", article.getAuthor());
			subJson.put("digest", article.getDigest());
			subJson.put("show_cover_pic", article.getShow_cover_pic());
			subJson.put("content", article.getContent());
			subJson.put("content_source_url", article.getContent_source_url());
			rootJson.put("articles", subJson);
			
			String response = HttpsDataManager.sendData(url, rootJson.toString());
			JSONObject resJson = new JSONObject(response);
			if(resJson.getInt("errcode")==0){
				success = true;
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return success;
	}
	
	/**
	 * getMaterialCount 获取素材总数
	 */
	public HashMap<String,Integer> getMaterialCount(){
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		
		String url = APIBaseConfig.GET_MATERIAL_COUNT + this.accesstoken;
		String response = HttpsDataManager.sendData(url);
		try {
			JSONObject res = new JSONObject(response);
			if(response.contains("voice_count")){
				hm.put("voice_count", res.getInt("voice_count"));
				hm.put("video_count", res.getInt("video_count"));
				hm.put("image_count", res.getInt("image_count"));
				hm.put("news_count", res.getInt("news_count"));
			}
			else{
				System.out.println(response);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return hm;
	}
	
	/**
	 * getMaterilaList 获取素材列表
	 * @param type 素材的类型，图片（image）、视频（video）、语音 （voice）、图文（news）
	 * @param offset 从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
	 * @param count 返回素材的数量，取值在1到20之间
	 * @return
	 */
	public List<HashMap> getMaterilaList(String type, int offset, int count){
		List<HashMap> list = new ArrayList<HashMap>();
		
		String url = APIBaseConfig.GET_MATERIAL_LIST + this.accesstoken;
		try {
			JSONObject rootJson = new JSONObject();
			rootJson.put("type", type);
			rootJson.put("offset", offset);
			rootJson.put("count", count);
			String response = HttpsDataManager.sendData(url, rootJson.toString());
			
			JSONObject resJson = new JSONObject(response);
			//获取素材列表失败
			if(!response.contains("total_count")){
				System.out.println(response);
				return list;
			}
			
			//永久图文消息素材列表
			if(type.equals("news")){
				JSONArray items = resJson.getJSONArray("item");
				for(int i=0;i<items.length();i++){
					JSONObject subJson = items.getJSONObject(i);
					HashMap<String,Object> hm = new HashMap<String,Object>();
					JSONArray artArray = subJson.getJSONObject("content").getJSONArray("news_item");
					List<Article> artList = new ArrayList<Article>();
					for(int j=0;j<artArray.length();j++){
						JSONObject artJson = artArray.getJSONObject(j);
						Article article = new Article();
						article.setTitle(artJson.getString("title"));
						article.setThumb_media_id(artJson.getString("thumb_media_id"));
						article.setShow_cover_pic(artJson.getString("show_cover_pic"));
						article.setAuthor(artJson.getString("author"));
						article.setDigest(artJson.getString("digest"));
						article.setContent(artJson.getString("content"));
						article.setUrl(artJson.getString("url"));
						article.setContent_source_url(artJson.getString("content_source_url"));
						artList.add(article);
					}
					hm.put("media_id", subJson.getString("media_id"));
					hm.put("update_time", subJson.getString("update_time"));
					hm.put("content", artList);
					list.add(hm);
				}
			}
			
			//其他类型（图片、语音、视频）素材列表
			else{
				JSONArray items = resJson.getJSONArray("item");
				HashMap<String,String> hm;
				JSONObject subJson;
				for(int i=0;i<items.length();i++){
					subJson = items.getJSONObject(i);
					hm = new HashMap<String,String>();
					hm.put("media_id", subJson.getString("media_id"));
					hm.put("name", subJson.getString("name"));
					hm.put("update_time", subJson.getString("update_time"));
					if(response.contains("url")){
						hm.put("url", subJson.getString("url"));
					}
					list.add(hm);
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return list;
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
		
		//1、获取accesstoken
//		AccessTokenManager  atm  = new AccessTokenManager();
//		AccessTokenManager.accesstoken = "Ee2jCrzRQ1yqbs8Ibb4F_-OW5kXO9scYrWXQtCwk6Zd9uNKfLTIGSj3wZm_Re8cHs4sLga3snqy9lVhClgAFk1L-wc0GED4RjOFDfZkwY7KU27yJGbiuN5VD-Itz93ZpGAIcAHABVD";
			
		//2、测试新增永久图文素材
//		MaterialManager mm = new MaterialManager();
//		List<Article> list = new ArrayList<Article>();
//		//单图文
//		Article article = new Article();
//		article.setTitle("test");
//		article.setThumb_media_id("DNkPiq_x1JFtepHpgHXo59cGUTU749G5cnBcjtBcFRg");
//		article.setAuthor("tt");
//		article.setDigest("this is digest");
//		article.setShow_cover_pic("1");
//		article.setContent("test1\ntest2\ntest3\nyou are beautiful");
//		article.setContent_source_url("http://www.ipaiban.com");
//		list.add(article);
//		//多图文
//		article = new Article();
//		article.setTitle("testtest");
//		article.setThumb_media_id("DNkPiq_x1JFtepHpgHXo59cGUTU749G5cnBcjtBcFRg");
//		article.setAuthor("tt2");
//		article.setDigest("this is another digest");
//		article.setShow_cover_pic("1");
//		article.setContent("test1\ntest2\ntest3\nyou are handsome");
//		article.setContent_source_url("http://www.ipaiban.com");
//		list.add(article);
//		
//		String mediaId = mm.addNews(list);
//		System.out.println("----------add news----------");
//		System.out.println(mediaId);
		
		//3、测试上传图文消息里的图片获取URL
//		MaterialManager mm = new MaterialManager();
//		String filePath = "D:\\XHR\\ScanLogin\\uploadTest\\wukonglai.jpg";
//		String imgurl = mm.uploadImg(filePath);
//		System.out.println("----------get image url----------");
//		System.out.println(imgurl);
		
		//4-1、上传永久图片素材
//		MaterialManager mm = new MaterialManager();
//		String filePath = "D:\\XHR\\ScanLogin\\uploadTest\\wukonglai.jpg";
//		String type = "image";
//		HashMap<String, String> hm = mm.addMaterial(filePath, type, null);
//		Object[] keys = hm.keySet().toArray();
//		System.out.println("----------upload image----------");
//		for(int i=0;i<keys.length;i++){
//			System.out.println(keys[i]+": "+hm.get(keys[i]));
//		}
		
		//4-2、上传永久语音素材
//		MaterialManager mm = new MaterialManager();
//		String filePath = "D:\\XHR\\ScanLogin\\uploadTest\\1351.amr";
//		String type = "voice";
//		HashMap<String, String> hm = mm.addMaterial(filePath, type, null);
//		Object[] keys = hm.keySet().toArray();
//		System.out.println("----------upload voice----------");
//		for(int i=0;i<keys.length;i++){
//			System.out.println(keys[i]+": "+hm.get(keys[i]));
//		}
		
		//4-3、上传永久视频素材
//		MaterialManager mm = new MaterialManager();
//		String filePath = "D:\\XHR\\ScanLogin\\uploadTest\\coin_RPCA.mp4";
//		String type = "video";
//		HashMap<String, String> description = new HashMap<String, String>();
//		description.put("title","coin");
//		description.put("introduction","video test");
//		HashMap<String, String> hm = mm.addMaterial(filePath, type, description);
//		Object[] keys = hm.keySet().toArray();
//		System.out.println("----------upload video----------");
//		for(int i=0;i<keys.length;i++){
//			System.out.println(keys[i]+": "+hm.get(keys[i]));
//		}
		
		//4-4、上传永久缩略图素材
//		MaterialManager mm = new MaterialManager();
//		String filePath = "D:\\XHR\\ScanLogin\\uploadTest\\wukonglai.jpg";
//		String type = "thumb";
//		HashMap<String, String> hm = mm.addMaterial(filePath, type, null);
//		Object[] keys = hm.keySet().toArray();
//		System.out.println("----------upload thumb----------");
//		for(int i=0;i<keys.length;i++){
//			System.out.println(keys[i]+": "+hm.get(keys[i]));
//		}
		
		//5、测试获取永久图文素材
//		MaterialManager mm = new MaterialManager();
//		String mediaId = "DNkPiq_x1JFtepHpgHXo5372hZWypUwL_BF-kseJoIs";//单图文
//		String mediaId = "DNkPiq_x1JFtepHpgHXo5x5hXParS-R8oBm1KcKERxw";//多图文
//		List<Article> list = mm.getMaterial_article(mediaId);
//		System.out.println("----------get articles----------");
//		for(int i=0;i<list.size();i++){
//			Article article = list.get(i);
//			System.out.println("------#"+i+"------");
//			System.out.println("title: "+article.getTitle());
//			System.out.println("thumb_media_id: "+article.getThumb_media_id());
//			System.out.println("show_cover_pic: "+article.getShow_cover_pic());
//			System.out.println("author: "+article.getAuthor());
//			System.out.println("digest: "+article.getDigest());
//			System.out.println("content: "+article.getContent());
//			System.out.println("url: "+article.getUrl());
//			System.out.println("content_source_url: "+article.getContent_source_url());
//		}
		
		//6、测试获取永久视频素材URL
//		MaterialManager mm = new MaterialManager();
//		String mediaId = "DNkPiq_x1JFtepHpgHXo5yHEJyEXUiAwX2Q0pwVWvtI";
//		HashMap<String, String> hm = mm.getMaterial_videoUrl(mediaId);
//		Object[] keys = hm.keySet().toArray();
//		System.out.println("----------get video url----------");
//		for(int i=0;i<keys.length;i++){
//			System.out.println(keys[i]+": "+hm.get(keys[i]));
//		}
		
		//7-1、测试获取永久图片素材
//		MaterialManager mm = new MaterialManager();
//		String mediaId = "DNkPiq_x1JFtepHpgHXo53LkY8Jljwh965FFoE1ebyY";
//		String filePath = "D:\\";
//		String fileName = "test.jpg";
//		boolean success = mm.downMaterial(mediaId, filePath, fileName);
//		System.out.println("----------get image----------");
//		System.out.println(success);
		
		//7-2、测试获取永久语音素材
//		MaterialManager mm = new MaterialManager();
//		String mediaId = "DNkPiq_x1JFtepHpgHXo55dMqa3pzt8IQybeuGIMnK8";
//		String filePath = "D:\\";
//		String fileName = "test.amr";
//		boolean success = mm.downMaterial(mediaId, filePath, fileName);
//		System.out.println("----------get voice----------");
//		System.out.println(success);
		
		//7-3、测试获取永久视频素材
//		MaterialManager mm = new MaterialManager();
//		String mediaId = "DNkPiq_x1JFtepHpgHXo5yHEJyEXUiAwX2Q0pwVWvtI";
//		String filePath = "D:\\";
//		String fileName = "test.mp4";
//		boolean success = mm.downMaterial(mediaId, filePath, fileName);
//		System.out.println("----------get video----------");
//		System.out.println(success);
		
		//7-4、测试获取永久缩略图素材
//		MaterialManager mm = new MaterialManager();
//		String mediaId = "DNkPiq_x1JFtepHpgHXo59cGUTU749G5cnBcjtBcFRg";
//		String filePath = "D:\\";
//		String fileName = "test2.jpg";
//		boolean success = mm.downMaterial(mediaId, filePath, fileName);
//		System.out.println("----------get thumb----------");
//		System.out.println(success);
		
		//7-5、测试获取永久缩略图素材失败
//		MaterialManager mm = new MaterialManager();
//		String mediaId = "_x1JFtepHpgHXo59cGUTU749G5cnBcjtBcFRg";
//		String filePath = "D:\\";
//		String fileName = "test2.jpg";
//		boolean success = mm.downMaterial(mediaId, filePath, fileName);
//		System.out.println("----------get thumb----------");
//		System.out.println(success);
		
		//8、测试删除素材
//		MaterialManager mm = new MaterialManager();
//		String mediaId = "DNkPiq_x1JFtepHpgHXo59cGUTU749G5cnBcjtBcFRg";
//		boolean success = mm.deleteMaterial(mediaId);
//		System.out.println("----------delete material----------");
//		System.out.println(success);
		
		//9、测试修改永久图文素材
//		MaterialManager mm = new MaterialManager();
//		Article article = new Article();
//		article.setTitle("testupdate");
//		article.setThumb_media_id("DNkPiq_x1JFtepHpgHXo59cGUTU749G5cnBcjtBcFRg");
//		article.setAuthor("ss");
//		article.setDigest("this is another digest");
//		article.setShow_cover_pic("");
//		article.setContent("test1\ntest2\ntest3\nyou are handsome!");
//		article.setContent_source_url("http://www.ipaiban.com");
//		String mediaId = "DNkPiq_x1JFtepHpgHXo5x5hXParS-R8oBm1KcKERxw";
//		int index = 1;
//		boolean success = mm.updateNews(mediaId, index, article);
//		System.out.println("----------update news----------");
//		System.out.println(success);
		
		//10、测试获取永久素材总数
//		MaterialManager mm = new MaterialManager();
//		HashMap<String, Integer> hm = mm.getMaterialCount();
//		Object[] keys = hm.keySet().toArray();
//		System.out.println("----------get material count----------");
//		for(int i=0;i<keys.length;i++){
//			System.out.println(keys[i]+": "+hm.get(keys[i]));
//		}
		
		//11、测试获取永久素材列表
//		MaterialManager mm = new MaterialManager();
//		String type = "image";
//		String type = "voice";
//		String type = "video";
//		String type = "news";
//		int offset = 2;
//		int count = 2;
//		List<HashMap> list = mm.getMaterilaList(type, offset, count);
//		System.out.println("----------get material list----------");
//		//非图文
//		for(int i=0;i<list.size();i++){
//			Object[] keys = list.get(i).keySet().toArray();
//			System.out.println("------#"+i+"------");
//			for(int j=0;j<keys.length;j++){
//				System.out.println(keys[j]+": "+list.get(i).get(keys[j]));
//			}
//		}
//		//图文
//		for(int i=0;i<list.size();i++){
//			System.out.println("------#"+i+"------");
//			List<Article> artlist = (List<Article>) list.get(i).get("content");
//			for(int j=0;j<artlist.size();j++){
//				Article article = artlist.get(j);
//				System.out.println("------#"+j+"#------");
//				System.out.println("title: "+article.getTitle());
//				System.out.println("thumb_media_id: "+article.getThumb_media_id());
//				System.out.println("show_cover_pic: "+article.getShow_cover_pic());
//				System.out.println("author: "+article.getAuthor());
//				System.out.println("digest: "+article.getDigest());
//				System.out.println("content: "+article.getContent());
//				System.out.println("url: "+article.getUrl());
//				System.out.println("content_source_url: "+article.getContent_source_url());
//			}
//		}

	}
}
