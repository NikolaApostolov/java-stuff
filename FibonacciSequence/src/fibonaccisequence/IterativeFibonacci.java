package fibonaccisequence;

import java.util.Scanner;

public class IterativeFibonacci {

	public static void main(String args[]) {
		
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		
		System.out.println("sup");
		
	}
	
	static int itrFib( int n ) {
		int num1 = 1;
		int num2 = 1;
		int sumNum = 0;
		
		if (n == 1 || n == 2) {
			return 1;
		}
		else {
			
			for (int i=3; i<=n; i++) {
			sumNum = num1 + num2;
			num1 = num2;
			num2 = sumNum;
			}
			
			return num2;
		}
	} 
}
