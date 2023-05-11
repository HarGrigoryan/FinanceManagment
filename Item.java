import java.util.*;
import java.io.*;
public abstract class Item
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
	
	public static Item[] readItems(String path)
	{
		Scanner sc = null;
		try
		{
			sc = new Scanner(new FileInputStream(path));
		}
		catch(IOException e)
		{
			System.out.println("Error:" + e.getMessage());
			System.exit(0);
		}
		int size = sc.nextInt();
		sc.nextLine();
		Item[] items = new Item[size];
		int i = 0;
		while(sc.hasNextLine())
		{
			String itemString = sc.nextLine();
			String[] itemElements = itemString.split(" ");
			if(itemElements.length == 3)
			{
				items[i] = new BonusItem(itemElements[0], Integer.parseInt(itemElements[1]), Integer.parseInt(itemElements[2])); 
			}				
			else if (itemElements.length == 2)
			{
				items[i] = new SimpleItem(itemElements[0], Integer.parseInt(itemElements[1])); 
			}
			i++;
		}
		return items;
	}
	
	protected abstract void action(Player p);
}