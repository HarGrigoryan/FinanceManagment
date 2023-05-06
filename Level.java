public enum Level
{
	EASY(5000, 1500, 25, 75, 900),
	MEDIUM(3000, 1000, 20, 65, 700),
	HARD(1000, 600, 15, 55, 500);
	
	private int savings;
	private int monthlySalary;
	private int initialQol;
	private int requiredQOl;
	private int monthlyExpenses;
	
	Level( int s, int mS, int iQ, int rQ, int mE)
	{
		savings = s;
		monthlySalary = mS;
		initialQol = iQ;
		requiredQOl = rQ; 
		monthlyExpenses = mE;
	}
	
	public int getSavings()
	{ 
		return savings;
	}
	
	public int getMonthlySalary()
	{
		return monthlySalary;
	}
	
	public int getInitialQol()
	{
		return initialQol;
	}
	
	public int getRequiredQol()
	{
		return requiredQOl;
	}
	
	public int getMonthlyExpenses()
	{
		return monthlyExpenses;
	}
}