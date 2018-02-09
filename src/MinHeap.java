import java.util.Arrays;
import java.util.Scanner;

public class MinHeap {

	private int capacity = 10;
	private int size = 0;

	int[] items = new int[capacity];

	private int getRightChildIndex(int index) {
		return 2 * index + 2;
	}

	private int getLeftChildIndex(int index) {
		return 2 * index + 1;
	}

	private int getParentIndex(int index) {
		return (index - 1) / 2;
	}

	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}

	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}

	private boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}

	private int leftChild(int index) {
		return items[getLeftChildIndex(index)];
	}

	private int rightChild(int index) {
		return items[getRightChildIndex(index)];
	}

	private int parent(int index) {
		return items[getParentIndex(index)];
	}

	private void swap(int index1, int index2) {
		int temp = items[index1];
		items[index1] = items[index2];
		items[index2] = temp;
	}

	private void extraCapacity() {
		if (size == capacity) {
			items = Arrays.copyOf(items, capacity * 2);
			capacity *= 2;
		}
	}

	private int peek() {
		if (size == 0)
			throw new IllegalStateException();
		return items[0];
	}

	private int poll() {
		if (size == 0)
			throw new IllegalStateException();
		int item = items[0];
		items[0] = items[size - 1];
		size--;
		heapifyDown();
		return item;
	}

	public void add(int item) {
		extraCapacity();
		items[size] = item;
		size++;
		heapifyUp();
	}

	private void heapifyUp() {
		int index = size - 1;
		while (hasParent(index) && parent(index) > items[index]) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}

	}

	private void heapifyDown() {
		int index = 0;
		while (hasLeftChild(index)) {
			int smallerChildIndex = getLeftChildIndex(index);
			if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
				smallerChildIndex = getRightChildIndex(index);
			}
			if (items[index] < leftChild(smallerChildIndex)) {
				break;
			} else {
				swap(smallerChildIndex, index);
				index = smallerChildIndex;
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter N = ");
		int N = sc.nextInt();
		System.out.println("Enter numbers = ");
		MinHeap m = new MinHeap();
		for (int i = 0; i < N; i++) {
			m.add(sc.nextInt());
		}
		
		m.print(m.items);
		sc.close();
	}

	private void print(int[] arr) {
		for(int i = 0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
