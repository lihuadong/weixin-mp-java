/**
 * 
 * 微信-公众号-封装接口JAVA版本
 * weixin.util
 * HttpsDataManager.java
 * Ver0.0.1
 * 2014年9月28日-下午1:51:11
 * 2014全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpMethodParams;

/**
 * 
 * HttpsDataManager
 * 
 * 李华栋
 * 2014年9月28日 下午1:51:11
 * 
 * @version 0.0.1
 * 
 */
public class HTTPSDataManager {

	
	public static String sendData(String url,String data){
		    
		String receiveData  = null;
		      
		Map<String,String> paramsData = new HashMap<String,String>();
		paramsData.put("data", data);		       
		receiveData = send(url,paramsData);

		return receiveData;
	}

	/**
	* 
	* send(POST方式发送HTTPS请求)
	* (这里描述这个方法适用条件 – 可选)
	* @param url
	* @param paramsMap
	* @return 
	* String
	* @exception 
	* @since  0.0.1
	*/
	@SuppressWarnings("deprecation")
	private static String send(String url,Map<String,String> paramsMap){
		    
		String result = null;
		PostMethod postMethod = null;
		HttpClient httpClient = new HttpClient();
		
		httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
		postMethod = new PostMethod(url);
					
		postMethod.setRequestBody((String)paramsMap.get("data"));
		
		HttpClientParams httparams = new HttpClientParams();
		httparams.setSoTimeout(60000);
		postMethod.setParams(httparams);
		
		try {
			int statusCode = httpClient.executeMethod(postMethod);
			if (statusCode == HttpStatus.SC_OK) {
				result = postMethod.getResponseBodyAsString();
			} else {
				System.out.println("发送HTTPS数据错误 http response status is " + statusCode);
			}
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (postMethod != null) {
				postMethod.releaseConnection();
			}
		}
		      
		return result;
	}
	
	@SuppressWarnings("deprecation")
	private static String send(String url,Map<String,String> headerMap,Map<String,String> bodyMap){
		    
		String result = null;
		PostMethod postMethod = null;
		HttpClient httpClient = new HttpClient();
		
		httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
		postMethod = new PostMethod(url);
					
		
		HttpClientParams httparams = new HttpClientParams();
		httparams.setSoTimeout(60000);
		postMethod.setParams(httparams);
		
		try {
			int statusCode = httpClient.executeMethod(postMethod);
			if (statusCode == HttpStatus.SC_OK) {
				result = postMethod.getResponseBodyAsString();
			} else {
				System.out.println("发送HTTPS数据错误 http response status is " + statusCode);
			}
		} catch (HttpException e) {
			System.out.println("error url=" + url);
		} catch (IOException e) {
			System.out.println("error url=" + url);
		} finally {
			if (postMethod != null) {
				postMethod.releaseConnection();
			}
		}
		      
		return result;
	}
	
	/**
	 * 
	* send(GET方式发送HTTPS请求)
	* @param url
	* @param paramsMap
	* @return 
	* String
	* @exception 
	* @since  0.0.1
	*/
	public static String sendData(String url){
		
		String result = null;
		GetMethod getMethod = new GetMethod(url);
		HttpClient httpClient = new HttpClient();
		
		httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
		HttpClientParams httparams = new HttpClientParams();
		httparams.setSoTimeout(60000);
		getMethod.setParams(httparams);
		
		try {
			int statusCode = httpClient.executeMethod(getMethod);
			if (statusCode == HttpStatus.SC_OK) {
				result = getMethod.getResponseBodyAsString();
			} else {
				System.out.println("发送HTTPS数据错误 http response status is " + statusCode);
			}
		} catch (HttpException e) {
			System.out.println("error url=" + url);
		} catch (IOException e) {
			System.out.println("error url=" + url);
		} finally {
			if (getMethod != null) {
				getMethod.releaseConnection();
			}
		}
		
		return result;
	}
}
