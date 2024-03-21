import java.util.*;
public class studentsko {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int noOfStudents = N/K;
        int minutes =0;
        int[] array = new int[N];
        //Taking inputs from user
        for(int i=0; i< N; i++){
            array[i] = sc.nextInt();
        }
        //Sorting all teams
        int index =0;
        for(int i=0; i< N; i++){
            ArrayList<Integer> arr1 = new ArrayList<>();
            for(int j=0; j< noOfStudents; j++){
                if(array[i]> array[j]){
                    
                }
            }
        }
            System.out.println(minutes);
        }
    }

