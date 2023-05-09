import javax.swing.*;

public	class Accomplish extends JFrame
{
	public Accomplish()
	{
		super("ACCOMPLISH GOAL");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1000, 1000);
	}
	
	public void display(Player p, Goal g)
	{
		JLabel text = new JLabel(g.acomplishGoal(p));
		this.add(text);
		this.setVisible(true);
	}
	
	public void display(String s)
	{
		JLabel text = new JLabel(s);
		this.add(text);
		this.setVisible(true);
	}
	
}