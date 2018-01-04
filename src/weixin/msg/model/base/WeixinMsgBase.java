/**
 * 包打听全知道-微信H5版本
 * weixin.message
 * WeixinMsg.java
 * Ver0.0.1
 * 2014年9月5日-上午8:39:52
 * 2014全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.model.base;

/**
 * 
 * WeixinMsg
 * 
 * 李华栋
 * 李华栋
 * 2014年9月5日 上午8:39:52
 * 
 * @version 0.0.1
 * 
 */
public class WeixinMsgBase implements java.io.Serializable {

	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 *
	 * @since 0.0.1
	 */
	
	private static final long serialVersionUID = 8670109920887773831L;
	/**
	 * toUserName
	 *
	 * @return  the toUserName
	 * @since   0.0.1
	 */
	
	private String toUserNameGID; 			//开发者微信号
	private String fromUserNameOpenID;	//发送方帐号（一个OpenID）
	private String createTime;					//消息创建时间 （整型）
	private String msgType;					//(1)消息类型 	text image link voice video location 
														//				music article shortvideo
														//(2)事件类型  	event 
	
	/******消息类型为事件 event 时没有 msgId*/
	private String msgId;				//消息id，64位整型
	
	
	public String getToUserNameGID() {
		return toUserNameGID;
	}


	/**
	 * @param toUserName the toUserName to set
	 */
	public void setToUserNameGID(String toUserName) {
		this.toUserNameGID = toUserName;
	}


	/**
	 * fromUserName
	 *
	 * @return  the fromUserName
	 * @since   0.0.1
	 */
	
	public String getFromUserNameOpenID() {
		return fromUserNameOpenID;
	}


	/**
	 * @param fromUserName the fromUserName to set
	 */
	public void setFromUserNameOpenID(String fromUserName) {
		this.fromUserNameOpenID = fromUserName;
	}


	/**
	 * createTime
	 *
	 * @return  the createTime
	 * @since   0.0.1
	 */
	
	public String getCreateTime() {
		return createTime;
	}


	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}


	/**
	 * msgType
	 *
	 * @return  the msgType
	 * @since   0.0.1
	 */
	
	public String getMsgType() {
		return msgType;
	}


	/**
	 * @param msgType the msgType to set
	 */
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}


	/**
	 * msgId
	 *
	 * @return  the msgId
	 * @since   0.0.1
	 */
	
	public String getMsgId() {
		return msgId;
	}


	/**
	 * @param msgId the msgId to set
	 */
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}



	@Override
	public String toString() {
		return "WeixinMsg [toUserNameGID=" + toUserNameGID + ", fromUserNameOpenID=" + fromUserNameOpenID + ", createTime=" + createTime
				+ ", msgType=" + msgType + "]";
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
