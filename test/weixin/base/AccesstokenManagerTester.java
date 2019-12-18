package weixin.base;

import weixin.base.AccessTokenManager;

//https://mp.weixin.qq.com/debug/


public class AccesstokenManagerTester {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccessTokenManager at = new AccessTokenManager();
		System.out.println("AccessToken:\n"+at.getAccesstoken());
	}

}
