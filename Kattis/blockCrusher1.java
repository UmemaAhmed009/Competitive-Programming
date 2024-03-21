import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class blockCrusher1 {
    public static class Pair {
        private int x;
        private int y;
        public Pair(int first, int second) {
            this.x = first;
            this.y = second;
        }
    }

    public static class Vertex {
        private int distance;
        ArrayList<Vertex> neighbours = new ArrayList<>();
        private Vertex predecessor;
        private Pair index;
        public int getDistance(){
            return this.distance;
        }
    }
    public static boolean isValid(int x,int y, int height, int width){
        return x >= 0 && x < height && y >= 0 && y < width;
    }
    public static void dijkstra(int[][] block) {
        int height = block.length;
        int width = block[0].length;
        Vertex[][] vertices = new Vertex[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Vertex v = new Vertex();
                v.distance = block[i][j];
                v.index = new Pair(i, j);
                vertices[i][j] = v;
            }
        }
        int[] posX = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] posY = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int h = 0; h < height - 1; h++) {
            for (int w = 0; w < width; w++) {
                Vertex v = vertices[h][w];
                for(int k=0; k<8; k++) {
                    int x = h+posX[k];
                    int y = w+posY[k];
                    if (isValid(x,y,height,width)){
                        Vertex neighbour = vertices[x][y];
                        v.neighbours.add(neighbour);
                    }
                }
            }
        }
        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(Vertex::getDistance));
        int[][] distance = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<block.length;i++){
            Vertex v = new Vertex();
            v.index = new Pair(-1,-1);
            v.distance = 0;
            vertices[i][0].predecessor=v;
            pq.add(vertices[i][0]);
        }
//        pq.add(vertices[0][0]);
//        distance[0][0] = vertices[0][0].getDistance();
//        for (int i = 0; i < width; i++) {
//            pq.add(vertices[0][i]);
//            distance[0][i] = vertices[0][i].getDistance();
            while (!pq.isEmpty()) {
                Vertex current = pq.poll();
                Pair index = current.index;
                for (Vertex n : current.neighbours) {
                    Pair nindex = n.index;
//                    if (distance[index.x][index.y] + n.getDistance()
//                            < distance[nindex.x][nindex.y]) {
                    if(vertices[nindex.x][nindex.y].predecessor !=null) {
                        if (vertices[nindex.x][nindex.y].distance > current.getDistance() + n.getDistance()) {
                            n.predecessor = current;
                            n.distance+= current.distance;
                            vertices[nindex.x][nindex.y] = n;
//                                    = current.getDistance() + n.getDistance();
                            //= distance[index.x][index.y] + n.getDistance();
                            pq.add(n);
                        }
                    }
                    else{
                        n.predecessor = current;
                        n.distance+= current.distance;
                        vertices[nindex.x][nindex.y] = n;
//                                    = current.getDistance() + n.getDistance();
                        //= distance[index.x][index.y] + n.getDistance();
                        pq.add(n);
                    }
                }
            }
//        }
        Vertex least = new Vertex();
        int minimum = Integer.MAX_VALUE;
        for (int j = 0; j < width; j++) {
            if (vertices[height - 1][j].distance < minimum) {
                minimum = vertices[height - 1][j].distance;
                least = vertices[height - 1][j];
            }
        }
        Stack<Pair> path = new Stack<>();
        path.push(least.index);
        least = least.predecessor;
        for (int i = 0; i < height - 1; i++) {
            if (least.index.x ==-1&&least.index.y==1) {
                break;
            }
                path.push(least.index);
                least = least.predecessor;
        }
 //       path.reversed();
        for (int i = 0; i < height; i++) {
            int y = path.pop().y;
            for (int j = 0; j < width; j++){
                if(j==y){
                    System.out.print(" ");
                }
                else{
                    System.out.print(block[i][j]);
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String line = br.readLine();
            String[] arr = line.split(" ");
            int height = Integer.parseInt(arr[0]);
            int width = Integer.parseInt(arr[1]);
            //end of all block descriptions
            if(height == 0 && width == 0){
                break;
            }
            int[][] block = new int[height][width];
            for(int h =0; h < height; h++){
                line = br.readLine();
                for(int w=0; w< width; w++){
                    block[h][w] = Character.getNumericValue(line.charAt(w));
                }
            }
            dijkstra(block);

            System.out.println();
        }
    }
}

