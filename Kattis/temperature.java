import java.util.*;

public class temperature {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double X = sc.nextDouble();
        double Y = sc.nextDouble();
        if(X ==0 &&Y ==1){
            System.out.println("ALL GOOD");
        }
        else if(Y ==1){
            System.out.println("IMPOSSIBLE");
        }
        else{
            double N = X/(1-Y);
            if(N % 1 != 0){
                System.out.format("%.6f",N);
            }
            else{
                System.out.println((int)N);
        }
    }
    }
}
