package weixin.util;

public class TimeUtilTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(DateTimeUtil.getLocalCurrentTime());
		System.out.println(DateTimeUtil.getLocalDate());
		System.out.println(DateTimeUtil.getLocalTime());
		System.out.println(DateTimeUtil.getLocalSecond());
		
		System.out.println(System.currentTimeMillis());
		System.out.println(DateTimeUtil.getLocalMilli());
	}

}
