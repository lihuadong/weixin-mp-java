/**
 * 
 * 微信-公众号-封装接口JAVA版本
 * weixin.msg
 * ResponseTptMsg.java
 * Ver0.0.1
 * 2016年6月20日-下午2:58:36
 * 2014-2019 ©全智道(北京)科技有限公司
 * 
 */
package weixin.msg.builder;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import weixin.msg.model.tpt.TemplateMsg;


/**
 * 
 * ResponseTptMsg
 * 
 * 返回的为JSON
 * 同时会再进行事件消息的推送
 * 
 * 李华栋
 * 2016年6月20日 下午2:58:36
 * 
 * @version 0.0.1
 * 
 */
public class ResponseTptMsgBuilder {
	
	/**
	 * 发送设置所属行业消息
	 * @param industry1	公众号模板消息所属行业1编号
	 * @param industry2	公众号模板消息所属行业2编号
	 * @return String	json格式的数据
	 */
	public String setIndustry(int industry1, int industry2){
		
		//填充回复内容
		JSONObject rootJson = new JSONObject();
		try {
			rootJson.put("industry_id1", industry1+"");
			rootJson.put("industry_id2", industry2+"");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		//转换为json格式字符串
		return rootJson.toString();
	}
	
	/**
	 * 发送模板消息
	 * @param template	发送的模板
	 * @return String	json格式的数据
	 */
	public String template(TemplateMsg template){
				
		//填充回复内容
		JSONObject rootJson = new JSONObject();
		try {
			rootJson.put("touser", template.getTouser());
			rootJson.put("template_id", template.getTemplate_id());
			rootJson.put("url", template.getUrl());
		
			//填充模板信息
			JSONObject subJson = new JSONObject();
			JSONObject tJson = null;
			List<String> labels = template.getLabels();
			List<String> values = template.getValues();
			List<String> colors = template.getColors();
			for(int i=0;i<values.size();i++){
				tJson = new JSONObject();
				tJson.put("value", values.get(i));
				tJson.put("color", colors.get(i));
				subJson.put(labels.get(i), tJson);
			}
			rootJson.put("data", subJson);
		} catch (JSONException e) {
			e.printStackTrace();
		}
			
		//转换为json格式字符串
		return rootJson.toString();
	}


	

}
