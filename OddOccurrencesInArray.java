import java.util.Hashtable;
import java.util.Set;

public class OddOccurrencesInArray {

	public static void main(String args[]) {
		int[] A = { 9, 3, 7, 3, 7, 3, 9, 3, 9 };

		System.out.println(solution(A));

	}

	public static int solution(int[] A) {

		Hashtable<Integer, Integer> hashTable = new Hashtable<>();
		Hashtable<Integer, Integer> resultHashTable = new Hashtable<>();
		hashTable.put(0, 0);
		resultHashTable.put(0,0);

		for (int key = 0; key < A.length; key++) {
			if (hashTable.get(A[key]) != null) {
				hashTable.put(A[key], hashTable.get(A[key]) + 1);
			}
			else{
				hashTable.put(A[key], 1);
			}
			if(hashTable.get(A[key]) % 2 != 0){
				resultHashTable.put(A[key], A[key]);
			}
			else{
				resultHashTable.remove(A[key]);
			}
		}

		resultHashTable.remove(0);
		
		Set<Integer> keys = resultHashTable.keySet();
		for (Integer key : keys) {
			return key;
		}

		return 0;
	}
}
