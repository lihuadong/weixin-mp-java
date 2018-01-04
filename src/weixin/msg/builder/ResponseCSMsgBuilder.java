/**
 * 包打听全知道-微信H5版本
 * weixin.msg
 * ResponseCSMsg.java
 * Ver0.0.1
 * 2016年6月20日-下午2:00:15
 *  2016全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg.builder;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import weixin.msg.model.cs.Article;
import weixin.msg.model.cs.Card;
import weixin.msg.model.cs.Image;
import weixin.msg.model.cs.Music;
import weixin.msg.model.cs.Text;
import weixin.msg.model.cs.Video;
import weixin.msg.model.cs.Voice;

/**
 * 
 * ResponseCSMsg
 * 
 * 李华栋
 * 李华栋
 * 2016年6月20日 下午2:00:15
 * 
 * @version 0.0.1
 * 
 */
public class ResponseCSMsgBuilder {
	
	/**
	 * 客服发送文本消息
	 * @param text		发送的文本
	 * @param cs		指定客服账号(没有可设为"")
	 * @return String	json格式的数据
	 */
	public String text(Text text, String cs){

		String returnStr = "";
		
		//填充回复内容
		JSONObject rootJson = new JSONObject();
		try {
			rootJson.put("touser", text.getTouser());
			rootJson.put("msgtype", "text");
			
			//填充文本信息
			JSONObject subJson = new JSONObject();
			subJson.put("content", text.getText().getContent());
			rootJson.put("text", subJson);
			
			//指定客服账号
			if(cs.length()>0){
				subJson = new JSONObject();
				subJson.put("kf_account", cs);
				rootJson.put("customservice", subJson);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}		
		
		//转换为json格式字符串
		returnStr = rootJson.toString();
		return returnStr;
		
		
	}
	
	/**
	 * 客服发送图片消息
	 * @param image		发送的图片
	 * @param cs		指定客服账号(没有可设为"")
	 * @return String	json格式的数据
	 */
	public String image(Image image, String cs){

		String returnStr = "";
		
		//填充回复内容
		JSONObject rootJson = new JSONObject();
		try {
			rootJson.put("touser", image.getTouser());
			rootJson.put("msgtype", "image");
			
			//填充图片信息
			JSONObject subJson = new JSONObject();
			subJson.put("media_id", image.getImage().getMedia_id());
			rootJson.put("image", subJson);
			
			//指定客服账号
			if(cs.length()>0){
				subJson = new JSONObject();
				subJson.put("kf_account", cs);
				rootJson.put("customservice", subJson);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}		
		
		//转换为json格式字符串
		returnStr = rootJson.toString();
		return returnStr;
	}
	
	/**
	 * 客服发送语音消息
	 * @param voice		发送的语音
	 * @param cs		指定客服账号(没有可设为"")
	 * @return String	json格式的数据
	 */
	public String voice(Voice voice, String cs){

		String returnStr = "";
		
		//填充回复内容
		JSONObject rootJson = new JSONObject();
		try {
			rootJson.put("touser", voice.getTouser());
			rootJson.put("msgtype", "voice");
			
			//填充语音信息
			JSONObject subJson = new JSONObject();
			subJson.put("media_id", voice.getVoice().getMedia_id());
			rootJson.put("voice", subJson);
			
			//指定客服账号
			if(cs.length()>0){
				subJson = new JSONObject();
				subJson.put("kf_account", cs);
				rootJson.put("customservice", subJson);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}	
		
		//转换为json格式字符串
		returnStr = rootJson.toString();
		return returnStr;
	}
	
	/**
	 * 客服发送视频消息
	 * @param video		发送的视频
	 * @param cs		指定客服账号(没有可设为"")
	 * @return String	json格式的数据
	 */
	public String video(Video video, String cs){

		String returnStr = "";
		
		//填充回复内容
		JSONObject rootJson = new JSONObject();
		try {
			rootJson.put("touser", video.getTouser());
			rootJson.put("msgtype", "video");
			
			//填充视频信息
			JSONObject subJson = new JSONObject();
			subJson.put("media_id", video.getVideo().getMedia_id());
			subJson.put("thumb_media_id", video.getVideo().getThumb_media_id());
			subJson.put("title", video.getVideo().getTitle());
			subJson.put("description", video.getVideo().getDescription());
			rootJson.put("video", subJson);
			
			//指定客服账号
			if(cs.length()>0){
				subJson = new JSONObject();
				subJson.put("kf_account", cs);
				rootJson.put("customservice", subJson);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		//转换为json格式字符串
		returnStr = rootJson.toString();
		return returnStr;
		
	}
	
	/**
	 * 客服发送音乐消息
	 * @param music		发送的音乐
	 * @param cs		指定客服账号(没有可设为"")
	 * @return String	json格式的数据
	 */
	public String music(Music music, String cs){

		String returnStr = "";
		
		//填充回复内容
		JSONObject rootJson = new JSONObject();
		try {
			rootJson.put("touser", music.getTouser());
			rootJson.put("msgtype", "music");
			
			//填充音乐信息
			JSONObject subJson = new JSONObject();
			subJson.put("title", music.getMusic().getTitle());
			subJson.put("description", music.getMusic().getDescription());
			subJson.put("musicurl", music.getMusic().getMusicurl());
			subJson.put("hqmusicurl", music.getMusic().getHqmusicurl());
			subJson.put("thumb_media_id", music.getMusic().getThumb_media_id());
			
			rootJson.put("music", subJson);
			
			//指定客服账号
			if(cs.length()>0){
				subJson = new JSONObject();
				subJson.put("kf_account", cs);
				rootJson.put("customservice", subJson);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		//转换为json格式字符串
		returnStr = rootJson.toString();
		return returnStr;
	}
	
	/**
	 * 客服发送图文消息
	 * @param articles	发送的图文(不可超过8个)
	 * @param cs		指定客服账号(没有可设为"")
	 * @return String	json格式的数据
	 */
	public String articles(List<Article> articles, String cs){
		String returnStr = "";

		//图文消息限制8条以内
		if(articles.size()>8){
			return returnStr;
		}
		
		//填充回复内容
		JSONObject rootJson = new JSONObject();
		try {
			rootJson.put("touser", articles.get(0).getTouser());
			rootJson.put("msgtype", articles.get(0).getMsgtype());
			
			//填充图文信息
			JSONObject subJson = new JSONObject();
			
			//发送图文消息（点击跳转到外链） 
			if(articles.get(0).getMsgtype().equals("news")){
				List<JSONObject> artList = new ArrayList<JSONObject>();
				JSONObject artJson = null;
			
				for(int i=0;i<articles.size();i++){
					artJson = new JSONObject();
					artJson.put("title", articles.get(i).getTitle());
					artJson.put("description", articles.get(i).getDescription());
					artJson.put("url", articles.get(i).getUrl());
					artJson.put("picurl", articles.get(i).getPicurl());
					artList.add(artJson);
				}
				subJson.put("articles", artList);
			}
			//发送图文消息（点击跳转到图文消息页面） 
			else{
				subJson.put("media_id", articles.get(0).getMedia_id());
			}
			
			rootJson.put(articles.get(0).getMsgtype(), subJson);
			
			//指定客服账号
			if(cs.length()>0){
				subJson = new JSONObject();
				subJson.put("kf_account", cs);
				rootJson.put("customservice", subJson);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		//转换为json格式字符串
		returnStr = rootJson.toString();
		return returnStr;
	}
	
	/**
	 * 客服发送卡券
	 * @param card		发送的卡券
	 * @param cs		指定客服账号(没有可设为"")
	 * @return String	json格式的数据
	 */
	public String card(Card card, String cs){

		String returnStr = "";
		
		//填充回复内容
		JSONObject rootJson = new JSONObject();
		try {
			rootJson.put("touser", card.getTouser());
			rootJson.put("msgtype", "wxcard");
			
			//填充卡券信息
			JSONObject subJson = new JSONObject();
			subJson.put("card_id", card.getCard_id());
			
			JSONObject cardJson = new JSONObject();
			cardJson.put("code", card.getCode());
			cardJson.put("openid", card.getOpenid());
			cardJson.put("timestamp", card.getTimestamp());
			cardJson.put("signature", card.getSignature());
			String str = cardJson.toString().replaceAll("\"", "\\\\\"");
			
			subJson.put("card_ext", str);
			rootJson.put("wxcard", subJson);
			
			//指定客服账号
			if(cs.length()>0){
				subJson = new JSONObject();
				subJson.put("kf_account", cs);
				rootJson.put("customservice", subJson);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		//转换为json格式字符串
		returnStr = rootJson.toString().replaceAll("\\\\\\\\\\\\", "\\\\");
		return returnStr;
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
				
//				String touser = "oFHIYt2guBTMngMiwFCAQdpOlu5k";
				
		        //1-1、构造文本
//				Text  text   = new Text();
//				
//				Content ct  = new Content();
//				ct.setContent("good jobs 出来打妖怪");
//				
//				text.setText(ct);
//				//text.setTouser("oFHIYt78MuQjL0dNnLLO-Fn7cixE");
//				text.setTouser(touser);
				
				//1-2、构造图片消息
//				Image image = new Image();
//				ImageDetail image_d = new ImageDetail();
//				image_d.setMedia_id("GCsXLR3-7T97ZyryykoYR57R3ewU5RTrR_NdqWmujpY");
//				
//				image.setImage(image_d);
//				image.setTouser(touser);
				
				//1-3、构造语音消息
//				Voice voice = new Voice();
//				VoiceDetail voice_d = new VoiceDetail();
//				voice_d.setMedia_id("YutqTpce4DW2X32dGxIc1g6coQTc-KFfiGPVEpXs4XpDcbhCjDiv16LnxEJu0I7_");
//				
//				voice.setVoice(voice_d);
//				voice.setTouser(touser);
				
				//1-4、构造视频消息
//				Video video = new Video();
//				VideoDetail video_d = new VideoDetail();
//				video_d.setDescription("video testtesttest");
//				video_d.setMedia_id("ZudW5cM11pxaoODfSB-Qao304Tab8jek3nJK2KaargHZZ0B2eT5Hj-NXfc2aIeHF");
//				video_d.setThumb_media_id("rquWvoqabIvZJv7jd_C87AX_cEunFmZVAWdNmYQimxAvXeSWyAHpj-B9QH02CEf-");
//				video_d.setTitle("video test");
//				
//				video.setVideo(video_d);
//				video.setTouser(touser);
				
				//1-5、构造音乐消息
//				Music music = new Music();
//				MusicDetail music_d = new MusicDetail();
//				music_d.setDescription("music testtesttest");
//				music_d.setHqmusicurl("http://music.baidu.com/song/242078437");
//				music_d.setMusicurl("http://music.baidu.com/song/242078437");
//				music_d.setThumb_media_id("rquWvoqabIvZJv7jd_C87AX_cEunFmZVAWdNmYQimxAvXeSWyAHpj-B9QH02CEf-");
//				music_d.setTitle("music test");
//				
//				music.setMusic(music_d);
//				music.setTouser(touser);
				
				//1-6-1、构造图文消息（外链）
//				Article article = null;
//				//单图文
//				article = new Article();
//				article.setMsgtype("news");
//				article.setDescription("tuwen1 testtesttest");
//				article.setPicurl("http://wx.qlogo.cn/mmopen/ib2k7ibicrHR6icgCNXVuNOoV9UfUlGdqF7ensnnXx8NgJWR51sbTjPm1S2OGEz0xQEprut2Luhn0P1hdNj8nsURIw/0");
//				article.setTitle("tuwen yige");
//				article.setTouser(touser);
//				article.setUrl("http://www.ipaiban.com/");
//				List<Article> list1 = new ArrayList<Article>();
//				list1.add(article);
//				//多图文
//				List<Article> list2 = new ArrayList<Article>();
//				list2.add(article);
//				article = new Article();
//				article.setMsgtype("news");
//				article.setDescription("tuwen2 testtesttest");
//				article.setPicurl("http://wx.qlogo.cn/mmopen/ib2k7ibicrHR686eCcBpOHRorEI8YzNSghxiaBQmiaeTPtYXX3mXlD1DgrrPSmnSdWfxY7JBIC71Wr1ibBN7ibEVhic43Fr2PPb6a5zJ/0");
//				article.setTitle("tuwen haoduo");
//				article.setTouser(touser);
//				article.setUrl("http://www.playhudong.com/");
//				list2.add(article);
				
				//1-6-2、构造图文消息（点击跳转到图文消息页）
//				Article article = null;
//				article = new Article();
//				article.setMsgtype("mpnews");
//				article.setTouser(touser);
//				article.setMedia_id("br2zs2DBqS7Oj8AP6T7cOopNZEfUXLvBmVUKS5WfYN3eHbbDHtp0FTPWqQbOVMzB");
//				List<Article> list = new ArrayList<Article>();
//				list.add(article);
				
				//1-7、构造卡券消息
//				Card card = new Card();
//				card.setCard_id("pFHIYt2DqXDYfa2ZpvTwI3RW2rmk");
//				card.setCode(code);
//				card.setOpenid(openid);
//				card.setSignature(signature);
//				card.setTimestamp(timestamp);
//				card.setTouser(touser);
				
		        //2、获取accesstoken
//				AccessTokenManager  atm  = new AccessTokenManager();
//				AccessTokenManager.accesstoken = "f1-gyjHMshBk11XfVnGVgcBMud5l2DCMtGWEj6FIRvDT_UOMelgKcs-pPVzALhFu9q-s909szcJRO4jqJuXw2DQ52yX5R65df-zE1t8VlDM-JHdogPu9ihCjRfbMwyIAKGUdAEABXL";
				
		        //3、触发客服消息
//				ResponseCSMsg  rcs  = new ResponseCSMsg();
				
//				String res = rcs.text(text, "");	//文本-
//				String res = rcs.image(image, "");	//图片-
//				String res = rcs.voice(voice, "");	//语音-
//				String res = rcs.video(video, "");	//视频 参数错误*********************
//				String res = rcs.music(music, "");	//音乐-
//				String res = rcs.articles(list1, "");//单图文（外链）-
//				String res = rcs.articles(list2, "");//多图文（外链）-
//				String res = rcs.articles(list, "");//图文（跳转图文消息页）-
//				String res = rcs.card(card, "");	//卡券-
				
//				System.out.println(res);			//发送的内容
//				Response resp = new Response();
//				System.out.println(resp.sendCSMsg(res));
				
//----------------------------------------------------------------------------------
//				获取素材列表
//				JSONObject jo = new JSONObject();
//				try {
//					jo.put("type", "thumb");
//					jo.put("offset", 0);
//					jo.put("count", 2);
//				} catch (JSONException e) {
//					e.printStackTrace();
//				}
//				String response = HttpsDataManager.sendData("https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token="+AccessTokenManager.accesstoken, jo.toString());
//				System.out.println(response);
//-----------------------------------------------------------------------------------
//				上传图文消息
//				String url = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token="+AccessTokenManager.accesstoken;
//				JSONObject jo = new JSONObject();
//				JSONArray ja = new JSONArray();
//				JSONObject subJo = null;
//				try{
//					subJo = new JSONObject();
//					subJo.put("thumb_media_id", "rquWvoqabIvZJv7jd_C87AX_cEunFmZVAWdNmYQimxAvXeSWyAHpj-B9QH02CEf-");
//					subJo.put("author", "xhr");
//					subJo.put("title", "kaixin");
//					subJo.put("content_source_url", "http://www.ipaiban.com");
//					subJo.put("content","nihaomeili");
//					subJo.put("digest","digest");
//					ja.put(subJo);
//					jo.put("articles", ja);
//				} catch(JSONException e){
//					System.out.println(e.toString());
//				}
//				String response = HttpsDataManager.sendData(url, jo.toString());
//				System.out.println("-----------------------------------------");
//				System.out.println(response);
//		String touser = "oFHIYtxveXh57uRNKptUAwBH2u7Y";
		//--------发送文本-------------------------
		//1构造文本信息
		/*Text text=new Text();
		Content content=new Content();
		content.setContent("您好！您本月的话费余额为-3.4元，请及时充话费");
		text.setText(content);
		text.setTouser(touser);
		//2获取AccessToken
		AccessTokenManager  atm  = new AccessTokenManager();
		AccessTokenManager.accesstoken = "WtlZeDnkfafTyapi3AkTxxu4Ss5j8y52bg1-pHLRt2ghniohCo1aC0wMkCkQyuT1BnBGMEDhbaKxgfl9vUU1S8DtoorW0NBClH2KMQxOem8NLJhAJAAYW";
		//3触发客户信息
		ResponseCSMsg resp=new ResponseCSMsg();
		String res=resp.text(text, "");
		System.out.println(res);
		Response  respo=new Response();
		System.out.println(respo.sendCSMsg(res));*/
		/*AccessTokenManager atm=new AccessTokenManager();
		String response = HttpsDataManager.sendData("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+AccessTokenManager.accesstoken);
		System.out.println(response);*/
//--------------------------------发送图片------------------------------------------------------
		//构造图片信息
		/*Image image=new Image();
		ImageDetail id=new ImageDetail();
		id.setMedia_id("GCsXLR3-7T97ZyryykoYR57R3ewU5RTrR_NdqWmujpY");
		image.setImage(id);
		image.setTouser(touser);
		//2获取AccessToken
		AccessTokenManager  atm  = new AccessTokenManager();
		System.out.println(atm);
		AccessTokenManager.accesstoken = "4FwzH1eK5ouCz-nJjzYi98sBlKH3Pe3Xa9-VPFLE36nvDanBrh6l67DqXaKPs39pZCSw1yxG9QRi86T3ivp1tc8R370qgh8_fFKmHLk2DeTUCuFDPVNMp7_2MyMcDrA4CPRjAAAQDF";
		//触发客户消息
		ResponseCSMsg resp=new ResponseCSMsg();
		String res=resp.image(image, "");
		System.out.println(res);
		Response  respo=new Response();
		System.out.println(respo.sendCSMsg(res));*/
//---------------------------------发送视频--------------------------------------------------------------
		//构造视频信息
//		Video video=new Video();
//		VideoDetail  vd=new VideoDetail();
//		vd.setDescription("send video");
//		vd.setMedia_id("ZudW5cM11pxaoODfSB-Qao304Tab8jek3nJK2KaargHZZ0B2eT5Hj-NXfc2aIeHF");
//		vd.setThumb_media_id("rquWvoqabIvZJv7jd_C87AX_cEunFmZVAWdNmYQimxAvXeSWyAHpj-B9QH02CEf-");
//		vd.setTitle("video test");
//		video.setMsgtype("video");
//		video.setVideo(vd);
//		video.setTouser(touser);
//		//2获取AccessToken
//		AccessTokenManager  atm  = new AccessTokenManager();
//		System.out.println(atm);
//		AccessTokenManager.accesstoken = "raP50KSTZNzHKXbI1KvYar2iJVU2g_5qnwERTWYQ-wbaZ6JcV4apKMZNjXLrmJmtw9KRiNA_g-cXJIOc2MmDcKZ0WYzKZUE2rvJisorcWY7qRDoIEhSQTPLSsY2SZUqgYQEhAIAIAO";
//		//触发客户消息
//		ResponseCSMsg resp=new ResponseCSMsg();
//		String res=resp.video(video, "");//有问题
//		System.out.println(res);
//		Response  respo=new Response();
//		System.out.println(respo.sendCSMsg(res));
//----------------------发送音乐-------------------------------------------------------
		//构造音乐信息
	/*	Music music=new Music();
		music.setMsgtype("music");
		MusicDetail md=new MusicDetail();
		md.setDescription("send music");
		md.setHqmusicurl("http://music.baidu.com/song/242078437");
		md.setMusicurl("http://music.baidu.com/song/242078437");
		md.setThumb_media_id("rquWvoqabIvZJv7jd_C87AX_cEunFmZVAWdNmYQimxAvXeSWyAHpj-B9QH02CEf-");
		md.setTitle("music test");
		music.setMusic(md);
		music.setTouser(touser);
		//2获取AccessToken
		AccessTokenManager  atm  = new AccessTokenManager();
		System.out.println(atm);
		AccessTokenManager.accesstoken = "Cvy6x49yew4OMM0iGLWbef0WydL_7RGcNfaz59JXkwc0XXRY0fu4nEpIQmdZfv8TrVSAbLJCbN6CZTWIho3Rxwt-Wp4GlpBegar97eER3nVqNaYu3pf4PyFNAL0pk31mATQeABARKH";
		//触发客户消息
		ResponseCSMsg resp=new ResponseCSMsg();
		String res=resp.music(music,"" );//
		System.out.println(res);
		Response  respo=new Response();
		System.out.println(respo.sendCSMsg(res));//"errcode":-1,"errmsg":"system error hint: [htTVha0162ge11]"
		*/
//------------------发送图文外连接-----------------------
		//构造图文消息
		/*Article article = new Article();
		//单图文
		article.setMsgtype("news");
		article.setDescription("send news");
		article.setPicurl("http://wx.qlogo.cn/mmopen/ib2k7ibicrHR6icgCNXVuNOoV9UfUlGdqF7ensnnXx8NgJWR51sbTjPm1S2OGEz0xQEprut2Luhn0P1hdNj8nsURIw/0");
		article.setTitle("tuwen test");
		article.setTouser(touser);
		article.setUrl("http://www.ipaiban.com/");
		List<Article> list1 = new ArrayList<Article>();
		list1.add(article);
		//多图文
		List<Article> list2 = new ArrayList<Article>();
		list2.add(article);
		article = new Article();
		article.setMsgtype("news");
		article.setDescription("send duoge tuwen");
		article.setPicurl("http://wx.qlogo.cn/mmopen/ib2k7ibicrHR686eCcBpOHRorEI8YzNSghxiaBQmiaeTPtYXX3mXlD1DgrrPSmnSdWfxY7JBIC71Wr1ibBN7ibEVhic43Fr2PPb6a5zJ/0");
		article.setTitle("tuwne test2");
		article.setTouser(touser);
		article.setUrl("http://www.playhudong.com/");
		list2.add(article);
		//2获取AccessToken
		AccessTokenManager  atm  = new AccessTokenManager();
		System.out.println(atm);
		AccessTokenManager.accesstoken = "qj6loh6Fajo20CgH6wfMKHv48QaCQjlC895dn-h2ffysomHNqyM3tmjzPgvxGSXx5y6Xh4FohdAk3ldubpEUkA7DIK5N_YwfOXpzEdhaQhF3-yMuChmMy_cLZfS_PsEjVDYgAHAOWR";
		//触发客户消息
		ResponseCSMsg resp=new ResponseCSMsg();
		//String res=resp.articles(list1, "");//单个图文
		String res=resp.articles(list2, "");//多个图文
		System.out.println(res);
		Response  respo=new Response();
		System.out.println(respo.sendCSMsg(res));*/
//-------------图文（跳转图文消息页）--------------------------
		//1构造图信息
	/*	Article article = new Article();
		article.setMsgtype("mpnews");
		article.setTouser(touser);
		article.setMedia_id("br2zs2DBqS7Oj8AP6T7cOopNZEfUXLvBmVUKS5WfYN3eHbbDHtp0FTPWqQbOVMzB");
		List<Article> list = new ArrayList<Article>();
		list.add(article);
		//2获取AccessToken
		AccessTokenManager  atm  = new AccessTokenManager();
		System.out.println(atm);
		AccessTokenManager.accesstoken = "oyPBo1CE43v-eIRCL8Y-ZvfYQgYIpBdfR4iJhsSxpZXsTkir3nqOPWperfSLC785rc4YsCWgqFp9FBdvaoU6HZKg6kXmrIPgR1zFQN0l9SxAc-O2GjZsduriS65jdogzFHAbADATVO";
		//触发客户消息
		ResponseCSMsg resp=new ResponseCSMsg();
		String res=resp.articles(list, "");
		System.out.println(res);
		Response  respo=new Response();
		System.out.println(respo.sendCSMsg(res));*/
//--------------发送卡券---------------------------------------------------------
		//1构造卡券信息
	/*	Card card = new Card();
		card.setCard_id("pFHIYt2DqXDYfa2ZpvTwI3RW2rmk");
		card.setCode("");
		card.setOpenid("oFHIYtxveXh57uRNKptUAwBH2u7Y");
		card.setSignature("017bb17407c8e0058a66d72dcc61632b70f511ad");
		card.setTimestamp("1402057159");
		card.setTouser(touser);
		//2获取AccessToken
		AccessTokenManager  atm  = new AccessTokenManager();
		System.out.println(atm);
	    AccessTokenManager.accesstoken = "U84QHjq7-JewmWfzMVd34waSxtIt2K2by6DVjM-ywYY3pPeNKrHIR40a3nRM1NpgAIl_RwI1slbU7YPLQ2AXe85QTZZhmyuTear8vCp-K_n42MSFcmmqrp6To-whfNdFTLGbAAAJBW";
		//触发客户消息
		ResponseCSMsg resp=new ResponseCSMsg();
		String res=resp.card(card, "");
		System.out.println(res);
		Response  respo=new Response();
		System.out.println(respo.sendCSMsg(res));*/
	}

}
