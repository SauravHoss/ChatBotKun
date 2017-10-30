import java.util.Scanner;

/* This bot is a very rough draft
It is supposed to respond to depressed patients 
Acting Very happy will break it for now, sorry we didn't get to work on it a lot
For best results select bot 1 and 3, 2 and 4 were barely worked on
*/
public class personalrunnervhashout 
{

	public static void main(String [] args)
	{
		Scanner in = new Scanner (System.in);
		System.out.println("Welcome To Happy Sad Care Center~");
		System.out.println("Please select a representative you would like to talk to.");
		System.out.println("If you would like to talk to Mean Robbie Press '1'");
		System.out.println("If you would like to talk to x Press '2'");
		System.out.println("If you would like to talk to y Press '3'");
		System.out.println("If you would like to talk to z Press '4'");

	
		String x = in.nextLine();
	
		
		
		
		
		
		if (x.equals("1"))
		{
			{
	 			ChatBotHossain chatbot1 = new ChatBotHossain();
	 
	 
	 			while (!x.equals("Bye"))
	 			{	
	 				System.out.println (chatbot1.theybetalkin(x));
	 				x = in.nextLine();
	 			}
	 		}
		}
		
		if (x.equals("2"))
		{
			{
	 			ChatBotWang chatbot2 = new ChatBotWang();
	 		
	 			System.out.println (chatbot2.getGreeting());	 		
	 
	 
	 			while (!x.equals("Bye"))
	 			{
	 				System.out.println (chatbot2.getResponse(x));
	 				x = in.nextLine();
	 			}
	 		}
		}
		
		if (x.equals("3"))
		{
			{
	 			ChatBotZhu chatbot3 = new ChatBotZhu();
	 		
	 			System.out.println (chatbot3.getGreeting());	 		
	 
	 
	 			while (!x.equals("Bye"))
	 			{
	 				System.out.println (chatbot3.getResponse(x));
	 				x = in.nextLine();
	 			}
	 		}
		}
		
		if (x.equals("4"))
		{
			{
	 			ChatBotSun chatbot4 = new ChatBotSun();
	 		
	 			System.out.println (chatbot4.hello());	 		
	 
	 
	 			while (!x.equals("Bye"))
	 			{
	 				System.out.println (chatbot4.getResponse(x));
	 				x = in.nextLine();
	 			}
	 		}
		}
		
	}
}
