
public class SudokuSolver {

	public static void main(String args[]) {
		int grid[][] = { { 1, 0, 3, 0 }, { 0, 0, 2, 1 }, { 0, 1, 0, 2 }, { 2, 4, 0, 0 } };
		SudokuSolver s = new SudokuSolver();
		s.print(grid, grid.length, grid[0].length);
		s.solveSudoku(grid, 0, 0);
		System.out.println("-----------------");
		s.print(grid, grid.length, grid[0].length);
	}

	private void print(int[][] grid, int N, int M) {
		
		for(int i = 0; i<N; i++) {
			for(int j =0; j<M; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	private boolean isSafe(int grid[][], int row, int column, int number) {
		for (int i = 0; i < grid[row].length; i++) {
			if (number == grid[row][i]) {
				return false;
			}
		}

		for (int i = 0; i < grid.length; i++) {
			if (number == grid[i][column]) {
				return false;
			}
		}
		return true;
	}

	private void solveSudoku(int[][] grid, int row, int col) {
		if (row < grid.length && col < grid[0].length) {
			if (isFindLocationSafe(grid, row, col)) {
				for(int i = 1; i<=4 ;i++) {
					if(isSafe(grid, row,col,i)) {
						grid[row][col] = i;
					}
				}

			} else {
				if (col == grid[0].length - 1) {
					solveSudoku(grid, row + 1, 0);
				} else {
					solveSudoku(grid, row, col + 1);
				}
			}
		}
	}

	private boolean isFindLocationSafe(int[][] grid, int row, int col) {
		if (grid[row][col] == 0) {
			return true;
		}
		return false;
	}
}
