import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class getShorty {
        public static class Vertex{
            private int name;
            Map<Vertex,Double> adjList = new HashMap<>();
            private double factor = 1.0;
            public Vertex(int v) {
                this.name = v;
            }
            //setters and getters
            public void addNeighbour(Vertex neighbour, double edgeLength){
                this.adjList.put(neighbour,edgeLength);
            }
            public double getFactor(){
                return this.factor;
            }
        }
        public static class Graph{
            Vertex[] vertices;
            public Graph(int n){
                vertices = new Vertex[n];
                for(int i=0; i<n; i++){
                    vertices[i] = new Vertex(i);
                }
            }
        }
        public static double dijikstra(Graph g){
            double[] factors = new double[g.vertices.length];
            factors[0] = 1.0;

            HashSet<Vertex> settled = new HashSet<>();
            PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(Vertex::getFactor).reversed());
            for(Vertex v: g.vertices){
                v.factor = (v == g.vertices[0]) ? 1.0 : 0.0;
                priorityQueue.add(v);
            }
            while (!priorityQueue.isEmpty()) {
                Vertex currentNode = priorityQueue.poll();
                if(currentNode == null){
                    break;
                }
                if(settled.contains(currentNode)){
                    continue;
                }

                //Calculate new distances to direct neighbours by keeping the lowest distance at each evaluation
                for(Map.Entry<Vertex,Double> adjPair: currentNode.adjList.entrySet()){
                    Vertex adjacentNode = adjPair.getKey();
                    double edgeWeight = adjPair.getValue();
                    if(!settled.contains(adjacentNode)){
                         double newFactor = edgeWeight * currentNode.factor;
                         if(factors[adjacentNode.name] < newFactor ){
                             factors[adjacentNode.name] = newFactor;
                             priorityQueue.remove(adjacentNode);
                             adjacentNode.factor = newFactor;
                             priorityQueue.add(adjacentNode);
                         }
                    }
                }
                settled.add(currentNode);
            }
            return factors[factors.length -1];
        }
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while (true){
                String line = br.readLine();
                String[] arr = line.split(" ");
                int n = Integer.parseInt(arr[0]); //no of intersections
                int m = Integer.parseInt(arr[1]); // no of corridors
                if(n ==0 && m==0){
                    break;
                }
                Graph graph = new Graph(n);
                for(int i=0; i<m;i++) {
                    line = br.readLine();
                    arr = line.split(" ");
                    int u = Integer.parseInt(arr[0]);
                    int v = Integer.parseInt(arr[1]);
                    double w = Double.parseDouble(arr[2]);

                    Vertex U = graph.vertices[u];
                    Vertex V = graph.vertices[v];

                    U.addNeighbour(V, w);
                    V.addNeighbour(U, w);
                }
                double factor = dijikstra(graph);

                System.out.format("%.4f", factor);
                System.out.println();
            }
        }
}

