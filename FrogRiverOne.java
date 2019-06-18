import java.util.*;

public class FrogRiverOne {

	public static void main(String args[]) {
		int[] A = {};
		System.out.println(solution(5, A));
	}

	public static int solution(int X, int[] A) {

		Set<Integer> setOfPositions = new HashSet<>();

		for (int i = 1; i <= X; i++) {
			setOfPositions.add(i);
		}

		for (int i = 0; i < A.length; i++) {

			if (setOfPositions.isEmpty()) {
				return i;
			} else if (setOfPositions.contains(A[i])) {
				setOfPositions.remove(A[i]);
			}
		}
		return -1;
	}
}
