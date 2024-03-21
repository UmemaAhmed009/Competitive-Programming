import java.util.*;
public class muzicari {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();//no of concert minutes
        int N = scan.nextInt();//no of musicians
        int wt[] = new int[N+1];
        wt[0] =0;//array of break minutes
        //In this problem, the array of weights wt[] and the array of profits P[] are same
        for(int i=1; i<=N; i++){
            wt[i] = scan.nextInt();
        }
        int[][] dp= new int[N+1][T+1];

        //filling the table
        for(int i=0; i<N; i++){
            for(int j=0; j<=T; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (wt[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i]] + wt[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        boolean[] used = new boolean[N]; //to denote which items are put in knapsack
        //backtracking
        int i = N;
        int j = T;
        while(i >0 && j > 0){
            if(dp[i][j] != dp[i-1][j]) {
                used[i - 1] = true;
                j = j - wt[i];
            }
            i--;
        }
        //printing the solution
        for(int index=0; index<used.length;index++){
            if(used[index]){
                System.out.print(i + " ");
                i = i + wt[index+1];
            }
            else{
                System.out.print(j + " ");
                j = j + wt[index+1];
            }
        }

        }
    }

