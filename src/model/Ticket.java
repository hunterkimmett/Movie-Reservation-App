package model;
import java.time.LocalDateTime;

public class Ticket {
	
	private Offering movieOffering;
	private Seat movieSeat;
	private String ticketID;
	
	public Ticket(Offering offer, Seat seat) {
		movieOffering =  offer;
		movieSeat = seat;
		ticketID = "" + movieOffering.getOfferingID() + "-" + movieSeat.getSeatNo();
	}
	
	public Offering getMovieOffering() {
		return movieOffering;
	}
	public void setMovieOffering(Offering movieOffering) {
		this.movieOffering = movieOffering;
	}
	public Seat getMovieSeat() {
		return movieSeat;
	}
	public void setMovieSeat(Seat movieSeat) {
		this.movieSeat = movieSeat;
	}
	public String getTicketID() {
		return ticketID;
	}
	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}
	
	@Override
	public String toString() {
		String ticketPrint = "Movie Ticket";
		ticketPrint += "\nTicketID: " + ticketID;
		ticketPrint += "\nMovie: " + movieOffering.getMovie();
		ticketPrint += "\nSeat: " + movieSeat.getSeatNo();
		
		LocalDateTime time = movieOffering.getTime();
		ticketPrint += "\nDate: " + time.getMonthValue() + "/" + time.getDayOfMonth();
		ticketPrint += "\nTime: " + time.getHour() + "h" + time.getMinute() + "m";
		
		
		return ticketPrint;
	}
	
	public void printTicket() {
		String ticketPrint = this.toString();
		
		System.out.println("Printing ticket...");
		System.out.println(ticketPrint);
	}
	
	
}
