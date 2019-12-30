/**
 * 
 * 微信-公众号-封装接口JAVA版本
 * weixin.pay
 * WxPayConfig.java
 * Ver0.0.1
 * 2015年1月23日-下午4:15:00
 * 2014-2019 ©全智道(北京)科技有限公司
 * 
 */
package weixin.pay;


import weixin.util.PropertiesUtil;

/**
 * 
 * WxPayConfig
 * 
 * 李华栋
 * 李华栋
 * 2015年1月23日 下午4:15:00
 * 
 * @version 0.0.1
 * 
 */
public class PayConfig {

	//=======【基本信息设置】=====================================
	//微信公众号身份的唯一标识。审核通过后，在微信发送的邮件中查看
	final static String APPID = PropertiesUtil.readPropertiesFile(PayConfig.class.getResourceAsStream("/weixin.properties"),"APPID");
	//审核后在公众平台开启开发模式后可查看
	final static  String APPSECRET = PropertiesUtil.readPropertiesFile(PayConfig.class.getResourceAsStream("/weixin.properties"),"APPSECRET");
	//受理商ID，身份标识
	final static  String MCHID = PropertiesUtil.readPropertiesFile(PayConfig.class.getResourceAsStream("/wxpay.properties"),"MCHID");
	//商户支付密钥Key。审核通过后，在微信发送的邮件中查看
	final static String KEY = PropertiesUtil.readPropertiesFile(PayConfig.class.getResourceAsStream("/wxpay.properties"),"KEY");

	//=======【异步通知url设置】===================================
	//异步通知url，商户根据实际开发过程设定
	final static String NOTIFY_URL = PropertiesUtil.readPropertiesFile(PayConfig.class.getResourceAsStream("/wxpay.properties"),"NOTIFY_URL");
	
	//=======【JSAPI路径设置】===================================
	//获取access_token过程中的跳转uri，通过跳转将code传入jsapi支付页面
	final String JS_API_CALL_URL = "http://baodating.net.cn/Baodating/wxpay/js_api_call.jsp";
	
	//=======【证书路径设置】=====================================
	//证书路径,注意应该填写绝对路径
	final String SSLCERT_PATH = "/xxx/xxx/xxxx/WxPayPubHelper/cacert/apiclient_cert.pem";
	final String SSLKEY_PATH = "/xxx/xxx/xxxx/WxPayPubHelper/cacert/apiclient_key.pem";
	
	//=======【curl超时设置】===================================
	//本例程通过curl使用HTTP POST方法，此处可修改其超时时间，默认为30秒
	final int CURL_TIMEOUT = 30;
	
	//=======【统一支付接口地址】===================================
	final static String UNIFIDORDER_URL ="https://api.mch.weixin.qq.com/pay/unifiedorder";
	
	//=======【支付查询接口地址】===================================
	public final static String ORDERQUERY_URL = "https://api.mch.weixin.qq.com/pay/orderquery";
	
}
