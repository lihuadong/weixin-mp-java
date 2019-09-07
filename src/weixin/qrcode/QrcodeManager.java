/**
 * 包到位小程序SaaS
 * weixin.qrcode
 * QrcodeManager.java
 * Ver0.0.1
 * 2016年6月27日-下午1:51:16
 *  2014-2019 全智道(北京)科技有限公司
 * 
 */
package weixin.qrcode;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import weixin.base.APIBaseConfig;
import weixin.util.HttpsDataManager;

/**
 * 
 * QrcodeManager
 * 
 * 李华栋
 * 李华栋
 * 2016年6月27日 下午1:51:16
 * 
 * @version 0.0.1
 * 
 */
public class QrcodeManager {
	
	private String accesstoken;
	  
	public QrcodeManager(String accesstoken){
		this.accesstoken = accesstoken;
	}
	
	/**
	 * getTempQrcode(获取临时二维码ticket)
	 * @param expire, sceneId
	 * @return 
	 *Map
	 * @exception 
	 * @since  0.0.1
	 */
	public HashMap<String, Object> getTempQrcode(int expire, int sceneId){
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		
		//临时二维码有效时间最长为30天
		if(expire>2592000){
			expire = 2592000;
		}
		
		//填充请求内容
		JSONObject rootJson = new JSONObject();
		try {
			rootJson.put("expire_seconds", expire);
			rootJson.put("action_name", "QR_SCENE");
			
			JSONObject scene_id = new JSONObject();
			scene_id.put("scene_id", sceneId);
			
			JSONObject scene = new JSONObject();
			scene.put("scene", scene_id);
			
			rootJson.put("action_info", scene);
			
			 //System.out.println("QrcodeManager getTempQrcode:"+rootJson.toString());
			 
		} catch (JSONException e) {
			e.printStackTrace();
		}		
				
		//调用接口
	    String url = APIBaseConfig.QRCode_GET_URL+this.accesstoken;
	    String response = HttpsDataManager.sendData(url, rootJson.toString());
	    
		//解析对应的JSON代码
	    try{
	    	
		    	JSONObject responseJson = new JSONObject(response);
		    	hm.put("ticket", responseJson.getString("ticket"));
		    	hm.put("expire_seconds", responseJson.getInt("expire_seconds"));
		    	hm.put("url", responseJson.getString("url").replace("\\",""));
		    	
	    } catch(JSONException e){	    	
	    		e.printStackTrace();
	    }
	    
	    return hm;
	}
	
	/**
	 * getTempQrcode(获取临时二维码ticket)
	 * @param sceneId
	 * @return 
	 *Map
	 * @exception 
	 * @since  0.0.1
	 */
	public HashMap getTempQrcode(int sceneId){
		
		//临时二维码默认有效期为60秒
		return getTempQrcode(60, sceneId);
	}
	
	/**
	 * getPermQrcode(获取永久二维码ticket_指定字符串)
	 * @param sceneStr
	 * @return 
	 *Map
	 * @exception 
	 * @since  0.0.1
	 */
	public HashMap getPermQrcode(String sceneStr){
		
		HashMap<String, String> hm = new HashMap<String, String>();
				
		//填充请求内容
		JSONObject rootJson = new JSONObject();
		try {
			rootJson.put("action_name", "QR_LIMIT_STR_SCENE");
			
			JSONObject scene_str = new JSONObject();
			scene_str.put("scene_str", sceneStr);
			JSONObject scene = new JSONObject();
			scene.put("scene", scene_str);
			rootJson.put("action_info", scene);
		} catch (JSONException e) {
			e.printStackTrace();
		}		
				
		//调用创建标签接口
	    String url = APIBaseConfig.QRCode_GET_URL+this.accesstoken;
	    String response = HttpsDataManager.sendData(url, rootJson.toString());
	    
		//解析对应的JSON代码
	    try{
	    	JSONObject responseJson = new JSONObject(response);
	    	hm.put("ticket", responseJson.getString("ticket"));
	    	hm.put("url", responseJson.getString("url").replace("\\",""));
	    } catch(JSONException e){
	    	System.out.println(response);
	    }
	    
	    return hm;
	}
	
	/**
	 * getPermQrcode(获取永久二维码ticket_指定ID)
	 * @param sceneId
	 * @return 
	 *Map
	 * @exception 
	 * @since  0.0.1
	 */
	public HashMap getPermQrcode(int sceneId){
		
		HashMap<String, String> hm = new HashMap<String, String>();
				
		//填充请求内容
		JSONObject rootJson = new JSONObject();
		try {
			rootJson.put("action_name", "QR_LIMIT_SCENE");
			
			JSONObject scene_id = new JSONObject();
			scene_id.put("scene_id", sceneId);
			JSONObject scene = new JSONObject();
			scene.put("scene", scene_id);
			rootJson.put("action_info", scene);
		} catch (JSONException e) {
			e.printStackTrace();
		}		
				
		//调用创建标签接口
	    String url = APIBaseConfig.QRCode_GET_URL+this.accesstoken;
	    String response = HttpsDataManager.sendData(url, rootJson.toString());
	    
		//解析对应的JSON代码
	    try{
	    	JSONObject responseJson = new JSONObject(response);
	    	hm.put("ticket", responseJson.getString("ticket"));
	    	hm.put("url", responseJson.getString("url").replace("\\",""));
	    } catch(JSONException e){
	    	System.out.println(response);
	    }
	    
	    return hm;
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
//		AccessTokenManager.accesstoken = "3vIszRQqBgan51iMPx_3EPXwGDSOVIaHGopFB0n2cU7XK1FxhC6vt5ds2kVXbQhlrMcJRPuJa3UZVy9KdL0KY_ZT8k41bJ4TDpxGzVvZcDmCuIitjIHNXjv37o1v0ySZLWQgADAGRL";
		
		//2、测试获取临时二维码ticket
//		QrcodeManager qm = new QrcodeManager();
//		HashMap hm = qm.getTempQrcode(120, 001);
//		System.out.println("----------get temp qrcode----------");
//		System.out.println("ticket: "+hm.get("ticket"));
//		System.out.println("expire seconds: "+hm.get("expire_seconds"));
//		System.out.println("url: "+hm.get("url"));
		
		//3、测试获取临时二维码ticket（默认有效时间）
//		QrcodeManager qm = new QrcodeManager();
//		HashMap hm = qm.getTempQrcode(002);
//		System.out.println("----------get temp qrcode(default)----------");
//		System.out.println("ticket: "+hm.get("ticket"));
//		System.out.println("expire seconds: "+hm.get("expire_seconds"));
//		System.out.println("url: "+hm.get("url"));
		
		//4、测试获取永久二维码ticket（scene_id）
//		QrcodeManager qm = new QrcodeManager();
//		HashMap hm = qm.getPermQrcode(003);
//		System.out.println("----------get permanent qrcode(scene_id)----------");
//		System.out.println("ticket: "+hm.get("ticket"));
//		System.out.println("url: "+hm.get("url"));
		
		//5、测试获取永久二维码ticket（scene_str）
//		QrcodeManager qm = new QrcodeManager();
//		HashMap hm = qm.getPermQrcode("abc");
//		System.out.println("----------get permanent qrcode(scene_str)----------");
//		System.out.println("ticket: "+hm.get("ticket"));
//		System.out.println("url: "+hm.get("url"));
		
	}

}
