import java.util.*;

public class babyBites {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            String word = sc.next();
            if (word.equals("mumble") || Integer.parseInt(word) == count + 1) {
                count++;
            } 
        }
        if(count == n){
            System.out.println("makes sense");
        }
        else {
                System.out.println("Something is fishy");
            }
    }
}
