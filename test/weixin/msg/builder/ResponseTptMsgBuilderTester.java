package weixin.msg.builder;

public class ResponseTptMsgBuilderTester {

	/**
	 * main(这里用一句话描述这个方法的作用)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param args 
	 *void
	 * @exception 
	 * @since  0.0.1
	 */
	public static void main(String[] args) {
		// TODO Auto-generated met
      /*  //1、构造TptMsg对象
		TemplateMsg tptmsg=new TemplateMsg();
		//AccessTokenManager access=new AccessTokenManager();
		//ResponseTptMsg rtp=new ResponseTptMsg();
		//rtp.template(tptmsg);
		//tptMsg.
        //2、获取accesstoken
		AccessTokenManager  atm  = new AccessTokenManager();
		System.out.println(atm);
		AccessTokenManager.accesstoken="8G1Dv_7y7Z1ap5lRrXgSXCADLqEB9s8H2L4Om8aN6ZminHVKv9ek8zSmiLIHqqFVrRAejXxrf7TWg-XJ2efJLKXM0_jrapvbwYh7E5u6CZ9IjNq-SE_6D9KMkpbtn97sNWPaAAAGPI";
        //3、触发模版消息
		ResponseTptMsg  rts  = new ResponseTptMsg();
		rts.template(tptmsg);*/
//		String touser = "oFHIYtxveXh57uRNKptUAwBH2u7Y";
//		
//        //1、构造TptMsg对象
		/*TemplateMsg  tptMsg  = new TemplateMsg();
		List<String> labels = new ArrayList<String>();
		labels.add("first");
		labels.add("keyword1");
		labels.add("keyword2");
		labels.add("keyword3");
		labels.add("remark");
		List<String> values = new ArrayList<String>();
		values.add("哈罗");
		values.add("一只兔子");
		values.add("onerabbit");
		values.add("1");
		values.add("特别可爱！");
		List<String> colors = new ArrayList<String>();
		colors.add("#173177");
		colors.add("#173177");
		colors.add("#173177");
		colors.add("#173177");
		colors.add("#173177");
		tptMsg.setTouser(touser);
		tptMsg.setTemplate_id("d-mBLWd0YQOE_YLC2NLvPUdgK9S73riOsnW7oe-nq9w");
		tptMsg.setLabels(labels);
		tptMsg.setValues(values);
		tptMsg.setColors(colors);
    	tptMsg.setUrl("http://www.playhudong.com/");*/
//        
//		//2、获取accesstoken
		//AccessTokenManager  atm  = new AccessTokenManager();
		//System.out.println(atm);
		//AccessTokenManager.accesstoken = "Em4-894Ss3s4Ena-BmSj34Cb5r_M2z7GmeFja5ttfddbxtT6MDkoxI0gQdEvebX7TfCbcRJOBAYoDwvk8eb8W84GdYNFlWTjAGaRFCkVf12WABTIM5LvwhhippllhSwxFYFgAGAOHO";       
//		//3、触发模版消息
		//ResponseTptMsg  rts  = new ResponseTptMsg();
		//String res = rts.template(tptMsg);
		//System.out.println(res);
		//Response resp = new Response();
		//System.out.println(resp.sendTptMsg(res));
		
//-----------------------------------------------------------------------------
//		获取模板列表
//		String response = HttpsDataManager.sendData("https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token="+AccessTokenManager.accesstoken);
//		System.out.println(response);
//----------------------------------------------------------------------------------------
		//获取模板列表
		/*AccessTokenManager atm=new AccessTokenManager();
		String response = HttpsDataManager.sendData("https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token="+AccessTokenManager.accesstoken);
		System.out.println(response);*/
		//1.构造tptmsg对象
		/*String template_id="CidG4qTUzFgeRf0TwyySZdxe-p6IxDs2fn6NqivuRIw";
		String url="http://www.playhudong.com/";
		TemplateMsg tptmsg=new TemplateMsg();
		List<String> labels = new ArrayList<String>();
		labels.add("first");
		labels.add("keyword1");
		labels.add("keyword2");
		labels.add("keyword3");
		labels.add("remark");
		List<String> values = new ArrayList<String>();
		values.add("您好，您有新的消息！");
		values.add("车辆剩余油量过少");
		values.add("2015年8月20日");
		values.add("您的车辆剩余测量过少，请注意加油");
		values.add("感谢您使用车管家！");
		List<String> colors=new ArrayList<String>();
		colors.add("#173177");
		colors.add("#173177");
		colors.add("#173177");
		colors.add("#173177");
		colors.add("#173177");
		tptmsg.setTouser(touser);
		tptmsg.setTemplate_id(template_id);
		tptmsg.setLabels(labels);
		tptmsg.setValues(values);
		tptmsg.setColors(colors);
		tptmsg.setUrl(url);
		//2.获取accessToken
		AccessTokenManager atm=new AccessTokenManager();
		System.out.println(atm);
		AccessTokenManager.accesstoken="8CCxQgXN6yamE6VaAoMV7WBGICsPrxiE9yRVIIxbJNDGeoftTUDgItcW1b8K_ox2RxqRvhhg61Ff29BnPtx5AYWWoQlzI59bsQQnkPjGSoOOMN-lmsW0_UaTMNES5GamUQDiAHABXK";
		//3.触发模板消息
		ResponseTptMsg rtm=new ResponseTptMsg();
		String res=rtm.template(tptmsg);
		System.out.println(res);
		Response resp=new Response();
		System.out.println(resp.sendTptMsg(res));*/
		
	
	}

}
