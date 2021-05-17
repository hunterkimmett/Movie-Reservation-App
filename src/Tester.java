import java.time.LocalDateTime;
import java.util.ArrayList;

import managerController.SelectOffering;
import model.Seat;
import model.TicketReservationSystem;

public class Tester {

	public static void main(String[] args) {
		
		TicketReservationSystem trs = new TicketReservationSystem();
		
		//System.out.print(trs.createTicket("Mad Max", LocalDateTime.parse("2020-12-01T15:00:00"), 10, true, "wa3dk@ucalgary.ca").toString());
		
		SelectOffering selector = new SelectOffering(trs);
		
		ArrayList<String> movies = selector.getMovieList(false);
		
		for(String i:movies) {
			System.out.println(i);
		}
		
		ArrayList<LocalDateTime> dates = selector.getTimeList(movies.get(0), false);
		
		System.out.println(dates.size());
		
		for(LocalDateTime i:dates) {
			System.out.println(i);
		}
		
		ArrayList<Seat> seats = selector.getSeatList(movies.get(0), dates.get(0));
		
		for(Seat i:seats) {
			System.out.println(i.getSeatNo() + ", " + i.isTaken());
		}
		
		
	}

}
