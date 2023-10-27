package homework.dsa;

import java.util.Arrays;

public class FindTheNumberAppearOddTimes {
	public static void main(String[] args) {
		int[] arrayNumber = { 0, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 100, 400, 15, 15, 15, 15 };
		System.out.println("The number that appears odd times is : ");
		findNonRepeatingElement(arrayNumber);
	}

	public static void findNonRepeatingElement(int nums[]) {
		Arrays.sort(nums);

		if (nums[0] != nums[1])
			System.out.println(nums[0]);

		for (int i = 1; i < nums.length - 1; i++) {
			if (nums[i - 1] != nums[i] && nums[i] != nums[i + 1])
				System.out.println(nums[i]);
		}
			if (nums[nums.length - 2] != nums[nums.length - 1])
				System.out.print(nums[nums.length - 1]);
			
		}
}
