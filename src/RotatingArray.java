import java.util.Scanner;

public class RotatingArray {

	static int[] leftRotation(int[] a, int d) {
        // Complete this function
        int result[] =a;
        for(int i = 0; i<d; i++){
            int temp = a[0];
            for(int j = 1; j<a.length; j++){
                result[j-1] = a[j];
            }
            result[a.length - 1] = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 5;
        int d = 4;
        int[] a = {1,2,3,4,5};
        int[] result = leftRotation(a, d);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
