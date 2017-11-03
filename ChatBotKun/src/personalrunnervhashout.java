import java.util.Scanner;

public class personalrunnervhashout 
{

	public static void main(String [] args)
	{

		Scanner in = new Scanner (System.in);
		System.out.println("Welcome To Happy Sad Care Center~");
		System.out.println("Please select a representative you would like to talk to.");
		System.out.println("1.Hossain ");
		System.out.println("2.Wang ");
		System.out.println("3.Zhu ");
	
		String x = in.nextLine();
		
		if (x.equals("1"))
		{
			{
	 			ChatBotHossain chatbot1 = new ChatBotHossain();
	 		
	 			System.out.println ();
	 
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
		if (!x.equals("1") && !x.equals("2") && !x.equals("3"))
		{
			System.out.println("Please using # to select an operator.");
			main(null);
		}
		  
	}
}
