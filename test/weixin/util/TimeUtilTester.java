package weixin.util;

public class TimeUtilTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(TimeUtil.getLocalCurrentTime());
		System.out.println(TimeUtil.getLocalDate());
		System.out.println(TimeUtil.getLocalTime());
		System.out.println(TimeUtil.getLocalSecond());
		
		System.out.println(System.currentTimeMillis());
		System.out.println(TimeUtil.getLocalMilli());
	}

}
