package studyHall;
import java.util.Scanner;
public class addition {
static Scanner sp = new Scanner(System.in);
public static String multiplyer(double mv1 ,double et1 ,double mv2 ,double et2) {
	double ef1 = et1/mv1 ;
	double ef2 = et2/mv2 ;
	double multi1 = mv1 * mv2 ;
	double addef =  ef1 + ef2 ;
	double multi2 = multi1 * addef ;
	String multiply = String.valueOf(multi1)+" \u00B1 "+ String.valueOf(multi2);
	return multiply;
}
public static String divider(double mv1 ,double et1 ,double mv2 ,double et2) {
	double ef1 = et1/mv1 ;
	double ef2 = et2/mv2 ;
	double div1 = mv1/mv2 ;
	double addef =  ef1 + ef2 ;
	double div2 = div1 * addef ;
	String divide = String.valueOf(div1)+" \u00B1 "+ String.valueOf(div2);
	return divide;
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
System.out.println("Select the operation * or / ");
String operator = sp.next();
if (operator.equals("*"))
{
String TV = multiplyer(firstTerm, et1Term, secondTerm, et2Term);
System.out.println(TV);
}
else if (operator.equals("/"))
{
	String TV1 = divider(firstTerm, et1Term, secondTerm, et2Term);
	System.out.println(TV1);
}
else {
	System.out.println("Invalid input: Program Terminated");
}
}
}