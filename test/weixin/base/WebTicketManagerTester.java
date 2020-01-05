package weixin.base;

public class WebTicketManagerTester {
	public static void main(String[] args) {
		
		String accesstoken  = "29_5ViKyXRf5KoUFkiSerrWo18BHpHJmuyO_1IRREvq9VeuiCeJ4zr1eTshpvwlFPS8Lg_z7KQ8w3fDeSvrN0JvaHMdo7Kg6dCOpl0sUZXhe2aeyD-l6RiBfb0oqtobPztCxwiYRoCRjB1twJ7uSZVfABAWDZ";
		
		WebTicketManager ticket  = new WebTicketManager(accesstoken);
		System.out.println(ticket.getJsTicket());
		System.out.println(ticket.getExpires_in());
	}
}

