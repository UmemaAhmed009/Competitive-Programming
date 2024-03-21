import java.util.*;
//the graph is undirected
//nodes: cities starting from 0
//edges: roads
public class bumped {
    static List<Integer>[] graph;
    static Map<Integer, Map<Integer, Integer>> edgeCosts;
    public static int Dijikstra(int source, int target){
        int[] distance = new int[graph.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(distanceValue -> distance[distanceValue]));
        pq.add(source);
        boolean[] flightUsed = new boolean[graph.length];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        while(!pq.isEmpty()){
            int current = pq.poll();
            for(int neighbour: graph[current]){
                int cost = edgeCosts.get(current).get(neighbour);
                if(distance[neighbour] > distance[current]+cost){
                    if(cost ==-1 && !flightUsed[current]){
                        distance[neighbour] = distance[current];
                        flightUsed[current] = true;
                    }
                    else distance[neighbour] = distance[current]+cost;
//                    if(!pq.contains(neighbour))
                    pq.add(neighbour);
                }
            }
        }
        return distance[target];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int f = sc.nextInt();
        int s = sc.nextInt();
        int t = sc.nextInt();

        graph = new ArrayList[n];
        edgeCosts = new HashMap<>();

        for(int i=0;i<n; i++){
            graph[i]= new ArrayList<>();
            edgeCosts.put(i, new HashMap<>());
        }
        for(int i=0; i< m; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            edgeCosts.get(v1).put(v2, cost);
            edgeCosts.get(v2).put(v1, cost);
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        for(int j=0; j<f;j++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            graph[v1].add(v2);
            edgeCosts.get(v1).put(v2, -1);
        }
//        int flight_start = sc.nextInt();
//        int flight_end = sc.nextInt();
        int final_cost = Dijikstra(s, t);
//        if(flight_start == s && flight_end == t){
//            System.out.println(0);
//        }
//        else{
            System.out.println(final_cost);
//        }
    }
    
}
