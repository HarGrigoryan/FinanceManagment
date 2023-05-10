import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;


public class GUIFinance extends JFrame
{
	private Event[] events;
	private Player player;
	private Item[] items;
	private Goal goal;
	private Bank bank;
	private JLabel balanceLabel;
	private JLabel qolLabel;
	private JPanel labelsButtons;
	private int time;
	private boolean isAccomplished;

    public GUIFinance()
	{
        super("Finance Management");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize(); 
        setSize(screenSize.width,screenSize.height);
		setVisible(true);
		JOptionPane.showMessageDialog(null, "Hello dear player, welcome to The Finance Game that helps you understand how to manage finances as a part of a family. In the game, you choose the level to play and work together with your family to achieve your financial goals.", null, JOptionPane.INFORMATION_MESSAGE);
		String character = JOptionPane.showInputDialog(null, "Choose the character to play as. Type in mom or dad:");
		if(character.equalsIgnoreCase("dad"))
			setBackgroundImage("2.jpg");
		else
			setBackgroundImage("1.jpg");
		setVisible(true);
		events = Event.eventReader("Events.txt");
		items = Item.readItems("Items.txt");
		bank = new Bank();
		time = 0;
        add(setMenu(), BorderLayout.NORTH);
		player = new Player(Level.valueOf((JOptionPane.showInputDialog(this, "Please select the game's level of difficulty:\n" + Level.getInformation())).toUpperCase()));
		balanceLabel = new JLabel("Balance: " + player.getBalance());	
		qolLabel = new JLabel("QOL: " + player.getQol());
		JPanel labelsButtons = new JPanel(new GridLayout(1,3));
		labelsButtons.add(setLabels());
		labelsButtons.add(setButtons());
		add(labelsButtons, BorderLayout.SOUTH);
		goal = Goal.valueOf((JOptionPane.showInputDialog(null, "Now as a part of the family you need to have goals , your goals can be one of the following: \nNew house (type in house) \nNew car for the family (type in car) \nFinancially helping the kids for education (type in education)")).toUpperCase());
		setVisible(true);
    }
	
    private void setBackgroundImage(String imagePath) {
        try 
		{
            BufferedImage image = ImageIO.read(new File(imagePath));
            JLabel backgroundLabel = new JLabel(new ImageIcon(image));
            backgroundLabel.setLayout(new BorderLayout());
            add(backgroundLabel);
        } 
		catch (IOException e) {
            System.out.println("Error setting background image: " + e.getMessage());
        }
    }
	
    private JMenuBar setMenu()
	{
    	JMenuBar menuBar = new JMenuBar();
        JMenu shopMenu = new JMenu("Shop");
		for ( int i = 0; i < items.length; i++)
		{
			Item item = items[i];
			JMenuItem shopItem = new JMenuItem(item.getName());
			shopItem.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					item.action(player);	
					updateJLabels();
				}
			});
        	shopMenu.add(shopItem);
		}
        menuBar.add(shopMenu);
        return menuBar;

    }
	
    private JPanel setButtons()
	{
		JPanel buttons =  new JPanel(new GridLayout(1, 3));
		JButton accomplishButton = new JButton("Accomplish Goal"); 
		accomplishButton.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			String out = goal.accomplishGoal(player); 
			JOptionPane.showMessageDialog(null, out, null, JOptionPane.INFORMATION_MESSAGE);
			if(out.startsWith("C"))
				isAccomplished = true;
			updateJLabels();
			
		}
		});
		buttons.add(accomplishButton);
		JButton depositButton = new JButton("Deposit");
		depositButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  int inputMoney = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the amount of money you want to deposit:"));
			  int years = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of years you want to deposit:"));
			  bank = new Bank(inputMoney, years);
			  player.changeBalance(-1*inputMoney);
			  updateJLabels();
			}
		});
		buttons.add(depositButton);
    	JButton nextButton = new JButton("Next");
    	nextButton.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) 
		  {
			if(time == 3)
			{
				String s = "";
				if(!isAccomplished)
				{
					if(player.getBalance() >= goal.getMoneyRequired())
						goal.accomplishGoal(player);
					else
					{
						s = "Sorry you lost";
						JOptionPane.showMessageDialog(null, s, null, JOptionPane.INFORMATION_MESSAGE);
						System.exit(0);
					}
				}
				if(player.win())
					s = "Congratiulations you won!";
				else
					s = "Sorry you lost";
				JOptionPane.showMessageDialog(null, s, null, JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
			else
			{
				Choice c = events[time].getChoices()[(Integer.parseInt(JOptionPane.showInputDialog(null, events[time])))-1];		
				c.choiceResult(player);
				time++;
				if(time == bank.getNumberOfYears())
				{
					player.changeBalance(bank.getMoney());
				}
				player.update();
				updateJLabels();
			}
		}
		});
    	buttons.add(nextButton);
		return buttons;
    }
	
	private void updateJLabels()
	{
		balanceLabel.setText("Balance: " + player.getBalance());
		qolLabel.setText("QOL: " + player.getQol());
	}
	
	private JPanel setLabels()
	{
		JPanel labels = new JPanel(new GridLayout(1,2));
		labels.add(balanceLabel);
		labels.add(qolLabel);
		return labels;
	}

    public static void main(String[] args) 
	{	
		GUIFinance guiFinance = new GUIFinance();
		guiFinance.setVisible(true);
    }
}
