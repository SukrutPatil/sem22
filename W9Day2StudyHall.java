package studyHall;
import java.util.Scanner;
public class addition {
static Scanner sp = new Scanner(System.in);
public static String adder(double mv1 ,double et1 ,double mv2 ,double et2) {
	double upperBound1 = mv1 + et1;
	double lowerBound1 = mv1 - et1;
	double upperBound2 = mv2 + et2;
	double lowerBound2 = mv2 - et2;
	double addUb =  upperBound1 +  upperBound2;
	double addLb = lowerBound1 +  lowerBound2;
	double answer = (addUb  + addLb)/2;
	double answerET = (addUb-addLb)/2;
	String sum = String.valueOf(answer)+" \u00B1 "+ String.valueOf(answerET);
	return sum;
}
	public static String subtractor(double mv1 ,double et1 ,double mv2 ,double et2) {
		double upperBound1 = mv1 + et1;
		double lowerBound1 = mv1 - et1;
		double upperBound2 = mv2 + et2;
		double lowerBound2 = mv2 - et2;
		double subUb =  upperBound1 -  upperBound2;
		double subLb = lowerBound1 -  lowerBound2;
		double answer = (subUb  + subLb)/2;
		double answerET = (subUb - subLb)/2;
		String subtract = String.valueOf(answer)+" \u00B1 "+ String.valueOf(answerET);
		return subtract;
}


public static void main (String[] args ) {
System.out.println("This is error term calculator by Sukrut Patil");
System.out.println("Input first term\n");
double firstTerm = sp.nextDouble();
System.out.println("Input error term 1 term\n");
double et1Term = sp.nextDouble();
System.out.println("Input second term\n");
double secondTerm = sp.nextDouble();
System.out.println("Input error term 2 term\n");
double et2Term = sp.nextDouble();
System.out.println("Select the operation + or - ");
String operator = sp.next();
if (operator.equals("+"))
{
String TV = adder(firstTerm, et1Term, secondTerm, et2Term);
System.out.println(TV);
}
else if (operator.equals("-"))
{
	String TV1 = subtractor(firstTerm, et1Term, secondTerm, et2Term);
	System.out.println(TV1);
}
else {
	System.out.println("Invalid input: Program Terminated");
}
}
}
