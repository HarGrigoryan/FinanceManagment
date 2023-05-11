public enum Goal 
{
	CAR (5000, 70),
	EDUCATION(3000, 50),
	HOUSE(10000, 100);

	private int moneyRequired;
	private int qolIncrease;
	
	Goal(int mR, int qI)
	{
		moneyRequired = mR;
		qolIncrease = qI;
	}
	
	public String accomplishGoal(Player p)
	{
		if( p.getBalance() >= moneyRequired)
		{
			p.changeBalance(-1 * this.moneyRequired);
			p.changeQol(this.qolIncrease);
			return "Congratulations You Have Accomplished Your Goal With The Following Properties " + display();
		}
		else 
		{
			return "Sorry! $" + this.moneyRequired + " is required to accomplish the goal";
		}
	}
	
	public int getMoneyRequired()
	{
		return moneyRequired;
	}
	
	public int getQolIncrease()
	{
		return qolIncrease;
	}
	
	public String display()
	{
		return this + ": Money Required: " + moneyRequired + ": QOL increase: " + qolIncrease;
	}
	
}