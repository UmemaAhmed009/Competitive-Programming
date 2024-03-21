import java.util.*;
public class unfairplay {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        while (N != -1) {
            int M = scan.nextInt();
            int[] teamPoints = new int[N];
            int[] matchResults = new int[M];
            int maxPoints = 0;//points of team N
            for (int i = 0; i < N; i++) {
                teamPoints[i] = scan.nextInt();
            } 
            for (int i = 0; i < M; i++) {
                int t1 = scan.nextInt() - 1;
                int t2 = scan.nextInt() - 1;
                if (t1 == N-1 || t2 == N-1) { //team N is playing in match
                    if (t1 == N-1) {
                        teamPoints[t1] = teamPoints[t1] + 2;
                        matchResults[i] = 0;
                    } else {
                        teamPoints[t2] = teamPoints[t2] + 2;
                        matchResults[i] = 2;
                    }
                } else {
                    int a = teamPoints[t1];
                    int b = teamPoints[t2];
                    if (a <= b) {
//                        if (a + 2 <= b + 1) {
                        a = a + 2;
                        matchResults[i] = 0;//first team wins
                        teamPoints[t1] = a;
//                        }
                    } else {
                        b = b + 2;
                        matchResults[i] = 2; //2nd team wins
                        teamPoints[t2] = b;
                    }
//                    } else {
//                        a = a + 1;
//                        teamPoints[t1] = a;
//                        b = b + 1;
//                        teamPoints[t2] = b;
//                        matchResults[i] = 1; //match draws
//                    }
                }
            }
            maxPoints = teamPoints[N-1];
            boolean possibility = true; //the possibility of team N winning the league
            for (int i = 0; i < N - 1; i++) {
                if (teamPoints[i] >= maxPoints) {
                    possibility = false;
                    System.out.println("NO");
                    break;
                }
            }
            if (possibility) {
                for (int i = 0; i < M; i++) {
                    System.out.print(matchResults[i] + " ");
                }
            }
            N = scan.nextInt();
        }
    }

}

