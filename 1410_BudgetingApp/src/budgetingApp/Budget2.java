package budgetingApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Budget of 50/40/5/5 where: 50% for bills/necessity, 40% for debt handling, 5% for spending and 5% for saving
 * 
 * @author Jeremiah Smith
 *
 */
public class Budget2 extends BudgetOptions {
	
	public Budget2(double savings, double spending, double necessity) {
		super(savings, spending, necessity);
		// TODO Auto-generated constructor stub
	}
	
	public List<Double> catagoryPercentage(double income)
	{
		double necessityQT = income * .50;
		double debtQT = income * .40;
		double savingsQT = income * .05;
		double spendingQT = income * .05;
		
		List<Double> percents = new ArrayList<Double>();
		Collections.addAll(percents, necessityQT, debtQT, savingsQT, spendingQT);
		
		return percents;
	}

}
