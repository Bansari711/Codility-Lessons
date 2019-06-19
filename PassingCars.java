import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PassingCars {
	public static void main(String args[]) {
		int[] A = { 0, 1, 0, 1, 1 };
		solution(A);
	}

	public static int solution(int[] A) {

		HashSet<Integer> indexOfEastCarsSet = new HashSet<>();

		for (int i = 0; i < A.length; i++) {

			if (A[i] == 0) {
				indexOfEastCarsSet.add(i);
			}
		}

		Iterator<Integer> hashSet = indexOfEastCarsSet.iterator();
		Integer totalPair = 0;

		while (hashSet.hasNext()) {
			if (totalPair > 1000000000) {
				return -1;
			} else {
				int indexOfEastCar = hashSet.next();
				totalPair += (A.length - (indexOfEastCar + 1)) - (indexOfEastCarsSet.size() - 1);
				hashSet.remove();
				indexOfEastCarsSet.remove(indexOfEastCar);
			}
		}
		return totalPair;
	}
}
