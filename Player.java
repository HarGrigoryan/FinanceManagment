public class Player 
{
	private int savings;
	private int qol;
	Level l;
	
	public Player(Level l)
	{
		this.l = l; 
		savings = l.getSavings();
		qol = l.getInitialQol();
		
	}
	
	public void setSavings (int s)
	{
		savings = s;
	}
	
	public void setQol(int q)
	{
		qol = q;
	}
	
	public double getSavings()
	{
		return savings;
	}
	
	public double getMonthlySalary()
	{
		return l.getMonthlySalary();
	}
	
	public double getMonthlyExpenses()
	{
		return getMonthlyExpenses();
	}
	
	public int getQol()
	{
		return qol;
	}
	
	public int getRequiredQol()
	{
		return l.getRequiredQol();
	}
}