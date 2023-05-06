public enum Goal 
{
	CAR (5000, 70),
	EDUCATION(3000, 50),
	HOUSE(1000, 100);

	private int moneyRequired;
	private int qolIncrease;
	
	Goal(int mR, int qI)
	{
		moneyRequired = mR;
		qolIncrease = qI;
	}
	
	public double getMoneyRequired()
	{
		return moneyRequired;
	}
	
	public int getQolIncrease()
	{
		return qolIncrease;
	}
	
	public String display()
	{
		return this + "\nMoney Required: " + moneyRequired + " QOL increase: " + qolIncrease;
	}
	
	public static void main(String[] args)
	{
		System.out.print(CAR.display());
	}
	
}