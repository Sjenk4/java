package coding.metor.dsa;

public class SortUpAscending {
	public static void main(String[] args) {
		
		int[] numbers = {0, 1, 0, 1, 2, 2, 0, 1, 2, 1, 1, 1, 1};
		SortUpAscendingArrayNumbers(numbers);
	
	}
	
	public static void SortUpAscendingArrayNumbers(int[] numbers) {
		
		int countZero = 0;
		int countOne = 0;
		
		for (int num : numbers) {
			if(num == 0) {
				countZero++;
			}else if(num == 1) {
				countOne++;
			}
		}
		
		int[] result = new int[numbers.length];
		
		for (int i = countOne; i < (countZero + countOne); i++) {
			result[i] = 1;
		}
		
		for (int i = (countZero + countOne); i < numbers.length; i++) {
			result[i] = 2;
		}
		
		for (int value : result) {
			System.out.println(value);
		}
	}
	
}
