import java.util.Random;
import java.util.Scanner;

public class ChatBotHossain 
{
	
	public String theybetalkin(String x) 
	{
		String blah = x.toLowerCase();
		String wordz = "Robbie: ";
		
		if (x.equals("0"))
		{ 
			wordz += "You got something to say?";
		}
		
		if (blah.length() == 0) 
		{
			wordz += "You gonna say something?";
		}
		
		else if (blah.contains("lol"))
		{
			wordz += "Say 'kek' instead you normie";
		}
		
		else if (blah.contains("hello") || blah.contains("hi") || blah.contains("hey") || blah.contains("greetings") || blah.contains("sup")) 
		{
			wordz += "What's crakalakin homie";
		}
		
		else if (blah.contains("don't want to live") || blah.contains("don't wanna to live"))
		{
			wordz += "Now you listen to me and listen good. Killing yourself is the most selfish thing you have could ever do. When you kill yourself you are hurting everyone who loves you to an unbearable extent. "
					+ "If you are too much of a wimp to live by yourself then live for those who can't bear to see you die." ;
		}
				

		return wordz;
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
				System.out.print("Yay~");
			}
			else System.out.println("Try again");
		}
	
	}



	// if i need an rgn for stuff
	private static int rgn(int range) 
	{
		return (int) Math.random()*range; //yay I learned to cast
	}
}