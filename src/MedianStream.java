import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianStream {

	public static double[] getMedians(int[] array) {
		PriorityQueue<Integer> lower = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
				return -1 * a.compareTo(b);
			}

		});
		PriorityQueue<Integer> higher = new PriorityQueue<>();
		double[] medians = new double[array.length];
		for (int i = 0; i < array.length; i++) {
			int number = array[i];
			addNumber(number, lower, higher);
			rebalance(lower, higher);
			medians[i] = getMedian(lower, higher);
		}
		return medians;
	}

	private static double getMedian(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
		PriorityQueue<Integer> bigger = lower.size() > higher.size() ? lower : higher;
		PriorityQueue<Integer> smaller = lower.size() > higher.size() ? higher : lower;
		if (bigger.size() == smaller.size()) {
			return ((double) bigger.peek() + smaller.peek()) / 2;
		} else {
			return bigger.peek();
		}
	}

	private static void rebalance(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
		PriorityQueue<Integer> bigger = lower.size() > higher.size() ? lower : higher;
		PriorityQueue<Integer> smaller = lower.size() > higher.size() ? higher : lower;
		if (bigger.size() - smaller.size() >= 2) {
			smaller.add(bigger.poll());
		}
	}

	private static void addNumber(int number, PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
		if (lower.size() == 0 || number < lower.peek()) {
			lower.add(number);
		} else {
			higher.add(number);
		}

	}

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter N = ");
		int N = sc.nextInt();
		System.out.println("enter number in array = ");
		int[] array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = sc.nextInt();
		}
		double[] medians = getMedians(array);
		printMedians(medians);
		sc.close();
	}

	private static void printMedians(double[] medians) {
		for (int i = 0; i < medians.length; i++) {
			System.out.println(medians[i]);
		}
	}
}
