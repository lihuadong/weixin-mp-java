<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ page import="java.io.InputStream" %> 
<%@ page import="java.io.Writer" %>
<%@ page import="java.util.List" %>   
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %>      

     
<%@ page import="weixin.util.EncoderHandler" %>
<%@ page import="weixin.util.TimeUtil" %>
<%@ page import="weixin.msg.RequestMsg"%>
<%@ page import="weixin.msg.model.base.WeixinMsgBase"%>
<%! String TOKEN = "lihuadong4weixin"; %>

<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	response.setContentType("text/plain");

	String signature = request.getParameter("signature");		//微信服务器生成的签名
	String timestamp = request.getParameter("timestamp");	//时间戳 
	String nonce = request.getParameter("nonce");				//随机数 
	String echostr = request.getParameter("echostr");			//随机字符串

	Writer outer = response.getWriter();
	if(echostr != null){
		List<String> list = new ArrayList<String>(3) {
			//重写ArrayList的toString方法
			public String toString() {return this.get(0) + this.get(1) + this.get(2);
			}
		};
	    //将token、timestamp、nonce加入列表
		list.add(TOKEN);
		list.add(timestamp);
		list.add(nonce);
		
		//将token、timestamp、nonce三个参数进行字典序排序
		Collections.sort(list);			
		
		// 进行sha1加密
		String tmpStr = EncoderHandler.encode("SHA-1",list.toString());
		
		//告诉微信服务器完成校验		
		if (signature.equals(tmpStr)) {
				outer.write(echostr); 
		}
		
	}else{/*******************处理微信与用户的正常交互内容************************/
	     
			try{
	              InputStream is = request.getInputStream();
	              RequestMsg req  = new RequestMsg();
	              req.getMessage(is);
	              //业务进行处理
	              outer.write("");
	              is.close();
		       }catch (Exception e) {
		    	  e.printStackTrace();
			  }
	}
	
	outer.flush();
	outer.close();
%>