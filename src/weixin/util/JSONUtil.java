package weixin.util;

import org.json.HTTP;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JSONUtil {

	  private static final Logger LOGGER = Logger.getLogger(JSONUtil.class);

	    private static final ObjectMapper OBJECT_MAPPER =new ObjectMapper();

	    /**
	     * 将POJO转换为JSON
	     */
	    public static <T> String toJson(T obj){
	        String json = null;
	        try {
	            json = OBJECT_MAPPER.writeValueAsString(obj);
	        } catch (JsonProcessingException e) {
	            LOGGER.error("convert POJO to JSON failure",e);
	            throw new RuntimeException(e);
	            //e.printStackTrace();
	        } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return json;
	    }

	    /**
	     * 将JSON转为POJO
	     */
	    public static <T> T fromJson(String json,Class<T> type){
	        T pojo;
	        try {
	            pojo = OBJECT_MAPPER.readValue(json,type);
	        } catch (IOException e) {
	            LOGGER.error("convert JSON to POJO failure",e);
	            throw new RuntimeException(e);
	            //e.printStackTrace();
	        }
	        return pojo;

	    }
}
