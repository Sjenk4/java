package coding.metor.dsa;


public class RomanNumbers {
	public static void main(String[] args) {

		String rommanString = "MCMXCIV";

		int currentRommanValue = 0;
		int result = 0;
		int nextRommanValue = 0;
		for (int i = 0; i < rommanString.length(); i++) {
			currentRommanValue = getValueFromCharacter(rommanString.charAt(i));

			if (i < rommanString.length() - 1) {
				nextRommanValue = getValueFromCharacter(rommanString.charAt(i + 1));
			}
			if(currentRommanValue < nextRommanValue) {
				result -= currentRommanValue;
			}else {
				result += currentRommanValue;
			}
		}
		System.out.println("Value :" + result);

	}

	public static int getValueFromCharacter(char rommanChar) {
		switch (rommanChar) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		}
		return 0;
	}
}
