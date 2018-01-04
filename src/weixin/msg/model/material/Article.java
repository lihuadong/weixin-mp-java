/**
 * 包打听全知道-微信H5版本
 * weixin.msg.model.material
 * Article.java
 * Ver0.0.1
 * 2016年6月28日-上午9:52:53
 *  2016全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.model.material;

/**
 * 
 * Article
 * 
 * 李华栋
 * 李华栋
 * 2016年6月28日 上午9:52:53
 * 
 * @version 0.0.1
 * 
 */
public class Article {
	
	private String title;			//标题
	private String thumb_media_id;	//图文消息的封面图片素材id（必须是永久mediaID）
	private String author;			//作者
	private String digest;			//图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
	private String show_cover_pic;	//是否显示封面，0为false，即不显示，1为true，即显示
	private String content;			//图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS
	private String content_source_url;	//图文消息的原文地址，即点击“阅读原文”后的URL
	private String url;				//图文页的URL
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the thumb_media_id
	 */
	public String getThumb_media_id() {
		return thumb_media_id;
	}
	/**
	 * @param thumb_media_id the thumb_media_id to set
	 */
	public void setThumb_media_id(String thumb_media_id) {
		this.thumb_media_id = thumb_media_id;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the digest
	 */
	public String getDigest() {
		return digest;
	}
	/**
	 * @param digest the digest to set
	 */
	public void setDigest(String digest) {
		this.digest = digest;
	}
	/**
	 * @return the show_cover_pic
	 */
	public String getShow_cover_pic() {
		return show_cover_pic;
	}
	/**
	 * @param show_cover_pic the show_cover_pic to set
	 */
	public void setShow_cover_pic(String show_cover_pic) {
		this.show_cover_pic = show_cover_pic;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the content_source_url
	 */
	public String getContent_source_url() {
		return content_source_url;
	}
	/**
	 * @param content_source_url the content_source_url to set
	 */
	public void setContent_source_url(String content_source_url) {
		this.content_source_url = content_source_url;
	}
	/**
	 * @return the url
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
	
}
