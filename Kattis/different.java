import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class different{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null){
            String[] arr = line.split(" ");
            long num1 = Long.parseLong(arr[0]);
            long num2 = Long.parseLong(arr[1]);
            long diff =0;
            if(num1 > num2){
                diff = (num1 - num2);
            }
            else{
                diff = (num2 - num1);
            }
            System.out.println(diff);
        }
    }
}
