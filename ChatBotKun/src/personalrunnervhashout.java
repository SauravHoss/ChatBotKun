import java.util.Scanner;

public class personalrunnervhashout 
{

	public static void main(String [] args)
	{

		Scanner in = new Scanner (System.in);
		System.out.println("Welcome To Happy Sad Care Center~");
		System.out.println("Please select a representative you would like to talk to.");
	
		String x = in.nextLine();
		
		if (x.equals("0"))
		{
			{
	 			ChatBotHossain chatbot1 = new ChatBotHossain();
	 		
	 			System.out.println (chatbot1.instahi());	 		
	 
	 
	 			while (!x.equals("Bye"))
	 			{
	 				System.out.println (chatbot1.theybetalkin(x));
	 				x = in.nextLine();
	 			}
	 		}
		}
		
		if (x.equals("1"))
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
		
	
	
	}
}
