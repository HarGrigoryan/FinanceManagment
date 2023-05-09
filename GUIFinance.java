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
	private Event event;
	private Player player;
	private Item[] items;
	private Goal goal;
	private JLabel balanceLabel;
	private JLabel qolLabel;
	private JPanel labelsButtons;

    public GUIFinance()
	{
        super("Finance Management");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 1000);
		items = Item.readItems("Items.txt");
        add(setMenu(), BorderLayout.NORTH); 
		JPanel p = new JPanel();
		JTextArea levelLabel = new JTextArea(Level.getInformation());
        JPanel levelButtons =  new JPanel(new GridLayout(1, 3));
        JButton easy = new JButton(Level.EASY.toString());
        easy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
			{
                player = new Player(Level.EASY);
				intialisePlayer();
				p.setVisible(false);
				initialiseGoal();
            }
        });
        JButton medium= new JButton(Level.MEDIUM.toString());
        medium.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
			{
                player = new Player(Level.MEDIUM);
				intialisePlayer();
				p.setVisible(false);
				initialiseGoal();
            }
        });
        JButton hard= new JButton(Level.HARD.toString());
        hard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
			{
                player = new Player(Level.HARD);
				intialisePlayer();
				p.setVisible(false);
				initialiseGoal();
            }
        });
        levelButtons.add(easy);
        levelButtons.add(medium);
        levelButtons.add(hard);
		p.add(levelLabel, BorderLayout.CENTER);
		p.add(levelButtons, BorderLayout.SOUTH);
		add(p);
		setVisible(true);
		//setBackgroundImage("1.jpeg");
		/*
		JPanel gp = new JPanel();
		JLabel goalLabel = new JLabel("Choose the goal you want to achieve");
        JPanel goalButtons =  new JPanel(new GridLayout(1, 3));
        JButton car= new JButton(goal.CAR.toString());
        car.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goal = Goal.CAR;
				gp.setVisible(false);
            }
        });
        JButton education= new JButton(goal.EDUCATION.toString());
        education.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goal = Goal.EDUCATION;
				gp.setVisible(false);
            }
        });
        JButton house= new JButton(goal.HOUSE.toString());
        house.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				goal = Goal.HOUSE;
				gp.setVisible(false);
            }
        });
        goalButtons.add(car);
        goalButtons.add(education);
        goalButtons.add(house);
        goalLabel.add(goalButtons);
        gp.add(goalLabel);
		gp.add(goalButtons, BorderLayout.SOUTH);
		add(gp);*/
		setVisible(true);
		
    }
	
	public void intialisePlayer()
	{
		balanceLabel = new JLabel("Balance: " + player.getBalance());	
		qolLabel = new JLabel("QOL: " + player.getQol());
		JPanel labelsButtons = new JPanel(new GridLayout(1,3));
		labelsButtons.add(setLabels());
		labelsButtons.add(setButtons());
		add(labelsButtons, BorderLayout.SOUTH);
	}
	
	public void initialiseGoal()
	{
		JPanel gp = new JPanel();
		JLabel goalLabel = new JLabel("Choose the goal you want to achieve");
        JPanel goalButtons =  new JPanel(new GridLayout(1, 3));
        JButton car= new JButton(goal.CAR.toString());
        car.addActionListener(new ActionListener()
		{
            public void actionPerformed(ActionEvent e) {
                goal = Goal.CAR;
				gp.setVisible(false);
            }
        });
        JButton education= new JButton(goal.EDUCATION.toString());
        education.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e) {
                goal = Goal.EDUCATION;
				gp.setVisible(false);
            }
        });
        JButton house= new JButton(goal.HOUSE.toString());
        house.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e) {
				goal = Goal.HOUSE;
				gp.setVisible(false);
            }
        });
        goalButtons.add(car);
        goalButtons.add(education);
        goalButtons.add(house);
        goalLabel.add(goalButtons);
        gp.add(goalLabel);
		gp.add(goalButtons, BorderLayout.SOUTH);
		add(gp);		
		setVisible(true);
	}
	
    public void setBackgroundImage(String imagePath) {
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
	
    public JMenuBar setMenu()
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
					balanceLabel.setText("Balance: " + player.getBalance());
					qolLabel.setText("QOL: " + player.getQol());
				}
			});
        	shopMenu.add(shopItem);
		}
        menuBar.add(shopMenu);
        return menuBar;

    }
    public JPanel setButtons()
	{
		JPanel buttons =  new JPanel(new GridLayout(1, 3));	
		JButton deposit;
		JButton accomplishButton = new JButton("Accomplish Goal"); 
		accomplishButton.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			Accomplish a = new Accomplish();
			a.display( player, goal);
			balanceLabel.setText("Balance: " + player.getBalance());
			qolLabel.setText("QOL: " + player.getQol());
			
		}
		});
		buttons.add(accomplishButton);
    	JButton nextButton = new JButton("Next");
    	nextButton.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			System.out.println("next clicked");
			
			balanceLabel.setText("Balance: " + player.getBalance());
			qolLabel.setText("QOL: " + player.getQol());
		}
		});
    	buttons.add(nextButton);
		return buttons;
    }
	
	public JPanel setLabels()
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
