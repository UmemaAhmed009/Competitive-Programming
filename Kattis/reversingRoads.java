import java.util.*;
import java.util.LinkedList;
public class reversingRoads {
    static String[] point;
    static boolean[] p;
    static class Graph{
        private int V; //No of vertices
        private LinkedList<Integer>[] adj; //Adjacency List
        //Constructor
        @SuppressWarnings("unchecked")
        Graph(int v){
            V = v;
            adj = new LinkedList[v];
//            pair = new ArrayList<>();

            for(int i =0; i<v; i++){
                adj[i] = new LinkedList<>();
            }
        }
        //Function to add an edge into the graph
        void addEdge(int v, int w){
            adj[v].add(w);
        }
        //A recursive function to print DFS starting from v
        void DFSUtil(int v, Boolean[] visited){
            //Mark the current node as visited
            visited[v] = true;
            int n;
            //Recur for all the vertices adjacent to this vertex
            Iterator<Integer> i = adj[v].iterator();
            while(i.hasNext()){
                n = i.next();
                if(!visited[n]){
                    DFSUtil(n,visited);
                }
            }
        }
        //Function that returns transpose of this graph
        Graph getTranspose(){
            Graph g = new Graph((V));
            for(int v=0; v < V; v++){
                //Recur for all the vertices adjacent to this vertex
                Iterator<Integer> i = adj[v].listIterator();
                while(i.hasNext()){
                    g.adj[i.next()].add(v);
                }
            }
            return g;
        }
        //The main function
        void isSC(int c){
            //Step 1: Mark all the vertices as not visited
            //(For first DFS)
            Boolean[] visited = new Boolean[V];
            for(int i =0; i< V ;i++){
             visited[i] = false;
            }
            //Step: 2 Do DFS Traversal starting from first vertex
            DFSUtil(0, visited);

            //If DFS Traversal doesn't visit all vertices, then print "invalid"
            for(int i =0; i< V; i++) {
                if (!visited[i]) {
                    System.out.println("Case " + c + ": invalid");
                    return;
                }
            }

                //Step:3 Create a transposed graph
                Graph gr = getTranspose();

                //Step 4: Mark all the vertices as not visited
                //(For second DFS)
                for(int i=0; i< V; i++){
                    visited[i] = false;
                }

                int count =0;
                //Step 5: Do DFS for transposed graph starting from
                //first vertex. Starting vertex must be the same starting
                //point of first DFS.

                gr.DFSUtil(0, visited);
                boolean valid = true;
                for(int i=0; i< V; i++){
                    if (!visited[i]) {
                        valid = false;
                        break;
                    }}
            if(valid){
                System.out.println("Case " + c + ": valid");
            }
            else{
                //If all vertices are not visited in second DFS, then try to reverse
                //direction
                int a,b;
                for(int i=0; i< V; i++){
//                        if (!visited[i]) {
////                            a = i - 1;
////                            b = i;
////                            gr.adj[a].add(b);
////                            gr.adj[b].remove(0);
//                            a = i;
//                            b = i + 1;
//                            gr.adj[a].add(b);
//                            gr.adj[b].remove(Integer.valueOf(a));
//                            for (int k = 0; k < point.length; k++) if (point[k].equals(a + " " + b)) p[k] = true;
//                            count++;
                    for(int j=0;j<gr.adj[i].size();j++) {
                        a = i;
                        b = gr.adj[a].remove(0);
                        gr.adj[b].add(a);
                        for (int k = 0; k < point.length; k++) if (point[k].equals(a + " " + b)) p[k] = true;

                        gr.adj[a].add(b);
                        gr.adj[b].remove(gr.adj[b].size() - 1);
                    }
                    }
                    for(int i=0; i< point.length;i++){
                        if(!p[i]){
                            System.out.println("Case " + c +": "+ point[i]);
                            break;
                        }
                    }
                }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        while(sc.hasNext()){
            ++count;
            int m = sc.nextInt();
            int n = sc.nextInt();
            Graph g = new Graph(m);
            point = new String[n];
            p = new boolean[n];
            for(int i =0; i< n; i++){
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                g.addEdge(v1, v2);
                point[i] = v1+" "+v2;
            }
            g.isSC(count);
        }
    }
}
