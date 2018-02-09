import java.util.Arrays;
import java.util.Scanner;

public class PileCount {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = 11;
		int a = 2;
		int b = 2;
		PileCount p = new PileCount();
		int count = p.countPiles(N, a, b);
		System.out.println(count);
		sc.close();
	}

	private int countPiles(int n, int a, int b) {

		int count = countPilesUtil(n, a, b, 0);
		return count;

	}

	private int countPilesUtil(int n, int a, int b, int count) {
		if (n < a) {
			return ++count;
		}
		if (n < b) {
			return ++count;
		}
		String str = divideInto(n, b);
		if (!str.isEmpty()) {
			str.trim();
		}
		String split[] = str.split(" ");
		int arr[] = new int[split.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(split[i]);

		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < b) {
				count++;
			}
			countPilesUtil(arr[i], a, b, count);
		}

		return count;
	}

	private String divideInto(int n, int b) {
		int arr[] = new int[b];
		arr[0] = n / b;
		int total = arr[0];
		for (int i = 1; i < b - 1; i++) {
			arr[i] = arr[i - 1] + 1;
			
			total += arr[i];
		}

		arr[b - 1] = n - total;
		Arrays.sort(arr);
		String str = "";
		for (int i = 0; i < b; i++) {

			str += arr[i] + " ";
		}
		return str;
	}
}
