/**
 * 
 * 微信-公众号-封装接口JAVA版本
 * weixin.util
 * PropertiesFileOper.java
 * Ver0.0.1
 * 2015年5月29日-下午5:14:39
 * 2014-2019 ©全智道(北京)科技有限公司
 * 
 */
package weixin.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * PropertiesFileOper
 * 
 * 李华栋
 * 李华栋
 * 2015年5月29日 下午5:14:39
 * 
 * @version 0.0.1
 * 
 */
public class PropertiesUtil {

    //读取weixin.properties配置文件
    public static String readPropertiesFile(InputStream is,String key){
        
    	Properties properties = new Properties();
        try{
            InputStream inputStream = is;
            properties.load(inputStream);
            inputStream.close(); //关闭流
        }catch (IOException e) {
            e.printStackTrace();
        }
        return  properties.getProperty(key);
    }
}
