
public class MazeProblem {

	public static void main(String args[]) {
		int[][] A = { { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 0, 1, 1, 1 }, { 0, 0, 1, 1 } };
		System.out.println("Finding the path in maze ....... ");
		MazeProblem m = new MazeProblem();
		m.solveMaze(A, A.length, A[0].length);
	}

	private void solveMaze(int[][] a, int m, int n) {
		int[][] sol = new int[m][n];
		solveMazeUtil(a, 0, 0, sol);

		print(sol);

	}

	private void print(int[][] sol) {
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol[0].length; j++) {
				System.out.print(sol[i][j]);
			}
			System.out.println();
		}

	}

	private boolean isSafe(int[][] M, int i, int j) {
		if (i >= 0 && j >= 0 && i < M.length && j < M[0].length && M[i][j] == 1) {
			return true;
		}
		return false;
	}

	private boolean solveMazeUtil(int[][] a, int i, int j, int[][] sol) {
		if (i == a.length - 1 && j == a[0].length - 1) {
			sol[i][j] = 1;
			
			return true;
		}
		if (isSafe(a, i, j)) {
			sol[i][j] = 1;
			if (solveMazeUtil(a, i + 1, j, sol))
				return true;
			if (solveMazeUtil(a, i, j + 1, sol))
				return true;

			sol[i][j] = 0;
			return false;
		}
		return false;

	}
}
