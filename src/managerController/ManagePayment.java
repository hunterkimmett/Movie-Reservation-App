package managerController;
import java.time.LocalDateTime;
import java.util.ArrayList;

import fiModel.FinancialInstituteManager;
import model.Constants;
import model.Payment;
import model.TicketReservationSystem;
import model.Voucher;

public class ManagePayment implements Constants{
	
	private TicketReservationSystem trs;
	private FinancialInstituteManager fin;
	
	public ManagePayment(TicketReservationSystem system) {
		trs = system;
		fin = new FinancialInstituteManager();
	}
	
	public String createYearlyPayment(String card, String email) {
		trs.getPayments().add(new Payment(ANNUALFEE, card, email));
		exportPayments();
		return "Yearly payment made, $" + ANNUALFEE + " charged.";
	}
	
	public String createRegisteredUserPayment(String movie, LocalDateTime time, int seatNo, String card, String email) {
		trs.getPayments().add(new Payment(TICKETPRICE, card, email));
		exportPayments();
		return "Ticket Price: $" + TICKETPRICE + "\n" + trs.createTicket(movie, time, seatNo, true, email);
		
	}
	
	public String createRegisteredUserVoucherPayment(String movie, LocalDateTime time, int seatNo, String email) {
		if(trs.getMui().hasVoucher(email)) {
			trs.getMui().decreaseVoucher(email);
			return "Ticket Price: Free!\n" + trs.createTicket(movie, time, seatNo, true, email);
		}
		
		return "No vouchers available.";
	}
	

	public String createGuestPayment(String movie, LocalDateTime time, int seatNo, String card, String email) {
		trs.getPayments().add(new Payment(TICKETPRICE, card, email));
		exportPayments();
		return "Ticket Price: $" + TICKETPRICE + "\n" + trs.createTicket(movie, time, seatNo, false, email);
		
	}
	
	public String createGuestVoucherPayment(String movie, LocalDateTime time, int seatNo, String card, String email, int voucherID) {
		for(Voucher v:trs.getVouchers()) {
			if (v.getVoucherID() == voucherID) {
				trs.getVouchers().remove(v);
				trs.getPayments().add(new Payment(VOUCHERPAYMENT, card, email));
				exportPayments();
				return "Ticket Price: $" + VOUCHERPAYMENT + "\n" + trs.createTicket(movie, time, seatNo, false, email);
			}
		}
		
		return "Voucher not found, please try again";
	}
	
	
	public TicketReservationSystem getTrs() {
		return trs;
	}
	
	public void exportPayments() {
		ArrayList<String> paymentRecord =  new ArrayList<String>();
		
		for(Payment i:trs.getPayments()) {
			paymentRecord.add(i.toString());
		}
		
		fin.writePaymentRecords(paymentRecord);
		
	}

}
