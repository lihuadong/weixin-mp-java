package weixin.user;

public class TagManagerTester {

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
		
		//1、获取accesstoken 
//		AccessTokenManager  atm  = new AccessTokenManager();
//		AccessTokenManager.accesstoken = "jyKAXeB6SbV7y389kiTo69grzN9y9IXpSmK9IawjsWBXdx22WWRBe2O-aoIHLrTSOkpfMtfE85qgABopiBw6LfTVYi0eGPVfJgyNcne1OCRuuXFKrH_ZNXega5i2zYBGPVHhABAAGS";
		
		//2、测试创建标签(129)
//		TagManager tm = new TagManager();
//		HashMap create_hm = tm.createTag("testtest");
//		System.out.println("----------create a tag----------");
//		System.out.println("id: "+create_hm.get("id"));
//		System.out.println("name: "+create_hm.get("name"));
//		System.out.println("count: "+create_hm.get("count"));
		
		//3、测试修改标签名字(139)
//		TagManager tm = new TagManager();
//		boolean result = tm.updateTag(100,"testtesttest");
//		System.out.println("----------update a tag----------");
//		System.out.println("result: "+result);		
		
		//4、测试给用户打标签(14689)
//		UserTagManager utm = new UserTagManager();
//		List<String> openidList = new ArrayList<String>();
//		openidList.add("oFHIYt2guBTMngMiwFCAQdpOlu5k");
//		openidList.add("oFHIYtxveXh57uRNKptUAwBH2u7Y");
//		System.out.println("----------add tags for users----------");
//		System.out.println(utm.addUserTag(2, openidList));
//		System.out.println(utm.addUserTag(100, openidList));
		
		//5、测试删除用户标签(15689)
//		UserTagManager utm = new UserTagManager();
//		List<String> openidList = new ArrayList<String>();
//		openidList.add("oFHIYt2guBTMngMiwFCAQdpOlu5k");
//		openidList.add("oFHIYtxveXh57uRNKptUAwBH2u7Y");
//		System.out.println("----------delete a tag for users----------");
//		System.out.println(utm.deleteUserTag(2, openidList));
		
		//6、测试获取标签下用户列表
//		TagManager tm = new TagManager();
//		List<String> userList = null;
//		System.out.println("----------get userlist of a tag----------");
//		userList = tm.getOpenidListByTag(2, "");
//		System.out.println("---1---");
//		for(int i=0;i<userList.size();i++){
//			System.out.println(userList.get(i));
//		}
//		userList = tm.getOpenidListByTag(100, "");
//		System.out.println("---2---");
//		for(int i=0;i<userList.size();i++){
//			System.out.println(userList.get(i));
//		}
//		userList = tm.getOpenidListByTag(100, "oFHIYtxveXh57uRNKptUAwBH2u7Y");///加第一个openid
//		System.out.println("---3---");
//		for(int i=0;i<userList.size();i++){
//			System.out.println(userList.get(i));
//		}
		
		//7、测试删除标签(179)->(168)
//		TagManager tm = new TagManager();
//		System.out.println("----------delete a tag----------");
//		System.out.println(tm.deleteTag(100));
		
		//8、测试获取用户标签
//		UserTagManager utm = new UserTagManager();
//		List<String> tagList = utm.getUserTag("oFHIYt2guBTMngMiwFCAQdpOlu5k");
//		System.out.println("----------get tags of a user----------");
//		for(int i=0;i<tagList.size();i++){
//			System.out.println(tagList.get(i));
//		}
		
		//9、测试获取已创建标签
//		TagManager tm = new TagManager();
//		List list = tm.getTag("");
//		HashMap hm;
//		System.out.println("----------get tags----------");
//		for(int i=0;i<list.size();i++){
//			hm = (HashMap) list.get(i);
//			System.out.println("id: "+hm.get("id"));
//			System.out.println("name: "+hm.get("name"));
//			System.out.println("count: "+hm.get("count"));
//		}
	}
}
