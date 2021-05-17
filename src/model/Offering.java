package model;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Offering {

	private static int offeringCounter = 10000;
	private int offeringID;
	private String movie;
	private LocalDateTime time;
	private int capacity;
	private ArrayList<Seat> seats;
	private boolean isEarly;
	
	
	public Offering(String mov, LocalDateTime t, int cap, boolean early) {
		offeringCounter++;
		offeringID = offeringCounter;
		movie = mov;
		time = t;
		capacity = cap;
		isEarly = early;
		seats = new ArrayList<Seat>();
		initializeSeats(capacity);
	}
	
	public boolean isFull() {
		for(Seat s: seats) {
			if(!s.isTaken()) {
				return false;
			}
		}
		
		return true;
	}
	
	public void initializeSeats(int num) {
		for (int i = 1; i<=num; i++) {
			seats.add(new Seat(i, false, false));
		}
	}
	
	
	public int getOfferingID() {
		return offeringID;
	}
	public void setOfferingID(int offeringID) {
		this.offeringID = offeringID;
	}
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public ArrayList<Seat> getSeats() {
		return seats;
	}
	public void setSeats(ArrayList<Seat> seats) {
		this.seats = seats;
	}
	public boolean isEarly() {
		return isEarly;
	}
	public void setEarly(boolean isEarly) {
		this.isEarly = isEarly;
	}
}
