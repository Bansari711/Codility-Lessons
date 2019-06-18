
import java.util.*;

public class PermCheck {
	public static void main(String args[]) {
		int[] A = { 4, 1, 3, 2 };
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {

		Set<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < A.length; i++) {
			set.add(A[i]);
		}

		for (int i = 1; i <= A.length; i++) {
			if (set.contains(i) == false) {
				return 0;
			}
		}

		return 1;
	}
}
