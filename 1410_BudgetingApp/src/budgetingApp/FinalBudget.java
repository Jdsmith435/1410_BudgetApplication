package budgetingApp;

import java.util.ArrayList;
import java.util.List;

public class FinalBudget {

	/**
	 * This method is called when the budget is made initially
	 * 
	 * @param expenses List expenses will create a new budget list expense 
	 * @return allExpenses holds all expenses in String format "$xx.xx"
	 */
	public List<String> generateExpenses(List<Double> expenses){
		
		List<String> allExpenses = new ArrayList<String>();
		String expenseWithDollar = "$";
		
		try {
			for(double d : expenses) {
				String price = expenseWithDollar + Double.toString(d);
				allExpenses.add(price);
			}
		} catch ( IllegalArgumentException ex){
			System.err.println("Input needs to be a digit with a decimal value");
			allExpenses = null;
		}
	
		return allExpenses;
	}
	

	/**
	 * This method will return a list from the input file that was 
	 * uploaded by the user. 
	 * 
	 * @param fileExpenses Tokens from input file when a created budget is imported
	 * @return
	 */
	public List<String> generateExpenses(String fileExpenses){
		
		try {
		
		} catch ( IllegalArgumentException ex){
			System.err.println("Input needs to be a digit with a decimal value");
		}
		
		return null;
	}
}
