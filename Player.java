public class Player 
{
	private double savings;
	private double monthlySalary;
	private double monthlyExpenses;
	private float qol;
	
	public Player()
	{
		savings = 0;
		monthlySalary = 0;
		monthlyExpenses = 0;
		qol = 0;
		
	}
	
	public Player( double s, double mS, double mE, float q)
	{
		savings = s;
		monthlySalary = mS;
		monthlyExpenses = ME;
		qol = q;
		
	}
	
	public void setSavings (double s)
	{
		savings = s;
		
	}
	
	public double getSavings()
	{
		return savings;
	}
	
	public double getMonthlySalary()
	{
		return monthlySalary;
	}
	
	public double getMonthlyExpenses()
	{
		return monthlyExpenses;
	}
	
	public void setQol(float q)
	{
		qol = q;
	}
	
	public float getQol()
	{
		return qol;
	}
	
}