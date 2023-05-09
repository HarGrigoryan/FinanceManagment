import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame
{
    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;
	private Player pl;

    public Window(String s)
    {
        super("Information");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane( ).setBackground(Color.PINK);
        JLabel aLabel = new JLabel(s);
        add(aLabel);
    }
	
    public Window(String s, Event event, Player p){
        super("Event");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane( ).setBackground(Color.PINK);
        JLabel eventLabel = new JLabel(s);
        JButton choice1 = new JButton(event.getChoices()[0].toString());
        choice1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event.getChoices()[0].choiceResult(p);
            }
        });
        JButton choice2= new JButton(event.getChoices()[1].toString());
        choice2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event.getChoices()[0].choiceResult(p);
            }
        });
        eventLabel.add(choice1);
        eventLabel.add(choice2);
        add(eventLabel);
    }
    public Window(String s, Goal goal){
        super("Goal");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane( ).setBackground(Color.PINK);
        JLabel goalLabel = new JLabel(s);
        JPanel goalButtons =  new JPanel(new GridLayout(1, 3));
        JButton car= new JButton(goal.CAR.toString());
        car.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //something
            }
        });
        JButton education= new JButton(goal.EDUCATION.toString());
        education.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //something
            }
        });
        JButton house= new JButton(goal.HOUSE.toString());
        house.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //something
            }
        });
        goalButtons.add(car);
        goalButtons.add(education);
        goalButtons.add(house);
        goalLabel.add(goalButtons);
        add(goalLabel);
    }
	
		
	public Player getPlayer()
	{
		return pl.clone();
	}
	
    public Window()
	{
        super("Level");
        setSize(WIDTH, HEIGHT);
		setLayout(new GridLayout(2,1));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane( ).setBackground(Color.PINK);
        JLabel levelLabel = new JLabel(Level.getInformation());
        JPanel levelButtons =  new JPanel(new GridLayout(1, 3));
        JButton easy = new JButton(Level.EASY.toString());
        easy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pl = new Player(Level.EASY);
            }
        });
        JButton medium= new JButton(Level.MEDIUM.toString());
        medium.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pl = new Player(Level.MEDIUM);
            }
        });
        JButton hard= new JButton(Level.HARD.toString());
        hard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pl = new Player(Level.HARD);
            }
        });
        levelButtons.add(easy);
        levelButtons.add(medium);
        levelButtons.add(hard);
		add(levelLabel);
        add(levelButtons);
		setVisible(true);
    }
}
