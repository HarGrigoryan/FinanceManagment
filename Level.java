public enum Level
{
	EASY(5000, 1500, 25, 80, 900),
	MEDIUM(3000, 1000, 20, 70, 700),
	HARD(1000, 700, 15, 60, 400);
	
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
	
	public int getMonthlyIncrease()
	{
		return monthlySalary - monthlyExpenses;
	}
	
	public String displayLevel()
	{
		return this + " Monthly salary: " + monthlySalary + " Monthly Expenses: " + monthlyExpenses + " QOL required to win: " + requiredQOl + "\n";
	}
	
	public static String getInformation()
	{
		return "\n" + EASY.displayLevel() + "\n" + MEDIUM.displayLevel() + "\n" + HARD.displayLevel();
	}
}