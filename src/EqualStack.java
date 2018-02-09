import java.util.Scanner;

public class EqualStack {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		int n3 = in.nextInt();
		int h1[] = new int[n1];
		int height_h1 = 0;
		for (int h1_i = 0; h1_i < n1; h1_i++) {
			h1[h1_i] = in.nextInt();
			height_h1 += h1[h1_i];
		}
		int height_h2 = 0;
		int h2[] = new int[n2];
		for (int h2_i = 0; h2_i < n2; h2_i++) {
			h2[h2_i] = in.nextInt();
			height_h2 += h2[h2_i];
		}
		int height_h3 = 0;
		int h3[] = new int[n3];
		for (int h3_i = 0; h3_i < n3; h3_i++) {
			h3[h3_i] = in.nextInt();
			height_h3 += h3[h3_i];
		}
		EqualStack solution = new EqualStack();
		solution.calculateHeight(h1, h2, h3, height_h1, height_h2, height_h3, 0, 0, 0);
	}

	private void calculateHeight(int h1[], int h2[], int h3[], int height_h1, int height_h2, int height_h3, int i,
			int j, int k) {
		if ((height_h1 == height_h2) && (height_h2 == height_h3)) {
			System.out.println(height_h1);
			return;
		} else {
			int max = height_h1;
			if (height_h2 >= height_h3) {
				if (max <= height_h2) {
					max = height_h2;
				}
			} else {
				if (max <= height_h3) {
					max = height_h3;
				}
			}
			if (max == height_h1) {
				int top = h1[i];
				i++;
				height_h1 -= top;
			}
			if (max == height_h2) {
				int top = h2[j];
				j++;
				height_h2 -= top;
			}
			if (max == height_h3) {
				int top = h3[k];
				k++;
				height_h3 -= top;
			}
			calculateHeight(h1, h2, h3, height_h1, height_h2, height_h3, i, j, k);
		}
	}
}
