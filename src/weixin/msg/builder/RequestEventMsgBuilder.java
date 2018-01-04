/**
 * 包打听全知道-微信H5版本
 * weixin.msg
 * RequestEventMsg.java
 * Ver0.0.1
 * 2016年6月20日-下午1:56:42
 *  2016全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.builder;

import java.util.List;

import org.jdom.Element;

import weixin.msg.model.base.WeixinMsgBase;
import weixin.msg.model.event.ClickEvent;
import weixin.msg.model.event.LocationSelectEvent;
import weixin.msg.model.event.MassSendJobFinishEvent;
import weixin.msg.model.event.PicPhotoOrAlbumEvent;
import weixin.msg.model.event.PicSysphotoEvent;
import weixin.msg.model.event.PicWeixinEvent;
import weixin.msg.model.event.ScanEvent;
import weixin.msg.model.event.ScancodePushEvent;
import weixin.msg.model.event.ScancodeWaitmsgEvent;
import weixin.msg.model.event.SubscribeEvent;
import weixin.msg.model.event.LocationEvent;
import weixin.msg.model.event.TemplateSendJobFinishEvent;
import weixin.msg.model.event.ViewEvent;
import weixin.msg.model.event.account.AnnualRenew;
import weixin.msg.model.event.account.NamingVerifyFail;
import weixin.msg.model.event.account.NamingVerifySuccess;
import weixin.msg.model.event.account.QualificationVerifyFail;
import weixin.msg.model.event.account.QualificationVerifySuccess;
import weixin.msg.model.event.account.VerifyExpired;

/**
 * 
 * RequestEventMsg
 * 
 * 李华栋
 * 李华栋
 * 2016年6月20日 下午1:56:42
 * 
 * @version 0.0.1
 * 
 */
public class RequestEventMsgBuilder {
	
	private String toUserName;
	private String fromUserName;
	private String createTime;
	private String msgType;
	private String event;
	
	private String eventKey;
	private String ticket;
	private String latitude;
	private String longitude;
	private String precision;
	private String menuID;
	private String msgID;
	private String status;
	
	private String sendLocationInfo;
	private String location_X;
	private String location_Y;
	private String scale;
	private String label;
	private String poiname;
	private String sendPicsInfo;
	private String count;
	private String picList;
	private String picMd5Sum;
	private String scanCodeInfo;
	private String scanType;
	private String scanResult;
	private String totalCount;
	private String filterCount;
	private String sentCount;
	private String errorCount;
	private String expiredTime;
	private String failTime;
	private String failReason;
	
