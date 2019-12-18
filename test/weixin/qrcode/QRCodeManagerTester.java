package weixin.qrcode;

import org.json.JSONObject;

public class QRCodeManagerTester {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		String accesstoken = "28_KKIVDsyVXonIV1I41c0SmQqZyUJzqSotU3nJtkJIlJiFo25SSnv9MsYK4jXDAtINffNvCHi9ED4sfI6OCJfCg13JNKcuhac70vWZvjcQHvse06IrRaGPXCxBBp2Ap6NsnwM1ymHV7ofVdt_wDEGjAEAJKM";
		QRCodeManager  qr  = new QRCodeManager(accesstoken);
		
		JSONObject  qr1  = qr.getTempQRcode(3600);
		System.out.println("qr1:"+qr1.toString());
		
		JSONObject  qr2  = qr.getTempQRcode(3600, 100);
		System.out.println("qr2:"+qr2.toString());
		
		JSONObject  qr3  = qr.getTempQRcode("wukonglai");
		System.out.println("qr3:"+qr3.toString());
		
		JSONObject  qr4  = qr.getTempQRcode(1000, "wukonglai");
		System.out.println("qr4:"+qr4.toString());
		
		JSONObject  qr5  = qr.getPermQRcode(1000);
		System.out.println("qr5:"+qr5.toString());
		
		JSONObject  qr6  = qr.getPermQRcode("wukonglai");
		System.out.println("qr6:"+qr6.toString());
	}

}
