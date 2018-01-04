/**
 * 包打听全知道-微信H5版本
 * weixin.message
 * Location.java
 * Ver0.0.1
 * 2014年9月5日-上午9:07:34
 *  2014全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.model.common;

import weixin.msg.model.base.WeixinMsgBase;

/**
 * 
 * Location
 * 
 * 李华栋
 * 李华栋
 * 2014年9月5日 上午9:07:34
 * 
 * @version 0.0.1
 * 
 */
public class Location extends WeixinMsgBase {

	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 *
	 * @since 0.0.1
	 */
	
	private static final long serialVersionUID = 5209030403136629511L;
	
	private String location_X;	//地理位置维度
	private String location_Y;	//地理位置经度
	private String scale;		//地图缩放大小
	private String label;		//地理位置信息
	
	/**
	 * location_X
	 *
	 * @return  the location_X
	 * @since   0.0.1
	 */
	
	public String getLocation_X() {
		return location_X;
	}

	/**
	 * @param location_X the location_X to set
	 */
	public void setLocation_X(String location_X) {
		this.location_X = location_X;
	}

	/**
	 * location_Y
	 *
	 * @return  the location_Y
	 * @since   0.0.1
	 */
	
	public String getLocation_Y() {
		return location_Y;
	}

	/**
	 * @param location_Y the location_Y to set
	 */
	public void setLocation_Y(String location_Y) {
		this.location_Y = location_Y;
	}

	/**
	 * scale
	 *
	 * @return  the scale
	 * @since   0.0.1
	 */
	
	public String getScale() {
		return scale;
	}

	/**
	 * @param scale the scale to set
	 */
	public void setScale(String scale) {
		this.scale = scale;
	}

	/**
	 * label
	 *
	 * @return  the label
	 * @since   0.0.1
	 */
	
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
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
