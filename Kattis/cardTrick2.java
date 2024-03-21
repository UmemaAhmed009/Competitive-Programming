import java.util.*;
import java.util.Scanner;

public class cardTrick2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        while (n > 0) {
            n--;
            int cards = scanner.nextInt();
            List<Integer> deck = new ArrayList<>();

            // Perform the out shuffle
            for (int i = cards; i >= 1; i--) {
                deck.add(0,i);

                for (int j = 0; j < i; j++) {
                    int temp = deck.remove(deck.size() - 1);
                    deck.add(0,temp);
                }
            }
            // Print the resulting order of the cards
            for (int i : deck) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
