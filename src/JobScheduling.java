import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobScheduling {

	public static void main(String args[]) {
		String arr = "9:00-9:30,9:15-13:00,10:30-11:00,10:45-11:45,14:00-17:00,10:00-12:00,7:30-9:30";
		System.out.println(arr);
		String splitArr[] = arr.split(",");
		int job[] = new int[splitArr.length * 2];
		int newArr[] = new int[splitArr.length * 2];
		int k = 0;
		Map<Character, List<String>> map = new HashMap<>();
		for (int i = 0; i < splitArr.length; i++) {
			String split[] = splitArr[i].split("-");
			newArr[k++] = Integer.parseInt(split[0].split(":")[0]) * 60 + Integer.parseInt(split[0].split(":")[1]);
			newArr[k++] = Integer.parseInt(split[1].split(":")[0]) * 60 + Integer.parseInt(split[1].split(":")[1]);
			List<String> list = map.get('A');
			if (list == null) {
				list = new ArrayList<>();
			}
			list.add(split[0]);
			map.put('A', list);
			list = map.get('D');
			if (list == null) {
				list = new ArrayList<>();
			}
			list.add(split[1]);
			map.put('D', list);
		}
		Arrays.sort(newArr);
		String timeArr[] = new String[splitArr.length * 2];
		for (int i = 0; i < k; i++) {
			int rem = newArr[i] % 60;
			int number = newArr[i] / 60;
			timeArr[i] = "" + (number == 0 ? "00" : number) + ":" + (rem == 0 ? "00" : rem);
		}

		for (int i = 0; i < k; i++) {
			System.out.print(timeArr[i] + " ");
		}
		System.out.println();
		int number = calculateNumberOfStation(timeArr, map, job);
		System.out.println();
		System.out.println(number);

	}

	private static int calculateNumberOfStation(String[] timeArr, Map<Character, List<String>> map, int[] job) {

		List<String> arrival = map.get('A');
		List<String> departure = map.get('D');
		int index = 0;
		for (int i = 0; i < timeArr.length; i++) {
			String time = timeArr[i];
			recursiveFunction(time, arrival, job, i, 1);
			recursiveFunction(time, departure, job, i, -1);
		}

		for (int i = 0; i < job.length; i++) {
			System.out.print(job[i] + " ");
		}

		System.out.println();
		System.out.print(job[0] + " ");
		int max = job[0];
		for (int i = 1; i < job.length; i++) {
			job[i] = job[i] + job[i - 1];
			if (max < job[i]) {
				max = job[i];
			}
			System.out.print(job[i] + " ");
		}

		return max;

	}

	private static void recursiveFunction(String time, List<String> list, int[] job, int index, int value) {
		if (value == 1) {
			if (list.contains(time)) {
				job[index] = value;
				list.remove(time);
				recursiveFunction(time, list, job, index + 1, 1);
			}
		}

		else if (value == -1) {
			if (list.contains(time)) {
				job[index] = value;
				list.remove(time);
				recursiveFunction(time, list, job, index + 1, -1);
			}
		}
	}
}
