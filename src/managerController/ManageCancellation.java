package managerController;
import model.Constants;
import model.Offering;
import model.RefundConfirmation;
import model.RegisteredUser;
import model.Ticket;
import model.TicketReservationSystem;
import model.Voucher;

public class ManageCancellation implements Constants{
	
	private TicketReservationSystem trs;
	
	public ManageCancellation(TicketReservationSystem system) {
		trs = system;
	}
	
	public String cancelTicketRU(String ticketID, String email) {
		for(Ticket i:trs.getTickets())
			if (i.getTicketID().equals(ticketID)){
				trs.getTickets().remove(i);
				break;
			}
		
		for(RegisteredUser u:trs.getMui().getUc().getUserList()) {
			if(u.getEmail().equals(email)) {
				for (Ticket t: u.getTicketList()) {
					if(t.getTicketID().equals(ticketID)) {
						u.getTicketList().remove(t);
						u.getRefundList().add(new RefundConfirmation(TICKETPRICE));
						Offering offer = t.getMovieOffering();
						trs.removeTicket(offer.getMovie(), offer.getTime(), t.getMovieSeat().getSeatNo());
						return("Refund created, $" + TICKETPRICE + " added to account.");
					}
				}
			}
		}
		
		
		return("No refund given, TicketID/User not found. Please try again.");
	}
	
	public String cancelTicktGuest(String ticketID){
		for(Ticket i:trs.getTickets())
			if (i.getTicketID().equals(ticketID)){
				trs.getTickets().remove(i);
				trs.getVouchers().add(new Voucher());
				Offering offer = i.getMovieOffering();
				trs.removeTicket(offer.getMovie(), offer.getTime(), i.getMovieSeat().getSeatNo());
				
				return "Voucher created. Your voucher is worth $" + VOUCHER + 
						" and your voucher number is " + trs.getVouchers().get(trs.getVouchers().size() -1).getVoucherID();
			}
		
		return "Ticket not found, please try again.";
	}

	public TicketReservationSystem getTrs() {
		return trs;
	}

	public void setTrs(TicketReservationSystem trs) {
		this.trs = trs;
	}
	
	
}
