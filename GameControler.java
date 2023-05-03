import java.util.Scanner;

public final class GameControler 
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Hello User! Welcom to Finance Management Game. ........");
		System.out.println("First Choose your character! Please type in either Mother or Father");
		String r1 = sc.next();
		System.out.println("Now chose the level of dificulty. .... Please type in either Hard, Medium or Easy.");
		String levelChoice = sc.next();
		Player p = null;
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
		
	}
}