package budgetingApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * FinalBudget creates the format and returns a formated string.
 * 
 * Two generateExpenses methods return a List of type String to CreateBudget.
 * CreateBudget sends a list of expenses of type double to generateExpenses and 
 * UploadBudget will send two lists: a list of String with already generated expenses
 * and a list of double of newly added expenses.
 * 
 * @author Jeremiah Smith Kenyon Gentry
 *
 */
public class FinalBudget {

	//Test Class
	/*
	public static void main(String [] args){
		List<String> expenses = new ArrayList<String>();
		List<Double> newExpenses = new ArrayList<Double>();
		Collections.addAll(expenses, "100.50", "50.46", "17.45");
		Collections.addAll(newExpenses, 10.34, 12.54,  100.23);
		
		List<String> testExpenses = new ArrayList<String>();
		testExpenses = generateExpenses(newExpenses);
		testExpenses.forEach(x -> System.out.println(x));
		
		System.out.println();
		
		List<String> testExpenses1 = new ArrayList<String>();
		testExpenses1 = generateExpenses(expenses, newExpenses);
		testExpenses1.forEach(x -> System.out.println(x));
	}
	*/
	//This might be a jframe also maybe ¯\_(ツ)_/¯ 
	/**
	 * This method is called when the budget is made initially
	 * 
	 * @param expenses List expenses will create a new budget list expense 
	 * @return allExpenses holds all expenses in String format "$xx.xx"
	 */
	public static List<String> generateExpenses(List<Double> expenses){
		
		List<String> allExpenses = new ArrayList<String>();
		String expenseWithDollar = "$";
		
		try {
			for(double d : expenses) {
				String price = expenseWithDollar + Double.toString(d);
				allExpenses.add(price);
				System.out.println("here");
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
	 * @param newExpenses List that contains the added in expenses 
	 * @param fileExpenses List of Tokens from input file when a created budget is imported
	 * @return
	 */
	public static List<String> generateExpenses(List<String> fileExpense, List<Double> newExpenses){
		List<String> allExpenses = new ArrayList<String>();
		String expenseWithDollarSign = "$";

		try {
			for(String s : fileExpense) {
				String price = expenseWithDollarSign + s;
				allExpenses.add(price);	
			}
			for(Double d : newExpenses) {
				String price = expenseWithDollarSign + Double.toString(d);
				allExpenses.add(price);
			}
		} catch ( IllegalArgumentException ex){
			System.err.println("Input needs to be a digit with a decimal value");
		}
		
		return allExpenses;
	}
}
