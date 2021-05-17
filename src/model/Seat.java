package model;

public class Seat {

	private int seatNo;
	private boolean isTaken;
	private boolean isRegisteredUser;
	
	
	public Seat(int num, boolean occupied, boolean registered) {
		seatNo = num;
		isTaken = occupied;
		isRegisteredUser = registered;
	}
	
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public boolean isTaken() {
		return isTaken;
	}
	public void setTaken(boolean isTaken) {
		this.isTaken = isTaken;
	}
	public boolean isRegisteredUser() {
		return isRegisteredUser;
	}
	public void setRegisteredUser(boolean isRegisteredUser) {
		this.isRegisteredUser = isRegisteredUser;
	}
	
	
}
