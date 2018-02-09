import java.util.HashMap;
import java.util.Map;

public class ArraySum {

	public static void main(String args[]) {
		int a[] = { 2, -20, -10, 20, 20, 10 };
		int sum = -30;
		ArraySum arr = new ArraySum();
		arr.findArraySum(a, a.length, sum);
	}

	private void findArraySum(int[] a, int length, int sum) {
		Map<Integer, Integer> map = new HashMap<>();
		int total = 0;

		for (int i = 0; i < length; i++) {
			total += a[i];
			if (sum - total == 0) {
				System.out.println("sum found at " + 0 + " and " + i);
				return;
			}
			if (map.containsKey(total - sum)) {
				System.out.println("sum found at " + map.get(total - sum) + 1 + " and " + i);
				return;
			}

			map.put(total, i);
		}
		System.out.println("Given sum is not found in any subarray");
	}
}
