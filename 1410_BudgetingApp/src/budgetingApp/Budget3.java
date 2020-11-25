package budgetingApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Im no budget man but if you want to eat rice and cucumber everyday this is the budget
 * for you
 * 
 * 40/55/5 where: 40% is necessity, 55% is savings, 5% is spending
 * 
 * @author Jeremiah Smith
 *
 */
public class Budget3 extends BudgetOptions {
	
	public Budget3(double savings, double spending, double necessity) {
		super(savings, spending, necessity);
		// TODO Auto-generated constructor stub
	}
	
	public List<Double> catagoryPercentage(double income)
	{
		double necessityQT = income * .40;
		double savingsQT = income * .55;
		double spendingQT = income * .05;
		
		List<Double> percents = new ArrayList<Double>();
		Collections.addAll(percents, necessityQT, savingsQT, spendingQT);
		
		return percents;
	}

}
