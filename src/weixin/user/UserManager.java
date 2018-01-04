/**
 * 包打听全知道-微信H5版本
 * weixin.user
 * UserManager.java
 * Ver0.0.1
 * 2016年5月4日-下午1:17:29
 *  2016全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import weixin.base.APIBaseConfig;
import weixin.util.HttpsDataManager;

/**
 * 
 * UserManager
 * 
 * 李华栋
 * 李华栋
 * 2016年5月4日 下午1:17:29
 * 
 * @version 0.0.1
 * 
 */
public class UserManager {

	private static Logger logger = Logger.getLogger(UserManager.class); 	
	private String accesstoken;
	
	public UserManager(){}
	
	public UserManager(String accesstoken){
		this.accesstoken = accesstoken;
	}
	

	 
    /**
     * 
     * getUserInfoByOpenid(根据openid获取用户信息)
     * (这里描述这个方法适用条件 – 可选)
     * @param openid
     * @return
     * @throws Exception 
     *HashMap<String,String>
     * @exception 
     * @since  0.0.1
     */
    public HashMap<String,Object> getUserInfoByOpenid(String openid){
    	
    		
		//调用获取用户信息的接口
	    String  getUserInforUrl = APIBaseConfig.USER_INFO+this.accesstoken+"&openid="+openid+"&lang=zh_CN";
	    String  strJSONRes  = HttpsDataManager.sendData(getUserInforUrl, "获取用户信息非WEB方式");
	    
	    HashMap  map   = new HashMap();
	    try {
				//解析对应的JSON代码
		    		JSONObject singleUseInfoObject;
				singleUseInfoObject = new JSONObject(strJSONRes);

			if(singleUseInfoObject.getInt("subscribe") == 1){
				map.put("nickname", singleUseInfoObject.getString("nickname"));
				map.put("headimgurl", singleUseInfoObject.getString("headimgurl"));
				map.put("sex", singleUseInfoObject.getInt("sex"));
				map.put("language", singleUseInfoObject.getString("language"));
				map.put("city", singleUseInfoObject.getString("city"));
				map.put("province", singleUseInfoObject.getString("province"));
				map.put("country", singleUseInfoObject.getString("country"));
				map.put("subscribe_time", singleUseInfoObject.getLong("subscribe_time"));
				map.put("unionid", singleUseInfoObject.getString("unionid"));
				map.put("remark", singleUseInfoObject.getString("remark"));
				map.put("groupid", singleUseInfoObject.getInt("groupid"));
				map.put("tagid_list",singleUseInfoObject.getJSONArray("tagid_list").toString());
				map.put("openid",singleUseInfoObject.getString("openid"));
				map.put("language",singleUseInfoObject.getString("language"));
				map.put("subscribe","1");
				
			}else{
				map.put("subscribe","0");
				map.put("nickname", "非关注用户");
				map.put("headimgurl", "http://1251001145.cdn.myqcloud.com/1251001145/wukonglai/weixin/wukonglai200200.png");
			}
			
	    } catch (JSONException e) {
	    		map.put("subscribe","0");
			map.put("nickname", "非关注用户");
			map.put("headimgurl", "http://1251001145.cdn.myqcloud.com/1251001145/wukonglai/weixin/wukonglai200200.png");
			e.printStackTrace();
		}

		return map;
      }
	
