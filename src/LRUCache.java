import java.util.HashMap;
import java.util.Map;

class DoublyLinkedList{
	int key;
	int value;
	DoublyLinkedList pre;
	DoublyLinkedList post;
}


public class LRUCache {
	
	public void addNode(DoublyLinkedList node) {
		node.post = head.post;
		head.post = node;
		node.post.pre = node;
		node.pre = head;
	}
	
	public void removeNode(DoublyLinkedList node) {
		
		head.post = node.post;
		node.pre = null;
		head.post.pre = head;
		node.post = null;
	}
	
	public DoublyLinkedList popNode() {
		DoublyLinkedList temp = tail.pre;
		removeNode(temp);
		return temp;
	}
	
	public void moveFront(DoublyLinkedList node) {
		removeNode(node);
		addNode(node);
	}
	
	Map<Integer, DoublyLinkedList> map = new HashMap<Integer, DoublyLinkedList>();
	
	int capacity, count;
	DoublyLinkedList head, tail;
	
	public LRUCache(int capacity) {
		count = 0;
		this.capacity = capacity;
		head = new DoublyLinkedList();
		head.pre = null;
		tail = new DoublyLinkedList();
		tail.pre = head;
		tail.post = null;
		head.post = tail;
	}
	
	public void put(int key, int value) {
		DoublyLinkedList node = map.get(key);
		if(node == null) {
			node = new DoublyLinkedList();
			node.key = key;
			node.value = value;
			addNode(node);
			map.put(key,node);
			count++;
			if(count>capacity) {
				DoublyLinkedList temp = popNode();
				--count;
				map.remove(temp.key);
			}
		}
		else {
			node.value = value;
			moveFront(node);
		}
	}
	
	public int get(int key) {
		DoublyLinkedList node = map.get(key);
		if(node == null) {
			return -1;
		}
		moveFront(node);
		return node.value;
	}
	public static void main(String args[]) {
		LRUCache lru = new LRUCache(4);
		
	}
}
