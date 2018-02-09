
public class EarlistTime {

	public String solution(String S) {
		int[] numbers = new int[S.length() - 1];
		String[] newStr = S.split("");
		int j = 0;
		for (int i = 0; i < newStr.length; i++) {
			if (newStr[i].equals(":")) {
				continue;
			}
			numbers[j] = Integer.parseInt(newStr[i]);
			j++;
		}
		int num[] = numbers;
		int temp = 0;
		int cnt = 0;
		int numA = 0;
		int numB = 0;
		int numC = 0;
		int numD = 0;
		int max = 1439;
		for (int a = 0; a < num.length; a++) {
			for (int b = 0; b < num.length; b++) {
				for (int c = 0; c < num.length; c++) {
					for (int d = 0; d < num.length; d++) {
						if (a != b && a != c && a != d && b != c && b != d && c != d) {
							if ((10 * num[c] + num[d]) < 60) {
								int cal = (10 * num[a] + num[b]) * 60 + (10 * num[c] + num[d]);
								if (cal <= max) {
									cnt++;
									if (temp < cal) {
										temp = cal;
										numA = num[a];
										numB = num[b];
										numC = num[c];
										numD = num[d];
									}
								}
							}
						}
					}

				}
			}
		}
		if (cnt == 0)

		{
			return "impossible";
		} else {
			return numA + "" + numB + ":" + numC + "" + numD;
		}
	}

	public static void main(String args[]) {
		EarlistTime e = new EarlistTime();
		String p = e.solution("12:32");
		System.out.println(p);
	}
}
