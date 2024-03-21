import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
public class whereismyinternet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str =br.readLine().split(" ");
        int N = Integer.parseInt(str[0]); // no of nodes
        int M = Integer.parseInt(str[1]); // no of edges
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int t =0;
//        Set<Integer> connectedNodes = new HashSet<>();
//        ArrayList<Integer> notConnected = new ArrayList<>();

        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
//            notConnected.add(i);
        }
        for(int i=0; i<M; i++){
            str =br.readLine().split(" ");
            int v1 = Integer.parseInt(str[0]);
            int v2 = Integer.parseInt(str[1]);
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        boolean[] visited =new boolean[N+1];
        for(int i=0; i<=N;i++){
            visited[i] = false;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1]= true;
        t++;
//        connectedNodes.add(1);
//        notConnected.remove(1);
        while(!queue.isEmpty()){
            int current = queue.remove();
            for(int neighbour:graph.get(current)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.add(neighbour);
                    t++;
//                    connectedNodes.add(neighbour);
//                    notConnected.remove(Integer.valueOf(neighbour));
                }
            }
        }
//        if(connectedNodes.size() ==N){
        if(t ==N){
        System.out.println("Connected");
        }
//        for(int i=1 ;i<=N; i++){
//            if(!visited[i]){
//                notConnected.add(i);
//                System.out.println(i);
//            }
//        }
        for(int i=1; i<=N; i++){
//            if (!connectedNodes.contains(i)) {
            if (!visited[i]) {
                bw.append(i + "\n");
//                System.out.println(i);
            }
//            System.out.println(notConnected.get(i));
        }
        bw.flush();
    }
}
