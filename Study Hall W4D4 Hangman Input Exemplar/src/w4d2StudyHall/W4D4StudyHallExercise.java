package w4d2StudyHall;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
public class W4D4StudyHallExercise {

	/**********************************************************************************************
	 * The following static variables are used by the main method to hold the key state and 
	 * objects that must exist and be available across the various methods of this class (the
	 * mainline).
	 */

	static Scanner keyboard = new Scanner(System.in);		// The scanner for the keyboard
	static String [] secretWords;						// This array holds the secret words
	static Random random = new Random();					// A random number generator
	private static String userName;
	private static String inputFromUser;
	private static char menuCharacter;
	/**********
	 * This private method reads in a list of words from a specified input file
	 * 
	 * @param theFileName	A String parameter that specifies the name of the file to use
	 * @return				The methods returns an array of words if the file is there
	 * 
	 * @exception			A File not found exception results in program termination
	 */
	public static String displayVersion(String theWord, String theGuessedLetters) {
		// Make a copy of the input parameter
		String theResult = theWord;
		
		// Set up a local variable to hold each of the letters in theWord
		char aCharacter = '?';		
		
		// Use a For Loop to access each and every letter in theWord
		for (int ndx = 0; ndx < theWord.length(); ndx++) {
			
			// Access each letter, one at a time, from theWord
			aCharacter = theWord.charAt(ndx);
			
			// Check to see if that letter appears somewhere in theGuessedLetters
			if (theGuessedLetters.indexOf(aCharacter) != -1)
				
				// If so, replace all occurrences of it with a question mark
				theResult = theResult.replace(aCharacter, '?');
		}
		
		// Return the word with all unguessed letters being replaced by question marks
		return theResult;
	}
	
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Welcome!");
		System.out.println("Please Enter Your Name");
		String userName = keyboard.next();
		System.out.println(userName+", "+"Please enter command letter");
		System.out.println("p-> Play the game");
		System.out.println("s-> View Statistics");
		System.out.println("q-> Quit");
		while(true)	 {
		 String inputFromUser =keyboard.next();
	
	
		 if (inputFromUser.equals("p"))
		 {
			 System.out.println(userName +", "+"Please enter command letter");
			 System.out.println("p-> Play the game");
				System.out.println("s-> View Statistics");
				System.out.println("q-> Quit");
		 
		 }
		     else if (inputFromUser.equals("q"))
		 {
		     System.out.println("Thanks for playing");
		   
		 }	 
		     else if (inputFromUser.equals("s"))
			 {
		    	 System.out.println(userName+", "+"Please enter command letter");
		    	 System.out.println("p-> Play the game");
					System.out.println("s-> View Statistics");
					System.out.println("q-> Quit");
		  
			 }	 
		     else if (inputFromUser!="s")
			 {
		    	 System.out.println("***Error*** Invalid menu itom.");
			    System.out.println("The input was"+" "+inputFromUser);
			 }	 
		     else if (inputFromUser!="p")
			 {
		    	 System.out.println("***Error*** Invalid menu itom.");
			  
		
			 }
		 else if (inputFromUser!="q")
			 {
		    	 System.out.println("***Error*** Invalid menu itom.");
		    	 break;  
			 }
		
		
		
			/* Play the game? */

			/* View the statistics? */

			/* Quit the game? */

			/* Display error (if command is none of the above) */
		// Try to read in the array of words and store them into the class instance variable
		}
		 }
	

	
	

		// If we get here, it means that the file containing the secret words properly start with
		// an integer. We then use that integer to allocate an array of just the right size 
		String [] words = new String[numWords];

		// We then use the size to drive a for loop to read in the words and store them into
		// the array, converting the letters to UPPER CASE
		for (int ndx = 0; ndx < numWords; ndx ++)
			if (fileReader.hasNext())
				words[ndx] = fileReader.next().toUpperCase();
			else {
				// If we get here, it means that we have run out of words to be read in before we
				// have filled the array of words.  Therefore, we will inform the user of this 
				// error condition and terminate the program.
				System.out.println("*** Error *** The file does not contain enough secret word to "
						+ "satisfy the number specified at the beginning of the file!");
				System.out.println("The program terminates with an error now.");
				System.exit(0);
			}
		// If we get here, it means we found enough words to fill the array, but there may still 
		// have a problem.  There could be more words left in the file, so this check sees if the
		// fileReader has exhausted all of the data in the file.

		if (fileReader.hasNext()) {
			// If we get here, there is more data in the file, when it should be at the end, so
			// we will issue another error message to address this situation.
			System.out.println("*** Error *** The file has provided enough data to satisfy the "
					+ "the integer at the beginning of the file, but there is more data left "
					+ "to be read!");
			System.out.println("The program terminates with an error now.");
		System.exit(0);
		}

		return words;
	}

	
		

}
