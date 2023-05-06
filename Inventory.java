import java.util.ArrayList;

public final class Inventory 
{
	private ArrayList<Item> items;
	
	public Inventory()
	{
		items = new ArrayList<>();
	}
	
	public void addItem( Item i)
	{
		items.add(i); // Item is immutable 
	}
	
	public String toString()
	{
		StringBuilder b = new StringBuilder("");
		for (int i = 0; i < items.size(); i++ )
		{
			b.append(items.get(i).toString() + "\n");
		}
		
		return b.toString();
	}
}