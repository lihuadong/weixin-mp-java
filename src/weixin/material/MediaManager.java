/**
 * 
 * 微信-公众号-封装接口JAVA版本
 * weixin.material
 * MediaManager.java
 * Ver0.0.1
 * 2016年6月27日-下午4:09:31
 * 2014-2019 ©全智道(北京)科技有限公司
 * 
 */
package weixin.material;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import weixin.base.APIURL;
import weixin.util.HttpsFileUpload;

/**
 * 
 * MediaManager 临时素材管理
 * 
 * 李华栋
 * 2016年6月27日 下午4:09:31
 * 
 * @version 0.0.1
 * 
 */
public class MediaManager {
	
	private String accesstoken;
	private JSONObject resultJSON;
	
	public MediaManager(String accesstoken){
		this.accesstoken = accesstoken;
		resultJSON = null;
	}
	
	/**
	 * 新增临时素材addMedia 
	 * @param filePath
	 * @param type
	 * @return
	 */
	public JSONObject addMedia(String filePath,String type){
		
		String url = APIURL.ADD_MEDIA+ this.accesstoken+"&type="+type;
		HttpsFileUpload hf = new HttpsFileUpload();
		Map<String, String> fileMap = new HashMap<String, String>();
		fileMap.put("media", filePath);
		String response = hf.formUpload(url, null, fileMap);
		
		try {
			resultJSON = new JSONObject(response);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return resultJSON;
	}
	
	/**
	 * 下载永久素材到本地（除图文）downMedia  获取临时素材（图片、视频、语音、缩略图）
	 * @param mediaId
	 * @param filePath
	 * @param fileName
	 * @return
	 */
	public boolean downMedia(String mediaId, String filePath, String fileName){
		
		boolean flag = true;
		String url = APIURL.GET_MEDIA+ this.accesstoken+"&media_id="+mediaId;
		
		try {
			URL mediaUrl = new URL(url);
			HttpURLConnection mediaConn;
			mediaConn = (HttpURLConnection) mediaUrl.openConnection();
			mediaConn.setDoOutput(true);
			mediaConn.setRequestMethod("GET");
			
			//获取媒体文件
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			BufferedInputStream bis = new BufferedInputStream(mediaConn.getInputStream());
			byte[] buf = new byte[8096];
			int size = 0;
			while ((size = bis.read(buf)) != -1) {
				outputStream.write(buf, 0, size);
			}
			
			//将媒体文件写到本地文件
			String contentType = mediaConn.getHeaderField("Content-Type");
			if(contentType.equals("text/plain")){
				String response = outputStream.toString();
				//下载临时视频素材
				if(response.contains("video_url")){
					String video_url = response.substring(14,response.length()-2);
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
				} else{
					fileName = "getMedia_ErrorLog.txt";
					flag = false;
				}
			}
			File file = new File(filePath + fileName);    
            FileOutputStream fops = new FileOutputStream(file);    
            fops.write(outputStream.toByteArray());
            fops.flush();
            fops.close();
            outputStream.close();
            bis.close();
            mediaConn.disconnect();
		} catch (IOException e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}
	

	

}
