import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Trie {

	private class TrieNode {
		Map<Character, TrieNode> children;
		boolean endOfWord;

		public TrieNode() {
			children = new HashMap<>();
			endOfWord = false;
		}
	}

	private final TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;
		}
		current.endOfWord = true;
	}

	public void insertWord(String word) {
		int index = 0;
		TrieNode current = root;
		insertIteratively(current, word, index);

	}

	private void insertIteratively(TrieNode current, String word, int index) {
		char ch = word.charAt(index);
		if (current.children.get(ch) != null) {

			insertIteratively(current.children.get(ch), word, index + 1);
		} else {
			TrieNode node = new TrieNode();
			current.children.put(ch, node);
			current = node;
			current.endOfWord = true;
			return;
		}
	}

	public boolean search(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				return false;
			}
			current = node;
		}
		return current.endOfWord;
	}

	public boolean searchWord(String word) {
		return searchRecursively(root, word, 0);
	}

	private boolean searchRecursively(TrieNode current, String word, int index) {
		char ch = word.charAt(index);
		if (index == word.length()) {
			return current.endOfWord;
		} 
		TrieNode node = current.children.get(ch);
		if(node == null) {
			return false;
		}
		return searchRecursively(current, word, index+1);
	}
	
	public boolean delete(String word) {
		return deleteRecursively(root, word, 0);
	}

	private boolean deleteRecursively(TrieNode current, String word, int index) {
		if(index == word.length()) {
			if(!current.endOfWord) {
				return false;
			}
			current.endOfWord = false;
			return current.children.size() == 0;
		}
		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);
		if(node == null) {
			return false;
		}
		boolean shouldDeleteNode = deleteRecursively(current, word, index+1);
		if(shouldDeleteNode) {
			current.children.remove(ch);
			 return current.children.size() == 0;
		}
		return false;
	}
	
	public void print() {
		TrieNode current = root;
		for(int i = 0; i<root.children.size(); i++) {
			
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter N = ");
		int N = sc.nextInt();
		System.out.println("Enter Strings = ");
		String[] array = new String[N];
		Trie trie = new Trie();
		for(int i = 0; i<N; i++) {
			trie.insert(sc.next());
		}
		
		sc.close();
	}
}
