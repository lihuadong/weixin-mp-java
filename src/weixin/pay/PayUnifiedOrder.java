/**
 * 
 * 微信-公众号-封装接口JAVA版本
 * weixin.pay
 * UnifiedOrder.java
 * Ver0.0.1
 * 2015年1月23日-下午5:00:23
 * 2014-2019 ©全智道(北京)科技有限公司
 * 
 */
package weixin.pay;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.jdom.JDOMException;

import weixin.util.HTTPSDataManager;
import weixin.util.XMLUtil;


/**
 * 
 * UnifiedOrder	统一支付接口
 * 
 * 李华栋
 * 李华栋
 * 2015年1月23日 下午5:00:23
 * 
 * @version 0.0.1
 * 
 */
public class PayUnifiedOrder {
	
	//统一支付接口请求地址
	String unifiedorderUrl;
	///////////////////////////////////////////////统一支付接口相关参数
	//公众账号ID  
	String appid;
	//商户号
	String mch_id;
	//设备号(非必填项目)
	String device_info;
	//随机字符串
	String nonce_str;
	//签名
	String sign;
	//商品描述
	String body;
	//附加数据
	String attach;
	//商户订单号
	String out_trade_no;
	//总金额(单位为分)
	int total_fee;
	//终端IP
	String spbill_create_ip;
	//交易起始时间(非必填)
	String time_start;
	//交易结束时间(非必填)
	String time_expire;
	//商品标记(非必填)
	String goods_tag;
	//通知地址
	String notify_url;
	//交易类型(JSAPI/APP/Native)
	String trade_type;
	//用户标识(非必填,在网页下时为必传)
	String openid;
	//商品ID(非必填)
	String product_id;
	
	///////用来保存对应信息的Map
	public SortedMap<Object,Object> parameters;
	
	private static Logger logger = Logger.getLogger(PayUnifiedOrder.class);   
	
	/**
	 * 
	 * 创建一个新的实例 UnifiedOrder.
	 *
	 * @param map 根据不同订单传进不同参数
	 */
	public PayUnifiedOrder(HashMap<String, String> map){

		this.parameters = new TreeMap<Object,Object>();
		this.parameters.put("appid", map.get("appid"));
		this.parameters.put("mch_id", map.get("mch_id"));
		this.parameters.put("nonce_str", map.get("nonce_str"));
		this.parameters.put("trade_type",map.get("trade_type"));
		this.parameters.put("notify_url",map.get("notify_url"));
		this.parameters.put("body", map.get("body"));   
		
		this.parameters.put("spbill_create_ip", map.get("spbill_create_ip"));
		this.parameters.put("openid", map.get("openid"));
		this.parameters.put("total_fee", map.get("total_fee"));
		this.parameters.put("out_trade_no",map.get("orderid"));
		
		if(map.get("trade_type").equals("JSAPI")){
			
		}else{
			this.parameters.put("product_id", map.get("product_id"));   //二维码支付时需要这个字段
		}
		
		
		this.parameters.put("attach", map.get("attach"));
		this.parameters.put("goods_tag", map.get("goods_tag"));
		
		//非必填参数，商户可根据实际情况选填
		//$unifiedOrder->setParameter("sub_mch_id","XXXX");//子商户号  
		//$unifiedOrder->setParameter("device_info","XXXX");//设备号 
		//$unifiedOrder->setParameter("time_start","XXXX");//交易起始时间
		//$unifiedOrder->setParameter("time_expire","XXXX");//交易结束时间 
		
	}
	


	/**
	 * 返回预支付订单号
	 */
	public String getPrepayId(String key){
		
		//到这里时所有的参数都已经加载完毕
		String sign = new PaySign().createSign("utf-8", this.parameters,key);
		this.parameters.put("sign",sign);
		
		//请求内容XML化
		String data = new PaySign().getRequestXml(parameters);
		logger.debug("提交后台的支付数据为："+data);

		
		//XML数据发送到微信支付后台返回预付订单号
		String res  = HTTPSDataManager.sendData(PayConfig.UNIFIDORDER_URL, data);
		logger.debug("后台的返回支付结果："+res);
				
		String prepay_id = "";
		String code_url = "";

		
		try {
				Map<String, String> uniOrderResMap = XMLUtil.doXMLParse(res);
				prepay_id = uniOrderResMap.get("prepay_id");
				
				code_url  =  uniOrderResMap.get("code_url");
				this.parameters.put("code_url",code_url);
				
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//返回之前把时间戳加入列表中,网页前端会使用
		this.parameters.put("timeStamp", Long.toString(System.currentTimeMillis() / 1000));
		
		return prepay_id;
		
	}	

}
