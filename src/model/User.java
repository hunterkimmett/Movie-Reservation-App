package model;
import java.util.ArrayList;

public class User {
	
	private String name;
	private String address;
	private String creditCardNumber;
	private String email;
//	private ArrayList<Ticket> ticketList;
//	private ArrayList<Payment> paymentList;
	private Voucher userVoucher;
	private String userType;
	
	public User (String name, String address, String ccNum, String email) {
		this.name = name;
		this.address = address;
		this.creditCardNumber = ccNum;
		this.email = email;
		
	}
	
	public void purchaseTicket() {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void cancelTicket() {
		
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
}
