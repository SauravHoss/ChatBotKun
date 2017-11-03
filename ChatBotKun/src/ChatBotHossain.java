import java.util.Random;
import java.util.Scanner;

public class ChatBotHossain 
{
	public String hey() 
	{
		return "Robbie: What's up?"; // why ivan get a push error i no has brain cells anymore
	}
	
	public String theybetalkin(String x) 
	{
		String blah = x.toLowerCase();
		String wordz = " ";
		
		if (x.equals("0"))
		{ 
			wordz += "Robbie: You got something to say?";
		}
		
		if (blah.length() == 0) 
		{
			wordz += "Robbie: You gonna say something?";
		}
		
		else if (blah.contains("lol"))
		{
			wordz += "Robbie: Say 'kek' instead you normie";
		}
		
		else if (blah.contains("hello") || blah.contains("hi") || blah.contains("hey") || blah.contains("greetings") || blah.contains("sup")) 
		{
			wordz += "Robbie: What's crakalakin homie? Wanna play a game?";
		}
		
		else if (blah.contains("yes") || blah.contains("sure") || blah.contains("ok"))
		{
		wordz += ("Aight. I've been looking forward to sharing my skills with someone.");
		ugh();
		}
		
		
		else if (x.equals("switch to 2"))
		{
			ChatBotWang chatbot1 = new ChatBotWang();
			System.out.println (chatbot1.getGreeting());
			Scanner in = new Scanner (System.in);
			String mmwhatchusay = in.nextLine();
			


			while (!mmwhatchusay.equals("Bye"))
			{
				System.out.println (chatbot1.getResponse(mmwhatchusay));
				mmwhatchusay = in.nextLine();
			}
		}	

		return wordz;
	}

	public static void ugh() 
	{
		System.out.println("So let's get to it.");
		System.out.println("I'm going to pick a number between 0 and 10.");
		System.out.println("Guess it and I'll let you in on something");
		DidYouGetIt();
	}
		

	
	public static void DidYouGetIt()
	{
		Scanner usersguess = new Scanner(System.in);
		Random com = new Random();
		int rangeofnumberz = com.nextInt(10);
		int ug;
		boolean wowIneedthisorIwillcrash = false;
		
		
		while (wowIneedthisorIwillcrash == false) 
		{
			ug = usersguess.nextInt();
	
			if(ug == rangeofnumberz) 
			{
				wowIneedthisorIwillcrash = true;
				System.out.println("Ayy you got it.");
				rc();
				DidYouGetIt();
				
			}
			else System.out.println("Nah man, try again.");
		}
	}

	private static String rc()
	{ ////wtf
		Random g = new Random();
		return challengephrases[g.nextInt(challengephrases.length)];
	}
	
	private static String [] challengephrases = { "Best Two out of Three", "Bet you can't beat me again", "OMG CAN U STOP"}; 





	// if i need an rgn for stuff idk i just wanted to learn to cast
	private static int rgn(int range) 
	{
		return (int) Math.random()*range; //yay I learned to cast
	}
}
