import java.util.Scanner;

public class RunnerKun 
{ // THIS ISNT THE RUNNER FILE
	 
	 /**
	  * A simple class to run our chatbot teams.
	  * @author Mr. Levin
	  * @version September 2017
	  */
	
	 
	 
	 	/**
	 	 * Create instances of each chatbot, give it user input, and print its replies. Switch chatbot responses based on which chatbot the user is speaking too.
	 	 
	 	public static void main(String[] args)
	 	{
	 		int YourSelection = 0;
	 		if (YourSelection == 1)
	 		{
	 			ChatBotHossain chatbot1 = new ChatBotHossain();
	 		
	 			System.out.println (chatbot1.instahi());
	 			Scanner in = new Scanner (System.in);
	 			String statement = in.nextLine();
	 		
	 
	 
	 			while (!statement.equals("Bye"))
	 			{
	 				System.out.println (chatbot1.theybetalkin(statement));
	 				statement = in.nextLine();
	 			}
	 		}
	 		if (YourSelection == 2)
	 		{
	 			ChatBotHossain chatbot2 = new ChatBotHossain();
	 		
	 			System.out.println (chatbot2.instahi());
	 			Scanner in = new Scanner (System.in);
	 			String statement = in.nextLine();
	 		
	 
	 
	 			while (!statement.equals("Bye"))
	 			{
	 				System.out.println (chatbot2.theybetalkin(statement));
	 				statement = in.nextLine();
	 			}
	 		}
	 	
	 	
	 	
	 	}
	 
}
	


	
*/
