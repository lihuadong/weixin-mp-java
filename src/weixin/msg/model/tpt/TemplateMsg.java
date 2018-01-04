/**
 * 
 */
package weixin.msg.model.tpt;

import java.util.List;

/**
 * @author 
 *
 */
public class TemplateMsg {
	
	private String touser;		//发给的用户(openid)
	private String template_id;	//模板id
	private String url;	//模板消息打开的URL
	private List<String> labels;//模板空白部分标签
	private List<String> values;//模板空白部分填写内容
	private List<String> colors;//模板空白部分填写文字颜色
	
	/**
	 * @return the touser
	 */
	public String getTouser() {
		return touser;
	}

	/**
	 * @param touser the touser to set
	 */
	public void setTouser(String touser) {
		this.touser = touser;
	}

	/**
	 * @return the template_id
	 */
	public String getTemplate_id() {
		return template_id;
	}

	/**
	 * @param template_id the template_id to set
	 */
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	/**
	 * @return the labels
	 */
	public List<String> getLabels() {
		return labels;
	}

	/**
	 * @param labels the labels to set
	 */
	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

	/**
	 * @return the values
	 */
	public List<String> getValues() {
		return values;
	}

	/**
	 * @param values the values to set
	 */
	public void setValues(List<String> values) {
		this.values = values;
	}

	/**
	 * @return the colors
	 */
	public List<String> getColors() {
		return colors;
	}

	/**
	 * @param colors the colors to set
	 */
	public void setColors(List<String> colors) {
		this.colors = colors;
	}



	/**
	 * url
	 *
	 * @return  the url
	 * @since   0.0.1
	 */
	
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
