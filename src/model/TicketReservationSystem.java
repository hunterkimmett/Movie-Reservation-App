package model;
import java.time.LocalDateTime;
import java.util.ArrayList;

import managerController.ManageUserInfo;

public class TicketReservationSystem {
 
	private OfferingController ofc;
	private ManageUserInfo mui;
	private ArrayList<Ticket> tickets;
	private ArrayList<Voucher> vouchers;
	private ArrayList<Payment> payments;
	
	
	public TicketReservationSystem () {
		this.setMui(new ManageUserInfo());
		this.setOfc(new OfferingController());
		tickets = new ArrayList<Ticket>();
		payments = new ArrayList<Payment>();
		vouchers = new ArrayList<Voucher>();
	}
	
	public String createTicket(String movie, LocalDateTime time, int seatNo, boolean isRegisteredUser, String email) {
		Offering offer = null;
		Seat seat = null;
		for(Offering i:ofc.getOfferingList()) {
			if (i.getMovie().equals(movie) && i.getTime().equals(time)) {
				i.getSeats().get(seatNo-1).setRegisteredUser(isRegisteredUser);
				i.getSeats().get(seatNo-1).setTaken(true);
				
				offer = i;
				seat = i.getSeats().get(seatNo-1);
				break;
			}
		}
		
		tickets.add(new Ticket(offer, seat));
		
		if(isRegisteredUser) {
			mui.addUserTicket(new Ticket(offer, seat), email);
		}
		
		return tickets.get(tickets.size()-1).toString();
	}
	
	public void removeTicket(String movie, LocalDateTime time, int seatNo) {
		for (Offering o: ofc.getOfferingList()) {
			if(o.getMovie().equals(movie) && o.getTime().equals(time)) {
				for (Seat s: o.getSeats()) {
					if(s.getSeatNo() == seatNo) {
						s.setRegisteredUser(false);
						s.setTaken(false);
						break;
					}
				}
			}
		}
		
	}
	
	public ArrayList<Ticket> getTickets(){
		return tickets;
	}
	
	public ManageUserInfo getMui() {
		return mui;
	}


	public void setMui(ManageUserInfo mui) {
		this.mui = mui;
	}


	public OfferingController getOfc() {
		return ofc;
	}


	public void setOfc(OfferingController ofc) {
		this.ofc = ofc;
	}


	public ArrayList<Voucher> getVouchers() {
		return vouchers;
	}


	public void setVouchers(ArrayList<Voucher> vouchers) {
		this.vouchers = vouchers;
	}


	public ArrayList<Payment> getPayments() {
		return payments;
	}


	public void setPayments(ArrayList<Payment> payments) {
		this.payments = payments;
	}
}
