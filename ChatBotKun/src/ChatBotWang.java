

//Dave Wang depression help bot
/* conversation flow
	after input is yes for depression say why are you depressed
		input statement will be because "blank" or something along the lines (maybe do something with 
										      transform because statement)
			respond with random cheer you up statements (i.e things can only get better etc, cheer up) works with 
			depressionmeter -- if it gets to a high enough number respond with consult a professional
			if detecting thank you respond you welcome;
			then detect statements like ("i feel better or i feel great now") and return a statement and end the program
	if detects want to die, respond with a bunch of information regarding suicide prevention and terminate the program with consult professional and not the chatbot
*/
public class ChatBotWang
{
	
	int a = 0;
	int depressionMeter = 0;
	public String getGreeting()
	{
 		return "Hello this is the depression help bot service, do you currently suffer from depression?";
	}
	public String getResponse(String mmwhatchusay)
	{
		String response = "";
		a ++;
		if (mmwhatchusay.length() == 0)
		{
			response = "Hello is anyone one there?";
			
		}
		else if ( mmwhatchusay.equals("yes") && a == 2)
		{
			
			response = "I ask again do you suffer from depression?";
			a = a ++;
		}
		else if (mmwhatchusay.equals("no") && a == 2)
		{
			response = "hhmmmm I see someone is present. So I'll ask again, do you suffer from depression";
			a =a ++;
		}
		else if (mmwhatchusay.equals("no") && (a == 3 || a == 1))
		{
			response = "Then you do no require my service, goodbye and have a nice day";
			a = a ++;
		}
		else if (mmwhatchusay.equals("yes") && (a == 3 || a == 1))
		{
			response = "why do you feel that way?";
			a ++;
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
	public static int findKeyword(String mmwhatchusay, String goal, int startPos)
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
 	public static int findKeyword(String mmwhatchusay, String goal)
 	{
 		return findKeyword (mmwhatchusay, goal, 0);
 	}
 	
 	
 	
}
