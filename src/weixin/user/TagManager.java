/**
 * 
 * 微信-公众号-封装接口JAVA版本
 * weixin.user
 * UserTagManager.java
 * Ver0.0.1
 * 2016年6月21日-下午1:29:41
 * 2014-2019 ©全智道(北京)科技有限公司
 * 
 */

package weixin.user;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import weixin.base.APIURL;
import weixin.util.HTTPSDataManager;

/**
 * 
 * TagManager
 * 
 * 李华栋
 * 2016年6月21日 下午1:29:41
 * 
 * @version 0.0.1
 * 
 */
public class TagManager {
	
	private String accesstoken;
	  
	public TagManager(String accesstoken){
		this.accesstoken = accesstoken;
	}

    /**
     * 
     * 创建标签
     * 一个公众号，最多可以创建100个标签。
     * @param tag
     * @return JSONObject
     * @exception 
     * @since  0.0.1
     */
	public JSONObject createTag(String tag){
		//构建请求信息
		JSONObject rootJson = new JSONObject();
		JSONObject subJson = new JSONObject();
		try {
			subJson.put("name", tag);
			rootJson.put("tag", subJson);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		
		//调用创建标签接口
	    String url = APIURL.CREATE_TAG+this.accesstoken;
	    String response = HTTPSDataManager.sendData(url, rootJson.toString());
	    JSONObject responseJson =null;
		
	    //解析对应的JSON代码
	    try{
	    	responseJson  = new JSONObject(response);
	    	
	    } catch(JSONException e){
	    	e.printStackTrace();
	    }
	    
		return responseJson;
	}
	
	/**
	 * 
	 * 获取公众号已创建的标签
	 * @param tag
	 * @return JSONObject
	 * @exception 
	 * @since  0.0.1
	 */
	public JSONObject getTag(){

		//调用查询标签接口
	    String url = APIURL.GET_TAG+this.accesstoken;
	    String response = HTTPSDataManager.sendData(url);
	    JSONObject responseJson =null;
		//解析对应的JSON代码
	    try{
	    	responseJson  = new JSONObject(response);	
	    } catch(JSONException e){
	    	e.printStackTrace();
	    }
	    
		return responseJson;
	}
	
	/**
	 * 
	 * updateTag(编辑标签)
	 * @param id
	 * @param tag
	 * @return 
	 *boolean
	 * @exception 
	 * @since  0.0.1
	 */
	public boolean updateTag(int id,String tag){
		boolean success = false;
		
		//构建请求信息
		JSONObject rootJson = new JSONObject();
		JSONObject subJson = new JSONObject();
		try {
			subJson.put("id", id);
			subJson.put("name", tag);
			rootJson.put("tag", subJson);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		
		//调用编辑标签接口
	    String url = APIURL.UPDATE_TAG+this.accesstoken;
	    String response = HTTPSDataManager.sendData(url, rootJson.toString());
	    
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
	 * 删除标签(deleteTag)
	 * 请注意，当某个标签下的粉丝超过10w时，后台不可直接删除标签。
	 * 此时，开发者可以对该标签下的openid列表，先进行取消标签的操作，
	 * 直到粉丝数不超过10w后，才可直接删除该标签。
	 * @param id
	 * @return 
	 *boolean
	 * @exception 
	 * @since  0.0.1
	 */
	public boolean deleteTag(int id){
		boolean success = false;
		
		//构建请求信息
		JSONObject rootJson = new JSONObject();
		JSONObject subJson = new JSONObject();
		try {
			subJson.put("id", id);
			rootJson.put("tag", subJson);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		
		//调用删除标签接口
	    String url = APIURL.DELETE_TAG+this.accesstoken;
	    String response = HTTPSDataManager.sendData(url, rootJson.toString());
	    
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
	 * 获取标签下粉丝列表(getOpenidListByTag)
	 * 如果数据比较多的时候需要反复拉取
	 * @param id
	 * @param next_openid
	 * @return 
	 *List
	 * @exception 
	 * @since  0.0.1
	 */
	public List<String> getOpenidListByTag(int id,String next_openid){
		List<String> userList = new ArrayList<String>();
		String firstId = next_openid;
		int count = 0;
		
		while(true){
			//构建请求信息
			JSONObject rootJson = new JSONObject();
			try {
				rootJson.put("tagid", id);
				rootJson.put("next_openid", firstId);
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		
			//调用获取标签下粉丝列表接口
			String url = APIURL.GET_USERLIST_TAG+this.accesstoken;
			String response = HTTPSDataManager.sendData(url, rootJson.toString());
	    
			//解析对应的JSON代码
			try{
				JSONObject responseJson  = new JSONObject(response);
				count = responseJson.getInt("count");
				if(count==0)
					break;
				JSONObject data = (JSONObject) responseJson.get("data");
				JSONArray openid = (JSONArray) data.get("openid");
				for(int i=0;i<count;i++){
					userList.add(openid.get(i).toString());
				}
				firstId = responseJson.getString("next_openid");
			} catch(JSONException e){
				System.out.println(response);
				break;
			}
		}
		
		return userList;
	}
	
}
