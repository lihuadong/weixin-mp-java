package weixin.url;

import weixin.shorturl.ShortUrlManager;

public class ShortUrlTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String at = "29_EQZDjd6nKjlSbr67LZ4xIlNLI6gRtRpB-oTivxowcURT_sN3jgPXluuGJ_NLyS0cy12p7BIhUVOJvdTW_r9NhmTVdXFN90rZ9klzsV4jlSTubzFuvAekIUp1URKnR_Z4dTFzZdv2cKe-BbQRQBEfAHAALO"; 
        
        ShortUrlManager  manager  = new ShortUrlManager(at);
        String url  = manager.getShortUrl("https://org.modao.cc/app/ad9559a5bafb09eaf6827a3cfe28e725cf5345a5");
        System.out.println(url);
        
//        int i = 1000;
//        while(true) {
//        	i--;
//        	url  = manager.getShortUrl("https://wukonglai.com/index.html?num="+i);
//            System.out.println(url);
//        }
        
	}

}
