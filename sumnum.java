package jswork;

import java.util.Scanner;

public class s1 {
	
		     public int sumNumbers(int n)//Function to calculate sum of n natural numbers. 
		     { 
		         if(n==0) 
		           return 0; 
		        else 
		             return n+sumNumbers(n-1); 
		     } 	
		    public static void main(String args[]) 
		   { 
		        Scanner o =new Scanner(System.in); 
		        System.out.println("Enter value"); 
		         int n=o.nextInt(); 
		         s1 obj=new s1(); 
		         int sum=obj.sumNumbers(n); 
		        System.out.println("The sum of numbers is "+sum); 
		     } 
		 } 

