
public class GenomicRangeQuery {
	public static void main(String args[]) {
		int[] P = { 2 };
		int[] Q = { 4 };
		String S = "CAGCCTA";

		solution(S, P, Q);
	}

	public static int[] solution(String S, int[] P, int[] Q) {

		int[] A = new int[S.length() + 1];
		int[] C = new int[S.length() + 1];
		int[] G = new int[S.length() + 1];

		int[] result = new int[P.length];

		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == 'A') {
				A[i + 1] = A[i] + 1;
				C[i + 1] = C[i];
				G[i + 1] = G[i];
			} else if (S.charAt(i) == 'C') {
				A[i + 1] = A[i];
				C[i + 1] = C[i] + 1;
				G[i + 1] = G[i];
			} else if (S.charAt(i) == 'G') {
				A[i + 1] = A[i];
				C[i + 1] = C[i];
				G[i + 1] = G[i] + 1;
			} else if (S.charAt(i) == 'T') {
				A[i + 1] = A[i];
				C[i + 1] = C[i];
				G[i + 1] = G[i];
			}
		}

		for (int i = 0; i < P.length; i++) {

			if (A[Q[i] + 1] - A[P[i]] > 0) {
				result[i] = 1;
			} else if (C[Q[i] + 1] - C[P[i]] > 0) {
				result[i] = 2;
			} else if (G[Q[i] + 1] - G[P[i]] > 0) {
				result[i] = 3;
			} else {
				result[i] = 4;
			}
		}
		return result;
	}
}
