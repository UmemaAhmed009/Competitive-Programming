import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class breakingBad {
    public static class Graph{
        private int V;//no of vertices
        private Map<String, List<String>> adjList = new HashMap<>();
        Map<String, Boolean> visited = new HashMap<>();//visited hashmap
        Graph(String[] items) {
            for (String item : items) {
                adjList.put(item, new ArrayList<>());
                visited.put(item,false);
            }
        }
         public void addEdge(String u, String v) {
            adjList.get(u).add(v);
        }
        //bfs implementation
        public void bfs(){
            Map<String, String> colorMap = new HashMap<>();//for maintaining a bipartite graph
            Queue<String> queue = new LinkedList<>();//queue for bfs

            //below for loop is for multiple connected components
            for (String key : adjList.keySet()) {
                if (!visited.get(key)) {
                    queue.add(key);
                    colorMap.put(key, "blue");
                    visited.put(key,true); //set the vertex to visited
                    while (!queue.isEmpty()) {
                        String current = queue.poll();
                        String oppositeColor = "";
                        if (colorMap.get(current).equals("blue")) {
                            oppositeColor = "red";
                        } else {
                            oppositeColor = "blue";
                        }
                        for (String neighbour : adjList.get(current)) {
                            if (!visited.get(neighbour)) {
                                queue.add(neighbour);
                                visited.put(neighbour,true);
                                colorMap.put(neighbour, oppositeColor);
                            } else if (colorMap.get(current).equals(colorMap.get(neighbour))) {
                                System.out.println("impossible");
                                return;
                            }
                        }
                    }
                }
            }

        for (String s : colorMap.keySet()) {
            String value = colorMap.get(s);
            if (value.equals("red")) {
                System.out.print(s + " ");
            }
        }
        System.out.println();
        for (String s : colorMap.keySet()) {
            String value = colorMap.get(s);
            if (value.equals("blue")) {
                System.out.print(s + " ");
            }
        }
        }
    }
    public static void main(String[] args) throws IOException{
    //Scanner scan = new Scanner(System.in);
    BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
//        int N = scan.nextInt();
        int N = Integer.parseInt(reader.readLine());
//        scan.nextLine();
        String[] items = new String[N];

        for (int i = 0; i < N; i++) {
//            String v = scan.nextLine();
            String v = reader.readLine();
            items[i] = v;
        }
        Graph graph = new Graph(items);
//        int M = scan.nextInt();
        int M = Integer.parseInt(reader.readLine());
//        scan.nextLine();
        String[] lines = new String[M];
        for (int i = 0; i < M; i++) {
//            lines[i] = scan.nextLine();
            lines[i] = reader.readLine();
            String[] str = lines[i].split(" ");
            for (int j = 1; j < str.length; j++) {
                graph.addEdge(str[0], str[j]);
                graph.addEdge(str[j], str[0]);
            }
        }
        graph.bfs();
    }
}
