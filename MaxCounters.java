
public class MaxCounters {

	public static void main(String args[]) {

	}

	public static int[] solution(int N, int[] A) {
		int[] result = new int[N];
		int maxCounter = 0;
		int min = 0;

		for (int i = 0; i < A.length; i++) {
			if (A[i] <= N) {

				result[A[i] - 1] = (result[A[i] - 1] < min) ? min : result[A[i] - 1];
				result[A[i] - 1] = result[A[i] - 1] + 1;
				maxCounter = Math.max(maxCounter, result[A[i] - 1]);
			} else if (A[i] == N + 1) {
				min = maxCounter;
			}
		}

		for (int i = 0; i < result.length; i++) {
			result[i] = (result[i] < min) ? min : result[i];
		}
		return result;
	}
}
