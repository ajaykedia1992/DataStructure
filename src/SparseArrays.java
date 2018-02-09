import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class SparseArrays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			if (map.containsKey(str)) {
				int count = map.get(str);
				count += 1;
				map.put(str, count);
			} else {
				map.put(str, 1);
			}
		}

		int Q = sc.nextInt();
		Queue<String> myQueue = new LinkedList<String>();
		for (int i = 0; i < Q; i++) {
			myQueue.add(sc.next());
		}
		while (!myQueue.isEmpty()) {
			String str = myQueue.poll();
			if (map.containsKey(str)) {
				System.out.println(map.get(str));
			}
			else {
				System.out.println(0);
			}
		}
	}
}
