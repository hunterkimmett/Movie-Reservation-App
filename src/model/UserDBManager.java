package model;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class UserDBManager {
	
	
	
	public ArrayList<RegisteredUser> run() {
	
		ArrayList<RegisteredUser> userList = new ArrayList<RegisteredUser>();
        String csvFile = "UserData.csv";
        
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] userdata = line.split(cvsSplitBy);
                
          
            	RegisteredUser tempRU = new RegisteredUser(userdata[0].trim(),userdata[1].trim(), userdata[2].trim(), userdata[3].trim());
            
            	userList.add(tempRU);
                

                System.out.println(userdata[0] + userdata[1] +  userdata[2] +  userdata[3] + userdata[4] );
               

            }
                

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return userList;

    }
	
}