    /**
     * 
     * isSubscribe(查看用户是否关注)
     * 
     * @param openid
     * @return 
     *boolean
     * @throws JSONException 
     * @exception 
     * @since  0.0.1
     */    
	public boolean isSubscribe(String openid) throws JSONException{
		
		if(openid == null){
			return false;
		}
		//调用获取用户信息的接口
		try {
			HashMap  userMap  = getUserInfoByOpenid(openid);
			if(userMap.get("subscribe").equals("1")){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return false;
	}
	
    /**
     * 
     * getSubscribeList(获取当前账户的所有人的openid)
     * 少于1000人时调用一次
     * 大于1000人时要调用多次
     * 第一次调用的时候next_openid为空
     * @return 
     *List
     * @exception 
     * @since  0.0.1
     */
	public List getSubscribeList(String next_openid){
		
		List<String> userList = new ArrayList<String>();
		String firstId = next_openid;
		int count = 0;
		
		while(true){
			//调用获取用户列表接口
			String url = APIBaseConfig.GET_USERLIST+this.accesstoken+"&next_openid="+firstId;
			String response = HttpsDataManager.sendData(url);//!!!HttpsDataManager需要有GET的请求方式
			//解析对应的JSON代码
			try{
				JSONObject responseJson  = new JSONObject(response);
				count = responseJson.getInt("count");
				//System.out.println("-------------------"+count);
				if(count==0)
					break;
				JSONObject data = (JSONObject) responseJson.get("data");
				JSONArray openid = (JSONArray) data.get("openid");
				for(int i=0;i<count;i++){
					userList.add(openid.get(i).toString());
				}
				firstId = responseJson.getString("next_openid");
			} catch(JSONException e){
				//System.out.println(response);
				break;
			}
		}
	    
		return userList;
	} 
	
	/**
	 * 
	 * updateRemark(设置用户备注名)
	 * 
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
		
		boolean success = false;
		
		//构建请求信息
		JSONObject rootJson = new JSONObject();
		try {
			rootJson.put("openid", openid);
			rootJson.put("remark", remark);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		
		//调用设置用户备注名接口
		String url = APIBaseConfig.UPDATE_REMARK+this.accesstoken;
		String response = HttpsDataManager.sendData(url, rootJson.toString());
		
		//解析对应的JSON代码
	    try{
	    	JSONObject responseJson  = new JSONObject(response);
	    	if(responseJson.getString("errmsg").equals("ok"))
	    		success = true;
	    } catch(JSONException e){
	    		System.out.println(e.toString());
	    }
	    
		return success;
	}
	
	
	/**
	 * 
	 * getUserInfoByWEB(网页授权的方式获取用户的信息)
	 * (网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同)
	 * @param openid
	 * @return 
	 *HashMap
	 * @exception 
	 * @since  0.0.1
	 */
    public HashMap<String,Object>  getWEBUserInfoByOpenid(String openid,String accesstoken){
    	      
		
		//调用获取用户信息的接口
	    String  getSNSUserInforUrl = APIBaseConfig.USER_INFO_WEB+accesstoken+"&openid="+openid+"&lang=zh_CN";
	    String  strJSONRes  = HttpsDataManager.sendData(getSNSUserInforUrl, "get user information");
    
	    HashMap  map   = new HashMap();
	    try {
				//解析对应的JSON代码
			    	JSONObject singleUseInfoObject;
				singleUseInfoObject = new JSONObject(strJSONRes);
					
				if(singleUseInfoObject!=null){
						
						map.put("openid", singleUseInfoObject.getString("openid"));
						map.put("nickname", singleUseInfoObject.getString("nickname"));
						map.put("sex", singleUseInfoObject.getInt("sex"));
						map.put("province", singleUseInfoObject.getString("province"));
						map.put("city", singleUseInfoObject.getString("city"));
						map.put("country", singleUseInfoObject.getString("country"));						
						map.put("headimgurl", singleUseInfoObject.getString("headimgurl"));
						map.put("privilege", singleUseInfoObject.getJSONArray("privilege"));
						map.put("unionid", singleUseInfoObject.getString("unionid"));
						
				}else{
						map.put("nickname", "悟空来");
						map.put("headimgurl", "http://baodating.net.cn/baodating/weixin/images/wukonglai200200.png");
				}
				
	    } catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    return map;
    }
    
    public JSONObject  getUserInfoFromWeb(String openid,String accesstoken){
    	
		//调用获取用户信息的接口
	    String  getSNSUserInforUrl = APIBaseConfig.USER_INFO_WEB+accesstoken+"&openid="+openid+"&lang=zh_CN";
	    String  strJSONRes  = HttpsDataManager.sendData(getSNSUserInforUrl, "get user information");
    
	    JSONObject singleUseInfoObject = null;
	    try {
				singleUseInfoObject = new JSONObject(strJSONRes);		
	    } catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	    return singleUseInfoObject;
    }
    
    

	/**
	 * main(这里用一句话描述这个方法的作用)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param args 
	 *void
	 * @throws Exception 
	 * @exception 
	 * @since  0.0.1
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		  //1、获取accesstoken 
			//AccessTokenManager  atm  = new AccessTokenManager();
			//System.out.println(atm);
			//AccessTokenManager.accesstoken = "k0YYIvs9Mbb8HIExX0tDh6iBDEIMAidDp2O72T7OFllF8gHdmNdJcIbzDIljiCFuLCcRBt8svtrriaknFZVuzJpm6yb7c9rf_9xQCS0hUcaDS2EBk9xS8PT9X3gR6JawQEYbAFAUIC";
	        
		/*	//2、测试所有的会员ID显示
		UserManager  um  = new UserManager();
			List  list  = um.getSubscribeList("");
			
			System.out.println("list size:"+list.size());
			
			List<String> nicknames = new ArrayList<String>();			
			for(int i=0;i<list.size();i++){
				
				String nickname = um.getNicknameByOpenid((String) list.get(i));
				System.out.println("nickname:"+nickname+"\t"+"openid:"+(String) list.get(i));			
				nicknames.add("nickname: "+nickname+"  openid: "+(String) list.get(i));
			}
			for(int i=0;i<nicknames.size();i++){
				System.out.println(nicknames.get(i));//nickname: 七月  openid: oFHIYtxveXh57uRNKptUAwBH2u7Y,nickname: 吉  openid: oFHIYt3kwFCqgAak7YaTJirZlzdQ,nickname: 文立  openid: oFHIYt59P471ITZ_aKHudE4Ggokc
			}*/
		
//----------------------------------------------------------------------------------------------
		
		//1、获取accesstoken
//		AccessTokenManager  atm  = new AccessTokenManager();
		//System.out.println(atm);
//		AccessTokenManager.accesstoken = "gjlWX230yScBFl2UuWbpzoxbOmjTYHPfbE_V_GRVf5a9DkDvdix60WZOFulTElpHzz2Uibh42tQkYzpWoGgrSBPG5dFadQeijzW77CF36I9oPFgyUijAVCQqHIEjgOqcTBVjAAAOWQ";
		
		//2、测试根据openid获取用户昵称		
	  /* UserManager um = new UserManager();	
		String openid1 = "oFHIYtxveXh57uRNKptUAwBH2u7Y";
		String nickname1 = um.getNicknameByOpenid(openid1);	
		String openid2 = "oFHIYt3kwFCqgAak7YaTJirZlzdQ";
		String nickname2 = um.getNicknameByOpenid(openid2);	
		String openid3 = "oFHIYt59P471ITZ_aKHudE4Ggokc";
		String nickname3 = um.getNicknameByOpenid(openid3);	
		
		System.out.println("------get users' nicknames------");
		System.out.println("openid1: "+openid1+" nickname1: "+nickname1);
		System.out.println("openid2: "+openid2+" nickname2: "+nickname2);
		System.out.println("openid3: "+openid3+" nickname3: "+nickname3);*/
		
		//3、测试获取用户头像
		/*UserManager um = new UserManager();
		String openid1 = "oFHIYt2guBTMngMiwFCAQdpOlu5k";
		String image_url1 = um.getImgByOpenid(openid1);
		String openid2 = "oFHIYt59P471ITZ_aKHudE4Ggokc";
		String image_url2 = um.getImgByOpenid(openid2);
		System.out.println("------get users' head images------");
		System.out.println("openid1: "+openid1+"\n image_url1: "+image_url1);
		System.out.println("openid2: "+openid2+"\n image_url2: "+image_url2);
		*/
		String accesstoken  ="Wa3L0sZ8jGGXd225pUXv-B3iXNKnZu9ZErFbfpXqPAzp0hCnHq1qIkYAs2LVslVltz3p_T-ZdaIfXi8qZY6tqtsWziU2-wI6OHhtatox3SFBi-4AhezcB5p2pVxub6axEZWfAAATOL";
		//4、测试获取用户信息
		UserManager um = new UserManager(accesstoken);
		HashMap hm = null;
		String openid = "o7DxpuMwD_wmh0Ef-VhV6OCP7mrA";
		hm = um.getUserInfoByOpenid(openid);
		
		System.out.println("openid: "+hm.get("openid"));
		System.out.println("nickname: "+hm.get("nickname"));
		System.out.println("image_url: "+hm.get("headimgurl"));
		System.out.println("unionid: "+hm.get("unionid"));
		
		/*
		//5、测试查看用户是否关注
		UserManager uma = new UserManager();
		String openid1 = "oFHIYt2guBTMngMiwFCAQdpOlu5k";
		boolean result1 = uma.isSubscribe(openid1);
		String openid2 = "oFHIYtxveXh57uRNKptUAwBH2u7Y";
		boolean result2 = uma.isSubscribe(openid2);
		System.out.println("------check isSubscribe?------");
		System.out.println("result: "+result1);
		System.out.println("result: "+result2);*/
		
		//6、测试获取用户列表
	/*	UserManager um = new UserManager();
		List<String> list1 = um.getSubscribeList("");
		List<String> list2 = um.getSubscribeList("oFHIYt3kwFCqgAak7YaTJirZlzdQ");
		System.out.println("------/get subscribe list-1/------");
		System.out.println("count: "+list1.size());
		for(int i=0;i<list1.size();i++){
			System.out.println(list1.get(i));
		}
		System.out.println("------/get subscribe list-2/------");
		System.out.println("count: "+list2.size());
		for(int i=0;i<list2.size();i++){
			System.out.println(list2.get(i));
		}
		
		//7、测试设置用户备注名
		UserManager uma = new UserManager();
		String openid = "oFHIYtxveXh57uRNKptUAwBH2u7Y";
		
		String remark = "sunhsine";
		boolean result = uma.updateRemark(openid, remark);
		um.getUserInfoByOpenid(openid);
		System.out.println("------set remark for the user------");
		System.out.println("result: "+result);
		
		String remark1 = "";
		boolean result1 = um.updateRemark(openid, remark1);
		um.getUserInfoByOpenid(openid);
		System.out.println("------set remark for the user------");
		System.out.println("result1: "+result1);
		*/
	}
	
	
}
