import java.util.*;
public class purpleRain {
    public static int[] maxSum(int[] array) {
        int[] vars = new int[3]; //vars[0] stores the sum, vars[1] stores the left position and vars[2] stores the right position
        int sum = 0;
        int left = 0;
        int right = 0;
        int largest = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (sum < 0) {
                sum = 0;
                left = i + 1;
            }
            else if (sum > largest) {
            largest = sum;
            right = i;
        }
//            else {
//                right =i;
//            }
        }
        vars[0] = sum; vars[1] = left; vars[2] = right;
        return vars;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        char[] arr = line.toCharArray();
        int[] red = new int[arr.length];
        int[] blue = new int[arr.length];

        for(int i=0; i< arr.length; i++){
            if(arr[i] == 'B'){
                red[i] = -1;
                blue[i] = 1;
            }
            if(arr[i] == 'R'){
                red[i] = 1;
                blue[i] = -1;
            }
        }
        //finding max sum using Kadane's algorithm
        int[] redArray =  maxSum(red);
        int[] blueArray =  maxSum(blue);
        if(redArray[0] > blueArray[0]){
            int left = redArray[1]+1;
            int right = redArray[2]+1;
            System.out.println(left + " " + right);
        }
        else if(blueArray[0] > redArray[0]){
            int left = blueArray[1]+1;
            int right = blueArray[2]+1;
            System.out.println(left + " " + right);
        }
        else {
            if (redArray[1] < blueArray[1]) {
                int left = redArray[1] + 1;
                int right = redArray[2] + 1;
                System.out.println(left + " " + right);
            } else if (blueArray[1] < redArray[1]) {
                int left = blueArray[1] + 1;
                int right = blueArray[2] + 1;
                System.out.println(left + " " + right);
            } else {
                if (redArray[2] < blueArray[2]) {
                    int left = redArray[1] + 1;
                    int right = redArray[2] + 1;
                    System.out.println(left + " " + right);
                } else {
                    int left = blueArray[1] + 1;
                    int right = blueArray[2] + 1;
                    System.out.println(left + " " + right);
                }
            }
        }
    }
}
