/**
 * 微信-公众号-封装接口JAVA版本
 * weixin.base
 * AccessToken.java
 * Ver0.0.1
 * 2016年6月20日-下午3:06:02
 * 2014-2019 ©全智道(北京)科技有限公司
 * 
 */

package weixin.aes;

import java.util.ArrayList;

class ByteGroup {
	ArrayList<Byte> byteContainer = new ArrayList<Byte>();

	public byte[] toBytes() {
		byte[] bytes = new byte[byteContainer.size()];
		for (int i = 0; i < byteContainer.size(); i++) {
			bytes[i] = byteContainer.get(i);
		}
		return bytes;
	}

	public ByteGroup addBytes(byte[] bytes) {
		for (byte b : bytes) {
			byteContainer.add(b);
		}
		return this;
	}

	public int size() {
		return byteContainer.size();
	}
}
