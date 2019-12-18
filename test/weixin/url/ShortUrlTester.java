package weixin.url;

import weixin.shorturl.ShortUrlManager;

public class ShortUrlTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String at = "28_LOuButp0TaQCnuPZosVMmF-j3aZ892NzzWOxFD7Q6aP_hrJjuQpMxoW9xzQhmbNm-DLIYRzb_TouWhz5NjMhEkfi1c4BkdcyXs7KEv6VwZViOZ6uNPgokjRXfazPZAW_5L1bKE2l3pBbNdZLJHMfAJAOMR\n" + 
        		"";
        
        ShortUrlManager  manager  = new ShortUrlManager(at);
        String url  = manager.getShortUrl("https://wukonglai.com/index.html");
        System.out.println(url);
        
        int i = 1000;
        while(true) {
        	i--;
        	url  = manager.getShortUrl("https://wukonglai.com/index.html?num="+i);
            System.out.println(url);
        }
        
	}

}
