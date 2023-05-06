import java.util.Scanner;

public final class GameControler 
{
	private Player p;
	private Goal g;
	private Event[] events;
	
	public void play()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Hello User! Welcom to Finance Management Game. ........");
		System.out.println("First Choose your character! Please type in either Mother or Father");
		String r1 = sc.next();
		System.out.println("Now chose the level of dificulty. .... Please type in either Hard, Medium or Easy.");
		String levelChoice = sc.next();
		switch (levelChoice)
		{
			case "Hard" :
				p = new Player( 1000, 600, 450, 15);
				break;
			case "Medium" :	
				p = new Player( 3000, 1000, 800, 20);
				break;
			case "Easy":
				p = new Player( 5000, 1500, 1100, 25);
				break;
		}
		//"bla bla bla";
		System.out.println("Now chose the goal you want to achieve. .... Please type in either Car, Education, or House.");
		String r2 = sc.next();
		int eventcounter = 0;
		if(r2.equalsIgnoreCase("car"))
		{
			g = Goal.CAR;
		}
		else if(r2.equalsIgnoreCase("education"))
		{
			g = Goal.EDUCATION;
		}
		else if(r2.equalsIgnoreCase("house"))
		{
			g = Goal.HOUSE;
		}
		//the game starts 
		String response;
		while(sc.hasNext())
		{
			response = sc.next();
			if(response.equalsIgnoreCase(""))
			{
				
			}
			else if(response.equalsIgnoreCase("q"))
			{
				System.out.println("Great game!");
				System.exit(0);
			}
			else
			{
				System.out.println("Unknown command. Please try again");
			}
		}
	}
	
	public static void main(String[] args)
	{
		GameControler g = new GameControler();
		g.play();
	}
}