import java.util.Hashtable;
import java.util.Set;

public class Niobium2019 {

	public static Hashtable<Integer, Integer> noOfZeroCountHashTable = new Hashtable<>();

	public static void main(String args[]) {
		int[][] A = { { 1, 0, 0 }, { 0, 1, 0 } };
		System.out.println(solution(A));
	}

	public static int solution(int[][] A) {

		Hashtable<Integer, StringBuilder> matrixHashTable = new Hashtable<>();
		int colLength = 0;

		int maxNoOfRowsWithSameContentCounter = 0;

		if (A.length == 1) {
			return 1;
		}

		for (int i = 0; i < A.length; i++) {
			StringBuilder rowDataStr = new StringBuilder();
			int noOfZeroCounter = 0;
			for (int j = 0; j < A[i].length; j++) {
				rowDataStr = rowDataStr.append(String.valueOf(A[i][j]));
				if (A[i][j] == 0) {
					noOfZeroCounter++;
				}
				if (i == 0) {
					colLength++;
				}
			}
			matrixHashTable.put(i, rowDataStr);
			noOfZeroCountHashTable.put(i, noOfZeroCounter);
		}

		maxNoOfRowsWithSameContentCounter = maxNoOfRowsWithSameConent(noOfZeroCountHashTable, colLength);

		for (int key = 0; key < A.length; key++) {
			int count = findKeyFromValueHashTableInt(matrixHashTable, matrixHashTable.get(key));
			if (maxNoOfRowsWithSameContentCounter < count) {
				maxNoOfRowsWithSameContentCounter = count;
			}

			if (findKeyFromValueHashTableBoolean(matrixHashTable, onesComplement(matrixHashTable.get(key)))) {
				for (int colNum = 0; colNum < A[key].length; colNum++) {
					if (A[key][colNum] == 1) {
						A = flipColumn(colNum, A);
						int tempResult = maxNoOfRowsWithSameConent(noOfZeroCountHashTable, colLength);
						if (maxNoOfRowsWithSameContentCounter < tempResult) {
							maxNoOfRowsWithSameContentCounter = tempResult;
						}
					}
				}
			}

		}

		return maxNoOfRowsWithSameContentCounter;
	}

	public static boolean findKeyFromValueHashTableBoolean(Hashtable<Integer, StringBuilder> hashTable,
			StringBuilder value) {
		Set<Integer> keys = hashTable.keySet();
		for (Integer key : keys) {
			if (hashTable.get(key).toString().equals(value.toString())) {
				return true;
			}
		}
		return false;
	}

	public static int findKeyFromValueHashTableInt(Hashtable<Integer, StringBuilder> hashTable, StringBuilder value) {
		Set<Integer> keys = hashTable.keySet();
		int count = 0;

		for (Integer key : keys) {
			if (hashTable.get(key).toString().equals(value.toString())) {
				count++;
			}
		}
		return count;
	}

	public static int maxNoOfRowsWithSameConent(Hashtable<Integer, Integer> hashTable, int colLength) {

		int maxNoOfRowsWithSameContentCounter = 0;
		Set<Integer> keys = hashTable.keySet();

		for (Integer key : keys) {
			if (hashTable.get(key) == 0 || hashTable.get(key) == colLength)
				maxNoOfRowsWithSameContentCounter++;
		}
		return maxNoOfRowsWithSameContentCounter;
	}

	public static int[][] flipColumn(Integer columnNumber, int[][] matrix) {
		for (int rowNum = 0; rowNum < matrix.length; rowNum++) {

			if (matrix[rowNum][columnNumber] == 0) {
				matrix[rowNum][columnNumber] = 1;
				noOfZeroCountHashTable.put(rowNum, noOfZeroCountHashTable.get(rowNum) - 1);
			} else {
				matrix[rowNum][columnNumber] = 0;
				noOfZeroCountHashTable.put(rowNum, noOfZeroCountHashTable.get(rowNum) + 1);
			}
		}

		return matrix;
	}

	public static StringBuilder onesComplement(StringBuilder binaryStr) {
		StringBuilder complementStr = new StringBuilder();
		complementStr.append(binaryStr.toString());
		for (int i = 0; i < complementStr.length(); i++) {
			complementStr.setCharAt(i, (complementStr.charAt(i) == '0') ? '1' : '0');
		}
		return complementStr;
	}

}
