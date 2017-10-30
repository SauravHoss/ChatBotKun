
public class ChatBotHossain 
{

	public String instahi() 
	{
		return "You got something to say?";
	}
	
	public String theybetalkin(String x) 
	{
		String blah = x.toLowerCase();
		String wordz = "";
		if (blah.length() == 0) 
		{
			wordz = "You gonna say something?";
		}
		
		else if (blah.contains("lol"))
		{
			wordz = "Say 'kek' instead you normie";
		}
		
		else if (blah.contains("hello") || blah.contains("hi") || blah.contains("hey") || blah.contains("greetings") || blah.contains("sup")) 
		{
			wordz = "What's crakalakin homie";
		}
		
		else if (blah.contains("don't want to live") || blah.contains("don't wanna to live"))
		{
			wordz = "Now you listen to me and listen good. Killing yourself is the most selfish thing you have could ever do. When you kill yourself you are hurting everyone who loves you to an unbearable extent. "
					+ "If you are too much of a wimp to live by yourself then live for those who can't bear to see you die." ;
		}
				
		
				 
	
		return wordz;
		
		
		
	}
}
