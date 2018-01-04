/**
 * 包打听全知道-微信H5版本
 * weixin.user
 * UserTagManager.java
 * Ver0.0.1
 * 2016年6月21日-下午1:29:41
 *  2016全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.user;

import java.util.ArrayList;
import java.util.HashMap;
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
     * createTag创建标签)
     *一个公众号，最多可以创建100个标签。
     * @param tag
     * @return 
     *HashMap
     * @throws JSONException 
     * @exception 
     * @since  0.0.1
     */
	public HashMap createTag(String tag){
		HashMap<String, String> hm = new HashMap<String, String>();
		
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
	    String url = APIBaseConfig.CREATE_TAG+this.accesstoken;
	    String response = HttpsDataManager.sendData(url, rootJson.toString());
	    
		//解析对应的JSON代码
	    try{
	    	JSONObject responseJson  = new JSONObject(response);
	    	JSONObject content = (JSONObject)responseJson.get("tag");
	    	hm.put("id", content.getString("id"));
	    	hm.put("name", content.getString("name"));
	    	hm.put("count", "0");
	    } catch(JSONException e){
	    	System.out.println(response);
	    }
	    
		return hm;
	}
	
	/**
	 * 
	 * getTag(获取公众号已创建的标签)
	 * @param tag
	 * @return 
	 *List
	 * @exception 
	 * @since  0.0.1
	 */
	public List getTag(String tag){
		//每一个list元素都是一个hashmap
		//map.put("id","1");
		//map.put("name","1");
		//map.put("count","1");
		
		List<HashMap> tagList = new ArrayList<HashMap>();
		HashMap<String, String> hm = null;
		
		//调用查询标签接口
	    String url = APIBaseConfig.GET_TAG+this.accesstoken;
	    String response = HttpsDataManager.sendData(url);
	    
		//解析对应的JSON代码
	    try{
	    	JSONObject responseJson  = new JSONObject(response);	
	    	JSONArray tags = (JSONArray) responseJson.get("tags");
	    	JSONObject content = null;
	    	for(int i=0;i<tags.length();i++){
	    		content = tags.getJSONObject(i);
	    		hm = new HashMap<String, String>();
	    		hm.put("id", content.getInt("id")+"");
		    	hm.put("name", content.getString("name"));
		    	hm.put("count", content.getInt("count")+"");
		    	tagList.add(hm);
	    	}
	    } catch(JSONException e){
	    	System.out.println(response);
	    }
	    
		return tagList;
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
	    String url = APIBaseConfig.UPDATE_TAG+this.accesstoken;
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
	 * deleteTag(删除标签)
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
	    String url = APIBaseConfig.DELETE_TAG+this.accesstoken;
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
	 * getOpenidListByTag(获取标签下粉丝列表)
	 * 如果数据比较多的时候需要反复拉取
	 * @param id
	 * @param next_openid
	 * @return 
	 *List
	 * @exception 
	 * @since  0.0.1
	 */
	public List getOpenidListByTag(int id,String next_openid){
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
			String url = APIBaseConfig.GET_USERLIST_TAG+this.accesstoken;
			String response = HttpsDataManager.sendData(url, rootJson.toString());
	    
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
//		AccessTokenManager.accesstoken = "jyKAXeB6SbV7y389kiTo69grzN9y9IXpSmK9IawjsWBXdx22WWRBe2O-aoIHLrTSOkpfMtfE85qgABopiBw6LfTVYi0eGPVfJgyNcne1OCRuuXFKrH_ZNXega5i2zYBGPVHhABAAGS";
		
		//2、测试创建标签(129)
//		TagManager tm = new TagManager();
//		HashMap create_hm = tm.createTag("testtest");
//		System.out.println("----------create a tag----------");
//		System.out.println("id: "+create_hm.get("id"));
//		System.out.println("name: "+create_hm.get("name"));
//		System.out.println("count: "+create_hm.get("count"));
		
		//3、测试修改标签名字(139)
//		TagManager tm = new TagManager();
//		boolean result = tm.updateTag(100,"testtesttest");
//		System.out.println("----------update a tag----------");
//		System.out.println("result: "+result);		
		
		//4、测试给用户打标签(14689)
//		UserTagManager utm = new UserTagManager();
//		List<String> openidList = new ArrayList<String>();
//		openidList.add("oFHIYt2guBTMngMiwFCAQdpOlu5k");
//		openidList.add("oFHIYtxveXh57uRNKptUAwBH2u7Y");
//		System.out.println("----------add tags for users----------");
//		System.out.println(utm.addUserTag(2, openidList));
//		System.out.println(utm.addUserTag(100, openidList));
		
		//5、测试删除用户标签(15689)
//		UserTagManager utm = new UserTagManager();
//		List<String> openidList = new ArrayList<String>();
//		openidList.add("oFHIYt2guBTMngMiwFCAQdpOlu5k");
//		openidList.add("oFHIYtxveXh57uRNKptUAwBH2u7Y");
//		System.out.println("----------delete a tag for users----------");
//		System.out.println(utm.deleteUserTag(2, openidList));
		
		//6、测试获取标签下用户列表
//		TagManager tm = new TagManager();
//		List<String> userList = null;
//		System.out.println("----------get userlist of a tag----------");
//		userList = tm.getOpenidListByTag(2, "");
//		System.out.println("---1---");
//		for(int i=0;i<userList.size();i++){
//			System.out.println(userList.get(i));
//		}
//		userList = tm.getOpenidListByTag(100, "");
//		System.out.println("---2---");
//		for(int i=0;i<userList.size();i++){
//			System.out.println(userList.get(i));
//		}
//		userList = tm.getOpenidListByTag(100, "oFHIYtxveXh57uRNKptUAwBH2u7Y");///加第一个openid
//		System.out.println("---3---");
//		for(int i=0;i<userList.size();i++){
//			System.out.println(userList.get(i));
//		}
		
		//7、测试删除标签(179)->(168)
//		TagManager tm = new TagManager();
//		System.out.println("----------delete a tag----------");
//		System.out.println(tm.deleteTag(100));
		
		//8、测试获取用户标签
//		UserTagManager utm = new UserTagManager();
//		List<String> tagList = utm.getUserTag("oFHIYt2guBTMngMiwFCAQdpOlu5k");
//		System.out.println("----------get tags of a user----------");
//		for(int i=0;i<tagList.size();i++){
//			System.out.println(tagList.get(i));
//		}
		
		//9、测试获取已创建标签
//		TagManager tm = new TagManager();
//		List list = tm.getTag("");
//		HashMap hm;
//		System.out.println("----------get tags----------");
//		for(int i=0;i<list.size();i++){
//			hm = (HashMap) list.get(i);
//			System.out.println("id: "+hm.get("id"));
//			System.out.println("name: "+hm.get("name"));
//			System.out.println("count: "+hm.get("count"));
//		}
		
	}
}
