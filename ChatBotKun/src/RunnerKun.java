import java.util.Scanner;

/**
 * A simple class to run our chatbot teams.
 * @author Mr. Levin
 * @version September 2017
 */
public class RunnerKun
{

	/**
	 * Create instances of each chatbot, give it user input, and print its replies. Switch chatbot responses based on which chatbot the user is speaking too.
	 */
	public static void main(String[] args)
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

}
