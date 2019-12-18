package weixin.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import weixin.user.UserManager;

public class UserManagerTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//-----------------------------------------------1、测试所有的会员ID\昵称显示-----------------------------------------------
		
/*		String accesstoken  = "28_6YEAFyJUNZlZvKEa2p1I0XnUqeqBAImOroWQ72-k2wjXWe945dHzYvgMJLMl7RtPN0deZAVFTVSiuJfJ_EYJyfuWsjWldLS5BKMUR6IK_RqOr4TZUHGwM9--10c7A4_zYxYegqt7zsL237nVPXHeAAADLV";
		UserManager  um  = new UserManager(accesstoken);
		List<String>  list  = um.getSubscribeList("");
			
		System.out.println("list size:"+list.size());
		
		for(int i=0;i<list.size();i++){
			
			String openid  = list.get(i);
			String nickname = null;
			try {
				nickname = um.getUserInfo(openid).getString("nickname");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("nickname:"+nickname+"\t"+"openid:"+openid);			
			
		}*/
		
		//----------------------------------------2、测试查看用户是否关注------------------------------------------------------

		/*String accesstoken  = "28_6YEAFyJUNZlZvKEa2p1I0XnUqeqBAImOroWQ72-k2wjXWe945dHzYvgMJLMl7RtPN0deZAVFTVSiuJfJ_EYJyfuWsjWldLS5BKMUR6IK_RqOr4TZUHGwM9--10c7A4_zYxYegqt7zsL237nVPXHeAAADLV";
		UserManager uma = new UserManager(accesstoken);
		String openid1 = "oyGfajg8saQAEDdX-BZR9PuZvluA";
		String openid2 = "oyGfajpmm9_DBaHKCUppuxJ-ij-o";
	
		try {
			boolean result1 = uma.isSubscribe(openid1);			
			boolean result2 = uma.isSubscribe(openid2);
			System.out.println("------check isSubscribe------"+result1 + result2);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/		
				
		//----------------------------------------3、测试设置用户备注名------------------------------------------------------
		
	    String accesstoken  = "28_6YEAFyJUNZlZvKEa2p1I0XnUqeqBAImOroWQ72-k2wjXWe945dHzYvgMJLMl7RtPN0deZAVFTVSiuJfJ_EYJyfuWsjWldLS5BKMUR6IK_RqOr4TZUHGwM9--10c7A4_zYxYegqt7zsL237nVPXHeAAADLV";
		UserManager uma = new UserManager(accesstoken);

		String openid = "oyGfajg8saQAEDdX-BZR9PuZvluA";
		String remark = "sunhsine";
		boolean result = uma.updateRemark(openid, remark);
		System.out.println("result: "+result);		
		System.out.println("result: "+uma.getUserInfo(openid).toString());
		
		//----------------------------------------4、测试WEB方式获取信息------------------------------------------------------
		
		/*String accesstoken  = "28_6YEAFyJUNZlZvKEa2p1I0XnUqeqBAImOroWQ72-k2wjXWe945dHzYvgMJLMl7RtPN0deZAVFTVSiuJfJ_EYJyfuWsjWldLS5BKMUR6IK_RqOr4TZUHGwM9--10c7A4_zYxYegqt7zsL237nVPXHeAAADLV";
		UserManager uma = new UserManager(accesstoken);

		String openid = "oyGfajg8saQAEDdX-BZR9PuZvluA";
		System.out.println("result: "+uma.getUserInfoByWeb(openid,accesstoken).toString());*/
			
	}

}
