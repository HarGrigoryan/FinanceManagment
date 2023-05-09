public final class Choice implements Cloneable, Comparable<Choice>
{
	
	private String text;
	private int qolIndex;
	private int money;
	
	public Choice()
	{
		text = "No text yet";
		qolIndex = 0;
		money = 0;
	}
	
	public Choice(String t, int q, int m)
	{
		text = t;
		qolIndex = q;
		money = m;
	}
	
	public final String getText()
	{
		return text;
	}
	
	public final int getQolIndex()
	{
		return qolIndex;
	}
	
	public final double getMoney()
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
		return (text + " QOL index :" + qolIndex + " Balance :" + money);
	}
	
	/*public static String numberToSignedString(double n)
	{
		if(n > 0)
			return "+" + n;
		return "-" +n;
	}*/
	
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
	
	public int compareTo(Choice c)
	{
		return this.text.compareTo(c.text);
	}
	
	
}