	/**
	 * getRegularMessage 构建事件类微信消息对象
	 * @param list
	 *WeixinMsg
	 * @exception 
	 * @since  0.0.1
	 */
	public  WeixinMsgBase getEventMessage(List<Object> list){
		WeixinMsgBase wxmsg = null;
		//获取请求信息
		Element element = null;
		msgType = "event";
		ticket = "";	//区分关注与扫码关注
		menuID = "";	//区分是否是来自个性化菜单
		poiname = "";	//可能为空
		for(int i=0;i<list.size();i++){
			element = (Element)list.get(i);
			if(element.getName().equals("ToUserName")){
				toUserName = element.getValue().trim();
			} else if(element.getName().equals("FromUserName")){
				fromUserName = element.getValue().trim();
			} else if(element.getName().equals("CreateTime")){
				createTime = element.getValue().trim();
			} else if(element.getName().equals("Event")){
				event = element.getValue().trim();
			} else if(element.getName().equals("EventKey")){
				eventKey = element.getValue().trim();
			} else if(element.getName().equals("Ticket")){
				ticket = element.getValue().trim();
			} else if(element.getName().equals("Latitude")){
				latitude = element.getValue().trim();
			} else if(element.getName().equals("Longitude")){
				longitude = element.getValue().trim();
			} else if(element.getName().equals("Precision")){
				precision = element.getValue().trim();
			} else if(element.getName().equals("MenuID")){
				menuID = element.getValue().trim();
			} else if(element.getName().equals("MsgID")){
				msgID = element.getValue().trim();
			} else if(element.getName().equals("Status")){
				status = element.getValue().trim();
			} else if(element.getName().equals("SendLocationInfo")){
				sendLocationInfo = element.getValue().trim();
			} else if(element.getName().equals("Location_X")){
				location_X = element.getValue().trim();
			} else if(element.getName().equals("Location_Y")){
				location_Y = element.getValue().trim();
			} else if(element.getName().equals("Scale")){
				scale = element.getValue().trim();
			} else if(element.getName().equals("Label")){
				label = element.getValue().trim();
			} else if(element.getName().equals("Poiname")){
				poiname = element.getValue().trim();
			} else if(element.getName().equals("SendPicsInfo")){
				sendPicsInfo = element.getValue().trim();
			} else if(element.getName().equals("Count")){
				count = element.getValue().trim();
			} else if(element.getName().equals("PicList")){
				picList = element.getValue().trim();
			} else if(element.getName().equals("PicMd5Sum")){
				picMd5Sum = element.getValue().trim();
			} else if(element.getName().equals("ScanCodeInfo")){
				scanCodeInfo = element.getValue().trim();
			} else if(element.getName().equals("ScanType")){
				scanType = element.getValue().trim();
			} else if(element.getName().equals("ScanResult")){
				scanResult = element.getValue().trim();
			} else if(element.getName().equals("TotalCount")){
				totalCount = element.getValue().trim();
			} else if(element.getName().equals("FilterCount")){
				filterCount = element.getValue().trim();
			} else if(element.getName().equals("SentCount")){
				sentCount = element.getValue().trim();
			} else if(element.getName().equals("ErrorCount")){
				errorCount = element.getValue().trim();
			} else if(element.getName().equals("ExpiredTime")){
				expiredTime = element.getValue().trim();
			} else if(element.getName().equals("FailTime")){
				failTime = element.getValue().trim();
			} else if(element.getName().equals("FailReason")){
				failReason = element.getValue().trim();
			}
		}
		
		//构造事件类微信消息对象
		if(event.equals("subscribe")||event.equals("unsubscribe")){
			wxmsg = getSubscribe();
		} else if(event.equals("SCAN")){
			wxmsg = getScan();
		} else if(event.equals("LOCATION")){
			wxmsg = getLocation();
		} else if(event.equals("CLICK")){
			wxmsg = getClick();
		} else if(event.equals("VIEW")){
			wxmsg = getView();
		} else if(event.equals("TEMPLATESENDJOBFINISH")){
			wxmsg = getTemplate();
		} else if(event.equals("location_select")){
			wxmsg = getLocationSelect();
		} else if(event.equals("pic_photo_or_album")){
			wxmsg = getPicPhotoOrAlbum();
		} else if(event.equals("pic_sysphoto")){
			wxmsg = getPicSysphoto();
		} else if(event.equals("pic_weixin")){
			wxmsg = getPicWeixin();
		} else if(event.equals("scancode_push")){
			wxmsg = getScancodePush();
		} else if(event.equals("scancode_waitmsg")){
			wxmsg = getScancodeWaitmsg();
		} else if(event.equals("MASSSENDJOBFINISH")){
			wxmsg = getMassSendJobFinish();
		} else if(event.equals("qualification_verify_success")){
			wxmsg = getQualificationVerifySuccess();
		} else if(event.equals("qualification_verify_fail")){
			wxmsg = getQualificationVerifyFail();
		} else if(event.equals("naming_verify_success")){
			wxmsg = getNamingVerifySuccess();
		} else if(event.equals("naming_verify_fail")){
			wxmsg = getNamingVerifyFail();
		} else if(event.equals("annual_renew")){
			wxmsg = getAnnualRenew();
		} else if(event.equals("verify_expired")){
			wxmsg = getVerifyExpired();
		}
				
		return wxmsg;
	}
	
	/**
	 *构造 SubscribeEvent对象 
	 **/
	private SubscribeEvent getSubscribe(){
		SubscribeEvent se = new SubscribeEvent();
		
		se.setToUserNameGID(toUserName);
		se.setFromUserNameOpenID(fromUserName);
		se.setCreateTime(createTime);
		se.setMsgType(msgType);
		se.setEvent(event);
		if(ticket.length()>0){
			se.setEventKey(eventKey);
			se.setTicket(ticket);
		}
		
		return se;
	}
	
	/**
	 *构造 ScanEvent对象 
	 **/
	private ScanEvent getScan(){
		ScanEvent se = new ScanEvent();
		
		se.setToUserNameGID(toUserName);
		se.setFromUserNameOpenID(fromUserName);
		se.setCreateTime(createTime);
		se.setMsgType(msgType);
		se.setEvent(event);
		se.setEventKey(eventKey);
		se.setTicket(ticket);
		
		return se;
	}
	
	/**
	 *构造 LocationEvent对象 
	 **/
	private LocationEvent getLocation(){
		LocationEvent le = new LocationEvent();
		
		le.setToUserNameGID(toUserName);
		le.setFromUserNameOpenID(fromUserName);
		le.setCreateTime(createTime);
		le.setMsgType(msgType);
		le.setEvent(event);
		le.setLatitude(latitude);
		le.setLongitude(longitude);
		le.setPrecision(precision);
		
		return le;
	}
	
