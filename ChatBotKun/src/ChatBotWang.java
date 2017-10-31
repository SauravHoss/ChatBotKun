
//Dave Wang depression help bot
public class ChatBotWang
{
	int depressionMeter = 0;
	public String getGreeting()
	{
		return "Hello this is the depression help bot service, do you currently suffer from depression?";
	}
	
	public String getResponse(String mmwhatchusay)
	{
		String response = "";
		
		 
		if (mmwhatchusay.length() == 0)
		{
			response = "Hello is anyone one there?";
		}
		else if (blankCounter(mmwhatchusay) == 1 && mmwhatchusay.equals("yes") && yesNoCounter(mmwhatchusay) ==0)
		{
			
			response = "I ask again do you suffer from depression?";
		}
		else if (blankCounter(mmwhatchusay) == 1 && mmwhatchusay.equals("no") && yesNoCounter(mmwhatchusay) ==0)
		{
			response = "hhmmmm I see someone is present. So I'll ask again, do you suffer from depression";
		}
		else if ((yesNoCounter(mmwhatchusay) ==1)&& mmwhatchusay.equals("no"))
		{
			response = "Then you do no require my service, goodbye and have a nice day";
		}
		else if ((yesNoCounter(mmwhatchusay) ==1) && mmwhatchusay.equals("yes"))
		{
			response = "why do you feel that way?";
		}
			
			
		else if (ifDie(mmwhatchusay) == true) {
			depressionMeter -=10;
			response = "Please don't say that";
		}
		else if (ifDie(mmwhatchusay) == false) 
			{
				depressionMeter += 10;
				response = "That is good to hear";
			}
		
		if (depressionMeter <= -10 ) {
			
		}
		
	return response; 
	
	}
	private boolean ifDie (String mmwhatchusay)
	{
		// checks for statements containing the feeling of wanting to die
		mmwhatchusay = mmwhatchusay.toLowerCase();
		if (findKeyword(mmwhatchusay, "I")>=0) 
		{
			if ((findKeyword(mmwhatchusay, "dont") >=0 || findKeyword(mmwhatchusay, "don't") >=0) && findKeyword(mmwhatchusay, "die") >= 0)
			{
				return false;	
			}			
			else if ((findKeyword(mmwhatchusay, "die") >= 0) && findKeyword(mmwhatchusay, "want to") >=0)
			{
				return true;
			}
			else if ((findKeyword(mmwhatchusay, "dont") >=0 || findKeyword(mmwhatchusay, "don't") >=0) && findKeyword(mmwhatchusay, "live") >= 0) 
			{
				return true;
			}
				
	}
		
	return false;

	}
	private int findKeyword(String mmwhatchusay, String goal, int startPos)
 	{
 		String phrase = mmwhatchusay.trim().toLowerCase();
 		goal = goal.toLowerCase();

 		// The only change to incorporate the startPos is in
 		// the line below
 		int psn = phrase.indexOf(goal, startPos);

 		// Refinement--make sure the goal isn't part of a
 		// word
 		while (psn >= 0)
 		{
 			// Find the string of length 1 before and after
 			// the word
 			String before = " ", after = " ";
 			if (psn > 0)
 			{
 				before = phrase.substring(psn - 1, psn);
 			}
 			if (psn + goal.length() < phrase.length())
 			{
 				after = phrase.substring(
 						psn + goal.length(),
 						psn + goal.length() + 1);
 			}

 			// If before and after aren't letters, we've
 			// found the word
 			if (((before.compareTo("a") < 0) || (before
 					.compareTo("z") > 0)) // before is not a
 											// letter
 					&& ((after.compareTo("a") < 0) || (after
 							.compareTo("z") > 0)))
 			{
 				return psn;
 			}

 			// The last position didn't work, so let's find
 			// the next, if there is one.
 			psn = phrase.indexOf(goal, psn + 1);

 		}

 		return -1;
 	}
 	
 	/**
 	 * Search for one word in phrase.  The search is not case sensitive.
 	 * This method will check that the given goal is not a substring of a longer string
 	 * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
 	 * @param statement the string to search
 	 * @param goal the string to search for
 	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
 	 */
 	private int findKeyword(String mmwhatchusay, String goal)
 	{
 		return findKeyword (mmwhatchusay, goal, 0);
 	}
 	private int yesNoCounter (String mmwhatchusay)
 	// basically a way for the program to check how many yes/ no were said so the chatbot knows what to respond with
 	// excpet the thing doesn't save its value which sucks
	{
 		int a = 0;
 		while (a >= -3)
 		{
 			if (mmwhatchusay.length()==0) 
 			{
 			a --;	
 			}
 			if ((findKeyword(mmwhatchusay, "no" )) >= 0 || findKeyword(mmwhatchusay, "yes" ) >=0 )
 			{
			a ++;
 			}
 			
 			return a;
 		}
 		return 0;
 	}
 	private int blankCounter (String mmwhatchusay)
 	// basically a way for the program to check how many times you responded with a blank statement
 	{
 		int a = 0;
 		while (a >= 0)
 		{
 			if (mmwhatchusay.length() ==0 )
		{
			a ++;
			
		}
 		return a;
 		}
 		return 0;
 	}
 	
}

