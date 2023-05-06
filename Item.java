public abstract class Item implements Comparable<Item>
{
	private String name;
	private int cost;
	
	protected Item(String n, int c)
	{
		name = n;
		cost = c;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getCost()
	{
		return cost;
	}
	
	public String toString()
	{
		return name;
	}
	
	public int compareTo(Item i)
	{
		return this.name.compareTo(i.name);
	}
	
	public boolean equals(Object o)
	{
		if( o == null )
			return false;
		else if( this.getClass() != o.getClass() )
			return false;
		else
		{
			Item i = (Item) o;
			return this.name.equals(i.name) && (this.cost == i.cost);
		}
	}
	
	protected abstract void action(Player p);
}