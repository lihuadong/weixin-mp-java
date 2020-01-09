/**
 * 
 * 微信-公众号-封装接口JAVA版本
 * weixin.msg
 * Request.java
 * Ver0.0.1
 * 2016年6月20日-下午1:59:01
 * 2014-2019  ©全智道(北京)科技有限公司
 * 
 */

package weixin.msg;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.json.JSONException;
import org.json.JSONObject;

import weixin.base.APIURL;
import weixin.msg.builder.RequestMsgBuilder;
import weixin.msg.builder.RequestMsgEventBuilder;
import weixin.msg.model.base.WeixinMsgBase;
import weixin.util.HTTPSDataManager;

/**
 * 
 * Request
 * 
 * 李华栋
 * 李华栋
 * 2016年6月20日 下午1:59:01
 * 
 * @version 0.0.1
 * 
 */
public class RequestMsg {
	
	/**
	 * getMessage 解析请求内容并构建微信消息对象
	 * @param InputStream is
	 * WeixinMsg
	 * @exception 
	 * @since  0.0.1
	 */
	public static WeixinMsgBase getMessage(InputStream is){
		
		WeixinMsgBase wxmsg = null;
		
		SAXBuilder sax = new SAXBuilder(); 
		Document doc = null;
		try {
			doc = sax.build(is);
		} catch (JDOMException | IOException e) {
			e.printStackTrace();
		}
	
		//获得文件的根元素
		Element root = doc.getRootElement();			
		//获得根元素的第一级子节点
		List<Object> list = root.getChildren();
		//构建微信消息对象
		for(int j=0;j<list.size();j++){
			//获得结点
			Element element = (Element) list.get(j);
			if(element.getName().equals("MsgType")){
				String msgType = element.getValue().trim();
				if(msgType.equals("event")){
					
					//事件类微信消息
					RequestMsgEventBuilder rem = new RequestMsgEventBuilder();
					wxmsg = rem.getEventMessage(list);
				}
				else{
					
					//普通微信消息
					RequestMsgBuilder rm = new RequestMsgBuilder();
					wxmsg = rm.getRegularMessage(list);
				}
				break;
			}
		}
		return wxmsg;
	}

	/**
	 * 获取自动回复的所有规则
	 * @param accesstoken
	 * @return
	 */
	public static JSONObject getAutoReplyRules(String accesstoken) {
		String url = APIURL.MSG_AUTOREPLY_RULE_URL+ accesstoken;
	    String result = HTTPSDataManager.sendData(url);
	    try {
			return new JSONObject(result);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
	}
}
