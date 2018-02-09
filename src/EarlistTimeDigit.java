
public class EarlistTimeDigit {

	public String solution(String S) {
		String[] p = S.split("");
		int[] arr = new int[p.length-1];
		int j = 0;
		for (int i = 0; i < p.length; i++) {
			if (p[i].equals(":")) {
				continue;
			}
			arr[j] = Integer.parseInt(p[i]);
			j++;
		}
		int min = (10 * arr[0] + arr[1]) * 60 + arr[2] + arr[3];
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				for (int z = 0; z < 4; z++) {
					for (int a = 0; a < 4; a++) {

						if (x != y && y != z && z != a && a != x) {
							System.out.print(arr[x] + "" + arr[y] + "" + arr[z] + "" + arr[a] + "\t");
							int total = (10 * arr[x] + arr[y]) * 60 + arr[z] + arr[a];
							if (total < min) {
								min = total;
							}
							System.out.println(total);
						}
					}
				}
			}
		}
		return "ello";

	}

	public static void main(String[] args) {
		EarlistTimeDigit e = new EarlistTimeDigit();
		String p = e.solution("23:59");
		System.out.println(p);
	
	}
}
