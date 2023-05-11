public class SimpleItem extends Item
{
	public SimpleItem(String n, int c)
	{
		super(n,c);
	}
	
	public void action(Player p)
	{
		p.changeBalance(-1 * this.getCost());
	}
}