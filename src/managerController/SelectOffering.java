package managerController;
import java.time.LocalDateTime;
import java.util.ArrayList;

import model.Offering;
import model.Seat;
import model.TicketReservationSystem;

public class SelectOffering {

	private TicketReservationSystem trs;
	
	public SelectOffering(TicketReservationSystem system) {
		setTrs(system);
	}
	
	public ArrayList<String> getMovieList(boolean isRegisteredUser){
		ArrayList<String> movieStrings = new ArrayList<String>();

		for (Offering i:trs.getOfc().getOfferingList()) {
			
			if(i.isFull()) {
				continue;
			}
			
			if (!movieStrings.contains(i.getMovie())) {
				if(isRegisteredUser) {
					int regCount = 0;
					for(Seat s:i.getSeats()) {
						if (s.isRegisteredUser() && i.isEarly()) {
							regCount++;
						}
					}
					
					if(regCount<(i.getCapacity()/10)) {
						movieStrings.add(i.getMovie());
					}
					
				} else {
					if (!i.isEarly()) {
						movieStrings.add(i.getMovie());
					}
				}
			}
		}

		return movieStrings;	
	}
	
	public ArrayList<LocalDateTime> getTimeList(String movie, boolean isRegisteredUser){
		ArrayList<LocalDateTime> movieTimes = new ArrayList<LocalDateTime>();
		
		for (Offering i:trs.getOfc().getOfferingList()) {
			if (i.getMovie().equals(movie)) {
				
				if(i.isFull()) {
					continue;
				}
				
				if(isRegisteredUser) {
					int regCount = 0;
					for(Seat s:i.getSeats()) {
						if (s.isRegisteredUser()&& i.isEarly()) {
							regCount++;
						}
					}
					
					if(regCount<(i.getCapacity()/10)) {
						movieTimes.add(i.getTime());
					}
					
				} else {
					if (!i.isEarly()) {
						movieTimes.add(i.getTime());
					}
				}
			}
		}
		
		return movieTimes;
	}
	
	
	public ArrayList<Seat> getSeatList(String movie, LocalDateTime time){
		for (Offering i:trs.getOfc().getOfferingList()) {
			if (i.getMovie().equals(movie)) {
				if (i.getTime().equals(time)) {
					return i.getSeats();
				}
			}
		}
		
		return null;
	}
	
	
	public TicketReservationSystem getTrs() {
		return trs;
	}

	public void setTrs(TicketReservationSystem trs) {
		this.trs = trs;
	}

	
}
