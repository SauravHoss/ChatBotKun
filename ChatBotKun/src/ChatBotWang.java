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
		response = convo(mmwhatchusay);
		if (negPre(mmwhatchusay) == true)
		{
			response = getRandomResponse();
			depressionMeter --;
		}
		else if (mmwhatchusay.indexOf("thank you") != -1)
		{
			response = "You are welcome";
		}
		
		
		else if ( (findKeyword(mmwhatchusay, "yes") >=0 || findKeyword(mmwhatchusay, "okay") >= 0 
				|| findKeyword(mmwhatchusay, "sure") >=0) && a  >=3)
		{
			response = wordsearchPuzzle();
		}
		else if ((findKeyword(mmwhatchusay, "no") >=0 || findKeyword(mmwhatchusay, "nah") >=0 ) && a >= 3)
		{
			response =  "It's okay there is always next time";
		}
		
		else if (findKeyword(mmwhatchusay, "nevergiveup") >=0 || findKeyword(mmwhatchusay, "cheerful") >=0 || 
				findKeyword(mmwhatchusay, "optimistic") >=0  || findKeyword(mmwhatchusay, "joyful") >=0 
				|| findKeyword(mmwhatchusay, "brightside") >=0 || findKeyword(mmwhatchusay, "smile") >=0) 
		{
			wordsearchCounter(mmwhatchusay);
			int wrong = wordsearchCounter(mmwhatchusay);
			int right = 6 - wordsearchCounter(mmwhatchusay);		
			response = "you are missing" +" "+ wrong + " " + "word(s) and got" + " " + right + " " + "correct";
			if (wrong == 0)
			{
				return response = response + " " + "congratulatiosn you got them all right! now do you feel better?";
			}
			else if (wrong < 3)
			{
				response = response + " " + "so close!";
			}
			else if (wrong >= 3)
			{
				response = response + " " + "keep trying and never give up";
			}
		}
		
		
		else if (ifDie(mmwhatchusay) == 2 ) 
		{
			depressionMeter -=20;
			response = "Please don't say that, do you want to do a cross word puzzle instead?";
		}
		
		
		else if (ifDie(mmwhatchusay) == 1) 
		{
			depressionMeter += 20;
			response = "That is good to hear";
		}
		else if (depressionMeter <= -10 ) 
		{
			
		}
		else if (depressionMeter > -10 && depressionMeter < 0)
		{
			
		}
		else if (depressionMeter > 0)
		{
			
		}
		
		else 
		{
		
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
 		
 		if (mmwhatchusay.indexOf("dis") != -1  || findKeyword(mmwhatchusay, "hate") >=0 || mmwhatchusay.indexOf("il") != -1 
 				|| mmwhatchusay.indexOf("no") != -1)
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
		if (depressionMeter < 0 && depressionMeter > -10)
		{
			return randomCheerYouUpResponses [r.nextInt(randomCheerYouUpResponses.length)];
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
	private String [] randomCheerYouUpResponses = {"The future will always be better", "Don't worry everything will be fine", 
			"there is always someone out there that cares"};
	
	private String wordsearchPuzzle ()
	// words includes cheerful, joyful, nevergiveup, brightside, optimistic, smile 
	{
		return ("Let's go champ"
				+ System.lineSeparator() +
				"Please seperate the words with a space and phrases dont need spaces between words (hint there are 6 words/phrases)"
				+ System.lineSeparator() + "F A S Q C C Z D C B F C X U F"
				+ System.lineSeparator() + "I C W E D I S T H G I R B A B"
				+ System.lineSeparator() + "E J Q T F T X D E K I F C L I"
				+ System.lineSeparator() + "E M X R M S A T	E K W J T U U"
				+ System.lineSeparator() + "P L O U B I V D R C J C X I P"
				+ System.lineSeparator() + "W I I C T M Z D F F K J O X I"
				+ System.lineSeparator() + "E N R M Z I Z U U M K D Q G G"
				+ System.lineSeparator() + "G V P J S T V R L M I A V S E"
				+ System.lineSeparator() + "J L N Q Q P K F U I I N U B D"
				+ System.lineSeparator() + "O H T S N O K T J Z U K Q P I"
				+ System.lineSeparator() + "Y F A W J M S V	O H F Q E K C"
				+ System.lineSeparator() + "F R G D J H O J N H X J G K D"
				+ System.lineSeparator() + "U Q G G Q N R T C Q S W T C J"
				+ System.lineSeparator() + "L P B J J P C Q E R L G N U U"
				+ System.lineSeparator() + "Y N C K N E V E R G I V	E U P");
	}
	private int wordsearchCounter(String mmwhatchusay)
	{
		int wrong = 0;
		while (wrong <=6)
		{
			if (findKeyword(mmwhatchusay, "nevergiveup") <= -1 || findKeyword(mmwhatchusay, "cheerful")<= -1 || 
				findKeyword(mmwhatchusay, "optimistic") <=-1  || findKeyword(mmwhatchusay, "joyful") <=-1
				|| findKeyword(mmwhatchusay, "brightside") <=-1 || findKeyword(mmwhatchusay, "smile") <=-1) 
			{
				wrong ++;
				
			}
			return wrong;
		}
		return 0;
	}
	private String convo (String mmwhatchusay)
	{
		if (mmwhatchusay.length() == 0)
		{
			return "Hello is anyone one there?";
			
		}
		else if ( findKeyword(mmwhatchusay, "yes") >=0 && a == 2)
		{
			return "I ask again do you suffer from depression?";
		}
		else if (findKeyword(mmwhatchusay, "no") >=0 && a == 2)
		{
			return "hhmmmm I see someone is present. So I'll ask again, do you suffer from depression?";
		}
		else if (findKeyword(mmwhatchusay, "no") >=0 && (a == 3 || a == 1))
		{
			return  "Then you do no require my service, goodbye and have a nice day";
		}
		else if (findKeyword(mmwhatchusay, "yes") >=0 && (a == 3 || a == 1))
		{
			return  "why do you feel that way?";
		}
		return "";
	}

}
