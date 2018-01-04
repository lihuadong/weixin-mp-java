/**
 * 包打听全知道-微信H5版本
 * ipaiban.weixin.util
 * MD5Util.java
 * Ver0.0.1
 * 2014年12月25日-下午8:11:53
 *  2014全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.util;

import java.security.MessageDigest;

/**
 * 
 * MD5Util
 * 
 * 李华栋
 * 李华栋
 * 2014年12月25日 下午8:11:53
 * 
 * @version 0.0.1
 * 
 */
public class MD5Util {

	
    public final static String MD5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       

        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
	  private static String byteArrayToHexString(byte b[]) {
	        StringBuffer resultSb = new StringBuffer();
	        for (int i = 0; i < b.length; i++)
	            resultSb.append(byteToHexString(b[i]));
	
	        return resultSb.toString();
	  }

	  private static String byteToHexString(byte b) {
	        int n = b;
	        if (n < 0)
	            n += 256;
	        int d1 = n / 16;
	        int d2 = n % 16;
	        return hexDigits[d1] + hexDigits[d2];
	  }

	  public static String MD5Encode(String origin, String charsetname) {
		    String resultString = null;
		    try {
		        resultString = new String(origin);
		        MessageDigest md = MessageDigest.getInstance("MD5");
		        if (charsetname == null || "".equals(charsetname))
		            resultString = byteArrayToHexString(md.digest(resultString
		                    .getBytes()));
		        else
		            resultString = byteArrayToHexString(md.digest(resultString
		                    .getBytes(charsetname)));
		    } catch (Exception exception) {
		    }
		    return resultString;
	 }
	    
	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
	        "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };


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
	/*	System.out.println(MD5Util.MD5("20121221"));
        System.out.println(MD5Util.MD5("加密"));*/
	}

}
