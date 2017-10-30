
public class ChatBotSun 
{
	public String hello()
	{
		return "Hey there cutie~";
	}
	
	public String getResponse(String statement)
	{
		String response = "";
		
		if (statement.length() == 0)
		{
			response = "Say something sweetheart";
		}
		return response;
	}
}
