package weixin.card;

import org.json.JSONException;
import org.json.JSONObject;

import weixin.base.APIBaseConfig;
import weixin.util.HttpsDataManager;

/**
 * 
* @Title: CardConsume.java
* @Package weixin.card
* @Description: TODO(核销卡券)
* @author 涂鹏雄
* @date 2016年1月18日 上午11:10:46
* @version V1.0.0
 */
public class CardDistroy {

	private String  accesstoken;
	
	public CardDistroy(String  accesstoken){
		this.accesstoken  = accesstoken;
	}
	
	
	/**
	 * 查询卡券Code状态
	 * @date 2016年1月20日下午2:54:55
	 * @param card_id 单张卡券的唯一标准
	 * @param code 卡券ID代表一类卡券。自定义code卡券必填。
	 * @param check_consume 是否校验code核销状态，填入true和false时的code异常状态返回数据不同
	 * @return 微信官方给的json格式数据结果
	 * @throws JSONException 
	 */
	public  String getCodeCard(String card_id,String code,boolean check_consume) throws JSONException{
		
		String url = APIBaseConfig.CARD_GETCODE_URL+this.accesstoken;
		HttpsDataManager dataManager = new HttpsDataManager();
		JSONObject data = new JSONObject();
		try {
			data.put("card_id", card_id);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		data.put("code", code);
		data.put("check_consume", check_consume);
		String res = dataManager.sendData(url, data.toString());
		return res;
	}
	
	/**
	 * 线下核销自定义Code卡券
	 * @date 2016年1月20日下午2:59:55
	 * @param card_id 卡券ID。创建卡券时use_custom_code填写true时必填。非自定义Code不必填写。
	 * @param code 需核销的Code码。
	 * @return 微信官方给的json格式数据结果
	 * @throws JSONException 
	 */
	public  String codeConsumeCard(String card_id,String code) throws JSONException{
	
		String url = APIBaseConfig.CARD_CODE_CONSUME_URL+this.accesstoken;
		HttpsDataManager dataManager = new HttpsDataManager();
		JSONObject data = new JSONObject();
		data.put("card_id", card_id);
		data.put("code", code);
		String res = dataManager.sendData(url, data.toString());
		return res;
	}
	
	/**
	 * 线下核销非自定义Code卡券
	 * @date 2016年1月20日下午2:59:55
	 * @param card_id 卡券ID。创建卡券时use_custom_code填写true时必填。非自定义Code不必填写。
	 * @param code 需核销的Code码。
	 * @return 微信官方给的json格式数据结果
	 * @throws JSONException 
	 */
	public  String codeConsumeCard(String code) throws JSONException{
		
		String url = APIBaseConfig.CARD_CODE_CONSUME_URL+this.accesstoken;
		HttpsDataManager dataManager = new HttpsDataManager();
		JSONObject data = new JSONObject();
		data.put("code", code);
		String res = dataManager.sendData(url, data.toString());
		return res;
	}
	
	/**
	 * 线上核销---Code解码接口
	 * @date 2016年1月20日下午3:11:44
	 * @param encrypt_code 未解码的code
	 * @return 微信官方返回的json数据
	 * @throws JSONException 
	 */
	public  String codeDecryptCard(String encrypt_code) throws JSONException{
		
		String url = APIBaseConfig.CARD_CODE_DECRYPT_URL+this.accesstoken;
		HttpsDataManager dataManager = new HttpsDataManager();
		JSONObject data = new JSONObject();
		data.put("encrypt_code", encrypt_code);
		String res = dataManager.sendData(url, data.toString());
		return res;
	}
	
	
	
	
}
