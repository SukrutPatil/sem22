package calculator;

import java.util.Scanner;


/**
 * <p> Title: CalculatorValue Class. </p>
 * 
 * <p> Description: A component of a JavaFX demonstration application that performs computations </p>
 * 
 * <p> Copyright: Lynn Robert Carter © 2017 </p>
 * 
 * @author Lynn Robert Carter ; Sukrut Patil
 * 
 * @version 4.2	2018-02-25 Double float implementation of the CalculatorValue class 
 * 
 */
public class CalculatorValue {
	
	/**********************************************************************************************

	Attributes
	
	**********************************************************************************************/
	
	// These are the major values that define a calculator value
	double measuredValue = 0;
	String errorMessage = "";
	
	String zeroMessage ="Invalid Input";                // this defines the error message when the divisor is zero
	public static String measuredValueErrorMessage = "";	// The alternate error message text
	public static String measuredValueInput = "";		// The input being processed
	public static int measuredValueIndexofError = -1;		// The index where the error was located
	public static int state = 0;						// The current state value
	public static int nextState = 0;					// The next state value
	public static boolean finalState = false;			// Is this state a final state
	private static String inputLine = "";				// The input line
	private static char currentChar;						// The current character in the line
	private static int currentCharNdx;					// The index of the current character
	private static boolean running;						// The flag that specifies if it is running
	
	
	/**********************************************************************************************

	Constructors
	
	**********************************************************************************************/

	/*****
	 * This is the default constructor
	 */
	public CalculatorValue() {
	}

	/*****
	 * This constructor creates a calculator value based on a long integer. For future calculators, it
	 * is best to avoid using this constructor.
	 */
	public CalculatorValue(double s) {
		measuredValue = s;
	}

	/*****
	 * This copy constructor creates a duplicate of an already existing calculator value
	 */
	public CalculatorValue(CalculatorValue s) {
		measuredValue = s.measuredValue;
		errorMessage = s.errorMessage;
	}

	/*****
	 * This constructor creates a calculator value from a string... Due to the nature
	 * of the input, there is a high probability that the input has errors, so the 
	 * routine returns the value with the error message value set to empty or the string 
	 * of an error message.
	 */
	public CalculatorValue(String character) {
		measuredValue = 0;
		if (character.length() == 0) {							     	// If there is nothing in the text field,
			errorMessage = "***Error*** Input is empty";		// signal an error	
			return;												
		}
		                                                     // If the first character is a plus sign, ignore it.
		int start = 0;										// Start at character position zero
		boolean negative = false;							// Assume the value is not negative
		
		if (character.charAt(start) == '+')							// See if the first character is '+'
			 start++;										// If so, skip it and ignore it
		
		// If the first character is a minus sign, skip over it, but remember it
		else if (character.charAt(start) == '-'){					// See if the first character is '-'
			start++;											// if so, skip it
			negative = true;									// but do not ignore it
		}
		
		// See if the user-entered string can be converted into an integer value

		                                                               // See if the user-entered string can be converted into an double value
		Scanner tempScanner = new Scanner(character.substring(start));// Create scanner for the digits
		if (!tempScanner.hasNextDouble()) {				           	// See if the next token is a valid
			errorMessage = "***Error*** Invalid value"; 		
			tempScanner.close();								
			return;												
		}
		
		
		measuredValue = tempScanner.nextDouble();				// Convert the value and check to see
		if (tempScanner.hasNext()) {							// that there is nothing else is 
			errorMessage = "***Error*** Excess data"; 		// following the value.  If so, it
			tempScanner.close();								// is an error.  Therefore we must
			measuredValue = 0;								// return a zero value.
			return;													
		}
		tempScanner.close();
		errorMessage = "";
		if (negative)										// Return the proper value based
			measuredValue = -measuredValue;					// on the state of the flag that
	}

	/**********************************************************************************************

	Getters and Setters
	
	**********************************************************************************************/
	
	/*****
	 * This is the start of the getters and setters
	 * 
	 * Get the error message
	 */
	public String getErrorMessage(){
		return errorMessage;
	}
	public String getZeroMessage () {
		return zeroMessage;                            // getter when the value of divisor is 0
		
	}
	
