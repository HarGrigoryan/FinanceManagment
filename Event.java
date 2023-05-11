import java.util.Scanner;
import java.io.*;
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
	
	public static Event[] eventReader(String filePath)
	{ 

        try 
        {
            Scanner scanner = new Scanner(new FileInputStream(filePath));
            Event[] events = new Event[scanner.nextInt()];
			scanner.nextLine();
			int i = 0;
            while (i < events.length) 
            {
				String eventLine = scanner.nextLine();
				int j = 0;
				Choice[] choices = new Choice[2];
				while(j < 2)
				{
					String choiceLine = scanner.nextLine();
					String[] parts = choiceLine.split(":");
					choices[j] = new Choice(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
					j++;
				}
				events[i] = new Event(eventLine,choices );
				i++;
            }
            scanner.close();
			return events;
        } 
        catch (FileNotFoundException e)
        {
            System.out.println("File not found: " + filePath);
			return null;
        }
    }
	
	public String toString()
	{
		StringBuilder b = new StringBuilder("");
		for(int i = 1; i <= choices.length; i++)
			b.append(i + ") " + choices[i-1].toString() +"\n");
		return description + "\n" + b.toString();
	}
}