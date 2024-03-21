import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class buttonBashing{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for(int i =0; i< testCases; i++){
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]); //no of buttons
            int t = Integer.parseInt(str[1]); //desired cooking time
            int[] V = new int[n];
            str = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                V[j] = Integer.parseInt(str[j]);
            }
            BFS(V, t);
        }

    }
    private static void BFS(int[] V, int desiredTime) {
        ArrayList<int[]> adj = new ArrayList<>(V.length);
        for (int i = 0; i < V.length; i++) {
            adj.add(V);
        }
        int sourceVertex = 0;
        int[] buttonPresses = new int[3601];
        Arrays.fill(buttonPresses, Integer.MAX_VALUE);
        buttonPresses[0] = 0;

        LinkedList<Integer> Queue = new LinkedList<Integer>();
        Queue.add(sourceVertex);

        //main BFS program
        while (!Queue.isEmpty()) {
            int current = Queue.remove();
            int currentDistance = buttonPresses[current];

            for (int i = 0; i < V.length; i++) {
                int vertex = current + V[i];
                if (vertex < 0) {
                    vertex = 0;
                }
                if (vertex >= buttonPresses.length) {
                    vertex = 3600;
                }
                if (buttonPresses[vertex] > currentDistance + 1) {
                    buttonPresses[vertex] = currentDistance + 1;
                    Queue.add(vertex);
                }
            }
        }
        int index = desiredTime;
        int count = 0;
        while (true) {
            if (buttonPresses[index] != Integer.MAX_VALUE){
                break;
            }
            index +=1;
            count +=1;
        }
        System.out.println(buttonPresses[index] + " " + count);
    }
    }

