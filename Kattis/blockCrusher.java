import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//Main algorithm points:
//1. Traverse the grid from left to right
//2. The parents of each leftmost column are virtual vertices (-1,-1)

public class blockCrusher {
    public static class Pair {
        private int x;
        private int y;
        private int distance;
        private Pair predecessor;
        public Pair(int first, int second) {
            this.x = first;
            this.y = second;
        }
        public int getDistance(){
            return this.distance;
        }
    }
    public static void dijisktra(int[][] block){
        int maxHeight = block.length;
        int maxWidth = block[0].length;
        Pair last = new Pair(0,0); //the last element in right side with smallest value
        //posX[0], posY[0] = left,up diagonal
        //posX[1], posY[1] = up
        //posX[2], posY[2] = right,up diagonal
        //posX[3], posY[3] = left
        //posX[4], posY[4] = right
        //posX[5], posY[5] = left,bottom diagonal
        //posX[6], posY[6] = bottom
        //posX[7], posY[7] = right,bottom diagonal
        int[] posX = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] posY = {-1, 0, 1, -1, 1, -1, 0, 1};

        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Pair::getDistance));
        Pair[][] visited = new Pair[maxHeight][maxWidth];
        //initializing visited array
        for(int i =0; i<maxHeight; i++){
            for(int j=0; j<maxWidth; j++){
                Pair p = new Pair(i,j);
                visited[i][j] = p;
                visited[i][j].distance = block[i][j];
            }
        }

       //adding parents to left most column of all rows and adding adding leftmost column in pq.
       for(int i=0; i<maxHeight; i++){
           Pair p = new Pair(-1,-1);
           visited[i][0].predecessor = p;
            priorityQueue.add(visited[i][0]);
       }
       int min = Integer.MAX_VALUE; //keeping track of minimum value in entire grid
        while(!priorityQueue.isEmpty()){
            Pair first = priorityQueue.poll();
            if(first.x ==maxHeight-1 && min > first.distance){
                min = first.distance;
                last = first;
            }
            if(first.distance < min) {
                for (int i = 0; i < 8; i++) {
                    int X = first.x;
                    int Y = first.y;
                    X += posX[i];
                    Y += posY[i];
                    if (X < 0 || Y < 0 || X > maxHeight - 1 || Y > maxWidth - 1) {
                        continue;
                    }
                    Pair a = visited[X][Y];
                    if(visited[X][Y].predecessor != null){
                    //block[X][Y] is the neighbour and block[first.x][first.y] is the source vertex
                        if (a.distance + first.distance < visited[X][Y].distance) {
                            a.distance += first.distance;
                            a.predecessor = first;
//                            visited[X][Y].distance = a.distance + first.distance;
                            visited[X][Y] = a;
                            priorityQueue.add(a);
                        }
                    }
                    else{
                        a.distance += first.distance;
                        a.predecessor = first;
//                            visited[X][Y].distance = a.distance + first.distance;
                        visited[X][Y] = a;
                        priorityQueue.add(a);
                    }
                }
            }
        }
        int count =0;
        while(true) {
            if ((last.x == -1 && last.y == -1) || count >maxHeight-1) {
                break;
            }
                block[last.x][last.y] = 0;
                count +=1;
                last = last.predecessor;
        }
       System.out.println();
        for(int i=0; i<maxHeight;i++){
            for(int j=0; j< maxWidth; j++){
                if(block[i][j] ==0){
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
            dijisktra(block);

            System.out.println();
        }
    }
}
