/* Java program for solution of
M Coloring problem using backtracking */
import java.util.*;

public class vivoparc {
    static int V;
    int color[];

    /* A utility function to check
    if the current color assignment
    is safe for vertex v */
    boolean isSafe(int v, int graph[][], int color[], int c)
    {
        for (int i = 0; i < V; i++)
            if (graph[v][i] == 1 && c == color[i])
                return false;
        return true;
    }

    /* A recursive utility function
    to solve m coloring problem */
    boolean graphColoringUtil(int graph[][], int m,
                              int color[], int v)
    {
		/* base case: If all vertices are
		assigned a color then return true */
        if (v == V)
            return true;

		/* Consider this vertex v and try
		different colors */
        for (int c = 1; c <= m; c++) {
			/* Check if assignment of color c to v
			is fine*/
            if (isSafe(v, graph, color, c)) {
                color[v] = c;

				/* recur to assign colors to rest
				of the vertices */
                if (graphColoringUtil(graph, m, color,
                        v + 1))
                    return true;

				/* If assigning color c doesn't lead
				to a solution then remove it */
                color[v] = 0;
            }
        }

		/* If no color can be assigned to
		this vertex then return false */
        return false;
    }

    /* This function solves the m Coloring problem using
    Backtracking. It mainly uses graphColoringUtil()
    to solve the problem. It returns false if the m
    colors cannot be assigned, otherwise return true
    and prints assignments of colors to all vertices.
    Please note that there may be more than one
    solutions, this function prints one of the
    feasible solutions.*/
    void graphColoring(int[][] graph, int m)
    {
        // Initialize all color values as 0. This
        // initialization is needed correct
        // functioning of isSafe()
        color = new int[V];
        for (int i = 1; i < V; i++)
            color[i] = 0;

        graphColoringUtil(graph, m, color, 1);

        // Print the solution
        printSolution(color);
    }

    /* A utility function to print solution */
    void printSolution(int color[])
    {
        for (int i = 1; i < V; i++)
            System.out.println(i + " " + color[i]);
        System.out.println();
    }

    // Driver code
    public static void main(String args[])
    {
        vivoparc Coloring = new vivoparc();
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt()+1;
        int[][] graph = new int[V][V];
        for(int i=0; i< V; i++){
            for(int j=0; j<V; j++){
                graph[i][j] = 0;
            }
        }
        String str = sc.nextLine();
        while(sc.hasNext()){
            str = sc.nextLine();
            if(str == null){
                break;
            }
            String[] arr = str.split("-");
            int v1 = Integer.parseInt(arr[0]);
            int v2 = Integer.parseInt(arr[1]);
            if(v1==0 && v2 ==0){
                break;
            }
            if(graph[v1][v2] !=1) {
                graph[v1][v2] = 1;
                graph[v2][v1] = 1;
            }
        }
        int m = 4; // Number of colors

        // Function call
        Coloring.graphColoring(graph, m);
    }
}

