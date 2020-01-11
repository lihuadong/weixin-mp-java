package weixin.util;

import java.util.UUID;

public class StringUtil {

	/**
	 * 返回随机字符串
	 */
	public static String getNonceStr() {
		String nonce_str_temp = UUID.randomUUID().toString();
		return nonce_str_temp.substring(0, 32);
	}
	
    /**
     * 判断是否为空字符串最优代码
     * @param str
     * @return 如果为空，则返回true
     */
    public static boolean isEmpty(String str){
        return str == null || str.trim().length() == 0;
    }

    /**
     * 判断字符串是否非空
     * @param str 如果不为空，则返回true
     * @return
     */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
}
