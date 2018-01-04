/**
 * 包打听全知道-微信H5版本
 * weixin.user
 * UserTagManager.java
 * Ver0.0.1
 * 2016年6月21日-下午1:59:00
 *  2016全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.user;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import weixin.base.APIBaseConfig;
import weixin.util.HttpsDataManager;

/**
 * 
 * UserTagManager
 * 
 * 李华栋
 * 李华栋
 * 2016年6月21日 下午1:59:00
 * 
 * @version 0.0.1
 * 
 */
public class UserTagManager {
	
	private String accesstoken;
	  
	public UserTagManager(String accesstoken){
		this.accesstoken = accesstoken;
	}

	/**
	 * 
	 * addUserTag(批量为用户打标签)
	 * 标签功能目前支持公众号为用户打上最多三个标签
	 * @param tagid
	 * @param openidList
	 * @return 
	 *boolean
	 * @exception 
	 * @since  0.0.1
	 */
	public boolean addUserTag(int tagid, List openidList){
		
		boolean success = false;
	
		//构建请求信息
		JSONObject rootJson = new JSONObject();
		JSONArray subJson = new JSONArray();
		try {
			for(int i=0;i<openidList.size();i++){
				subJson.put(openidList.get(i));
			}
			rootJson.put("openid_list", subJson);
			rootJson.put("tagid", tagid);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		
		//调用批量打标签接口
	    String url = APIBaseConfig.ADD_USERTAG+this.accesstoken;
	    String response = HttpsDataManager.sendData(url, rootJson.toString());
	    
		//解析对应的JSON代码
	    try{
	    	JSONObject responseJson  = new JSONObject(response);
	    	if(responseJson.getString("errmsg").equals("ok"))
	    		success = true;
	    } catch(JSONException e){
	    	System.out.println(response);
	    }
	    
	    return success;
	}
	
	/**
	 * 
	 * deleteUserTag(批量为用户取消标签)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param tagid
	 * @param openidList
	 * @return 
	 *boolean
	 * @exception 
	 * @since  0.0.1
	 */
	public boolean deleteUserTag(int tagid, List openidList){
		
		boolean success = false;
		
		//构建请求信息
		JSONObject rootJson = new JSONObject();
		JSONArray subJson = new JSONArray();
		try {
			for(int i=0;i<openidList.size();i++){
				subJson.put(openidList.get(i));
			}
			rootJson.put("openid_list", subJson);
			rootJson.put("tagid", tagid);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		
		//调用批量取消标签接口
	    String url = APIBaseConfig.DELETE_USERTAG+this.accesstoken;
	    String response = HttpsDataManager.sendData(url, rootJson.toString());
	    
		//解析对应的JSON代码
	    try{
	    	JSONObject responseJson  = new JSONObject(response);
	    	if(responseJson.getString("errmsg").equals("ok"))
	    		success = true;
	    } catch(JSONException e){
	    	System.out.println(response);
	    }
	    
	    return success;
	}
	
	/**
	 * 
	 * getUserTag(获取用户身上的标签列表)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param openid
	 * @return 
	 *List
	 * @exception 
	 * @since  0.0.1
	 */
	public List getUserTag(String openid){
		
		List<String> tagList = new ArrayList<String>();
		
		//构建请求信息
		JSONObject rootJson = new JSONObject();
		try {
			rootJson.put("openid", openid);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		
		//调用获取用户标签列表接口
	    String url = APIBaseConfig.GET_USERTAG+this.accesstoken;
	    String response = HttpsDataManager.sendData(url, rootJson.toString());
	    
	    //解析对应的JSON代码
	    try{
	    	JSONObject responseJson  = new JSONObject(response);
	    	JSONArray tags = responseJson.getJSONArray("tagid_list");
	    	for(int i=0;i<tags.length();i++){
	    		tagList.add(tags.get(i).toString());
	    	}
	    } catch(JSONException e){
	    	System.out.println(response);
	    }
	    
		return tagList;	
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
