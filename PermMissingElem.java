import java.util.Hashtable;

public class PermMissingElem {

	public static void main(String args[]) {
		int[] A = { 2, 3, 1, 5 };

		System.out.println(solution(A));

	}

	public static int solution(int[] A) {
		Hashtable<Integer, Integer> hashTable = new Hashtable<>();

		for (int i = 0; i < A.length; i++) {
			hashTable.put(A[i], 1);
		}

		for (int i = 1; i <= A.length + 1; i++) {
			if (hashTable.get(i) == null) {
				return i;
			}
		}

		return 0;
	}
}