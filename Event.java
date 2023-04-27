public class Event 
{
	private String description;
	private Choice[] choices;
	
	public Event()
	{
		description = "No description yet"
		choices = null;
	}
	
	public Event(Strint d, Choice[] c)
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
}