package weixin.card;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;


import weixin.base.APIBaseConfig;
import weixin.util.HttpsDataManager;

/**
 * 
* @Title: CardThrow.java
* @Package weixin.card
* @Description: TODO(投放微信卡券)
* @author 涂鹏雄
* @date 2016年1月15日 下午6:21:34
* @version V1.0.0
 */
public class CardUsing {
	
	private String  accesstoken;
	
	public CardUsing(String  accesstoken){
		this.accesstoken  = accesstoken;
	}
	/**
	 * 生成带有卡券信息的二维码
	 * @date 2016年1月15日下午6:33:12
	 * @param cardJson 卡券信息
	 * @return 结果 微信官方返回的结果 json格式
	 */
	public  String qrcodeCreateCard(JSONObject cardJson){
		

		String url = APIBaseConfig.CARD_THROW_QRCODE_CREATE_URL+this.accesstoken;
		HttpsDataManager dataManager = new HttpsDataManager();
		String res = dataManager.sendData(url, cardJson.toString());
		return res;
	}
	/**
	 * 卡券货架的创建
	 * @date 2016年1月15日下午6:38:31
	 * @param landingpageJson 货架信息
	 * @return 结果 微信官方返回的结果 json格式
	 */
	public  String CreateLandingpageCard(JSONObject landingpageJson){
		

		String url = APIBaseConfig.CARD_LANDINGPAGE_CREATE_URL+this.accesstoken;
		HttpsDataManager dataManager = new HttpsDataManager();
		String res = dataManager.sendData(url, landingpageJson.toString());
		return res;
	}
	
	/**
	 * 导入code
	 * @date 2016年1月18日上午10:19:17
	 * @param card_id 需要进行导入code的卡券ID
	 * @param codes 需导入微信卡券后台的自定义code，上限为100个。
	 * @return String 导入code的结果json格式
	 * @throws JSONException
	 */
	public  String CodeDepositCard(String card_id,List<String> codes) throws JSONException{
		

		String url = APIBaseConfig.CARD_CODE_DEPOSIT_URL+this.accesstoken;
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("card_id", card_id);
		jsonObject.put("code", codes);
		HttpsDataManager dataManager = new HttpsDataManager();
		String res = dataManager.sendData(url, jsonObject.toString());
		return res;
	}
	
	/**
	 * 查询导入code数目
	 * @date 2016年1月18日上午10:26:04
	 * @param card_id 进行导入code的卡券ID。
	 * @return 查询导入code数目的结果json格式数据
	 * @throws JSONException
	 */
	public  String CodeGetDepositCountCard(String card_id) throws JSONException{
		

		String url = APIBaseConfig.CARD_CODE_GETDEPOSITCOUNT_URL+this.accesstoken;
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("card_id", card_id);
		HttpsDataManager dataManager = new HttpsDataManager();
		String res = dataManager.sendData(url, jsonObject.toString());
		return res;
	}
	
	/**
	 * 核查导入的code
	 * @date 2016年1月18日上午10:31:33
	 * @param card_id 进行导入code的卡券ID
	 * @param codes 已经微信卡券后台的自定义code，上限为100个。
	 * @return 核查导入的code的结果json格式数据
	 * @throws JSONException
	 */
	public  String CodeCheckCodeCard(String card_id,List<String> codes) throws JSONException{
		

		String url = APIBaseConfig.CARD_CODE_CHECKCODE_URL+this.accesstoken;
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("card_id", card_id);
		jsonObject.put("code", codes);
		HttpsDataManager dataManager = new HttpsDataManager();
		String res = dataManager.sendData(url, jsonObject.toString());
		return res;
	}
	
	/**
	 * 群发卡券
	 * 获取卡券嵌入图文消息的标准格式代码，将返回代码填入上传图文素材接口中content字段，即可获取嵌入卡券的图文消息素材
	 * @date 2016年1月18日上午11:04:39
	 * @param card_id 卡券ID
	 * @return String json格式
	 * @throws JSONException
	 */
	public  String MPNewsCard(String card_id) throws JSONException{
		

		String url = APIBaseConfig.CARD_MPNEWS_GETHTML_URL+this.accesstoken;
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("card_id", card_id);
		HttpsDataManager dataManager = new HttpsDataManager();
		String res = dataManager.sendData(url, jsonObject.toString());
		return res;
	}

}
