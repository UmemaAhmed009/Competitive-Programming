import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class tornToPieces {
    static String startPos;
    static String endPos;
    static Stack<String> stack;
    static Map<String, String> parentMap = new HashMap<>();
    //    static Stack<String> finalPath = new Stack<>();
    static ArrayList<String> finalPath = new ArrayList<>();

    public static class Graph {
        private int V; //no of vertices
        private Map<String, List<String>> adjList = new HashMap<>();
        Map<String, Boolean> visited = new HashMap<>();//hashmap for storing visited nodes

        Graph(List<String> items) {
            V = items.size();
            for (String item : items) {
                adjList.put(item, new ArrayList<>());
                visited.put(item, false);
            }
        }

        public void addEdge(String u, String v) {
            adjList.get(u).add(v);
        }

        //get adjacency list of a vertex
        public List<String> getAdjList(String v) {
            return adjList.get(v);
        }

        boolean dfs(Stack<String> stack) {
            if (stack.isEmpty()) {
                return false;
            }
            String v = stack.pop();
            if(!adjList.containsKey(v)){
                return false;
            }
            if (adjList.get(v).isEmpty()) {
                return false;
            }
            if (v.equals(startPos)) {
                return true;
            }
            visited.put(v, true);
            for (String adjacent : adjList.get(v)) {
                if (!visited.get(adjacent)) {
                    parentMap.put(adjacent, v);
//                    parentMap.put(v, adjacent);
                    stack.push(adjacent);
                    if (dfs(stack)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        int N = Integer.parseInt(reader.readLine());
        List<String> items = new ArrayList<String>();

        String[] lines = new String[N];
        //for getting vertices of graphs
        for (int i = 0; i < N; i++) {
            lines[i] = reader.readLine();
            String[] s = lines[i].split(" ");
            for (String string : s) {
                if (!items.contains(string)) {
                    items.add(string);
                }
            }
        }
        Graph graph = new Graph(items); //a graph with given vertices is created
        String lastLine = reader.readLine();
        String[] path = lastLine.split(" ");
        startPos = path[0];
        endPos = path[1];

        //Adding bidirectional edges
        for (int i = 0; i < N; i++) {
            String[] str = lines[i].split(" ");
            for (int j = 1; j < str.length; j++) {
                if (!graph.getAdjList(str[0]).contains(str[j])) {
                    graph.addEdge(str[0], str[j]);
                    graph.addEdge(str[j], str[0]);
                }
            }
        }
        stack = new Stack<>();
        stack.push(endPos);
        parentMap.put(startPos, null);
        if (!graph.dfs(stack)) {
            System.out.println("no route found");
        } else {
//                finalPath.push(endPos);
            String current = startPos;
            finalPath.add(current);
            while (!current.equals(endPos)) {
//                while (!endPos.equals(startPos)) {
//                    endPos = parentMap.(endPos);
                current = parentMap.get(current);
                finalPath.add(current);
//                    finalPath.push(endPos);
            }
//
//                finalPath.push(endPos);
//                endPos = parentMap.get(endPos);
////                if (startPos == null) {
////
////                    return;
////                }
//                while (endPos != null) {
//                    finalPath.push(endPos);
//                    endPos = parentMap.get(endPos);
//                }
            System.out.println();
            for (String s : finalPath) {
                System.out.print(s + " ");


//                while (!finalPath.isEmpty()) {
//                    String str = finalPath.pop();
//                    System.out.print(str + " ");
//
//                }
            }
        }
    }
}