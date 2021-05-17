package managerController;
import model.RegisteredUser;
import model.TicketReservationSystem;

public class RegisterNewUser {
	
	private TicketReservationSystem trs;
	
	public RegisterNewUser(TicketReservationSystem system) {
		setTrs(system);
	}
	
	public boolean doesUserExist(String email) {
		for(RegisteredUser u:trs.getMui().getUc().getUserList()) {
			if(u.getEmail().equals(email)) {
				return true;
			}
		}
		return false;
		
	}
	
	public void createUser(String name, String address, String ccNum, String email) {
		trs.getMui().getUc().getUserList().add(new RegisteredUser(name, address, ccNum, email));	
	}

	public TicketReservationSystem getTrs() {
		return trs;
	}

	public void setTrs(TicketReservationSystem trs) {
		this.trs = trs;
	}
	
	

}
