import java.util.Scanner;

public class SubstringRepeation {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string = ");
		StringBuffer str = new StringBuffer("abcabcd");
		System.out.println("Enter second String = ");
		StringBuffer str1 = new StringBuffer("bcdabcabcdab");
		SubstringRepeation s = new SubstringRepeation();
		s.solution(str, str1);
		sc.close();
	}

	private void solution(StringBuffer str, StringBuffer str1) {
		String newStr = null;
		int index = 0;
		if (str.length() > str1.length()) {
			newStr = str1.toString();
			index = calculateSolution(str, str1);
			if(index < 0) {
				System.out.println("false");
			}
			else {
				finalResult(str, str1, index, newStr);
			}
		} else {
			newStr = str.toString();
			index = calculateSolution(str1, str);
			if(index < 0) {
				System.out.println("false");
			}
			else {
				finalResult(str1, str, index, newStr);
			}
		}
		
		
	}

	private void finalResult(StringBuffer str, StringBuffer str1, int index, String newStr) {
		
		
	}

	private int calculateSolution(StringBuffer str, StringBuffer str1) {
		int index = str.indexOf(str1.toString());
		if (index > 0) {
			return index;
		}
		return calculateSolution(str, str1.deleteCharAt(str1.length() - 1));
	}
}
