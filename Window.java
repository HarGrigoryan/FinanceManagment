import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame
{
    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;

    public Window(String s)
    {
        super("Information");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane( ).setBackground(Color.PINK);
        JLabel aLabel = new JLabel(s);
        add(aLabel);
    }
    public Window(String s, Event event){
        super("Event");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane( ).setBackground(Color.PINK);
        JLabel eventLabel = new JLabel(s);
        JButton choice1= new JButton(Choice[0].toString());
        choice1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event.getChoices().choiceResult();
            }
        });
        JButton choice2= new JButton(Choice[1].toString());
        choice2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event.getChoices().choiceResult();
            }
        });
        eventLabel.add(choice1);
        eventLabel.add(choice2);
        add(eventLabel);
    }
    public Window(String s, Goal goal){
        super("Event");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane( ).setBackground(Color.PINK);
        JLabel goalLabel = new JLabel(s);
        JPanel goalButtons =  new JPanel(new GridLayout(1, 3));
        JButton car= new JButton(goal.CAR);
        car.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //something
            }
        });
        JButton education= new JButton(goal.EDUCATION);
        education.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //something
            }
        });
        JButton house= new JButton(goal.HOUSE);
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
    public Window(String s, Level level){
        super("Event");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane( ).setBackground(Color.PINK);
        JLabel levelLabel = new JLabel(s);
        JPanel levelButtons =  new JPanel(new GridLayout(1, 3));
        JButton easy= new JButton(level.EASY);
        easy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //something
            }
        });
        JButton medium= new JButton(level.MEDIUM);
        medium.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //something
            }
        });
        JButton hard= new JButton(level.HARD);
        hard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //something
            }
        });
        levelButtons.add(easy);
        levelButtons.add(medium);
        levelButtons.add(hard);
        levelLabel.add(levelButtons);
        add(levelLabel);

    }
}
