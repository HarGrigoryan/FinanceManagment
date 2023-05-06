public final class Bank
{
	private int moneyDeposited;
	private int numberOfYears; 
	private static final float rateForLong = 0.045f;
	private static final float rateForShort = 0.06f;
	
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
	
	
	public void setMoneyDeposited(int m)
	{
		moneyDeposited = m;
	}
	
	public void setNumberOfYears(int n)
	{
		numberOfYears =  n;
	}
	
	public double getMoney()
	{
		if(time >= 1)
			return moneyDeposited + ((moneyDeposited * rateForLong) * numberOfYears);
		else 
			return moneyDeposited + ((moneyDeposited * rateForShort) * numberOfYears);
	}
	
	public float getRateForLong()
	{
		return rateForLong;
	}
	
	public float getRateForShort()
	{
		return rateForShort;
	}

	public double getMoneyDeposited()
	{
		return moneyDeposited;
	}
	
	public double getNumberOfYears()
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