package weixin.url;

import weixin.shorturl.ShortUrlManager;

public class ShortUrlTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String at = "29_PCsGiqzohiNtaMtYR1KIY6t9l7SSfX7_DIc4eregVQpJTHfW25xKxRkfberje6uYawVRTbzQ7Vq9dLKQLZL_Tm6iW8OYvSaP3kA-dRuH1NHIPNbeGbbfI11XX6NYthBbUjAElfkHdgCAgfWjIGMeAJACAG"; 
        
        ShortUrlManager  manager  = new ShortUrlManager(at);
        //String url  = manager.getShortUrl("https://org.modao.cc/app/ad9559a5bafb09eaf6827a3cfe28e725cf5345a5");
        //System.out.println(url);
        
        int i = 100;
        while(true) {
        	i--;
        	String url  = manager.getShortUrl("https://wukonglai.com/index.html?num="+i);
            System.out.println(i+":"+url);
        }
        
	}

}
