
import java.util.Scanner;

public class HoursGlassSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int arr_i=0; arr_i < 6; arr_i++){
            for(int arr_j=0; arr_j < 6; arr_j++){
                arr[arr_i][arr_j] = in.nextInt();
            }
        }
       /* int arr[][] = new int[][]{
        	  { 1, 1, 1, 0, 0, 0 },
        	  { 0, 1, 0, 0, 0, 0 },
        	  { 1, 1, 1, 0, 0, 0 },
        	  { 0, 9, 2, -4, -4, 0},
        	  { 0, 0, 0, -2, 0, 0},
        	  {0,0,-1,-2,-4,0}
        	};*/
        HoursGlassSum solution = new HoursGlassSum();
        solution.hourGlassSum(arr, 6, 6);
    }
    
    private void hourGlassSum(int arr[][], int m, int n){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<=arr.length - 3; i++){
            for(int j = 0; j<=arr[0].length - 3; j++){
                int total = 0;
                int flag = 0;
                for(int k = i; k < i+3; k++ ){
                    if(flag == 1){
                        flag++;
                    	continue;
                        
                    }
                    for(int l = j; l<j+3; l++){
                        total +=arr[k][l];
                    }
                    flag++;
                }
                total += arr[i+1][j+1];
                if(total>max){
                    max = total;
                }
            }
        }
        System.out.println(max);
    }
}
