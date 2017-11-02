import java.util.Random;

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
		mmwhatchusay = mmwhatchusay.toLowerCase();
		String response = "";
		a ++;
		if (mmwhatchusay.length() == 0)
		{
			response = "Hello is anyone one there?";
			
		}
		else if ( mmwhatchusay.equals("yes") && a == 2)
		{
			response = "I ask again do you suffer from depression?";
		}
		else if (mmwhatchusay.equals("no") && a == 2)
		{
			response = "hhmmmm I see someone is present. So I'll ask again, do you suffer from depression?";
		}
		else if (mmwhatchusay.equals("no") && (a == 3 || a == 1))
		{
			response = "Then you do no require my service, goodbye and have a nice day";
		}
		else if (mmwhatchusay.equals("yes") && (a == 3 || a == 1))
		{
			response = "why do you feel that way?";
		}
		else if (negPre(mmwhatchusay) == true)
		{
			response = getRandomResponse();
			depressionMeter --;
		}
		else if (mmwhatchusay.indexOf("thank you") != -1)
		{
			response = "You are welcome";
		}
		
		else if (ifDie(mmwhatchusay) == 2) {
			depressionMeter -=20;
			response = "Please don't say that, instead lets play a game";
		}
		else if (ifDie(mmwhatchusay) == 1) 
			{
				depressionMeter += 20;
				response = "That is good to hear";
			}
		else if (depressionMeter <= -20 ) 
		{
			
		}
		else if (depressionMeter > -20 && depressionMeter < 0)
		{
			
		}
		if (depressionMeter > 0)
		{
			
		}
		
		else 
		{
			response = getRandomResponse();
		}
		
		
	return response; 
	
	}
	private int ifDie (String mmwhatchusay)
	{
		// checks for statements containing the feeling of wanting to die
		mmwhatchusay = mmwhatchusay.toLowerCase();
		if (findKeyword(mmwhatchusay, "I")>=0) 
		{
			if ((findKeyword(mmwhatchusay, "dont") >=0 || findKeyword(mmwhatchusay, "don't") >=0) && findKeyword(mmwhatchusay, "die") >= 0)
			{
				return 1;	
			}			
			else if ((findKeyword(mmwhatchusay, "die") >= 0) && findKeyword(mmwhatchusay, "want to") >=0)
			{
				return 2;
			}
			else if ((findKeyword(mmwhatchusay, "dont") >=0 || findKeyword(mmwhatchusay, "don't") >=0) && findKeyword(mmwhatchusay, "live") >= 0) 
			{
				return 2;
			}
			else if (findKeyword(mmwhatchusay,"kill") >= 0 && findKeyword(mmwhatchusay,"myself") >=0)	
			{
				return 2;
			}
		}
		
	return 0;

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
 	private boolean negPre (String mmwhatchusay)
 	// looks for negative prefixes/words to lower depression meter
 	{
 		
 		if (mmwhatchusay.indexOf("dis") != -1 || mmwhatchusay.indexOf("il") != -1 || findKeyword(mmwhatchusay, "hate") >=0)
 		{
 			return true;
 		}
 		return false;
 	}
 	private String getRandomResponse ()
	{
		Random r = new Random ();
		if (depressionMeter == 0)
		{	
			return randomNeutralResponses [r.nextInt(randomNeutralResponses.length)];
		}
		if (depressionMeter < 20)
		{	
			return randomYouNeedHelpResponses [r.nextInt(randomYouNeedHelpResponses.length)];
		}	
		return randomCheerYouUpResponses [r.nextInt(randomCheerYouUpResponses.length)];
	}
	
	private String [] randomNeutralResponses = {"Interesting, tell me more",
			"Hmmm.",
			"Do you really think so?",
			"You don't say.",
			"It's all boolean to me.",
			"So, would you like to go for a walk?",
			"Could you say that again?"
	};
	private String [] randomYouNeedHelpResponses = {"Bahumbug.", "Harumph", "The rage consumes me!"};
	private String [] randomCheerYouUpResponses = {"H A P P Y, what's that spell?", "Today is a good day", "You make me feel like a brand new pair of shoes."};
	private void crossWordPuzzle ()
	// words includes happy, live, love, intelligent, optimistic, sunny, lively, 
	{
		System.out.println("please seperate the words with a space (hint there are 7 word)");
		System.out.println("C G X R I I O Q H L O V E J E V Q O");
		System.out.println("N D T H N Q P W L Q A A V Q P T U X");
		System.out.println("O M F Y T S T Y S I P U F E X R G A");
		System.out.println("W A V B E Z I Y U U V H Z O F U S C");
		System.out.println("D F H K L C M E F X N E O P C D K E");
		System.out.println("U W A K L O I T Q M A N L G H X B G");
		System.out.println("G S P R I J S J G F D A Y Y V R B A");
		System.out.println("C M P M G N T I G Y O E B N H L D M");
		System.out.println("X O Y Z E M I Z M B K R P H B I U A");
		System.out.println("E P A F N Z C T R V W O C L P V A J");
		System.out.println("W M J H T S H W J W N C L F Q E O N");
		System.out.println("T Z A X N P K P R S E L E F F G G Z");
												
	}
	
	private int crosswordCounter(String mmwhatchusay)
	{
		mmwhatchusay = mmwhatchusay.toLowerCase();
		if (findKeyword(mmwhatchusay, "lively") >=0 && findKeyword(mmwhatchusay, "live") >=0 && findKeyword(mmwhatchusay, "optimistic") >=0
			&& findKeyword(mmwhatchusay, "intelligent") >=0 && findKeyword(mmwhatchusay, "sunny") >=0 && findKeyword(mmwhatchusay, "happy") >=0
			&& findKeyword(mmwhatchusay, "love") >=0) 
		{
			return (7);
		}
		
		return 0;
	}
}



