package coding.metor.dsa;

import java.util.Scanner;

public class SquareRoot {
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the number to search square root");
		Double number = keyboard.nextDouble();
		
		Double indexOfSearchNumber =  finNum(number);
		System.out.println("indexOfSearchNumber: " + indexOfSearchNumber);

	}

	private static Double finNum( Double number) {
		
		int loopTime = 0;
		Double endNumber = (double) (number / 2);
		Double startNumber = 0.0;
		Double middleNumber = (endNumber + startNumber) / 2;

		while (middleNumber <= endNumber) {
			loopTime ++;
			System.out.println("middleNumber * middleNumber  : " + middleNumber * middleNumber   );
			if (middleNumber * middleNumber ==  number) {
				System.out.println("loopTime: " + loopTime);
				return middleNumber ;
			}
			if(middleNumber * middleNumber  > number) {
				endNumber = middleNumber - 1;
			}else{
				startNumber = middleNumber + 1;
			}
			
			middleNumber = (endNumber + startNumber) / 2;
		}
		return -1.0;
	}

}
