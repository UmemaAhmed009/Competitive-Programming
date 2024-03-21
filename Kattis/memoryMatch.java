import java.util.*;
public class memoryMatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        /*Approach:
        * 1.Increment the count if two identical cards have occurred.
        * 2.If count of cards occurring once and cards left is same then add that number to count.
        * 3.If cards left = 2 and no individual cards(cards occurring once) remaining then those two
        * are same so add 1 to count.
        * 4. Subtract found pairs from count. */
        int count =0;
        int foundPairs = 0;
        int individualElements =0;
        int cardsLeft =0;
        boolean checkIfCountIncremented = false;

        HashMap<Integer, String> list = new HashMap<Integer, String>();
        for(int i=0; i< k; i++){
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            String word1 = sc.next();
            String word2 = sc.next();
            //checking if both words are same then foundPairs will be incremented
            if(word1.equals(word2)){
                foundPairs++;
            }
            list.put(num1, word1);
            list.put(num2, word2);
        }
        individualElements++;
        for(int i =2; i< n+1; i++){
            if(list.get(i) == null) {
                cardsLeft++;
                continue;
            }
            for(int j=1;  j< i; j++){
                //Condition: 1
                if(list.get(i).equals(list.get(j))) {
                    individualElements--;
                    count++;
                    checkIfCountIncremented = true;
                }
            }
            if(checkIfCountIncremented == false) {
                individualElements++;
            }
            checkIfCountIncremented = false;

        }
        //Condition: 2
        if(individualElements == cardsLeft){
            count = count + individualElements;
        }
        //Condition: 3
        if(individualElements == 0 && cardsLeft == 2){
            count++;
        }
        //Condition: 4
        count = count - foundPairs;
        System.out.println(count);
    }
}
