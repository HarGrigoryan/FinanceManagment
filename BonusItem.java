public class BonusItem extends Item
{
	private int qolBonus;
	
	public BonusItem(String n, int c, int qB)
	{
		super(n,c);
		qolBonus = qB;
	}
	
	public int getQolBonus()
	{
		return qolBonus;
	}
	
	public void action(Player p)
	{
		p.changeBalance(-1 * this.getCost());
		p.changeQol(qolBonus);
	}
	
	public boolean equals(Object o)
	{
		if( o == null)
			return false;
		else if(o.getClass() != this.getClass())
			return false;
		else
		{
			BonusItem bI = (BonusItem) o;
			return super.equals(bI) && this.qolBonus == bI.qolBonus;	
		}
	}
}