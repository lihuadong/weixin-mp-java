package weixin.card;

import org.json.JSONException;
import org.json.JSONObject;


import weixin.base.APIBaseConfig;
import weixin.util.HttpsDataManager;
import weixin.util.HttpsFileUpload;
/**
 * 
* @Title: CardManager.java
* @Package weixin.card
* @Description: TODO(创建微信卡券)
* @author 涂鹏雄
* @date 2016年1月15日 下午3:23:31
* @version V1.0.0
 */
public class CardCreate {

	private String  accesstoken;
	
	public CardCreate(String  accesstoken){
		this.accesstoken  = accesstoken;
	}
	
	
	/**
	 * 上传卡券logo并获取logo的url
	 * @date 2016年1月15日下午6:11:42
	 * @param imagePath 网络图片的路径  图片限制文件大小限制1MB，像素为300*300，仅支持JPG、PNG格式
	 * @return String 结果json格式的数据
	 */
	public  String uploadLogoCard(String imagePath){
		

		String url = APIBaseConfig.CARD_LOGO_URL+this.accesstoken;
		HttpsFileUpload fileUpload = new HttpsFileUpload();
		String res = fileUpload.uploadMedia(url ,imagePath, imagePath.substring(imagePath.lastIndexOf(".")));
		return res;
	}

	/**
	 * 创建卡券
	 * @date 2016年1月15日下午3:31:55
	 * @param cardJson 卡券的json格式数据信息
	 * @return String 创建卡券的结果json格式的数据
	 */
	public  String createCard(JSONObject cardJson){
		
		String url = APIBaseConfig.CARD_CREATE_URL+this.accesstoken;
		HttpsDataManager dataManager = new HttpsDataManager();
		String res = dataManager.sendData(url, cardJson.toString());
		return res;
	}
	
	/**
	 * 设置该card_id支持微信买单功能(买单的card_id必须已经配置了门店)
	 * @date 2016年1月15日下午3:37:29
	 * @param card_id 卡券ID
	 * @param is_open 是否开启买单功能，填true/false
	 * @return 结果json格式的数据
	 * @throws JSONException 
	 */
	public  String payCellCard(String card_id, boolean is_open) throws JSONException{
	
		String url = APIBaseConfig.CARD_PAYCELL_URL+this.accesstoken;
		HttpsDataManager dataManager = new HttpsDataManager();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("card_id", card_id);
		jsonObject.put("is_open", is_open);
		String res = dataManager.sendData(url, jsonObject.toString());
		return res;
	}
	
	public static void main(String args[]){
		
		String imagePath = "http://1251001145.cdn.myqcloud.com/1251001145/wukonglai/weixin/wukonglai200200.png";
		String at  ="ZZlnOq5eecH7zejLPOly2_Uh7QrVtheHoc3Dll6ada7krNtDVRezaoNdx9B87B0Lv5nnzELcsbL_5u8FBIzpLdptYJX7WalvPr9AXdK9hfkRKSjAFADWE";
		CardCreate  cc  = new CardCreate(at);
		String res = cc.uploadLogoCard(imagePath);
		System.out.println(res);
	}

}
