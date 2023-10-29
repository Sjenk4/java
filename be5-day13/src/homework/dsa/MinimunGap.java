package homework.dsa;

public class MinimunGap {
	public static void main(String[] args) {
		int[] arrayNumbers = { 1, 4, 5, 3, 2, 4, 1 , 2 ,4, 3,3};

		int result = findMinimumGap(arrayNumbers);
		System.out.println("Minimum gap is: " + result);
	}

	public static int findMinimumGap(int[] arr) {
		int result = 0;
		int temp = 0;
		for (int j = 0; j < arr.length - 1 ; j++) {
			for (int i = j + 1; i < arr.length; i++) {
				if (result == 1) {
					return 1;
				}

				if (arr[j] == arr[i]) {
					temp = i - j;
				}

				if (result == 0) {
					result = temp;
				}

				if (result > temp) {
					result = temp;
				}
			}
		}
		return result;
	}
}
