
public class CyclicRotation {
	public static void main(String args[]) {
		int[] A = {};
		int[] B = solution(A, 7);
		for (int i = 0; i < B.length; i++) {
			System.out.println(B[i]);
		}

	}

	public static int[] solution(int[] A, int K) {

		if (K == A.length || K <= 0 || A.length == 0) {
			return A;
		} else if (K >= A.length) {
			K = K % A.length;
		}
		int[] result = new int[A.length];
		int index = K;

		for (int i = 0; index != 0; i++) {
			result[i] = A[A.length - index];
			index--;
		}
		index = K;
		for (int i = 0; index < result.length; i++) {
			result[index] = A[i];
			index++;
		}
		return result;

	}
}
