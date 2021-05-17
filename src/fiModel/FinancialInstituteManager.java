package fiModel;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FinancialInstituteManager {
	
	public void writePaymentRecords(ArrayList<String> paymentRecord){
		
		BufferedWriter bw = null;
	    try {
		 
		 File file = new File("paymentrecords.txt");
		 
		  if (!file.exists()) {
		     file.createNewFile();
		  }

		  FileWriter fw = new FileWriter(file);
		  bw = new BufferedWriter(fw);
		  
		  for(String s:paymentRecord) {
			  bw.write(s);
			  bw.write("\n");
		  }
	     
		  System.out.println("Payment record exported.");

	    } catch (IOException ioe) {
		   ioe.printStackTrace();
		}
		finally
		{ 
		   try{
		      if(bw!=null)
			 bw.close();
		   }catch(Exception ex){
		       System.out.println("Error in closing the BufferedWriter"+ex);
		    }
		}
		
	}
	
	
	
}