	/*****
	 * Set the current value of a calculator value to a specific long integer
	 */
	public void setValue(double s){
		measuredValue = s;
	}
	
	/*****
	 * Set the current value of a calculator error message to a specific string
	 */
	public void setErrorMessage(String q){
		errorMessage = q;
	}
	public void setZeroMessage (String w){
		zeroMessage = w;                                  // setter when the value of divisor is 0
	}
	
	/*****
	 * Set the current value of a calculator value to the value of another (copy)
	 */
	public void setValue(CalculatorValue s){
		measuredValue = s.measuredValue;
		errorMessage = s.errorMessage;
	}
	
	/**********************************************************************************************

	The toString() Method
	
	**********************************************************************************************/
	
	/*****
	 * This is the default toString method
	 * 
	 * When more complex calculator values are creating this routine will need to be updated
	 */
	public String toString() {
		return measuredValue + "";
	}
	
	/*****
	 * This is the debug toString method
	 * 
	 * When more complex calculator values are creating this routine will need to be updated
	 */
	public String debugToString() {
		return "measuredValue = " + measuredValue + "\nerrorMessage = " + errorMessage + "\n";
	}

	
	/**********************************************************************************************

	The computation methods
	
	**********************************************************************************************/
	

	/*******************************************************************************************************
	 * The following methods implement computation on the calculator values.  These routines assume that the
	 * caller has verified that things are okay for the operation to take place.  These methods understand
	 * the technical details of the values and their reputations, hiding those details from the business 
	 * logic and user interface modules.
	 * 
	 * Since this is addition and we do not yet support units, we don't recognize any errors.
	 */
	
	public void add(CalculatorValue v) {
		measuredValue += v.measuredValue;
		errorMessage = "";
	}

	/*****
	 * For subtraction  
	 * @param s
	 */
	public void sub(CalculatorValue s) {
		measuredValue -= s.measuredValue;
		errorMessage = "";
	}
	
	/*****
	 * For multiplication  
	 * @param v
	 */

	public void mpy(CalculatorValue s) {
		measuredValue *= s.measuredValue;
		errorMessage = "";
	}
	
	/*****
	 * For division  
	 * @param v
	 */

	public void div(CalculatorValue s) {
		
		measuredValue /= s.measuredValue;
		errorMessage = "";
		
	}
	
	/*****
	 * For square root only one operand is required, thus operation is only performed over 
	 * measuredValue only
	 * 
	 * @param v
	 */
	public void sqrt(CalculatorValue s){                       
		                                                
   		measuredValue = Math.sqrt(measuredValue);          
		errorMessage = "";                         
		
	}

	private static String displayInput(String input, int currentCharNdx) {
		// Display the entire input line
		String result = input + "\n";

		// Display a line with enough spaces so the up arrow point to the point of an error
		for (int ndx=0; ndx < currentCharNdx; ndx++) result += " ";

		// Add the up arrow to the end of the second line
		return result + "\u21EB";				// A Unicode up arrow with a base
	}


	private static void moveToNextCharacter() {
		currentCharNdx++;
		if (currentCharNdx < inputLine.length())
			currentChar = inputLine.charAt(currentCharNdx);
		else {
			currentChar = ' ';
			running = false;
		}
	}

