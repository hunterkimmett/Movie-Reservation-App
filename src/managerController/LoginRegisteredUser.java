package managerController;
import model.RegisteredUser;
import model.TicketReservationSystem;

public class LoginRegisteredUser {
	
	private TicketReservationSystem trs;
	
	public LoginRegisteredUser(TicketReservationSystem system) {
		trs = system;
	}
	
	public RegisteredUser login(String email) {
		for(RegisteredUser u:trs.getMui().getUc().getUserList()) {
			if(u.getEmail().equals(email)) {
				return u;
			}
		}
		
		return null;
		
	}

}
