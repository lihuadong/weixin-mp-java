/**
 * 包打听全知道-微信H5版本
 * weixin.message.kefu
 * KefuMsg.java
 * Ver0.0.1
 * 2014年9月29日-下午7:10:08
 *  2014全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.model.base;

/**
 * 
 * KefuMsg
 * 
 * 李华栋
 * 李华栋
 * 2014年9月29日 下午7:10:08
 * 
 * @version 0.0.1
 * http://mp.weixin.qq.com/wiki/index.php?title=%E5%8F%91%E9%80%81%E5%AE%A2%E6%9C%8D%E6%B6%88%E6%81%AF#.E5.8F.91.E9.80.81.E5.9B.BE.E7.89.87.E6.B6.88.E6.81.AF
 */
public class KefuMsg {
	
	private String touser;	//发给的用户
	private String msgtype;	//消息类型
	
	/**
	 * touser
	 *
	 * @return  the touser
	 * @since   0.0.1
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
	 * msgtype
	 *
	 * @return  the msgtype
	 * @since   0.0.1
	 */
	
	public String getMsgtype() {
		return msgtype;
	}
	/**
	 * @param msgtype the msgtype to set
	 */
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
		
}
