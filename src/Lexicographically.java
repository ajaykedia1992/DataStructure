
import java.util.Arrays;
import java.util.Scanner;

public class Lexicographically {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Lexicographically l = new Lexicographically();
		int N = sc.nextInt();
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}
		String[] newArr = new String[N];
		for (int i = 0; i < N; i++) {
			newArr[i] = l.LexicographicallyString(arr[i]);
		}
		for (String string : newArr) {
			System.out.println(string);
		}
		sc.close();
	}

	public String LexicographicallyString(String str) {
		int size = str.length() - 1;
		if (str.length() <= 1) {
			return "no answer";
		}
		StringBuffer newStr = new StringBuffer(str);
		String a = "",b = "";
		int count = 1;
		for (int i = size, j = size - 1; i >= 0 && j >= 0; i--, j--) {
			if (str.charAt(i) > str.charAt(j)) {
				char temp = newStr.charAt(j);
				newStr.setCharAt(j, newStr.charAt(i));
				newStr.setCharAt(i, temp);
				a= newStr.substring(0, i);
				b = newStr.substring(i, newStr.length());
				break;
			} else {
				count++;
			}
		}
		if (count == str.length()) {
			return "no answer";
		}
		char[] arrayCharacter = b.toCharArray();
		Arrays.sort(arrayCharacter);
		newStr = new StringBuffer("");
		for(char character : arrayCharacter) {
			newStr.append(character);
		}
		StringBuffer newBuffer = new StringBuffer(a);
		newBuffer.append(newStr);
		return newBuffer.toString();
	}
}
