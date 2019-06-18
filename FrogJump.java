
public class FrogJump {
	public int solution(int X, int Y, int D) {
		if (D == 0) {
			return 0;
		}
		int jumps = (Y - X) / D;
		if ((X + D * jumps) < Y) {
			return jumps + 1;

		} else {
			return jumps;
		}
	}
}
