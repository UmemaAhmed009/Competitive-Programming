import java.util.*;
public class trik{
    public static void main(String[] args) {
        boolean[] value = new boolean[3];
        value[0] = true;
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        for(int i=0; i<str.length(); i++){
            char swapPosition = str.charAt(i);
            if(swapPosition == 'A'){
                boolean temp = value[0];
                value[0] = value[1];
                value[1] = temp;
            }
            else if(swapPosition == 'B'){
                boolean temp = value[1];
                value[1] = value[2];
                value[2] = temp;
            }
            else if(swapPosition == 'C'){
                boolean temp = value[0];
                value[0] = value[2];
                value[2] = temp;
            }
        }
        int position=0;
        //going through the entire array to find the place of ball
        for(int j=0; j<3; j++){
            if(value[j] == true){
                position = j+1;
                break;
            }
        }
        System.out.println(position);
    }
}
