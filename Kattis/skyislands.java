import java.util.*;
public class skyislands{
    static ArrayList<ArrayList<Integer>> graph;
    static int V;
    public static boolean DFS(int v,int[] visited){
        visited[v] = 1;
        // if(v==V){
        //     return true;
        // }
        Iterator<Integer> it = graph.get(v).iterator();
        while(it.hasNext()){
            int adjacent = it.next();
            if(visited[adjacent] != 1) DFS(adjacent,visited);
        }
        for(int i=1; i<visited.length;i++){
            if(visited[i] == 0){
                return false;
            }
        }
        return true;
    }
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //no of vertices
        V = N;
        graph = new ArrayList<>();
        int l =N+1; 
        for(int i=0; i< l; i++){
            graph.add(new ArrayList<Integer>());
        }
        int M = sc.nextInt();//no of edges 
        for(int i =0; i< M; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            graph.get(v1).add(v2);
        }
        //Running DFS to check if graph is connected
        int[] visited = new int[N+1];
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        if(DFS(1, visited)){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
         }
}