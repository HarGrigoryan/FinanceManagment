public final class Item
{
	private String name;
	private double cost;
	private int qol;
	
	public Item(double c, int q, String n)
	{
		name = n;
		cost = c;
		qol = q;
	}
	
	public double getCost()
	{
		return cost;
	}
	
	public int getQol()
	{
		return qol;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String toString()
	{
		return name + " QOL: " + qol + " Cost: $" + cost; 
	}
}