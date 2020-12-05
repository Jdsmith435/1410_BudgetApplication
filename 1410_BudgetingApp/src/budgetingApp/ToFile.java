package budgetingApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ToFile {
	
	public void toFile(File f, List<String> newExpenses) {
		
		try {
			FileInputStream fis = new FileInputStream(f);
			int r=0; 
			while((r=fis.read())!=-1)  
			{  
				System.out.print((char)r);      //prints the content of the file  
			}  
			FileWriter csvWriter = new FileWriter("budget.csv");
			
			List<String> data = new ArrayList<String>(FinalBudget.generateExpenses(newExpenses));
			
			data.forEach(x -> System.out.println(x));
			
			fis.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
