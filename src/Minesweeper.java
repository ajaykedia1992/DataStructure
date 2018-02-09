import java.util.Scanner;

public class Minesweeper {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter row m = ");
		int m = sc.nextInt();
		System.out.println("enter column n = ");
		int n = sc.nextInt();
		System.out.println("enter probability p = ");
		double probability = sc.nextDouble();
		boolean bomb[][] = new boolean[m + 2][n + 2];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				bomb[i][j] = Math.random() < probability;
			}
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (bomb[i][j]) {
					System.out.print("* ");
				} else {
					System.out.print(". ");
				}
			}
			System.out.println();
		}

		int[][] sol = new int[m + 2][n + 2];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				for (int ii = i - 1; ii <= i + 1; ii++) {
					for (int jj = j - 1; jj <= j + 1; jj++) {
						if (bomb[ii][jj]) {
							sol[i][j]++;
						}
					}
				}
			}
		}

		System.out.println();
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (bomb[i][j])
					System.out.print("* ");
				else
					System.out.print(sol[i][j] + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}
}
