/**
 * 包打听全知道-微信H5版本
 * weixin.shorturl
 * ShortUrlManager.java
 * Ver0.0.1
 * 2016年6月27日-下午3:17:14
 *  2016全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.shorturl;

import org.json.JSONException;
import org.json.JSONObject;

import weixin.util.HttpsDataManager;

/**
 * 
 * ShortUrlManager
 * 
 * 李华栋
 * 李华栋
 * 2016年6月27日 下午3:17:14
 * 
 * @version 0.0.1
 * 
 */
public class ShortUrlManager {

	private String at;
	public ShortUrlManager(String accesstoken){
		this.at  = accesstoken;
	}
	
	public  String getShortUrl(String longurl){
		
	    String shorturl ="";
		String url = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token="+ this.at; 
	    String data ="{\"action\":\"long2short\",\"long_url\":\""+longurl+"\"}";

	    String res = HttpsDataManager.sendData(url,data);
	    
	    JSONObject jsonObj;
		try {
			jsonObj = new JSONObject(res);
			shorturl =  jsonObj.getString("short_url"); 
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
	   return shorturl;
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
        String at = "3UEjECIO4_FwGPBFCUCwt_a9blu-HwAR69Sl3ctLgms_3HLCZ1R566NM7MrdDXGAUXbR3asehG3RA0QwdIJCp404920DeGKGZS7Wu3L9TxcQPBcAAABAM";
		ShortUrlManager  sm  = new ShortUrlManager(at);
		String surl = sm.getShortUrl("https://wukonglai.com/weixin/tools/token.jsp");
		System.out.println(surl);
		
	}

}
