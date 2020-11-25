/**
 * 
 */
package budgetingApp;

import java.util.List;

public abstract class BudgetOptions {

	//double amounts that represent the percentage of income towards this catagory
	private double savings;
	private double spending;
	private double necessity;

	
	public BudgetOptions (double savings, double spending, double necessity) {
		this.savings = savings;
		this.spending = spending;
		this.necessity = necessity;
	}


	/**
	 * @return the savings
	 */
	public double getSavings() {
		return savings;
	}


	/**
	 * @return the spending
	 */
	public double getSpending() {
		return spending;
	}


	/**
	 * @return the necessity
	 */
	public double getNecessity() {
		return necessity;
	}
	
	public List<Double> catagoryPercentage;
	
}
 