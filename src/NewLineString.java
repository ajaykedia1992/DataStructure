import java.util.Scanner;

public class NewLineString {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		// System.out.println("Enter a String.. = ");
		String str = "fhwig oerfwodj ffjo rhye wfndjo whowf npjqo fnnq wwoie iohf wnnc lsfns khieh genf";
		// System.out.println("Enter size of the screen = ");
		int n = 5;

		str = printNewLine(str, n);
		System.out.println(str);
	}

	private static String printNewLine(String str, int n) {
		StringBuffer sc = new StringBuffer("");
		int length = str.length() / n;
		int b = n;
		for (int i = 0; i <= str.length()-length + n;) {
			String a = "";
			int l = b;
			if (str.charAt(b - 1) != ' ') {
				while (str.charAt(l) != ' ' && l > i) {
					l--;
				}
				if (l != i) {
					a = str.substring(i, l);
				} else {
					a = str.substring(i, b);
				}
			} else if (str.charAt(b - 1) == ' ') {
				a = str.substring(i, b);
			}

			else if (str.charAt(b - 1) == '\n') {
				sc.append(str.substring(i, b));
				i = i + b;
				continue;
			}

			sc.append(a + "\n");
			i = i + n;
			b = i + n;
		}

		sc.append(str.substring(n * length));
		return sc.toString();
	}
}
