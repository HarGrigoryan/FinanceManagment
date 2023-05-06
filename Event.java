public final class Event implements Cloneable
{
	private String description;
	private Choice[] choices;
	
	public Event()
	{
		description = "No description yet";
		choices = null;
	}
	
	public Event(String d, Choice[] c)
	{
		description = d;
		choices = new Choice[c.length];
		for (int i = 0; i < c.length; i++)
		{
			choices[i] = c[i].clone();
		}
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public Choice[] getChoices()
	{
		Choice[] t = new Choice[choices.length];
		for (int i = 0; i < t.length; i++)
		{
			t[i] = choices[i].clone();
		}
		return t;
	}
	
	public Event clone()
	{
		try
		{
			Event e = (Event) super.clone();
			Choice[] temp = new Choice[choices.length];
			for ( int i = 0; i < temp.length; i++)
			{
				temp[i] = choices[i].clone();
			}
			e.choices = temp;
			return e;
		}
		catch(CloneNotSupportedException e)
		{
			return null;
			
		}
	}
	
	public String toString()
	{
		StringBuilder b = new StringBuilder("");
		for(int i = 0; i < choices.length; i++)
			b.append(choices[i].toString() +"\n");
		return description + "\n" + b.toString();
	}
}