// A Java program to print topological
// sorting of a DAG
import java.io.*;
import java.util.*;
public class builddeps {
    // This class represents a directed graph
// using adjacency list representation
        // No. of vertices
        private int V;

        // Adjacency List as ArrayList of ArrayList's
        private HashMap<String,ArrayList<String>> adj;

        // Constructor
        builddeps(int v) {
            V = v;
            adj = new HashMap<>();
        }

        // Function to add an edge into the graph
//        void addEdge(String v, String w) { adj.; }

        // A recursive function used by topologicalSort
        void topologicalSortUtil(String v, HashMap<String, Boolean> visited,
                                 Stack<String> stack)
        {
            // Mark the current node as visited.
            visited.replace(v,true);
            String str ="";

            // Recur for all the vertices adjacent
            // to this vertex
            Iterator<String> it = adj.get(v).iterator();
            while (it.hasNext()) {
                str = it.next();
                if (!visited.get(str))
                    topologicalSortUtil(str, visited, stack);
            }

            // Push current vertex to stack
            // which stores result
            stack.push(v);
        }

        // The function to do Topological Sort.
        // It uses recursive topologicalSortUtil()
        void topologicalSort(String file)
        {
            Stack<String> stack = new Stack<String>();

            // Mark all the vertices as not visited
            HashMap<String,Boolean> visited = new HashMap<>();
            for (String s : adj.keySet()) {
                visited.put(s, false);
            }

            // Call the recursive helper
            // function to store
            // Topological Sort starting
            // from all vertices one by one
//            for (int i = 0; i < V; i++)
//                if (visited[i] == false)
            topologicalSortUtil(file, visited, stack);

            // Print contents of stack
            while (!stack.empty())
                System.out.println(stack.pop());
        }

        // Driver code
        public static void main(String[] args)
        {
            Scanner sc = new Scanner(System.in);
            int V = sc.nextInt();
            builddeps g = new builddeps(V);
            sc.nextLine();
            for(int i=0; i< V; i++){
                String[] str = sc.nextLine().split(" ");
                str[0] = str[0].replace(":","");
                for(int j=1; j<str.length;j++){
                    if(!g.adj.containsKey(str[0])){
                        g.adj.put(str[0],new ArrayList<>());
                    }
                    if(g.adj.containsKey(str[j])){
                        g.adj.get(str[j]).add(str[0]);
                    }
                    else{
                        ArrayList<String> list = new ArrayList<>();
                        list.add(str[0]);
                        g.adj.put(str[j],list);
                    }
                }
            }
            String file = sc.nextLine();
//                System.out.println("Array: "+Arrays.toString(str));
            //Function Call
            g.topologicalSort(file);
    }
}
