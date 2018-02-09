
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class QuerySum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Q = sc.nextInt();
		long arr[][] = new long[Q][3];
		for (int i = 0; i < Q; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = sc.nextLong();
			}
		}
		/*long arr[][] = {
				{1,0,5},
				{1,1,7},
				{1,0,3},
				{2,1,0},
				{2,1,1}
				
		};*/

		QuerySum solution = new QuerySum();
		solution.getQuerySum(arr, N, Q);

	}

	private void getQuerySum(long arr[][], int N, int Q) {
		Long lastAnswer = 0L;
		Map<Integer, List<Long>> sequenceMap = new HashMap<>();
		for (int i = 0; i < Q; i++) {
			long subArray[] = new long[3];
			for (int j = 0; j < 3; j++) {
				subArray[j] = arr[i][j];
			}

			long feature = subArray[0];
			long x = subArray[1];
			long y = subArray[2];
			if (feature == 1) {
				int sequenceNumber = (int) ((x ^ lastAnswer) % N);
				if (sequenceMap.containsKey(sequenceNumber)) {
					List<Long> sequenceList = sequenceMap.get(sequenceNumber);
					sequenceList.add(y);
					sequenceMap.put(sequenceNumber, sequenceList);
				} else {
					List<Long> sequenceList = new ArrayList<Long>();
					sequenceList.add(y);
					sequenceMap.put(sequenceNumber, sequenceList);
				}
			} else if (feature == 2) {
				int sequenceNumber = (int) ((x ^ lastAnswer) % N);
				List<Long> sequenceList = sequenceMap.get(sequenceNumber);
				int length = sequenceList.size();
				int index = (int) (y % length);
				lastAnswer = sequenceList.get((int)index);
				System.out.println(lastAnswer);
			}

		}

	}
}