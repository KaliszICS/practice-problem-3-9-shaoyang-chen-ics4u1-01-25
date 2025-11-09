import java.util.ArrayList;
import java.util.List;

public class PracticeProblem {


	public static String[] towerOfHanoi(int n) {
		if (n <= 0) {
			return new String[0];
		}
		List<String> moves = new ArrayList<>();
		solveHanoi(n, 'L', 'R', 'M', moves);
		return moves.toArray(new String[0]);
	}
	private static void solveHanoi(int n, char from, char to, char aux, List<String> moves) {
		// 基准情况：只有一个盘子时，直接移动
		if (n == 1) {
			moves.add("" + from + to);
			return;
		}
		// 递归步骤：
		// 1. 将n-1个盘子从起始柱移动到辅助柱（使用目标柱作为辅助）
		solveHanoi(n - 1, from, aux, to, moves);
		// 2. 将最大的盘子从起始柱移动到目标柱
		moves.add("" + from + to);
		// 3. 将n-1个盘子从辅助柱移动到目标柱（使用起始柱作为辅助）
		solveHanoi(n - 1, aux, to, from, moves);
	}
}
