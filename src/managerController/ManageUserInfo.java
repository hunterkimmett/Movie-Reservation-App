package managerController;
import model.RegisteredUser;
import model.Ticket;
import model.UserController;

public class ManageUserInfo {
	
	private UserController uc;
	
	public ManageUserInfo () {
		this.setUc(new UserController());
	}
	
	
	public static void main (String [] args) {
		
		//testing.
		ManageUserInfo test = new ManageUserInfo();
		System.out.print(test.getUc().getUserList().get(0).toString());
		
	}
	// some methods
	
	public void addUserTicket(Ticket ticket, String email) {
		for(RegisteredUser i:uc.getUserList()) {
			if (i.getEmail().equals(email)) {
				i.getTicketList().add(ticket);
				break;
			}
		}
	}
	
	public boolean hasVoucher(String email) {
		for(RegisteredUser i:uc.getUserList()) {
			if (i.getEmail().equals(email)) {
				if (i.getRefundList().size()>0) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean decreaseVoucher(String email) {
		for(RegisteredUser i:uc.getUserList()) {
			if (i.getEmail().equals(email)) {
				i.getRefundList().remove(0);
			}
		}
		
		return false;
	}


	public UserController getUc() {
		return uc;
	}


	public void setUc(UserController uc) {
		this.uc = uc;
	}
}
