package jswork;

public class factor2 {

    static int num=0;
	
	public static void main(String[] args) {	
	System.out.println("Number of factors of 2 in 1000:  " + factorOf2(1000));
	
	num =0;
	System.out.println("Number of factors of 2 in 5:  " + factorOf2(5));	
	
	num=0;
	System.out.println("Number of factors of 2 in 32:  " + factorOf2(32));	
	}

	private static int factorOf2 (int number) {
		
		// if number isn't further divisible by 2, then return the numerb of factors.
		if(number %2 == 1) return num;
				
		
		if (number % 2 == 0) 	// Checking, if number is fully divisible by 2 and no remadiner is left then
			++num;              // then is a factor of 2, thus adding 1 to it.
				
		return factorOf2(number/2);
	}
}

