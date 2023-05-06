public class Player 
{
	private int balance;
	private int qol;
	Level l;
	
	public Player(Level l)
	{
		this.l = l; 
		balance = l.getSavings();
		qol = l.getInitialQol();
		
	}
	
	public void changeBalance(int s)
	{
		balance += s;
	}
	
	public void changeQol(int q)
	{
		qol += q;
	}
	
	public double getBalance()
	{
		return balance;
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
	
	public String toString()
	{
		return "Balance: " + balance + "QOL " + qol + l;
	}
}