public class Choice {
	
	private String text;
	private int qolIndex;
	private double money;
	
	public Choice()
	{
		text = "No text yet";
		qolIndex = 0;
		money = 0;
	}
	
	public Choice(String t, int q, double m)
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
	
	public double getMoney()
	{
		return money;
	}
	
}