package weixin.jssign;

import weixin.jssdk.JSSign;
import java.util.Map;

public class JSSignTester {

    
    public static void main(String[] args) {
        String web_ticket = "bxLdikRXVbTPdHSM05e5u4RbEYQn7pNQMPrfzl8lJNb1foLDa3HIwI3BRMkQmSO_5F64VFa75uURcq6Uz7QHgA";
        String url = "http://omstest.vmall.com:23568/thirdparty/wechat/vcode/gotoshare?quantity=1&batchName=MATE7";
        Map<String, String> ret = JSSign.sign(web_ticket, url);
        for (Map.Entry entry : ret.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

}
