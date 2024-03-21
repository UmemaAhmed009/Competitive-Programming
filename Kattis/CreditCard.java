
import java.util.Scanner;
import java.lang.Math;
public class CreditCard {
    public static double MonthlyPayments(double R, double B, double M)
    {
        //interest in dollars
        double interest = R/100 * B;
        //converting monthly interest to nearest cent
        interest = Math.round(interest * 100.0) /100.0;

        double totalOutstandingBalance = (B + interest);
        totalOutstandingBalance = Math.round(totalOutstandingBalance * 100.0)/100.0;
        double result= (totalOutstandingBalance - M);
        result = Math.round(result * 100.0)/100.0;

        return result;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for(int i =0; i < testCases; i++){
            double R = in.nextDouble();
            double B = in.nextDouble();
            double M = in.nextDouble();
            double error = 1e-16;

            int Payments = 0;

            double result =  MonthlyPayments(R,B,M);

            while(result > error && Payments <= 1200){
                Payments++;
                result = MonthlyPayments(R,result,M);
            }
            if(Payments > 1200){
                System.out.println("impossible");
            }
            else {
                Payments++;
                System.out.println(Payments);
            }
        }
    }

}
