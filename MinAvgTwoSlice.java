
public class MinAvgTwoSlice {
	public static void main(String args[]) {
		int[] A = { 4, 2, 2, 5, 1, 5, 8 };
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {

		float minResult = Integer.MAX_VALUE;
		int minStartPosition = 0;

		for (int i = 0; i < A.length - 2; i++) {
			float avgOfTwoElements = (float) (A[i] + A[i + 1]) / 2;
			float avgOfThreeElements = (float) (A[i] + A[i + 1] + A[i + 2]) / 3;

			float tempMin = Math.min(avgOfTwoElements, avgOfThreeElements);

			if (minResult > tempMin) {
				minResult = tempMin;
				minStartPosition = i;
			}
		}

		float avgOfLastTwoEle = (float) (A[A.length - 2] + A[A.length - 1]) / 2;

		if (minResult > avgOfLastTwoEle) {
			minResult = avgOfLastTwoEle;
			minStartPosition = A.length - 2;
		}
		return minStartPosition;
	}
}
