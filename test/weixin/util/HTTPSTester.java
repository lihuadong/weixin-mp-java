package weixin.util;

import weixin.util.HTTPSDataManager;

public class HTTPSTester {

	public static void main(String[] args) {
		
        String resStr  = HTTPSDataManager.sendData("https://www.freebuf.com/articles/network/118221.html");
        System.out.println(resStr);
	}

}
