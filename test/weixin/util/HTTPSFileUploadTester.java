package weixin.util;

public class HTTPSFileUploadTester {

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
		HTTPSFileUpload  hfu   = new HTTPSFileUpload();
		String at ="KgbEllawt4q65ttvgSO7qblGLvoUy2A788UleR1aT13JXlvbMrdnULtdeVct3F4ikNNGH3O3S2jj08KGMHbGQxiWKidoSvLTSCuowjx9BwFocc8owUfL0-ndrHdyXlJ6YMUhAIARFN";
		
		String uploadMediaUrl ="https://api.weixin.qq.com/cgi-bin/media/upload?access_token="+at+"&type=image";
		String mediaFileUrl ="http://img.xbza.com/se3/attached/image/20150612/20150612104941284128.jpg";
		//String mediaFileUrl ="/Users/lihuadong/Documents/Temp/9imags/pre_20170106_0438032_1.jpg";
		String type =".jpg";
		String res = hfu.uploadMedia(uploadMediaUrl, mediaFileUrl, type);
		System.out.println(res);
	}
}
