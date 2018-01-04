/**
 * 包打听全知道-微信H5版本
 * weixin.material
 * MediaManager.java
 * Ver0.0.1
 * 2016年6月27日-下午4:09:31
 *  2016全智道(北京)科技有限公司-版权所有
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

import weixin.base.APIBaseConfig;
import weixin.util.HttpsDataManager;
import weixin.util.HttpsFileUpload;

/**
 * 
 * MediaManager 临时素材管理
 * 
 * 李华栋
 * 李华栋
 * 2016年6月27日 下午4:09:31
 * 
 * @version 0.0.1
 * 
 */
public class MediaManager {
	
	private String accesstoken;
	  
	public MediaManager(String accesstoken){
		this.accesstoken = accesstoken;
	}
	
	/**
	 * addMedia 新增临时素材
	 * @param filePath
	 * @param type
	 * @return
	 */
	public HashMap<String, String> addMedia(String filePath,String type){
		HashMap<String, String> hm = new HashMap<String, String>();
		
		String url = APIBaseConfig.ADD_MEDIA+ this.accesstoken+"&type="+type;
		HttpsFileUpload hf = new HttpsFileUpload();
		Map<String, String> fileMap = new HashMap<String, String>();
		fileMap.put("media", filePath);
		String response = hf.formUpload(url, null, fileMap);
		
		try {
			JSONObject res = new JSONObject(response);
			if(response.contains("create_at")){
				hm.put("type",res.getString("type"));
				hm.put("create_at", res.getString("created_at"));
				if(type.equals("thumb")){
					hm.put("thumb_media_id", res.getString("thumb_media_id"));
				} else{
					hm.put("media_id", res.getString("media_id"));
				}
				System.out.println(response);
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
	 * downMedia 获取临时素材（图片、视频、语音、缩略图）
	 * @param mediaId
	 * @param filePath
	 * @param fileName
	 * @return
	 */
	public boolean downMedia(String mediaId, String filePath, String fileName){
		
		boolean success = true;
		String url = APIBaseConfig.GET_MEDIA+ this.accesstoken+"&media_id="+mediaId;
		
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
					//System.out.println(video_url);
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
					success = false;
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
			success = false;
			e.printStackTrace();
		}
		return success;
	}
	
	/**
	 * getVideoUrl 获取临时视频素材url
	 * @param mediaId
	 * @return
	 */
	public String getVideoUrl(String mediaId){
		String video_url = "";
		
		String url = APIBaseConfig.GET_MEDIA+ this.accesstoken+"&media_id="+mediaId;
		String response = HttpsDataManager.sendData(url);
		if(response.contains("video_url")){
			video_url = response.substring(14,response.length()-2);
		} else{
			System.out.println(response);
		}
		
		return video_url;
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
//		AccessTokenManager.accesstoken = "XTdxjNOOLJClpHc1uVbCmno8LuaFZFIyIpa_IjgfVn4bgW5Dm-9B1jzkxbo7VFn27u0ilVmI3K62m1KdHXayodsOMWO0cyfgO_Q6E-z2VnNjSdD-eKNcH55wn74tDoWdOSOgAGACGC";
		
		//2、测试新增临时素材	
//		String type = "image";
//		String filePath = "D:\\XHR\\ScanLogin\\uploadTest\\wukonglai.jpg";
//		String type = "video";
//		String filePath = "D:\\XHR\\ScanLogin\\uploadTest\\coin_RPCA.mp4";
//		String type = "voice";
//		String filePath = "D:\\XHR\\ScanLogin\\uploadTest\\1351.amr";
//		String type = "thumb";
//		String filePath = "D:\\XHR\\ScanLogin\\uploadTest\\wukonglai.jpg";
//		
//		MediaManager mm = new MediaManager();
//		mm.addMedia(filePath, type);
		
		//3、测试获取临时素材
//		MediaManager mm = new MediaManager();
//		
//		String mediaId = "hS5BfXT1lVQ6XG-QaKzXsgPHQEyHK7wX46WWXPB5AR8j8DbCHQrl6TjjWrNf09ez";
//		System.out.println(mm.downMedia(mediaId, "D:\\", "test.jpg"));
//		String mediaId = "-2WpkXTV2v6aIGgHzWINmTHSnPEBbI9IxtG0Ir0e5n9aNuhkGRWzfNPIOIIIpLCl";
//		System.out.println(mm.downMedia(mediaId, "D:\\", "test.mp4"));
//		String mediaId = "rdTq08C7bsMESzds7RsB0M6y7ncziLCkUE8MPynMublwCBMbi8Rbt1WF-IGETWIc";
//		System.out.println(mm.downMedia(mediaId, "D:\\", "test.amr"));
//		String mediaId = "4w2GWvlnvv-iS6ASWHmMtxsuqndMw2kVJOtTWCQgm8LcOlgfjPgliavohzxl18n9";
//		System.out.println(mm.downMedia(mediaId, "D:\\", "test2.jpg"));
		
		//4、测试获取临时视频素材url
//		MediaManager mm = new MediaManager();
//		String mediaId = "-2WpkXTV2v6aIGgHzWINmTHSnPEBbI9IxtG0Ir0e5n9aNuhkGRWzfNPIOIIIpLCl";
//		String url = mm.getVideoUrl(mediaId);
//		System.out.println("----------video url----------");
//		System.out.println(url);
		
	}
}
