
public class QueenProblem {
	static int top = -1;

	public class Position {
		int row, column;

		public Position(int row, int column) {
			this.row = row;
			this.column = column;
		}
	}

	public static void main(String args[]) {
		QueenProblem q = new QueenProblem();
		Position[] p = new Position[20];
		int[][] place = new int[20][20];
		q.placeQueen(p, place, 0, 0);
	}

	private void print(Position[] p, int[][] place) {
		for (Position pos : p) {
			System.out.print("row = " + pos.row + " col = " + pos.column);
			System.out.println();
		}
		for (int i = 0; i < place.length; i++) {
			for (int j = 0; j < place[0].length; j++) {
				if (place[i][j] == 1) {
					System.out.print("Q\t");
				} else {
					System.out.print(place[i][j] + "\t");
				}
			}
			System.out.println();
		}

	}

	public boolean isSafe(int[][] place, int i, int j) {
		if (i >= 0 && j >= 0 && i < place.length && j < place[0].length) {
			return true;
		}
		return false;
	}

	private boolean placeQueen(Position[] p, int[][] place, int i, int j) {
		/*
		 * if(i == place.length-1 && j == place[0].length-1 && checkPlace(place, i, j))
		 * { place[i][j] = 1; }
		 */
		if (p[p.length-1] != null) {
			print(p, place);
			System.exit(0);
		}
		if (isSafe(place, i, j)) {
			if (checkPlace(place, i, j)) {
				p[++top] = new Position(i, j);
				place[i][j] = 1;
				if (placeQueen(p, place, i + 1, 0))
					return true;
			} else if (j < place[0].length) {
				if (placeQueen(p, place, i, j + 1))
					return true;
				else return false;
			}
			int row = p[top].row;
			int col = p[top].column;
			p[top] = null;
			top--;
			place[row][col] = 0;
			if (placeQueen(p, place, row, col + 1))
				return true;
			return false;
		}
		return false;
	}

	public boolean checkPlace(int[][] place, int m, int n) {
		for (int i = 0; i < place.length; i++) {
			if (place[m][i] == 1) {
				return false;
			}
		}
		for (int i = 0; i < place.length; i++) {
			if (place[i][n] == 1) {
				return false;
			}
		}
		for (int i = 0; i < place.length; i++) {
			for (int j = 0; j < place.length; j++) {
				if (i + j == m + n && place[i][j] == 1) {
					return false;
				}
			}
		}
		for (int i = 0; i < place.length; i++) {
			for (int j = 0; j < place.length; j++) {
				if (i - j == m - n && place[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}
}
