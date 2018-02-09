import java.util.*;


public class SubstringProblem {

	public static void main(String args[]) {
		SubstringProblem s = new SubstringProblem();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int length = str.length();
		boolean count = false;;
		for(int i = 2 ; i<=length/2 ; i++) {
			count = s.findSubStringCount(str, i, i); 
			if(count) {
				break;
			}
		}
		if(count) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
		sc.close();
	}

	private boolean findSubStringCount(String str, int i, int inc) {
		int count = 0;
		int k = 0;
		for(int j = i; j<i+inc; j++) {
			if(str.charAt(k)==str.charAt(j)) {
				count ++;
			}
			k++;
		}
		if(count == i) {
			if(i+inc<str.length())
				findSubStringCount(str, i+inc, inc);
		}
		else {
			return false;
		}
		return true;
	}
}
