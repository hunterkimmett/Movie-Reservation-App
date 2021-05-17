package model;
import java.util.ArrayList;

public class RegisteredUser extends User{
	private ArrayList<RefundConfirmation> refundList;
	private ArrayList<Ticket> ticketList;
	private boolean annualPayment;
	
	public RegisteredUser(String name, String address, String ccNum, String email) {
		super(name, address, ccNum, email);
		this.setAnnualPayment(false);
		ticketList = new ArrayList<Ticket>();
		refundList = new ArrayList<RefundConfirmation>();
	}
	
	public void purchaseTicketCredit() {
		
	}
	
	@Override
	
	public String toString() {
		
		return String.format("%s \n %s \n %s \n %s \n %s", this.getName(),this.getAddress(), this.getCreditCardNumber(), this.getEmail(), this.getUserType());  
		
	}

	public ArrayList<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(ArrayList<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

	public ArrayList<RefundConfirmation> getRefundList() {
		return refundList;
	}

	public void setRefundList(ArrayList<RefundConfirmation> refundList) {
		this.refundList = refundList;
	}

	public boolean isAnnualPayment() {
		return annualPayment;
	}

	public void setAnnualPayment(boolean annualPayment) {
		this.annualPayment = annualPayment;
	}
}
