/**
 * 包打听全知道-微信H5版本
 * weixin.menu
 * MenuManager.java
 * Ver0.0.1
 * 2016年6月20日-下午4:21:55
 *  2016全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.menu;

import org.json.JSONException;
import org.json.JSONObject;

import weixin.base.APIBaseConfig;
import weixin.util.HttpsDataManager;

/**
 * 
 * MenuManager
 * 
 * 李华栋
 * 李华栋
 * 2016年6月20日 下午4:21:55
 * 
 * @version 0.0.1
 * 
 */
public class MenuManager {
	
	private String accesstoken;
	  
	public MenuManager(String accesstoken){
		this.accesstoken = accesstoken;
	}

	/**
	 * 
	 * createMenu(自定义菜单创建接口)
	 *1、自定义菜单最多包括3个一级菜单，每个一级菜单最多包含5个二级菜单。
	 *2、一级菜单最多4个汉字，二级菜单最多7个汉字，多出来的部分将会以“...”代替。
	 *3、创建自定义菜单后，菜单的刷新策略是，在用户进入公众号会话页或公众号profile页时，
	 *如果发现上一次拉取菜单的请求在5分钟以前，就会拉取一下菜单，如果菜单有更新，就会刷新客户端的菜单。
	 *测试时可以尝试取消关注公众账号后再次关注，则可以看到创建后的效果。
	 * @param jsonStr
	 * @return 
	 *boolean
	 * @exception 
	 * @since  0.0.1
	 */
	public boolean createMenu(String jsonStr){
		
		boolean success = false;
		
		//调用自定义菜单创建接口
	    String url = APIBaseConfig.CREATE_MENU+this.accesstoken;
	    String response = HttpsDataManager.sendData(url, jsonStr);
	    
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
	 * getMenu(自定义菜单查询接口)
	 * (这里描述这个方法适用条件 – 可选)
	 * @return 
	 *String
	 * @throws JSONException 
	 * @exception 
	 * @since  0.0.1
	 */
	public JSONObject getMenu() throws JSONException{
		
		String response = null;
		
		//调用自定义菜单查询接口
		String url = APIBaseConfig.GET_MENU+this.accesstoken;
		response = HttpsDataManager.sendData(url);
		
		return new JSONObject(response);
	}
	
	/**
	 * 
	 * deleteMenu(自定义菜单删除接口)
	 * (这里描述这个方法适用条件 – 可选)
	 * @return 
	 *boolean
	 * @exception 
	 * @since  0.0.1
	 */
	public boolean deleteMenu(){
		
		boolean success = false;
		
		//调用自定义菜单删除接口
		String url = APIBaseConfig.DELETE_MENU+this.accesstoken;
		String response = HttpsDataManager.sendData(url);
		
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
//		AccessTokenManager.accesstoken = "Li3R7lNTJ2d-TlrmIW7YlZz9kkhCk6H-aA17Unz7oy9tPuPFAv1Cv5SW8EjKOFPeprKvZy1FUrIoMYaDy5x44TRKYxCKua1fgTgN9pW0ESLEdHcKMMHFc1_PPOqfv6ASKTDcABAYHR";
		
		//2、测试查询菜单
//		MenuManager mm = new MenuManager();
//		try {
//			JSONObject menuJson = mm.getMenu();
//			System.out.println("---------get the menus---------");
//			System.out.println(menuJson.toString());
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
		
		//3、测试删除菜单(3->2)
//		MenuManager mm = new MenuManager();
//		boolean result = mm.deleteMenu();
//		System.out.println("---------delete the menus---------");
//		System.out.println("result: "+result);
		
		//4、测试创建菜单(4->2)
//		JSONObject buttons = null;
//		try {
//			JSONObject button = null;
//			JSONArray manybuttons = new JSONArray();
//			
//			button = new JSONObject();
//			button.put("name","完善信息");
//			button.put("sub_button", new JSONArray());
//			button.put("type", "view");
//			button.put("url", "http://www.ipaiban.com");
//			manybuttons.put(button);
//			
//			button = new JSONObject();
//			button.put("name","排版教程");
//			JSONArray subbutton = new JSONArray();
//			JSONObject subJson = new JSONObject();
//			subJson.put("name","教程");
//			subJson.put("sub_button", new JSONArray());
//			subJson.put("type", "view");
//			subJson.put("url", "http://mp.weixin.qq.com/s?__biz=MjM5NTIzNTMzNg==&mid=401107217&idx=2&sn=53392854e05cc309d000cd9a74222cf2&scene=18#rd");
//			subbutton.put(subJson);
//			subJson = new JSONObject();
//			subJson.put("name","排版示例");
//			subJson.put("sub_button", new JSONArray());
//			subJson.put("type", "click");
//			subJson.put("key", "KEY_DEMO");
//			subbutton.put(subJson);
//			button.put("sub_button", subbutton);
//			manybuttons.put(button);
//			
//			buttons = new JSONObject();
//			buttons.put("button", manybuttons);	
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//		MenuManager mm = new MenuManager();
//		boolean result = mm.createMenu(buttons.toString());
//		System.out.println("---------create a menu---------");
//		System.out.println(buttons.toString());
//		System.out.println("result: "+result);
		
	}

}
