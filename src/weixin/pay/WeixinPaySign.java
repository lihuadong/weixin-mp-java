/**
 * 包打听全知道-微信H5版本
 * weixin.pay
 * Sign.java
 * Ver0.0.1
 * 2015年1月26日-下午12:31:04
 *  2015全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.pay;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.ConnectException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.apache.log4j.Logger;

import weixin.util.MD5Util;

/**
 * 
 * Sign
 * 
 * 李华栋
 * 李华栋
 * 2015年1月26日 下午12:31:04
 * 
 * @version 0.0.1
 * 
 */
public class WeixinPaySign {

	private static Logger logger = Logger.getLogger(WeixinPaySign.class);   
	
	public static String createSign(String characterEncoding,SortedMap<Object,Object> parameters,String key){
        
		StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            Object v = entry.getValue();
            if(null != v && !"".equals(v) 
                    && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
                logger.debug("签名信息:"+k + "=" + v);
            }
        }
        sb.append("key=" +key);
        logger.debug("签名使用的KEY:"+key);
        logger.debug("需要签名的字符串:"+sb.toString());
        
        String sign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toUpperCase();
        //String sign = WeixinPaySign.getMD5(sb.toString());
        logger.debug("字符串的签名:"+sign.toUpperCase());
        
        return sign.toUpperCase();
        
    }
	
/*	public static String createSign(String characterEncoding,SortedMap<Object,Object> parameters){
        
		StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            Object v = entry.getValue();
            if(null != v && !"".equals(v) 
                    && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        
        System.out.println("（1）使用默认签名方式签名内容\n"+sb.toString());
        sb.append("key=" + WeixinPayConfig.KEY);
        System.out.println("（2）使用默认签名方式签名内容\n"+sb.toString());
        //String sign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toUpperCase();
        String sign = WeixinPaySign.getMD5(sb.toString());
        System.out.println("（3）使用默认签名方式签名内容\n"+sign);
        return sign.toUpperCase();
        
    }*/
	
	public static String createJSPaySign(String characterEncoding,SortedMap<Object,Object> parameters){
        
		StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            Object v = entry.getValue();
            if(null != v && !"".equals(v) 
                    && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + WeixinPayConfig.KEY);
        String sign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toUpperCase();
        return sign;
    }
	
	/**
     * @author 李欣桦
     * @date 2014-12-5下午2:32:05
     * @Description：将请求参数转换为xml格式的string
     * @param parameters  请求参数
     * @return
     */
    public static String getRequestXml(SortedMap<Object,Object> parameters){
        
    		StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            String v = (String)entry.getValue();
            if ("attach".equalsIgnoreCase(k)||"body".equalsIgnoreCase(k)||"sign".equalsIgnoreCase(k)) {
                sb.append("<"+k+">"+"<![CDATA["+v+"]]></"+k+">");
            }else {
                sb.append("<"+k+">"+v+"</"+k+">");
            }
        }
        sb.append("</xml>");
        return sb.toString();
    }
    
    
    /**
     * 发送https请求
     * @param requestUrl 请求地址
     * @param requestMethod 请求方式（GET、POST）
     * @param outputStr 提交的数据
     * @return 返回微信服务器响应的信息
     */
    public static String httpsRequest(String requestUrl, String requestMethod, String outputStr) {
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            //TrustManager[] tm = { new MyX509TrustManager() };
            TrustManager[] tm = null;
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            URL url = new URL(requestUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(ssf);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            conn.setRequestMethod(requestMethod);
            conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
            // 当outputStr不为null时向输出流写数据
            if (null != outputStr) {
                OutputStream outputStream = conn.getOutputStream();
                // 注意编码格式
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }
            // 从输入流读取返回内容
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            // 释放资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            conn.disconnect();
            return buffer.toString();
        } catch (ConnectException ce) {
            //log.error("连接超时：{}", ce);
        } catch (Exception e) {
            //log.error("https请求异常：{}", e);
        }
        return null;
    }
    
    
    public static String getMD5(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            //throw new SpeedException("MD5加密出现错误");
        }
		return str;
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
		String str ="appid=wx4fd80eab6384f6f1&mch_id=10023596&nonce_str=0976fdc1-f261-4b7e-8c48-acbfa721e984&product_id=ipaiban1&time_stamp=1481885603&key=4d964874c8237a54fae33e8a0f357089";
		String res  = WeixinPaySign.getMD5(str);
		System.out.println(res.toUpperCase());
	}

}
