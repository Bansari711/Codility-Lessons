
public class BinaryGap {
	public static void main(String args[]) {

		System.out.println(solution(-101));

	}

	public static int solution(int N) {

		StringBuilder binaryNumber = convertToBinaryUsingString(N);
		boolean checkForOneFlag = false;
		int binaryGap = 0;
		int counter = 0;

		for (int i = 0; i < binaryNumber.length(); i++) {

			if (binaryNumber.charAt(i) == '1') {
				if (checkForOneFlag) {
					checkForOneFlag = false;
					if (binaryGap < counter) {
						binaryGap = counter;
					}
					if (i != 0)
						i--;
					counter = 0;
				} else {
					checkForOneFlag = true;
				}

			}
			if (binaryNumber.charAt(i) == '0' && checkForOneFlag) {
				counter++;
			}
		}

		return binaryGap;
	}

	static StringBuilder convertToBinaryUsingString(int inputDecimalNumber) {
		StringBuilder binaryNumber = new StringBuilder();

		while (inputDecimalNumber > 0) {
			binaryNumber.append(inputDecimalNumber % 2);
			inputDecimalNumber = inputDecimalNumber / 2;
		}
		return binaryNumber.reverse();
	}
}
