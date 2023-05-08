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


public class GUIFinance extends JFrame{
	private Event event;
	private Player player;
	private Item[] items;
	private Goal goal;
	//private int counter = 0;

    public GUIFinance(Player p)
	{
        super("Finance Management");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
		player = p.clone();
		items = Item.readItems("Items.txt");
        add(setMenu(), BorderLayout.NORTH); 
		JPanel labelsButtons = new JPanel(new GridLayout(1,3));
		labelsButtons.add(setLabels());
		labelsButtons.add(setButtons());
        add(setNext(), BorderLayout.SOUTH);
    	if(true)
			setBackgroundImage("1.jpg");
    	else 
    	 	setBackgroundImage("2.jpg");
        setVisible(true);
		add(labelsButtons, BorderLayout.SOUTH);
		//add(setButtons(), BorderLayout.SOUTH);
    	
    }
    
    public void setBackgroundImage(String imagePath) {
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            JLabel backgroundLabel = new JLabel(new ImageIcon(image));
            backgroundLabel.setLayout(new BorderLayout());
            add(backgroundLabel);
        } catch (IOException e) {
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
					System.out.println(item);
					item.action(player);
				}
			});
        	shopMenu.add(shopItem);
		}
			
        JMenu bankMenu = new JMenu("Bank");
        JMenu infoMenu = new JMenu("Info");
        menuBar.add(shopMenu);
        menuBar.add(bankMenu);
        menuBar.add(infoMenu);
        return menuBar;

    }
    public JPanel setButtons(){
		JPanel buttons =  new JPanel(new GridLayout(1, 3));	
		JButton accomplishButton = new JButton("Accomplish Goal"); 
		accomplishButton.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			//add
		}
		});
		buttons.add(accomplishButton);
		return buttons;
    }
	
	public JPanel setLabels()
	{
		JPanel labels = new JPanel(new GridLayout(1,2));
		JLabel balanceLabel = new JLabel("Balance: " + player.getBalance());	
		labels.add(balanceLabel);
		JLabel qolLabel = new JLabel("QOL: " + player.getQol());
		labels.add(qolLabel);
		return labels;
	}
	
    public JPanel setNext(){
    	JPanel button =  new JPanel();
    	JButton next= new JButton("Next");
    	//button.setAlignmentX(JPanel.CENTER_ALIGNMENT);
    	add(next);
    	return button;
    }

    public static void main(String[] args) 
	{	
		Player p = new Player(Level.EASY);
        GUIFinance guiFinance = new GUIFinance(p);
		guiFinance.setVisible(true);
    }
}

        // create menu items for each menu and add them to the menus
        //shopItem1 = new JMenuItem("Item 1");
        //shopItem2 = new JMenuItem("Item 2");
        //shopMenu.add(shopItem1);
        //shopMenu.add(shopItem2);
        
        //bankItem1 = new JMenuItem("Item 1");
        //bankItem2 = new JMenuItem("Item 2");
        //bankMenu.add(bankItem1);
        //bankMenu.add(bankItem2);
        
        //infoItem1 = new JMenuItem("Item 1");
        //infoItem2 = new JMenuItem("Item 2");
        //infoMenu.add(infoItem1);
        //infoMenu.add(infoItem2);
