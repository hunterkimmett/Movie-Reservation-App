package managerController;
import model.TicketReservationSystem;

public class GetMovieNews {

	private TicketReservationSystem trs;
	
	public GetMovieNews(TicketReservationSystem system) {
		trs = system;
	}
	
	public String getNews() {
		return trs.getMui().getUc().getNews().getNewsItem();
	}
}
