package budgetingApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Exports all data pertaining to the budget to a csv file
 * Two methods to handle different an uploaded budget or a new budget
 * 
 * @author Jeremiah Kenyon
 *
 */
public class ToFile {
	
	/**
	 * From a file, exports a new budget with the new expenses added by the user
	 * @param f
	 * @param newExpenses
	 */
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
	
/**
 * Exports to a new csv file the budget that was created by the user
 * 
 * @param percentIncome
 * @param newExpenses
 * @param types
 * @param plan
 */
public void toFileNew(List<Double> percentIncome, List<String> newExpenses, List<String> types, int plan) {
		
		try {
			FileWriter csvWriter = new FileWriter("budget.csv");
			
			List<String> data = new ArrayList<String>(FinalBudget.generateExpenses(newExpenses));
			
			int i = 0;
			
			csvWriter.write("Budget: ");
			if (plan == 1) {
				csvWriter.write("50/30/20");
			} else if (plan == 2) {
				csvWriter.write("50/40/5/5");
			}else {
				csvWriter.write("40/55/5");
			}
			int a = 0;
			//Formatting of the file
			csvWriter.write(System.getProperty( "line.separator" ));
			csvWriter.write("Monthly Income: " + BudgetJFrame.income);
			csvWriter.write(System.getProperty( "line.separator" ));
			csvWriter.write("Necessary: " + percentIncome.get(a));
			csvWriter.write(System.getProperty( "line.separator" ));
			a++;
			if(plan ==2) {
				csvWriter.write("Debt: " + percentIncome.get(a));
				csvWriter.write(System.getProperty( "line.separator" ));
				a++;
			}
			csvWriter.write("Savings: " + percentIncome.get(a));	
			csvWriter.write(System.getProperty( "line.separator" ));
			a++;
			csvWriter.write("Entertainment: " + percentIncome.get(a));	
			csvWriter.write(System.getProperty( "line.separator" ));
			csvWriter.write("Expenses: ");	

			
			for(String d : data) {
				csvWriter.write(System.getProperty( "line.separator" ));
				csvWriter.write(d + " ");
				csvWriter.write(types.get(i));
				i++;
			}
			csvWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
