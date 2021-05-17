package model;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MovieDBManager {
	
	private String filename = "movies.csv";
	
	
	public ArrayList<String[]> importMovies() {
		ArrayList<String[]> offerings =  new ArrayList<String[]>();
	    String line = "";
	    String splitBy = ",";
	    
	    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
	    	br.readLine();

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] offering = line.split(splitBy);
                offerings.add(offering);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
	    
	    return offerings;
	    
		
	}
}
