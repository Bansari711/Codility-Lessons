import java.util.Collections;
import java.util.Hashtable;

public class MissingInteger {

	public static void main(String[] args) {

		int[] A = { 1, 1, 0, -1, -2 };

		System.out.println("A");
		System.out.print(solution(A));
	}

	public static int solution(int[] A) {

		Hashtable<Integer, Integer> inputHashTable = new Hashtable<Integer, Integer>();
		Hashtable<Integer, Integer> testHashTable = new Hashtable<Integer, Integer>();

		for (int i = 0; i < A.length; i++) {
			if (inputHashTable.get(A[i]) == null) {
				inputHashTable.put(A[i], A[i]);
			}
		}

		for (int i = 1; i <= 100000; i++) {
			if (inputHashTable.get(i) == null){
				return i;
			}
			if (i == 100000){
				return i + 1;
			}
		}

		return 1;

		
	}
}
