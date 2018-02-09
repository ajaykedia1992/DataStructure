import java.util.Scanner;
import java.util.Stack;

public class myCode {

	private static int count = 0;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = 35;
		int a = 5;
		int b = 7;

		myCode m = new myCode();
		if (N < b) {
			System.out.println(N);
		} else if (N < a) {
			System.out.println(1);
		} else {
			m.countPileUtil(N, a, b);
			System.out.println(count);
		}
		sc.close();
	}

	private void countPileUtil(int n, int a, int b) {

		Stack<Integer> stack = new Stack<Integer>();
		countPile(stack, n, a, b);
	}

	private void countPile(Stack<Integer> stack, int n, int a, int b) {
		addCount(stack, n, a, b);
		while (!stack.isEmpty()) {
			int l = stack.pop();
			if (l <= a) {
				count++;
			} else {
				countPile(stack, l, a, b);
			}
		}
	}

	private void addCount(Stack<Integer> stack, int n, int a, int b) {
		int div = n / b;
		if(div == 0) {
			div = 1;
		}
		stack.push(div);
		int total = div;
		for (int i = 1; i < b - 1; i++) {
			if (total + stack.peek() + 1 > n) {
				break;
			}
			stack.push(stack.peek() + 1);
			total += stack.peek();
		}
		if (n - total > 0) {
			stack.push(n - total);
		}
	}
}
