
public class RoseProblem {

	public int solution(int [] P, int K) {
		int [][] newP = new int[P.length][P.length];
		for(int i = 0; i<P.length; i++) {
				newP[i][P[i]-1] = 1;
				for(int j = 0;j<i; j++) {
					newP[i][P[j]-1] = 1;
				}
		}
		int count = 0;
		int value = 0;
		for(int i = 0; i<P.length; i++) {
			for(int j = 0; j<P.length; j++) {
				System.out.print(newP[i][j]);
			}
			System.out.println();
		}
		for(int i = 0; i<P.length; i++) {
			for(int j = 0; j<P.length; j++) {
				if(newP[i][j] == 0) {
					if(count == K) {
						value++;
						count = 0;
						j = P.length;
					}
					count = 0;
					continue;
				}
				else {
					count++;
				}
			}
			if(count == K) {
				value++;
			}
			count = 0;
		}
		if(value == 0) {
			return -1;
		}
		return value;
	}
	public static void main(String args[]) {
		
		RoseProblem r = new RoseProblem();
		int[] P = {3,1,5,4,2};
		int value = r.solution(P,4);
		System.out.println(value);
	}
}
