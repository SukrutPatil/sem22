package studyHall;
import java.lang.Math;
import java.util.Scanner;
public class addition {
static Scanner sp = new Scanner(System.in);
public static String square(double mv1 ,double et1) {
	double ef1 = et1/mv1 ;
	double ef2 = et1/mv1 ;
	double sq1 = Math.pow(mv1, 2);
	double addef =  ef1 + ef2 ;
	double sq2 = sq1 * addef ;
	String sq = String.valueOf(sq1)+" \u00B1 "+ String.valueOf(sq2);
	return sq;
}
public static String cube(double mv1 ,double et1) {
	double ef1 = et1/mv1 ;
	double ef2 = et1/mv1 ;
	double cube1 = Math.pow(mv1, 3);
	double addef =  ef1 + ef2 ;
	double cube2 = cube1 * addef ;
	String cub = String.valueOf(cube1)+" \u00B1 "+ String.valueOf(cube2);
	return cub;
}

public static void main (String[] args ) {
	System.out.println("Select the operation sq or cube ");
	String operator = sp.next();
	System.out.println("This is error term calculator by Sukrut Patil");
	System.out.println("Input first term\n");
	double firstTerm = sp.nextDouble();
	System.out.println("Input error term 1 term\n");
	double et1Term = sp.nextDouble();
	if (operator.equals("s"))
	{
		String TV = square(firstTerm, et1Term);
		System.out.println(TV);
		}
		else if (operator.equals("c"))
		{
			String TV1 = cube(firstTerm, et1Term);
			System.out.println(TV1);
		}
		else {
			System.out.println("Invalid input: Program Terminated");
		}	

}
}