	/**********
	 * This method is a mechanical transformation of a Finite State Machine diagram into a Java
	 * method.
	 * 
	 * @param input		The input string for the Finite State Machine
	 * @return			An output string that is empty if every things is okay or it will be
	 * 						a string with a help description of the error follow by two lines
	 * 						that shows the input line follow by a line with an up arrow at the
	 *						point where the error was found.
	 */
	public static String checkMeasureValue(String input) {
		if(input.length() <= 0) return "";
		// The following are the local variable used to perform the Finite State Machine simulation
		state = 0;							// This is the FSM state number
		inputLine = input;					// Save the reference to the input line as a global
		currentCharNdx = 0;					// The index of the current character
		currentChar = input.charAt(0);		// The current character from the above indexed position

		// The Finite State Machines continues until the end of the input is reached or at some 
		// state the current character does not match any valid transition to a next state

		measuredValueInput = input;			// Set up the alternate result copy of the input
		running = true;						// Start the loop
		

		// The Finite State Machines continues until the end of the input is reached or at some 
		// state the current character does not match any valid transition to a next state
		while (running) {
			// The switch statement takes the execution to the code for the current state, where
			// that code sees whether or not the current character is valid to transition to a
			// next state
			switch (state) {
			case 0: 
				// State 0 has three valid transitions.  Each is addressed by an if statement.
				
				// This is not a final state
				finalState = false;
				
				// If the current character is in the range from 1 to 9, it transitions to state 1
				if (currentChar >= '0' && currentChar <= '9') {
					nextState = 1;
					break;
				}
				// If the current character is a decimal point, it transitions to state 3
				else if (currentChar == '.') {
					nextState = 3;
					break;					
				}
				
				else if(currentChar =='-') {
					nextState = 0;
					break;
				}
				
				// If it is none of those characters, the FSM halts
				else 
					running = false;
				
				// The execution of this state is finished
				break;
			
			case 1: 
				// State 1 has three valid transitions.  Each is addressed by an if statement.
				
				// This is a final state
				finalState = true;
				
				// In state 1, if the character is 0 through 9, it is accepted and we stay in this
				// state
				if (currentChar >= '0' && currentChar <= '9') {
					nextState = 1;
					break;
				}
				
				// If the current character is a decimal point, it transitions to state 2
				else if (currentChar == '.') {
					nextState = 2;
					break;
				}
				// If the current character is an E or an e, it transitions to state 5
				else if (currentChar == 'E' || currentChar == 'e') {
					nextState = 5;
					break;
				}
				// If it is none of those characters, the FSM halts
				else
					running = false;
				
				// The execution of this state is finished
				break;			
				
			case 2: 
				// State 2 has two valid transitions.  Each is addressed by an if statement.
				
				// This is a final state
				finalState = true;
				
				// If the current character is in the range from 1 to 9, it transitions to state 1
				if (currentChar >= '0' && currentChar <= '9') {
					nextState = 2;
					break;
				}
				// If the current character is an 'E' or 'e", it transitions to state 5
				else if (currentChar == 'E' || currentChar == 'e') {
					nextState = 5;
					break;
				}

				// If it is none of those characters, the FSM halts
				else 
					running = false;

				// The execution of this state is finished
				break;
	
			case 3:
				// State 3 has only one valid transition.  It is addressed by an if statement.
				
				// This is not a final state
				finalState = false;
				
				// If the current character is in the range from 1 to 9, it transitions to state 1
				if (currentChar >= '0' && currentChar <= '9') {
					nextState = 4;
					break;
				}

				// If it is none of those characters, the FSM halts
				else 
					running = false;

				// The execution of this state is finished
				break;

			case 4: 
				// State 4 has two valid transitions.  Each is addressed by an if statement.
				
				// This is a final state
				finalState = true;
				
				// If the current character is in the range from 1 to 9, it transitions to state 4
				if (currentChar >= '0' && currentChar <= '9') {
					nextState = 4;
					break;
				}
				// If the current character is an 'E' or 'e", it transitions to state 5
				else if (currentChar == 'E' || currentChar == 'e') {
					nextState = 5;
					break;
				}

				// If it is none of those characters, the FSM halts
				else 
					running = false;

				// The execution of this state is finished
				break;

			case 5: 
                 //State 5 has two valid transitions.  Each is addressed by an if statement.
				
				
				finalState = false;
				
				// If the current character is in the range from 1 to 9, it transitions to state 4
				if (currentChar >= '0' && currentChar <= '9') {
					nextState = 7;
					break;
				}
				// If the current character is an 'E' or 'e", it transitions to state 5
				else if (currentChar == '+' || currentChar == '-') {
					nextState = 6;
					break;
				}

				// If it is none of those characters, the FSM halts
				else 
					running = false;

				// The execution of this state is finished
				break;

			case 6: 
                 //State 6 has one valid transitions.  It is addressed by an if statement.
				
				
				finalState = false;
				
				// If the current character is in the range from 1 to 9, it transitions to state 4
				if (currentChar >= '0' && currentChar <= '9') {
					nextState = 7;
					break;
				}
				
				// If it is none of those characters, the FSM halts
				else 
					running = false;

				// The execution of this state is finished
				break;

			case 7: 
                  //State 7 has one valid transitions.  It is addressed by an if statement.
				
				// This is a final state
				finalState = true;
				
				// If the current character is in the range from 1 to 9, it transitions to state 4
				if (currentChar >= '0' && currentChar <= '9') {
					nextState = 7;
					break;
				}
				 
				// If it is none of those characters, the FSM halts
				else 
					running = false;

				// The execution of this state is finished
				break;
				
			}
			
			if (running) {
				
				// When the processing of a state has finished, the FSM proceeds to the next character
				// in the input and if there is one, it fetches that character and updates the 
				// currentChar.  If there is no next character the currentChar is set to a blank.
				moveToNextCharacter();
				
				// Move to the next state
				state = nextState;

			}
			// Should the FSM get here, the loop starts again

		}

		measuredValueIndexofError = currentCharNdx;		// Copy the index of the current character;
		
		// When the FSM halts, we must determine if the situation is an error or not.  That depends
		// of the current state of the FSM and whether or not the whole string has been consumed.
		// This switch directs the execution to separate code for each of the FSM states.
		switch (state) {
		case 0:
			// State 0 is not a final state, so we can return a very specific error message
			measuredValueIndexofError = currentCharNdx;		// Copy the index of the current character;
			measuredValueErrorMessage = "The first character must be a digit or a decimal point.";
			return "The first character must be a \"+\" sign, digit a decimal point.";

		case 1:
			// State 1 is a final state, so we must see if the whole string has been consumed.
			if (currentCharNdx<input.length()) {
				// If not all of the string has been consumed, we point to the current character
				// in the input line and specify what that character must be in order to move
				// forward.
				measuredValueErrorMessage = "This character may only be an \"E\", an \"e\", a digit, "
						+ "a \".\", or it must be the end of the input.\n";
				return measuredValueErrorMessage + displayInput(input, currentCharNdx);
			}
			else {
				measuredValueIndexofError = -1;
				measuredValueErrorMessage = "";
				return measuredValueErrorMessage;
			}

		case 2:
		case 4:
			// States 2 and 4 are the same.  They are both final states with only one possible
			// transition forward, if the next character is an E or an e.
			if (currentCharNdx<input.length()) {
				measuredValueErrorMessage = "This character may only be an \"E\", an \"e\", a digit or it must"
						+ " be the end of the input.\n";
				return measuredValueErrorMessage + displayInput(input, currentCharNdx);
			}
			// If there is no more input, the input was recognized.
			else {
				measuredValueIndexofError = -1;
				measuredValueErrorMessage = "";
				return measuredValueErrorMessage;
			}
		case 3:
		case 6:
			// States 3, and 6 are the same. None of them are final states and in order to
			// move forward, the next character must be a digit.
			measuredValueErrorMessage = "This character may only be a digit.\n";
			return measuredValueErrorMessage + displayInput(input, currentCharNdx);

		case 7:
			// States 7 is similar to states 3 and 6, but it is a final state, so it must be
			// processed differently. If the next character is not a digit, the FSM stops with an
			// error.  We must see here if there are no more characters. If there are no more
			// characters, we accept the input, otherwise we return an error
			if (currentCharNdx<input.length()) {
				measuredValueErrorMessage = "This character may only be a digit.\n";
				return measuredValueErrorMessage + displayInput(input, currentCharNdx);
			}
			else {
				measuredValueIndexofError = -1;
				measuredValueErrorMessage = "";
				return measuredValueErrorMessage;
			}

		case 5:
			// State 5 is not a final state.  In order to move forward, the next character must be
			// a digit or a plus or a minus character.
			measuredValueErrorMessage = "This character may only be a digit, a plus, or minus "
					+ "character.\n";
			return measuredValueErrorMessage + displayInput(input, currentCharNdx);
			
					
		default:
			return "";
		}
	}
	
}
