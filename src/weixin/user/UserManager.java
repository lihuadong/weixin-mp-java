/**
 * 微信-公众号-封装接口JAVA版本
 * weixin.user
 * UserManager.java
 * Ver0.0.1
 * 2016年5月4日-下午1:17:29
 * 2014-2019 全智道(北京)科技有限公司
 * 
 */
package weixin.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import weixin.base.APIURL;
import weixin.util.HTTPSDataManager;

/**
 * 
 * UserManager
 * 
 * 获取用户信息的方式中，通过关注获取的用户信息与通过网页面获取的用户是不一样的
 * 主要体现两者需要传的access_token 不一样。
 * 网页部分是通过OAuth的方式获取的
 * 普通的是通过两小时一个周期来获取的
 * 
 * 李华栋
 * 2016年5月4日 下午1:17:29
 * 
 * @version 0.0.1
 * 
 */
public class UserManager {

	private static Logger logger = Logger.getLogger(UserManager.class); 	
	
	private String accesstoken;
	
	public UserManager() {}
	
	public UserManager(String accesstoken){
		this.accesstoken = accesstoken;
	}
	
	/**
	 * 
	 * 调用获取用户信息的接口
	 * (这里描述这个方法适用条件 – 可选)
	 * @param openid
	 * @return 
	 *String
	 * @exception 
	 * @since  0.0.1
	 */
    public JSONObject getUserInfo(String openid){
    	
	    String  getUserInforUrl = APIURL.USER_INFO+this.accesstoken+"&openid="+openid+"&lang=zh_CN";
	    String  strJSONRes  = HTTPSDataManager.sendData(getUserInforUrl);
	    
	    logger.debug("weixin.user.UserManager.getUserInfo:"+strJSONRes.toString());
	    try {
			return new JSONObject(strJSONRes);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
	    
    }
    
    /**
     * 
     * 调用获取用户信息的接口(网页OAuth部分))
     * (网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同)
     * @param openid
     * @return 
     *String
     * @exception 
     * @since  0.0.1
     */
    public JSONObject getUserInfoByWeb(String openid,String accesstoke4auth){
    	
	    String  getSNSUserInforUrl = APIURL.USER_INFO_WEB+accesstoke4auth+"&openid="+openid+"&lang=zh_CN";
	    String  strJSONRes  = HTTPSDataManager.sendData(getSNSUserInforUrl);
	    
	    logger.debug("weixin.user.UserManager.getUserInfoByWeb:"+strJSONRes.toString());
	    try {
			return new JSONObject(strJSONRes);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
    }
	 

    /**
     * 
     * 查看用户是否关注
     * 
     * @param openid
     * @return 
     *boolean
     * @throws JSONException 
     * @exception 
     * @since  0.0.1
     */    
	public boolean isSubscribe(String openid){
		
		if(openid == null){
			return false;
		}
		//调用获取用户信息的接口
		try {
			JSONObject  userMap  = getUserInfo(openid);
			if(userMap.getInt("subscribe") == 1){
				return true;
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return false;
	}
	
    /**
     * 
     * 获取当前账户的所有人的openid
     * 少于1000人时调用一次
     * 大于1000人时要调用多次
     * 第一次调用的时候next_openid为空
     * @return 
     *List
     * @exception 
     * @since  0.0.1
     */
	public List<String> getSubscribeList(String next_openid){
		
		List<String> userList = new ArrayList<String>();
		String firstId = next_openid;
		int count = 0;
		
		while(true){
			//调用获取用户列表接口
			String url = APIURL.GET_USERLIST+this.accesstoken+"&next_openid="+firstId;
			String response = HTTPSDataManager.sendData(url);
			//解析对应的JSON代码
			try{
				JSONObject responseJson  = new JSONObject(response);
				count = responseJson.getInt("count");

				if(count==0)break;
				
				JSONObject data = (JSONObject) responseJson.get("data");
				JSONArray openid = (JSONArray) data.get("openid");
				for(int i=0;i<count;i++){
					userList.add(openid.get(i).toString());
				}
				firstId = responseJson.getString("next_openid");
			} catch(JSONException e){
				e.printStackTrace();
			}
		}
	    
		return userList;
	} 
	
	/**
	 * 
	 * 设置用户备注名
	 * 新的备注名，长度必须小于30字符 
	 * 根据传入的两个数据进行json数据的拼装
	 * @param openid
	 * @param remark
	 * @return 
	 *boolean
	 * @exception 
	 * @since  0.0.1
	 */
	public boolean updateRemark(String openid,String remark){
		
		boolean flag = false;
		
		//构建请求信息
		JSONObject rootJson = new JSONObject();
		try {
			rootJson.put("openid", openid);
			rootJson.put("remark", remark);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		
		//调用设置用户备注名接口
		String url = APIURL.UPDATE_REMARK+this.accesstoken;
		String response = HTTPSDataManager.sendData(url, rootJson.toString());
		
		//解析对应的JSON代码
	    try{
	    	JSONObject responseJson  = new JSONObject(response);
	    	if(responseJson.getString("errmsg").equals("ok"))flag = true;
	    } catch(JSONException e){
	    		e.printStackTrace();
	    }
	    
		return flag;
	}
	
}
