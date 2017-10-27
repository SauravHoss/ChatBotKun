
public class ChatBotWang
{
	int depressionMeter = 0;
	public String getGreeting()
	{
		return "Hi, what is up?";
	}
	
	public String getResponse(String mmwhatchusay)
	{
		String response = "";
		
		if (mmwhatchusay.length() == 0)
		{
			response = "Hello is anyone one there?";
		}
		else if (mmwhatchusay.indexOf("yes")!=-1)
		{
			response = "Hello how may I help you";
		}
		
	
		
	
	
	}
	private boolean ifDie (String mmwhatchusay)
	{
		mmwhatchusay = mmwhatchusay.toLowerCase();
		if (mmwhatchusay.indexOf("I")!=0) {
			if (mmwhatchusay.indexOf("want to") !=0) {
				int x = mmwhatchusay.indexOf("die");
				if (mmwhatchusay.substring(x-1,x).equals(" ") && mmwhatchusay.substring(x+3,x+4).equals(" "))
				{
					return true;
				}
			}
		}
		
	}
	

}
