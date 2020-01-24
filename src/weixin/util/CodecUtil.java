package weixin.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.log4j.Logger;

public class CodecUtil {

    private static final Logger LOGGER = Logger.getLogger(CodecUtil.class);

    /**
     * 将URL编码
     */
    public static String encodeURL(String source){
        String target;
        try {
            target = URLEncoder.encode(source,"utf-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("encode url failure",e);
            throw new RuntimeException(e);
            //e.printStackTrace();
        }
        return target;
    }

    /**
     * 将URL解码
     */
    public static String dencodeURL(String source){
        String target;
        try {
            target = URLDecoder.decode(source,"utf-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("encode url failure",e);
            throw new RuntimeException(e);
            //e.printStackTrace();
        }
        return target;
    }
	
}
