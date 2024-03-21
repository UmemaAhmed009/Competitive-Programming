import java.util.Scanner;

public class beatspread {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int noOfTestCases = scan.nextInt();
        for (int i = 0; i < noOfTestCases; i++) {
            int sum = scan.nextInt();
            int difference = scan.nextInt();
            
            int val1 = (sum + difference) / 2;
            int val2 = sum - val1;
            if (sum > difference) {
                System.out.print(val1 + " " + val2);
            }
            else if (sum > difference && (sum%2!=0 || difference%2!=0)){
                System.out.print("impossible");
            }
            else if(sum == difference){
                System.out.println(val1 + " " + 0);
            }
            else {
                System.out.print("impossible");
            }
        }
    }
}