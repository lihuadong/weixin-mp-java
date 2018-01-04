/**
 * 包打听全知道-微信H5版本
 * weixin.msg
 * Request.java
 * Ver0.0.1
 * 2016年6月20日-下午1:59:01
 *  2016全智道(北京)科技有限公司-版权所有
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
import org.jdom.output.XMLOutputter;

import weixin.msg.builder.RequestEventMsgBuilder;
import weixin.msg.builder.RequestMsgBuilder;
import weixin.msg.model.base.WeixinMsgBase;

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
public class Request {
	
	/**
	 * getMessage 解析请求内容并构建微信消息对象
	 * @param InputStream is
	 *WeixinMsg
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

		XMLOutputter XMLOut = new XMLOutputter();  
		
		//String tempStr = XMLOut.outputString(doc);
		//System.out.println("-------------request message-------------");
		//System.out.println(tempStr);
		
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
					RequestEventMsgBuilder rem = new RequestEventMsgBuilder();
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
	 * main(这里用一句话描述这个方法的作用)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param args 
	 *void
	 * @exception 
	 * @since  0.0.1
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
