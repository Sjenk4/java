package homework.dsa;

public class TheFeast {
	public static void main(String[] args) {
		int result = theFeast(7, 5, 3);
		System.out.println("The feast is: " + result);
		// 7 12
		// 7 4 0
		// 11 4
		// 11 1 1
		// 12
	}

	public static int theFeast(int candy, int shell, int convertedQuantity) {
		int result = candy;
		int candyShell = candy + shell;
		int exchangeQuantity = convertedQuantity;
		int exchangeableCandy;
		int redundant;
		
		while (candyShell > exchangeQuantity) {

			exchangeableCandy = candyShell / exchangeQuantity;

			redundant = candyShell % exchangeQuantity;

			candyShell = exchangeableCandy + redundant;

			result = result + exchangeableCandy;
		}

		return result;
	}
}