	/**
	 *构造 ClickEvent对象 
	 **/
	private ClickEvent getClick(){
		ClickEvent ce = new ClickEvent();
		
		ce.setToUserNameGID(toUserName);
		ce.setFromUserNameOpenID(fromUserName);
		ce.setCreateTime(createTime);
		ce.setMsgType(msgType);
		ce.setEvent(event);
		ce.setEventKey(eventKey);
		
		return ce;
	}
	
	/**
	 *构造 ViewEvent对象 
	 **/
	private ViewEvent getView(){
		ViewEvent ve = new ViewEvent();
		
		ve.setToUserNameGID(toUserName);
		ve.setFromUserNameOpenID(fromUserName);
		ve.setCreateTime(createTime);
		ve.setMsgType(msgType);
		ve.setEvent(event);
		ve.setEventKey(eventKey);
		if(menuID.length()>0){
			ve.setMenuID(menuID);
		}
		
		return ve;
	}
	
	/**
	 *构造 TemplateSendJobFinishEvent对象 
	 **/
	private TemplateSendJobFinishEvent getTemplate(){
		TemplateSendJobFinishEvent te = new TemplateSendJobFinishEvent();
		
		te.setToUserNameGID(toUserName);
		te.setFromUserNameOpenID(fromUserName);
		te.setCreateTime(createTime);
		te.setMsgType(msgType);
		te.setEvent(event);
		te.setMsgId(msgID);
		te.setStatus(status);
		
		return te;
	}
	
	/**
	 *构造 LocationSelectEvent对象 
	 **/
	private LocationSelectEvent getLocationSelect(){
		LocationSelectEvent le = new LocationSelectEvent();
		
		le.setToUserNameGID(toUserName);
		le.setFromUserNameOpenID(fromUserName);
		le.setCreateTime(createTime);
		le.setMsgType(msgType);
		le.setEvent(event);
		le.setEventKey(eventKey);
		le.setLabel(label);
		le.setLocation_X(location_X);
		le.setLocation_Y(location_Y);
		le.setPoiname(poiname);
		le.setScale(scale);
		le.setSendLocationInfo(sendLocationInfo);
		
		return le;
	}
	
	/**
	 *构造 PicPhotoOrAlbumEvent对象 
	 **/
	private PicPhotoOrAlbumEvent getPicPhotoOrAlbum(){
		PicPhotoOrAlbumEvent pe = new PicPhotoOrAlbumEvent();
		
		pe.setToUserNameGID(toUserName);
		pe.setFromUserNameOpenID(fromUserName);
		pe.setCreateTime(createTime);
		pe.setMsgType(msgType);
		pe.setEvent(event);
		pe.setEventKey(eventKey);
		pe.setCount(count);
		pe.setPicList(picList);
		pe.setPicMd5Sum(picMd5Sum);
		pe.setSendPicsInfo(sendPicsInfo);
		
		return pe;
	}
	
	/**
	 *构造 PicSysphotoEvent对象 
	 **/	
	private PicSysphotoEvent getPicSysphoto(){
		PicSysphotoEvent pe = new PicSysphotoEvent();
		
		pe.setToUserNameGID(toUserName);
		pe.setFromUserNameOpenID(fromUserName);
		pe.setCreateTime(createTime);
		pe.setMsgType(msgType);
		pe.setEvent(event);
		pe.setEventKey(eventKey);
		pe.setCount(count);
		pe.setPicList(picList);
		pe.setPicMd5Sum(picMd5Sum);
		pe.setSendPicsInfo(sendPicsInfo);
		
		return pe;
	}
	
	/**
	 *构造 PicWeixinEvent对象 
	 **/
	private PicWeixinEvent getPicWeixin(){
		PicWeixinEvent pe = new PicWeixinEvent();
		
		pe.setToUserNameGID(toUserName);
		pe.setFromUserNameOpenID(fromUserName);
		pe.setCreateTime(createTime);
		pe.setMsgType(msgType);
		pe.setEvent(event);
		pe.setEventKey(eventKey);
		pe.setCount(count);
		pe.setPicList(picList);
		pe.setPicMd5Sum(picMd5Sum);
		pe.setSendPicsInfo(sendPicsInfo);
		
		return pe;
	}
	
