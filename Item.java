public final class Item
{
	private double cost;
	private int qol;
	
	public Item(double c, int q)
	{
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
}