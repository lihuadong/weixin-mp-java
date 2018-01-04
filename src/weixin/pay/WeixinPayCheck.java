/**
 * 包打听全知道-微信H5版本
 * weixin.pay
 * WeixinPayCheck.java
 * Ver0.0.1
 * 2016年11月15日-下午5:38:34
 *  2016全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.pay;

import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;

import org.jdom.JDOMException;


/**
 * 
 * WeixinPayCheck
 * 
 * 李华栋
 * 李华栋
 * 2016年11月15日 下午5:38:34
 * 
 * @version 0.0.1
 * 
 */
public class WeixinPayCheck {

	private String appid;
	private String mchid;
	private String key;
	
	public WeixinPayCheck(String appid,String mchid,String key){
		this.appid  = appid;
		this.mchid  = mchid;
		this.key  = key;
	}
	
	public boolean checkPay(String orderid){
		
		boolean flag  = false;
		
		//构建参数准备调用查询订单接口
		String appid   = this.appid;
		String mch_id = this.mchid;
		String nonce_str  = UUID.randomUUID().toString().substring(0, 32);		
		String out_trade_no = orderid;
				
		SortedMap<Object, Object> signDataMap = new TreeMap<Object, Object>();
	    	signDataMap.put("appid",appid);
		signDataMap.put("mch_id", mch_id);
		signDataMap.put("nonce_str", nonce_str);
		signDataMap.put("out_trade_no", out_trade_no);

		//生成签名
		String sign   = genSign(signDataMap);	
		signDataMap.put("sign",sign);
		
		//请求内容XML化
		String data = WeixinPaySign.getRequestXml(signDataMap);
		//XML数据发送到微信支付后台返回查询数据
		String resXML  = weixin.util.HttpsDataManager.sendData(WeixinPayConfig.ORDERQUERY_URL, data);	

		Map<String, String> payXMLMap = null;
		String trade_state = null,return_code = null;
		String err_code_des = null;
		
		try {	
				try {
					
					payXMLMap = weixin.util.XMLUtil.doXMLParse(resXML);
					trade_state = payXMLMap.get("trade_state");
					return_code = payXMLMap.get("return_code");
					err_code_des =  payXMLMap.get("err_code_des");
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
		} catch (JDOMException e) {
			e.printStackTrace();
		}
				

		
		if(return_code.equals("SUCCESS")){
			if(trade_state.equals("SUCCESS")){
				flag  = true;
			}else{
				flag  = false;
			}
		}else{
			flag  = false;
		}
		return flag;
	}
	
	
	//生成签名
	private  String  genSign(SortedMap<Object, Object>  signDataMap){
		
		String sign  = WeixinPaySign.createSign("utf-8", signDataMap,this.key);
		return sign;
	}
	
}
