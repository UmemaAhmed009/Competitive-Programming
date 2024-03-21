import java.util.*;
import java.io.*;
public class knapsack {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner input = new Scanner(System.in);
//        String inputString = new String(input.nextLine());
//        while (true) {
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine();
            if (line.isEmpty()) {
                break; // End the program if an empty line is encountered
            }
            String[] tokens = line.split(" ");
            int w = Integer.parseInt(tokens[0]); //the total weight of the knapsack
            int items = Integer.parseInt(tokens[1]); //no of items
            int[] P = new int[items + 1];// the array of profits of items, we will keep the first element of array=0
            int[] wt = new int[items + 1]; //the array of weights of items, we will keep the first element of array=0
            int[][] k = new int[items + 1][w + 1]; //the 2d matrix

            P[0] = 0;
            wt[0] = 0;
            for (int i = 1; i <= items; i++) {
                P[i] = scan.nextInt();
                wt[i] = scan.nextInt();
            }

            for (int i = 0; i <= items; i++) {
                for (int j = 0; j <= w; j++) {
                    if (i == 0 || j == 0) {
                        k[i][j] = 0;
                    } else if (wt[i] <= j) {
                        k[i][j] = Math.max(P[i] + k[i - 1][j - wt[i]], k[i - 1][j]);
                    } else {
                        k[i][j] = k[i - 1][j];
                    }
                }
            }
            ArrayList<Integer> array = new ArrayList<>();
            ;
            //for displaying the items put in knapsack
            int i = items;
            int j = w;
            while (i > 0 && j > 0) {
                if (k[i][j] != k[i - 1][j]) {
                    array.add(i - 1);
                    j = j - wt[i];
                    i--;
                } else {
                    i--;
                }
            }
            System.out.println(array.size());
//            printing the array
            for (Integer integer : array) {
                System.out.print(integer + " ");
            }
            System.out.println();
            line = scan.nextLine();
        }
    }
}
