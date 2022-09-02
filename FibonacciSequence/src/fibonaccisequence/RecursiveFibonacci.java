package fibonaccisequence;

import java.util.Scanner;

public class RecursiveFibonacci {
	
	public static void main(String args[]) {
		
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		
		System.out.println(rcsFib(number));
		
	}
	
	static int rcsFib( int n ) {
		if (n==1 || n ==2) 
		{ return 1; }
		else 
		{return (rcsFib(n-1)+rcsFib(n-2));}
		
	} 

}
