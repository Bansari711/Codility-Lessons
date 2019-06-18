

public class TapeEquilibrium {

	public static void main(String args[]) {
		int[] A = {2001, 1};
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {

		// stores sum of an array
		int total = 0;
		int sumOfFirstPart = 0;
		int sumOfSecondPart = 0;
		int minDiff = Integer.MAX_VALUE;

		// find total sum of an array
		for (int i = 0; i < A.length; i++) {
			total += A[i];   
		}

		//find absolute minimum difference 
		for (int i = 0; i < A.length - 1; i++) {
			
			sumOfFirstPart += A[i];  							   //sum of A[0] to A[P-1]
			sumOfSecondPart = total - sumOfFirstPart;			   //sum of A[P] to A[N-1]
			int diff = Math.abs(sumOfSecondPart - sumOfFirstPart); //returns difference between (A[0] to A[P-1]) and (A[P] to A[N-1])
			
			minDiff = Math.min(minDiff, diff);   //returns minimum difference between two integer variables: minDiff and diff
		}
		return minDiff;  //return minimum difference
	}

}
