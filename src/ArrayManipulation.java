import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulation {
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		long arr[] = new long[n];
		for (int a0 = 0; a0 < m; a0++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int k = in.nextInt();
			arr = manipuationArray(arr, a,b,k);
		}
		
		findMax(arr,n);
		
		in.close();
	}

	private static void findMax(long[] arr, int n) {
		Arrays.sort(arr);
		System.out.println(arr[arr.length-1]);
		
	}

	private static long[] manipuationArray(long[] arr, int a, int b, int k) {
		for(int i = a-1; i<b; i++) {
			arr[i] = arr[i] + k;
		}
		return arr;
	}
}
