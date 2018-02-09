import java.util.Scanner;

public class StackClass {
	static int top = -1;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		StackClass solution = new StackClass();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			int type = sc.nextInt();
			if (type == 1) {
				int x = sc.nextInt();
				if (x > max) {
					max = x;
				}
				solution.push(arr, x, N);
			} else if (type == 2) {
				if (arr[top] == max) {
					max = Integer.MIN_VALUE;
					for (int j = 0; j < top; j++) {
						if (arr[j] > max) {
							max = arr[j];
						}
					}
				}
				arr[top] = Integer.MIN_VALUE;
				top--;
			} else if (type == 3) {
				if (max == Integer.MIN_VALUE) {
					for (int j = 0; j <= top; j++) {
						if (arr[j] > max) {
							max = arr[j];
						}
					}
				}
				System.out.println(max);
			}
		}
		sc.close();
	}

	public void push(int arr[], int x, int N) {
		if (top + 1 < N) {
			arr[++top] = x;
		}
	}
}
