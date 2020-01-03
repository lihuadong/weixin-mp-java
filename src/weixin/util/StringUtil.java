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
}
