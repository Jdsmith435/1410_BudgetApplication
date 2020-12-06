/**
 * 
 */
package budgetingApp;

import java.util.List;

public abstract class BudgetOptions {

	//double amounts that represent the percentage of income towards this catagory
	private double income;
	private double debt;

	
	public BudgetOptions (double income, double debt) {
		this.income = income;
		this.debt = debt;
	}


	/**
	 * @return the savings
	 */
	public double getDebt() {
		return debt;
	}
	
	/**
	 * @return the savings
	 */
	public double getIncome() {
		return income;
	}
	
	public List<Double> catagoryPercentage;
	
}
 