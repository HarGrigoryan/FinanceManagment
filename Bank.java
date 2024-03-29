public final class Bank
{
	private int moneyDeposited;
	private int numberOfYears; 
	private static final int rateForLong = 4;
	private static final int rateForShort = 6;
	
	public Bank()
	{
		moneyDeposited = 0;
		numberOfYears = 0;
	}
	
	public Bank(int md, int nm)
	{
		moneyDeposited = md;
		numberOfYears = nm;
	}
	
	public int getMoney()
	{
		if(numberOfYears >= 3)
			return (int) (moneyDeposited + (((moneyDeposited * rateForLong) / 100) * numberOfYears));
		else 
			return (int) (moneyDeposited + (((moneyDeposited * rateForShort) / 100) * numberOfYears));
	}
	
	public int getRateForLong()
	{
		return rateForLong;
	}
	
	public int getRateForShort()
	{
		return rateForShort;
	}

	public int getMoneyDeposited()
	{
		return moneyDeposited;
	}
	
	public int getNumberOfYears()
	{
		return numberOfYears;
	}
	
	public String toString()
	{
		return "$" + moneyDeposited + " is deposited for " + numberOfYears + "with the rate " + (numberOfYears >= 1 ? rateForLong : rateForShort) + "%.";
	}
	
	public Bank clone()
	{
		try
		{
			Bank b = (Bank) super.clone();
			return b;
		}
		catch(CloneNotSupportedException e)
		{
			return null;
		}
	}
	
}