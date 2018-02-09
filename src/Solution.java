import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

	public String solution(String S, int K) {
		if (S == null) {
			return null;
		}
		if (S.length() == 1) {
			return S.toUpperCase();
		}
		Pattern pt = Pattern.compile("[^a-zA-Z0-9]");
		Matcher match = pt.matcher(S);
		while (match.find()) {
			String s = match.group();
			S = S.replaceAll("\\" + s, "");
		}
		// System.out.println(S);
		int count = 0;
		StringBuffer newStr = new StringBuffer("");
		S = S.toUpperCase();
		for (int i = S.length() - 1; i >= 0; i--) {
			if (count == K) {
				newStr.append("-");
				count = 0;
			}
			newStr.append(S.charAt(i));

			count++;
		}
		newStr.reverse();

		return newStr.toString();
	}

	public static void main(String args[]) {

		Solution s = new Solution();
		String p = s.solution("2-4A0r7-4k", 1);
		System.out.println(p);
	}
}
