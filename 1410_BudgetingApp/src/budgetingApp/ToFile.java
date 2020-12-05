package budgetingApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ToFile {
	
	public void toFile(File f, List<String> newExpenses) {
		
		try {
			FileInputStream fis = new FileInputStream(f);
			
			int r=0; 
			
			FileWriter csvWriter = new FileWriter("budget.csv");
			
			List<String> data = new ArrayList<String>(FinalBudget.generateExpenses(newExpenses));
			
			while((r=fis.read())!=-1)  
			{  
				csvWriter.write(r);      //prints the content of the file  
			}  
			
		
			for(String d : data) {
				csvWriter.write(System.getProperty( "line.separator" ));
				csvWriter.write(d);
			}
			
			csvWriter.close();
			fis.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
