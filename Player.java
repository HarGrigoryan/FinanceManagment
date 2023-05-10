public class Player implements Cloneable
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
	
	public boolean win()
	{
		return qol >= l.getRequiredQol();
	}
	
	
	void changeBalance(int s)
	{
		balance += s;
	}
	
	void changeQol(int q)
	{
		qol += q;
	}
	
	public int getBalance()
	{
		return balance;
	}
	
	public int getMonthlySalary()
	{
		return l.getMonthlySalary();
	}
	
	void update()
	{
		balance += 12 * l.getMonthlyIncrease(); 
	}
	
	public int getMonthlyExpenses()
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
	
	public Player clone()
	{
		try
		{
			return (Player) super.clone();
		}
		catch(CloneNotSupportedException e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}
}