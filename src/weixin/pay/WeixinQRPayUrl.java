/**
 * 包打听全知道-微信H5版本
 * weixin.pay
 * NativeLink.java
 * Ver0.0.1
 * 2015年3月25日-上午10:56:16
 *  2015全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.pay;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;


/**
 * 
 * NativeLink
 * 
 * 李华栋
 * 李华栋
 * 2015年3月25日 上午10:56:16
 * 
 * @version 0.0.1
 * 
 */
public class WeixinQRPayUrl {

	 public   TreeMap<Object,Object> parameters = new TreeMap<Object,Object>();  //静态链接参数
	 public   String  payUrl; //静态链接
	 
/*	 public WeixinQRPayUrl(String productID){
		 
		 this.parameters.put("appid",WeixinPayConfig.APPID);
		 this.parameters.put("mch_id",WeixinPayConfig.MCHID);
		 this.parameters.put("time_stamp", WeixinQRPayUrl.create_timestamp());
		 this.parameters.put("nonce_str",WeixinQRPayUrl.create_nonce_str());
		 this.parameters.put("product_id",productID);
		 String str  = WeixinPaySign.createSign("utf-8", this.parameters);
		 this.parameters.put("sign",str);
		 
	 }*/
	 
	 public WeixinQRPayUrl(String productID,String key){
		 
		 this.parameters.put("appid",WeixinPayConfig.APPID);
		 this.parameters.put("mch_id",WeixinPayConfig.MCHID);
		 this.parameters.put("time_stamp", WeixinQRPayUrl.create_timestamp());
		 this.parameters.put("nonce_str",WeixinQRPayUrl.create_nonce_str());
		 this.parameters.put("product_id",productID);
		 String str  = WeixinPaySign.createSign("utf-8", this.parameters,key);
		 this.parameters.put("sign",str);
		 
	 }
	 
	 public void   setParameter(String key,String value){
		 this.parameters.put(key, value);
	 }
	 
	 public String getPayUrl(){
		 
		 String str1 = WeixinQRPayUrl.creat_wxpayurl(parameters);
		 String str2  ="weixin://wxpay/bizpayurl?"+str1;
		 payUrl  = str2.substring(0, str2.length()-1);
		 return payUrl;
		 
	 }
	 

	 private static String create_nonce_str() {
	        return UUID.randomUUID().toString();
	  }

	 private static String create_timestamp() {
	        return Long.toString(System.currentTimeMillis() / 1000);
	 }
	 
	 private static String creat_wxpayurl(TreeMap<Object,Object> parameters){
		 StringBuffer sb = new StringBuffer();
	        Set es = parameters.entrySet();
	        Iterator it = es.iterator();
	        while(it.hasNext()) {
	            Map.Entry entry = (Map.Entry)it.next();
	            String k = (String)entry.getKey();
	            Object v = entry.getValue();
	            if(null != v && !"".equals(v) && !"key".equals(k)) {
	                sb.append(k + "=" + v + "&");
	            }
	        }
	       return sb.toString();
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
		WeixinQRPayUrl  nl  = new WeixinQRPayUrl("ipaiban1",WeixinPayConfig.KEY);
        String  url = nl.getPayUrl();
        System.out.println(url);
	}

}
