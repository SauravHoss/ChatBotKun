
public class ChatBotWang
{
	int depressionMeter = 0;
	public String getGreeting()
	{
		return "Hello how can I help you?";
	}
	
	public String getResponse(String mmwhatchusay)
	{
		String response = "";
		
		if (mmwhatchusay.length() == 0)
		{
			response = "Hello is anyone one there?";
		}
		else if (ifDie(mmwhatchusay) == true)
		{
			depressionMeter -=10;
			response = "That is not normal you should go get help";
		}
		else if 
		
	
		
	
		return response;
	}
	private boolean ifDie (String mmwhatchusay)
	{
		mmwhatchusay = mmwhatchusay.toLowerCase();
		if (mmwhatchusay.indexOf("I")== 0) {
			if ((mmwhatchusay.indexOf("dont")!= -1 || mmwhatchusay.indexOf("dont")!= -1) && mmwhatchusay.lastIndexOf("die") != 1)
			{
				return false;
			}
			if (mmwhatchusay.lastIndexOf("die") == 0) 
			{
				return true;
			}
			if (mmwhatchusay.indexOf("want to") != -1) {
				int x = mmwhatchusay.indexOf("die");
				if (mmwhatchusay.substring(x-1,x).equals(" ") && mmwhatchusay.substring(x+3,x+4).equals(" "))
				{
					return true;
				}
			}
		}
		return false;
	}
	

}
