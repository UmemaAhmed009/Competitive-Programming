import java.util.*;
public class awkwardParty {
    public static void main(String[] args) {
     Scanner scan = new Scanner(System.in);
      int totalPeople = scan.nextInt();
      HashMap<Integer, Integer> hm= new HashMap<>(0, 0);
      List<Integer> arrayIndex = new ArrayList<>();
      for(int i=0; i<totalPeople; i++){
        int num = scan.nextInt();
        if(arrayIndex.contains(num)){
            int x = arrayIndex.indexOf(num);
            int y = i;
            int difference = y-i;
            hm.put(i,difference);
        }
        else{
        arrayIndex.add(i);
        }
      }
//      List<Integer> sortedList = hm.values();
      

    }
}
