import java.util.Scanner;

public class GameOfTwoStack {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int g = in.nextInt();
		for (int a0 = 0; a0 < g; a0++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int x = in.nextInt();
			int[] a = new int[n];
			int sum1 = 0;
			for (int a_i = 0; a_i < n; a_i++) {
				a[a_i] = in.nextInt();
				sum1 += a[a_i];
			}
			int[] b = new int[m];
			int sum2 = 0;
			for (int b_i = 0; b_i < m; b_i++) {
				b[b_i] = in.nextInt();
				sum2 += b[b_i];
			}

			GameOfTwoStack sol = new GameOfTwoStack();
			sol.gameOfTwoStack(a, b, n, m, x);
		}
	}

	private void gameOfTwoStack(int a[], int b[], int n, int m, int x) {

		int count = 0;
		int sum = 0;
		int i = 0, j = 0;
		boolean flag1 = true, flag2 = true;
		while (i < n && j < m) {
			if (flag1 == false && flag2 == false) {
				break;
			} else if (a[i] <= b[j] && flag1) {
				sum += a[i];
				if (sum < x) {
					count++;
					i++;
				} else {
					flag1 = false;
					flag2 = false;
				}
			} else if (a[i] > b[j] && flag2) {
				sum += b[j];
				if (sum < x) {
					count++;
					j++;
				} else {
					flag1 = false;
					flag2 = false;
				}
			}
		}

		if (flag1 && flag2) {
			if (n > m) {
				while (i < n) {
					sum += a[i];
					if (sum < x) {
						count++;
					}
				}
			} else {
				while (j < m) {
					sum += b[j];
					if (sum < x) {
						count++;
					}
				}
			}
		}

		System.out.println(count);
	}

}
