package weixin.util;

public class MD5UtilTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    System.out.println(MD5Util.MD5Upper("20121221"));
        System.out.println(MD5Util.MD5Upper("加密"));
        
	    System.out.println(MD5Util.MD5Lower("20121221","utf-8"));
        System.out.println(MD5Util.MD5Lower("加密","utf-8"));   
        
        
        //magnet:?xt=urn:btih:ee8f56172d945b06800c91834c99f360ae59d7c9&dn=我和我的祖国.H265版.My.People.My.Country.2019.HD4K.X265.AAC.Mandarin.CHS-ENG.Mp4Ba
        String uri = "magnet:?xt=urn:btih:ee8f56172d945b06800c91834c99f360ae59d7c9&dn=我和我的祖国.H265版.My.People.My.Country.2019.HD4K.X265.AAC.Mandarin.CHS-ENG.Mp4Ba";
        System.out.println(MD5Util.MD5Lower(uri,"utf-8"));   
	}

}
