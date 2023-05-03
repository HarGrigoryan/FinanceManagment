public final class Goal implements Comparable<Goal>, Cloneable 
{
	private String goalDescription;
	private double moneyRequired;
	private int qolIncrease;
	
	public Goal(String t, double mR, int qI)
	{
		goalDescription = t;
		moneyRequired = mR;
		qolIncrease = qI;
	}
	
	public Goal()
	{
		goalDescription = "No description yet!";
		moneyRequired = 0;
		qolIncrease = 0;
	}
	
	public String getGoalDescription()
	{
		return goalDescription;
	}
	
	public double getMoneyRequired()
	{
		return moneyRequired;
	}
	
	public int getQolIncrease()
	{
		return qolIncrease;
	}
	
	public boolean equals(Object o)
	{
		if(o == null)
			return false;
		if(this.getClass() == o.getClass())
			return false;
		Goal g = (Goal) o;
		return ((goalDescription.equals(g.goalDescription)) && (moneyRequired == g.moneyRequired) && (qolIncrease == g.qolIncrease)); 
	}
	
	public String toString()
	{
		return goalDescription + "\nMoney Required: " + moneyRequired + "QOL increase: " + qolIncrease;
	}
	
	public int compareTo(Goal g)
	{
		try 
		{
			return this.goalDescription.compareTo(g.goalDescription);
		}
		catch(CloneNotSupportedException e)
		{
			return null;
		}
	}
	
	public Goal clone()
	{
		Goal copy = (Goal) super.clone();
	}
	
	
}