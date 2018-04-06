package jswork;

public class c1 { 
		static int arr[] = {22,55,65,78,21,77,7,55}; 
		static int smallest() 
	{ 
		 int i; 
		 int min = arr[0]; 
		  for (i = 1; i < arr.length; i++) 
		              if (arr[i] < min) 
		                 min = arr[i]; 
		       
		         return min; 
		      } 
		      
		  
		     public static void main (String[] args)  
		      { 
		          System.out.println("Smallest element in array is " + smallest()); 
		         } 
		  } 
