package homework.dsa;

import java.util.Scanner;

public class FindSquareInteger {
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter the starting number: ");
		int startNumber = keyboard.nextInt();
		System.out.println("Enter the ending number:");
		int endNumber = keyboard.nextInt();
		
		System.out.println("Numbers square integer is: ");
		findSquareInteger(startNumber, endNumber);
		
	}
	
	public static void findSquareInteger(int startNumber, int endNumber) {
		int result = startNumber;
		int loopTime = 0;
		while( result  < endNumber) {
			System.out.print(result + " " );
			startNumber++;
			result = startNumber * startNumber;
			loopTime++;
		}
		
		System.out.println("loopTime :" + loopTime);
	}
}