	/**
	 *构造 ScancodePushEvent对象 
	 **/
	private ScancodePushEvent getScancodePush(){
		ScancodePushEvent se = new ScancodePushEvent();
		
		se.setToUserNameGID(toUserName);
		se.setFromUserNameOpenID(fromUserName);
		se.setCreateTime(createTime);
		se.setMsgType(msgType);
		se.setEvent(event);
		se.setEventKey(eventKey);
		se.setScanCodeInfo(scanCodeInfo);
		se.setScanResult(scanResult);
		se.setScanType(scanType);
		
		return se;
	}
	
	/**
	 *构造 ScancodeWaitmsgEvent对象 
	 **/
	private ScancodeWaitmsgEvent getScancodeWaitmsg(){
		ScancodeWaitmsgEvent se = new ScancodeWaitmsgEvent();
		
		se.setToUserNameGID(toUserName);
		se.setFromUserNameOpenID(fromUserName);
		se.setCreateTime(createTime);
		se.setMsgType(msgType);
		se.setEvent(event);
		se.setEventKey(eventKey);
		se.setScanCodeInfo(scanCodeInfo);
		se.setScanResult(scanResult);
		se.setScanType(scanType);
		
		return se;
	}
	
	/**
	 *构造 MassSendJobFinishEvent对象 
	 **/
	private MassSendJobFinishEvent getMassSendJobFinish(){
		MassSendJobFinishEvent me = new MassSendJobFinishEvent();
		
		me.setToUserNameGID(toUserName);
		me.setFromUserNameOpenID(fromUserName);
		me.setCreateTime(createTime);
		me.setMsgType(msgType);
		me.setEvent(event);
		me.setMsgId(msgID);
		me.setStatus(status);
		me.setTotalCount(totalCount);
		me.setFilterCount(filterCount);
		me.setSentCount(sentCount);
		me.setErrorCount(errorCount);
		
		return me;
	}
	
	/**
	 *构造 QualificationVerifySuccess对象 
	 **/
	private QualificationVerifySuccess getQualificationVerifySuccess(){
		QualificationVerifySuccess qe = new QualificationVerifySuccess();
		
		qe.setToUserNameGID(toUserName);
		qe.setFromUserNameOpenID(fromUserName);
		qe.setCreateTime(createTime);
		qe.setMsgType(msgType);
		qe.setEvent(event);
		qe.setExpiredTime(expiredTime);
		
		return qe;
	}
	
	/**
	 *构造 QualificationVerifyFail对象 
	 **/
	private QualificationVerifyFail getQualificationVerifyFail(){
		QualificationVerifyFail qe = new QualificationVerifyFail();
		
		qe.setToUserNameGID(toUserName);
		qe.setFromUserNameOpenID(fromUserName);
		qe.setCreateTime(createTime);
		qe.setMsgType(msgType);
		qe.setEvent(event);
		qe.setFailTime(failTime);
		qe.setFailReason(failReason);
		
		return qe;
	}
	
	/**
	 *构造 NamingVerifySuccess对象 
	 **/
	private NamingVerifySuccess getNamingVerifySuccess(){
		NamingVerifySuccess ne = new NamingVerifySuccess();
		
		ne.setToUserNameGID(toUserName);
		ne.setFromUserNameOpenID(fromUserName);
		ne.setCreateTime(createTime);
		ne.setMsgType(msgType);
		ne.setEvent(event);
		ne.setExpiredTime(expiredTime);
		
		return ne;
	}
	
	/**
	 *构造 NamingVerifyFail对象 
	 **/
	private NamingVerifyFail getNamingVerifyFail(){
		NamingVerifyFail ne = new NamingVerifyFail();
		
		ne.setToUserNameGID(toUserName);
		ne.setFromUserNameOpenID(fromUserName);
		ne.setCreateTime(createTime);
		ne.setMsgType(msgType);
		ne.setEvent(event);
		ne.setFailTime(failTime);
		ne.setFailReason(failReason);
		
		return ne;
	}
	
	/**
	 *构造 AnnualRenew对象 
	 **/
	private AnnualRenew getAnnualRenew(){
		AnnualRenew ae = new AnnualRenew();
		
		ae.setToUserNameGID(toUserName);
		ae.setFromUserNameOpenID(fromUserName);
		ae.setCreateTime(createTime);
		ae.setMsgType(msgType);
		ae.setEvent(event);
		ae.setExpiredTime(expiredTime);
		
		return ae;
	}
	
	/**
	 *构造 VerifyExpired对象 
	 **/
	private VerifyExpired getVerifyExpired(){
		VerifyExpired ve = new VerifyExpired();
		
		ve.setToUserNameGID(toUserName);
		ve.setFromUserNameOpenID(fromUserName);
		ve.setCreateTime(createTime);
		ve.setMsgType(msgType);
		ve.setEvent(event);
		ve.setExpiredTime(expiredTime);
		
		return ve;
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
