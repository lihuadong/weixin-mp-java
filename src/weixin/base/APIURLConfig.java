/**
 * 
 * 微信-公众号-封装接口JAVA版本
 * weixin.base
 * APIConfig.java
 * Ver0.0.1
 * 2016年6月20日-下午6:18:05
 * 2014-2019 ©全智道(北京)科技有限公司
 * 
 */
package weixin.base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * APIURL
 * 
 * 李华栋
 * 2016年6月20日 下午6:18:05
 * 
 * @version 0.0.1
 * 
 */
public class APIURLConfig {

	//有不同区域的服务结点 
	private static String CURRENT_API; 
	
	static{
		Properties prop = new Properties();  
		InputStream in = APIURLConfig.class.getResourceAsStream("/weixin.properties"); 
		
		try {  
            prop.load(in);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  	
		CURRENT_API = prop.getProperty("ALL_DOMAIN");  
	}
	
	 
		/****************************************************************************************************
		 * 
		 * 微信公众平台基础部分
		 * 
		 ****************************************************************************************************/	 
		//(1)获取微信Accesstoken的URL  后面加APPID&secret=APPSECRET
		public  final static  String ACCESSTOKEN_GET_URL =CURRENT_API+"cgi-bin/token?grant_type=client_credential&appid=";
		//(2)后面加APPID&secret=APPSECRET
		public  final static String JSTICKET_URL = CURRENT_API+"cgi-bin/ticket/getticket?access_token=";
			
			
		/****************************************************************************************************
		 * 
		 * 消息发送
		 * 
		 ****************************************************************************************************/	 

		/**
		 * 消息体系-发送客服消息的URL
		 */
		public  final static  String  MSG_CS_URL  =CURRENT_API+"cgi-bin/message/custom/send?access_token=";
		/**
		 * 消息体系-发送模板消息的URL
		 */
		public  final static  String  MSG_TMPT_URL  =CURRENT_API+"cgi-bin/message/template/send?access_token=";
		/**
		 * 消息体系-根据标签发送群发消息的URL
		 */
		public  final static  String  MSG_GROUP_TAG_URL  =CURRENT_API+"cgi-bin/message/mass/sendall?access_token=";
		/**
		 * 消息体系-根据OpenID列表发送群发消息的URL
		 */
		public  final static  String  MSG_GROUP_OPENID_URL  =CURRENT_API+"cgi-bin/message/mass/send?access_token=";
		/**
		 * 通过API推送订阅模板消息给到授权微信用户
		 */
		public  final static  String  MSG_SUBSCRIBE_URL  =CURRENT_API+"cgi-bin/message/template/subscribe?access_token=";
		
		
		//获取公众号当前使用的自动回复规则，包括关注后自动回复、消息自动回复（60分钟内触发一次）、关键词自动回复
		public  final static  String  MSG_AUTOREPLY_RULE_URL  = CURRENT_API+"cgi-bin/get_current_autoreply_info?access_token=";
		
		/****************************************************************************************************
		 * 
		 * 微信卡券
		 * 
		 ****************************************************************************************************/	 
		/**
		 * 微信卡券的创建URL
		 */
		public  final static  String  CARD_CREATE_URL =CURRENT_API+"card/create?access_token=";
		/**
		 * 微信卡券的买单接口设置URL
		 */
		public  final static  String  CARD_PAYCELL_URL =CURRENT_API+"card/paycell/set?access_token=";
		/**
		 * 微信卡券上传logo的URL
		 */
		public  final static  String  CARD_LOGO_URL = CURRENT_API+"cgi-bin/media/uploadimg?access_token=";
		/**
		 * 微信卡券二维码投放生成URL
		 */
		public  final static  String  CARD_THROW_QRCODE_CREATE_URL =CURRENT_API+"card/qrcode/create?access_token=";
		/**
		 * 微信卡券投放货架创建的URL
		 */
		public  final static  String  CARD_LANDINGPAGE_CREATE_URL =CURRENT_API+"card/landingpage/create?access_token=";
		/**
		 * 卡券导入code接口的URL
		 */
		public  final static  String  CARD_CODE_DEPOSIT_URL =CURRENT_API+"card/code/deposit?access_token=";			
		/**
		 * 查询导入code数目的URL
		 */
		public  final static  String  CARD_CODE_GETDEPOSITCOUNT_URL =CURRENT_API+"card/code/getdepositcount?access_token=";
		/**
		 * 核查导入code的URL
		 */
		public  final static  String  CARD_CODE_CHECKCODE_URL =CURRENT_API+"card/code/checkcode?access_token=";
		/**
		 * 图文消息群发卡券获取content的URL
		 */
		public  final static  String  CARD_MPNEWS_GETHTML_URL =CURRENT_API+"card/mpnews/gethtml?access_token=";
		/**
		 * 线下核销--查询Code接口URL
		 */
		public  final static  String  CARD_GETCODE_URL =CURRENT_API+"card/code/get?access_token=";
		/**
		 * 线下核销--Code接口URL
		 */
		public  final static  String  CARD_CODE_CONSUME_URL =CURRENT_API+"card/code/consume?access_token=";
		/**
		 * 线上核销--Code解码URL
		 */
		public  final static  String  CARD_CODE_DECRYPT_URL =CURRENT_API+"card/code/decrypt?access_token=";
			
			
		/**
		 * 长网址变短网址的URL
		 */
		public final static String LONG2SHORT_URL = CURRENT_API+"cgi-bin/shorturl?access_token=";
	 	//支付 
		public  final static  String PAY_CREATE ="";
		//小店 
		public  final static  String  SHOP_CREATE ="";
		/**
		 * 微信二维码获取链接
		 */
		public  final static  String  QRCode_GET_URL =CURRENT_API+"cgi-bin/qrcode/create?access_token=";
		/**
		 * JSSDK配置相关的URL
		 */
		public  final static  String  JSSDK_GETTICKET  = CURRENT_API+"cgi-bin/ticket/getticket?access_token=";
			
			
		/****************************************************************************************************
		 * 
		 * 用户管理
		 * 
		 ****************************************************************************************************/			
		/**
		 * 获取用户信息URL
		 */
		public  final static  String  USER_INFO  = CURRENT_API+"cgi-bin/user/info?access_token=";
		/**
		 * 获取用户信息URL WEB AUTH
		 */
		public  final static  String  USER_INFO_WEB  = CURRENT_API+"sns/userinfo?access_token=";
		/**
		 * 创建用户标签URL
		 */
		public  final static  String  CREATE_TAG  = CURRENT_API+"cgi-bin/tags/create?access_token=";
		/**
		 * 查询所有标签URL
		 */
		public  final static  String  GET_TAG  = CURRENT_API+"cgi-bin/tags/get?access_token=";
		/**
		 * 编辑标签URL
		 */
		public  final static  String  UPDATE_TAG  = CURRENT_API+"cgi-bin/tags/update?access_token=";
		/**
		 * 删除标签URL
		 */
		public  final static  String  DELETE_TAG  = CURRENT_API+"cgi-bin/tags/delete?access_token=";
		/**
		 * 获取标签下粉丝列表URL
		 */
		public  final static  String  GET_USERLIST_TAG  = CURRENT_API+"cgi-bin/user/tag/get?access_token=";
		/**
		 * 批量为用户打标签URL
		 */
		public  final static  String  ADD_USERTAG  = CURRENT_API+"cgi-bin/tags/members/batchtagging?access_token=";
		/**
		 * 批量为用户取消标签URL
		 */
		public  final static  String  DELETE_USERTAG  = CURRENT_API+"cgi-bin/tags/members/batchuntagging?access_token=";
		/**
		 * 获取用户身上的标签列表URL
		 */
		public  final static  String  GET_USERTAG  = CURRENT_API+"cgi-bin/tags/getidlist?access_token=";
		/**
		 * 获取用户列表URL
		 */
		public  final static  String  GET_USERLIST  = CURRENT_API+"cgi-bin/user/get?access_token=";
		/**
		 * 设置用户备注名URL
		 */
		public  final static  String  UPDATE_REMARK  = CURRENT_API+"cgi-bin/user/info/updateremark?access_token=";
			
			
		/****************************************************************************************************
		 * 
		 * 菜单管理
		 * 
		 ****************************************************************************************************/	 
		/**
		 * 自定义菜单创建URL
		 */
		public  final static  String  CREATE_MENU  = CURRENT_API+"cgi-bin/menu/create?access_token=";
		/**
		 * 自定义菜单查询URL
		 */
		public  final static  String  GET_MENU  = CURRENT_API+"cgi-bin/menu/get?access_token=";
		/**
		 * 自定义菜单删除URL
		 */
		public  final static  String  DELETE_MENU  = CURRENT_API+"cgi-bin/menu/delete?access_token=";
		/**
		 * 创建个性化菜单
		 */
		public  final static String  CREATE_CONDITIONAL_MENU = CURRENT_API+"cgi-bin/menu/addconditional?access_token=";
		/**
		 * 删除个性化菜单
		 */
		public  final static String  DELETE_CONDITIONAL_MENU = CURRENT_API+"cgi-bin/menu/delconditional?access_token=";
		/**
		 * 区配个性化菜单
		 */
		public  final static String  TRYMATCH_CONDITIONAL_MENU = CURRENT_API+"cgi-bin/menu/trymatch?access_token=";
			
		/****************************************************************************************************
		 * 
		 * 素材管理
		 * 
		 ****************************************************************************************************/
		/**
		 * 新增临时素材URL
		 */
		public  final static  String  ADD_MEDIA  = CURRENT_API+"cgi-bin/media/upload?access_token=";
		/**
		 * 获取临时素材URL
		 */
		public  final static  String  GET_MEDIA  = CURRENT_API+"cgi-bin/media/get?access_token=";
		/**
		 * 新增永久图文素材URL
		 */
		public  final static  String  ADD_NEWS  = CURRENT_API+"cgi-bin/material/add_news?access_token=";
		/**
		 * 上传图文消息内图片URL
		 */
		public  final static  String  UPLOAD_IMG  = CURRENT_API+"cgi-bin/media/uploadimg?access_token=";
		/**
		 * 新增永久素材（除图文外）URL
		 */
		public  final static  String  ADD_MATERIAL  = CURRENT_API+"cgi-bin/material/add_material?access_token=";
		/**
		 * 获取永久素材URL
		 */
		public  final static  String  GET_MATERIAL  = CURRENT_API+"cgi-bin/material/get_material?access_token=";
		/**
		 * 删除永久素材URL
		 */
		public  final static  String  DELETE_MATERIAL  = CURRENT_API+"cgi-bin/material/del_material?access_token=";
		/**
		 * 修改永久图文素材URL
		 */
		public  final static  String  UPDATE_NEWS  = CURRENT_API+"cgi-bin/material/update_news?access_token=";
		/**
		 * 获取素材总数URL
		 */
		public  final static  String  GET_MATERIAL_COUNT  = CURRENT_API+"cgi-bin/material/get_materialcount?access_token=";
		/**
		 * 获取素材列表URL
		 */
		public  final static  String  GET_MATERIAL_LIST  = CURRENT_API+"cgi-bin/material/batchget_material?access_token=";
		
			
}
