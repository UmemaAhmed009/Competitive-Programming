import java.util.*;
public class Dijikstra {
    public static class Vertex{
        private String name;
        private Vertex predecessor;
        private int weight = Integer.MAX_VALUE;//distance from the source
        Map<Vertex,Integer> adjList = new HashMap<>();
        private List<Vertex> shortestPath = new LinkedList<>();
        public Vertex(String name){
            this.name = name;
        }
        //setters and getters
        public void addNeighbour(Vertex neighbour,int edgeLength){
            this.adjList.put(neighbour,edgeLength);
        }
        public void setWeight(int weight){
            this.weight = weight;
        }
        public int getWeight(){
            return this.weight;
        }
        public List<Vertex> getShortestPath(){
            return this.shortestPath;
        }
        public void setShortestPath(List<Vertex> shortestPath){
            this.shortestPath = shortestPath;
        }
    }
    public static class Graph{
        HashSet<Vertex> vertices = new HashSet<>();
//        private List<Vertex> shortestPath = new LinkedList<>();
        public void addVertex(Vertex V){
            vertices.add(V);
        }

    }
    public static Graph dijikstra(Vertex startNode, Graph g){

        HashSet<Vertex> settled = new HashSet<>();
        HashSet<Vertex> unsettled = new HashSet<>();
        startNode.setWeight(0);

        unsettled.add(startNode);
        while(!unsettled.isEmpty()){
            Vertex currentNode = null;
            int sourceDistance = Integer.MAX_VALUE;
            //choosing the node with the lowest distance from the source
            for(Vertex v:unsettled) {
                if (v.getWeight() < sourceDistance) {
                    sourceDistance = v.getWeight();
                    currentNode = v;
                }
            }
                unsettled.remove(currentNode);
                //Calculate new distances to direct neighbours by keeping the lowest distance at each evaluation
                for(Map.Entry<Vertex,Integer> adjPair: currentNode.adjList.entrySet()){
                    Vertex adjacentNode = adjPair.getKey();
                    int edgeWeight = adjPair.getValue();
                    if(!settled.contains(adjacentNode)){

                        if(sourceDistance + edgeWeight < adjacentNode.getWeight()){
                            adjacentNode.setWeight(sourceDistance + edgeWeight);
                            LinkedList<Vertex> shortestPath = new LinkedList<>(currentNode.getShortestPath());
                            shortestPath.add(currentNode);
                            adjacentNode.setShortestPath(shortestPath);
                        }
                        unsettled.add(adjacentNode);
                    }
                }
                settled.add(currentNode);
            }
        return g;
    }

    public static void main(String[] args) {
        Vertex A = new Vertex("0");
        Vertex B = new Vertex("1");
        Vertex C = new Vertex("2");
        Vertex D = new Vertex("3");
        Vertex E = new Vertex("4");
//        Vertex F = new Vertex("F");

        A.addNeighbour(B,3);
        A.addNeighbour(D,8);
        A.addNeighbour(E,8);

        B.addNeighbour(A,3);
        B.addNeighbour(C,1);
        B.addNeighbour(D,4);

        C.addNeighbour(B,1);
        C.addNeighbour(D,2);

        D.addNeighbour(A,8);
        D.addNeighbour(B,4);
        D.addNeighbour(C,2);
        D.addNeighbour(E,3);

        E.addNeighbour(A,7);
        E.addNeighbour(D,3);

        Graph graph = new Graph();
        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        graph.addVertex(D);
        graph.addVertex(E);

        graph = dijikstra(A,graph);
        for(Vertex v: graph.vertices){
            System.out.print(v.name+":");
            for(Vertex V: v.getShortestPath()){
                System.out.print(V.name+" ");
            }
            System.out.println();
        }

    }
}
