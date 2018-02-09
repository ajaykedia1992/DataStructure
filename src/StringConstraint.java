import java.util.Scanner;

public class StringConstraint {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a number");
		int n = sc.nextInt();
		int b = 1;
		int c = 2;
		double totalNo = Math.pow(n, n);
		//System.out.println(totalNo);
		StringConstraint s = new StringConstraint();
		double totalCombination = s.countStr(n);
		//double removingData = s.calculateCombination(n, b, n - b - 1, 0);
		//removingData += s.calculateCombination(n, c, n - c - 1, 0);
		//totalNo -= removingData;
		System.out.println(totalCombination);
		sc.close();
	}

	private double countStr(int n) {
		// TODO Auto-generated method stub
		return 1+(n*2)+(n*((n*n)-1)/2);
	}

	private double calculateCombination(int n, int num, int position, int count) {
		if(position == 0) {
			count++;
		}
		else {
			if(position>2) {
				int a = 1;
				for(int i = 0;i<position-2;i++) {
					a*= 1;
				}
				count += a;
			}
			else {
				int b = 1;
				for(int i = 0;i<position;i++) {
					b*=2;
				}
				count +=b;
			}
		}
		return count + calculateCombination(n,num,position-1,0);
	}
}
