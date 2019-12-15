/**
 * 
 * 微信-公众号-封装接口JAVA版本
 * weixin.menu
 * ConditionalMenuManager.java
 * Ver0.0.1
 * 2016年6月21日-下午2:14:44
 * 2014-2019 全智道(北京)科技有限公司
 * 
 */
package weixin.menu;

import org.json.JSONException;
import org.json.JSONObject;

import weixin.base.APIURL;
import weixin.util.HTTPSDataManager;

/**
 * 
 * ConditionalMenuManager
 * 
 * 李华栋
 * 李华栋
 * 2016年6月21日 下午2:14:44
 * 
 * @version 0.0.1
 * 
 */
public class ConditionalMenuManager {

	private String accesstoken;
	private JSONObject responseJSON;  
	
	public ConditionalMenuManager(String accesstoken){
		this.accesstoken = accesstoken;
		responseJSON = null;
	}
	
	
	public JSONObject createMenu(String jsonStr){		
		//调用个性化菜单创建接口
	    String url = APIURL.CREATE_CONDITIONAL_MENU + this.accesstoken;
	    String response = HTTPSDataManager.sendData(url, jsonStr);
	    
	    //解析对应的JSON代码
	    try{
	    	responseJSON = new JSONObject(response);
	    } catch(JSONException e){
	    	e.printStackTrace();
	    }	    
	    return responseJSON;
	}
	
	public JSONObject deleteMenu(){
		
		MenuManager  menu  = new MenuManager(this.accesstoken);
		responseJSON =menu.deleteMenu();
	    
		return responseJSON;
	}
	
	public JSONObject getMenu(){
				
		MenuManager  menu  = new MenuManager(this.accesstoken);
		responseJSON =menu.getMenu();
		return responseJSON;
	}
	

	
	public JSONObject tryMatchMenu(String jsonStr){
		
		//调用个性化菜单测试接口
		String url = APIURL.TRYMATCH_CONDITIONAL_MENU+this.accesstoken;
		String response = HTTPSDataManager.sendData(url,jsonStr);
		
		//解析对应的JSON代码
	    try{
	    	 responseJSON  = new JSONObject(response);
	    } catch(JSONException e){
	    	e.printStackTrace();
	    }
		return responseJSON;
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
