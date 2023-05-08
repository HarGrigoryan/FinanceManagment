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

	// public GUIFinance(){
	// 	super("Finance management");
    //     setDefaultCloseOperation(EXIT_ON_CLOSE);
    //     setSize(500, 400);
	// }
    
    public GUIFinance() {
        super("Finance Management");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);

        add(setMenu());   
        add(setButtons(), BorderLayout.NORTH);
    	add(setNext(), BorderLayout.SOUTH);
    	// if()
    	// 	setBackgroundImage("1.jpg");
    	// else 
    	// 	setBackgroundImage("2.jpg");
        setVisible(true);
    }
    
    public void setBackgroundImage(String imagePath) {
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            JLabel backgroundLabel = new JLabel(new ImageIcon(image));
            backgroundLabel.setLayout(new BorderLayout());
            setContentPane(backgroundLabel);
        } catch (IOException e) {
            System.out.println("Error setting background image: " + e.getMessage());
        }
    }
    public JPanel setMenu(){
    	JPanel menu =  new JPanel();
    	JMenuBar menuBar = new JMenuBar();
        JMenu shopMenu = new JMenu("Shop");
        JMenu bankMenu = new JMenu("Bank");
        JMenu infoMenu = new JMenu("Info");
        menuBar.add(shopMenu);
        menuBar.add(bankMenu);
        menuBar.add(infoMenu);
        return menu;
        //setJMenu(menuBar);

    }
    public JPanel setButtons(){
    JPanel buttons =  new JPanel(new GridLayout(1, 3));
        
    JLabel balanceButton = new JLabel("Balance");
    buttons.add(balanceButton);

    JLabel qolButton = new JLabel("QOL");
    
    buttons.add(qolButton);

    JButton forward = new JButton("Forward >");
    JButton accomplishButton = new JButton("Accomplish Goal"); 
    accomplishButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        //add
      }
    });
    buttons.add(accomplishButton);
        
    return buttons;

    }
    public JPanel setNext(){
    	JPanel button =  new JPanel();
    	JButton next= new JButton("Next");
    	//button.setAlignmentX(JPanel.CENTER_ALIGNMENT);
    	add(next);
    	return button;
    }

    public static void main(String[] args) {
        
        GUIFinance guiFinance = new GUIFinance();
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
