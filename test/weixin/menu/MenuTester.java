package weixin.menu;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import weixin.menu.ConditionalMenuManager;
import weixin.menu.MenuManager;

public class MenuTester {

	public static void main(String[] args) throws JSONException {
		// TODO Auto-generated method stub
		//AccessTokenManager  at  = new AccessTokenManager();
		String accesstoken  = "27_zC6XMWllpagbQv-Ud4HfJH3b6xqq17__5HZsiWgVe5sPjteo7DWrbvVFuPi1HuylOa78sRkGw5axuymUFGv7YGyzukhdQOcXbWj-Z07hPWzcehNvcH9z-9o8BWjYr7tA1_O9TXf9gqexd1U0IBNaAEARKW";
		ConditionalMenuManager  conditionMenu  = new ConditionalMenuManager(accesstoken);
		
		
		MenuManager  menuManager  = new MenuManager(accesstoken);
		JSONObject defaultMenuJSON  = new JSONObject();
		
		

		
		JSONObject jsonStr  = new JSONObject();
		
		JSONObject matchrule_android = new JSONObject();
		matchrule_android.put("client_platform_type", "2");//andorid		
		
			
		JSONObject menu1_sub1  = new JSONObject();
		menu1_sub1.put("type", "view");
		menu1_sub1.put("name", "APP下载");
		menu1_sub1.put("url", "http://app.mi.com/details?id=net.huicaishui.android");
		//https://appstore.huawei.com/app/C100336949
		//http://app.mi.com/details?id=net.huicaishui.android
		
		JSONArray  menu = new JSONArray();
		menu.put(menu1_sub1);
		
		
		defaultMenuJSON.put("button", menu);
		menuManager.createMenu(defaultMenuJSON.toString());
		
		
		jsonStr.put("button", menu);
		jsonStr.put("matchrule", matchrule_android);
			
		System.out.println(jsonStr.toString());
//		boolean flag = conditionMenu.createMenu(jsonStr.toString());
//		System.out.println(flag);
	}

}
