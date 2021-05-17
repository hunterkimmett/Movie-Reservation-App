package model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class OfferingController {
	
	private ArrayList<Offering> offeringList;
	private MovieDBManager offeringDB;

	public OfferingController() {
		offeringDB = new MovieDBManager();
		offeringList = new ArrayList<Offering>();
		importMovieDB();
	}
	
	public ArrayList<Offering> getOfferingList() {
		return offeringList;
	}

	public void setOfferingList(ArrayList<Offering> offeringList) {
		this.offeringList = offeringList;
	}

	public MovieDBManager getOfferingDB() {
		return offeringDB;
	}

	public void setOfferingDB(MovieDBManager offeringDB) {
		this.offeringDB = offeringDB;
	}
	
	public void importMovieDB() {
		ArrayList<String[]> temp = offeringDB.importMovies();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		
		for (String[] i:temp) {
			String movie = i[0];
			LocalDateTime time = LocalDateTime.parse(i[1]);
			int capacity = Integer.parseInt(i[2]);
			boolean early = Boolean.parseBoolean(i[3]);
			
			Offering offer = new Offering(movie, time, capacity, early);
			offeringList.add(offer);
		}
	}
	

}
