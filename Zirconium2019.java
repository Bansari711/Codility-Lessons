import java.util.*;

import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;

public class Zirconium2019 {

	public static void main(String args[]) {
		int[] A = { 7, 7, 7, 7 };
		int[] B = { 5, 3, 4, 3 };
		System.out.println(solution(A, B, 2));
	}

	public static int solution(int[] A, int[] B, int F) {

		Hashtable<Integer, Integer> hashtable = new Hashtable<>();
		int maxContribution = 0;

		for (int i = 0; i < A.length; i++) {
			hashtable.put(i, A[i] - B[i]);
		}

		ArrayList<Map.Entry<Integer, Integer>> l = new ArrayList(hashtable.entrySet());
		Collections.sort(l, new Comparator<Map.Entry<?, Integer>>() {

			public int compare(Map.Entry<?, Integer> o1, Map.Entry<?, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});

		for (int i = A.length - 1; i >= 0; i--) {
			if (F != 0) {
				int index = l.get(i).getKey().intValue();
				maxContribution += A[index];
				F--;
			} else {
				int index = l.get(i).getKey().intValue();
				maxContribution += B[index];
			}
		}
		return maxContribution;
	}
}
