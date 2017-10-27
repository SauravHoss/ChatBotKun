
public class ChatBotHossain 
{

	public String instahi() 
	{
		return "You got something to say?";
	}
	
	public String theybetalkin(String ugh) 
	{
		String blah = ugh.toLowerCase();
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
		
				
		
				 
	
		return wordz;
		
		
		
	}
}
