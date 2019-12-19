/**
 * 
 * 微信-公众号-封装接口JAVA版本
 * weixin.menu
 * MenuManager.java
 * Ver0.0.1
 * 2016年6月20日-下午4:21:55
 * 2014-2019 ©全智道(北京)科技有限公司
 * 
 */
package weixin.menu;

import org.json.JSONException;
import org.json.JSONObject;

import weixin.base.APIURL;
import weixin.util.HTTPSDataManager;

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
	private JSONObject responseJSON;
	
	public MenuManager(String accesstoken){
		this.accesstoken = accesstoken;
		responseJSON = null;
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
	 * @return  JSONObject
	 * @exception 
	 * @since  0.0.1
	 */	
	public JSONObject createMenu(String jsonStr){
		
		//调用自定义菜单创建接口
	    String url = APIURL.CREATE_MENU+this.accesstoken;
	    String response = HTTPSDataManager.sendData(url, jsonStr);
	    	    
	    try {
			 responseJSON  = new JSONObject(response);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return responseJSON;
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
	public JSONObject getMenu(){
		
		//调用自定义菜单查询接口
		String url = APIURL.GET_MENU+this.accesstoken;
		String response = HTTPSDataManager.sendData(url);
		
		try {
			responseJSON = new JSONObject(response);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return responseJSON;
	}
	
	/**
	 * 
	 * deleteMenu(自定义菜单删除接口)
	 * (这里描述这个方法适用条件 – 可选)
	 * @return  JSONObject
	 * @exception 
	 * @since  0.0.1
	 */
	public JSONObject deleteMenu(){
		
		//调用自定义菜单删除接口
		String url = APIURL.DELETE_MENU+this.accesstoken;
		String response = HTTPSDataManager.sendData(url);
		
		//解析对应的JSON代码
	    try{
	    	 responseJSON  = new JSONObject(response);
	    } catch(JSONException e){
	    	e.printStackTrace();
	    }
	    
		return responseJSON;
	}
}
