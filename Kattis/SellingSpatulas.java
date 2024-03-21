import java.util.Arrays;
import java.util.Scanner;

public class SellingSpatulas {

    public static boolean areEqual(double a, double b){
        return Math.abs(a-b) <= 1e-9;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == 0) {
                break;
            }

            double[] profit = new double[1440];
            Arrays.fill(profit, -0.08);

            for (int i = 0; i < n; i++) {
                int stamp = scanner.nextInt();
                double price = scanner.nextDouble();
                profit[stamp] += price;
            }
            //Kadane's algorithm in profit
            double sum = 0, ans= 0;
            int sumStart = 0, sumDuration = 0, ansStart = 0, ansDuration =0;

            for (int i = 0; i < 1440; i++) {
                sum += profit[i];

                if (sum < 1e-9) { //better to reset sum
                    sum = 0;
                    sumStart = i + 1;
                    sumDuration = 0;
                } else { //extend sum to current sum
                    sumDuration++;
                }
                //Check if current sum is a better ans
                if (sum - ans > 1e-9) { //if ans is strictly less than sum
                    ans = sum;
                    ansStart = sumStart;
                    ansDuration = sumDuration;
                }
                //if both sum and ans are equal
                else if (areEqual(ans, sum)) {
                    //check if our time period is shorter or not if equal
                    if (sumDuration < ansDuration) {
                        //sum period is shorter
                        ansStart = sumStart;
                        ansDuration = sumDuration;
                    }
                    //else we take the earlier one, i.e. the ans one
                }
            }
                if (areEqual(0,ans)) {
                    System.out.println("no profit");
                }
                else{
                    System.out.printf("%.2f %d %d\n", ans, ansStart, ansStart + ansDuration -1);
                }
        }
    }
}

