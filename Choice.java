public final class Choice implements Cloneable
{
	
	private String text;
	private int qolIndex;
	private int money;

	
	public Choice(String t, int q, int m)
	{
		text = t;
		qolIndex = q;
		money = m;
	}
	
	public String getText()
	{
		return text;
	}
	
	public int getQolIndex()
	{
		return qolIndex;
	}
	
	public int getMoney()
	{
		return money;
	}
	
	public Choice clone()
	{
		try
		{
			return (Choice) super.clone();
			
		}
		catch(CloneNotSupportedException e)
		{
			return null;
			
		}
	
	}
	
	public String toString()
	{

		return text;
	}
	
	public void choiceResult(Player p)
	{
		p.changeBalance(money);
		p.changeQol(qolIndex);
	}
	
	public boolean equals(Object o)
	{
		if( o==null )
			return false;
		if( this.getClass() != o.getClass() )
			return false;
		Choice t = (Choice)o;
		return (this.text.equals(t.text)) && (this.qolIndex == t.qolIndex) && (this.money == t.money);
	}

}