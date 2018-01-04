/**
 * 包打听全知道-微信H5版本
 * weixin.msg.model.cs
 * Tempplate.java
 * Ver0.0.1
 * 2016年6月21日-下午3:32:01
 *  2016全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.model.cs;

/**
 * 
 * Tempplate
 * 
 * 李华栋
 * 李华栋
 * 2016年6月21日 下午3:32:01
 * 
 * @version 0.0.1
 * 
 */
public class Tempplate {
	//template_id	模板ID
	//title	模板标题
	//primary_industry	模板所属行业的一级行业
	//deputy_industry	模板所属行业的二级行业
	//content	模板内容
	//example	模板示例
	public String template_id;
	public String title	;
	public String primary_industry;
	public String deputy_industry;
	public String content;
	public String example;
	
	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPrimary_industry() {
		return primary_industry;
	}
	public void setPrimary_industry(String primary_industry) {
		this.primary_industry = primary_industry;
	}
	public String getDeputy_industry() {
		return deputy_industry;
	}
	public void setDeputy_industry(String deputy_industry) {
		this.deputy_industry = deputy_industry;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getExample() {
		return example;
	}
	public void setExample(String example) {
		this.example = example;
	}
	
     
}
