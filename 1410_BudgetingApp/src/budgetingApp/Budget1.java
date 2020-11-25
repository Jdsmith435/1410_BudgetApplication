package budgetingApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Budget of 50/30/20 where: 50% for bills/necessity, 30% for savings, 20% for spending
 * 
 * @author Jeremiah Smith
 *
 */
public class Budget1 extends BudgetOptions {
	
	public Budget1(double savings, double spending, double necessity) {
		super(savings, spending, necessity);
		// TODO Auto-generated constructor stub
	}
	
	public List<Double> catagoryPercentage(double income)
	{
		double necessityQT = income * .50;
		double savingsQT = income * .30;
		double spendingQT = income * .20;
		
		List<Double> percents = new ArrayList<Double>();
		Collections.addAll(percents, necessityQT, savingsQT, spendingQT);
		
		return percents;
	}

}
