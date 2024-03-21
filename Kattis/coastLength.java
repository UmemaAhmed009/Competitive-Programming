import java.util.*;
public class coastLength {
    public static int dfs(int[][] table, int[][] visited,int r, int c,int x, int y, int coastLength){
        if(x < 0 || x >=r || y<0 || y>= c || visited[x][y]==-1 || table[x][y] != 0){
            return 0;
        }
        coastLength = 0;
        int[] dr = {0, -1, 0, 1}; //change in row
        int[] dc = {-1, 0, 1, 0}; //change in column
        for (int i = 0; i < 4; i++) {
            int j=x+dr[i];int k = y+dc[i];
            if(j< 0 || j >=r || k<0 || k>= c){
                continue;
            }
            else if (table[x + dr[i]][y + dc[i]] == 1) {
                coastLength += 1;
            }
        }

        visited[x][y] = -1; //which marks the cell as visited
        for (int i = 0; i < 4; i++) {
            coastLength+=dfs(table,visited,r,c,x+dr[i],y+dc[i], coastLength);//will recursively run for each of the neighbours
        }
        return coastLength;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt()+2;
        int columns = scan.nextInt()+2;
        int[][] table = new int[rows][columns];
        int[][] visited = new int[rows][columns];
        scan.nextLine();
        String[] str = new String[rows];
        for(int i=0; i< rows; i++){
            if(i==0 || i==rows-1){
                continue;
            }
            else{
                str[i] = scan.nextLine();
            }
        }

        //filling the table
        for(int r = 0; r<rows; r++) {
            String string = str[r];
                for (int c = 0; c < columns; c++) {
                    if (r == 0 || r == (rows - 1) || c == 0 || c == (columns - 1)) {
                        table[r][c] = 0;//sea
                    } else {
                        char character = string.charAt(c - 1);
                        table[r][c] = Character.getNumericValue(character);
                    }
                }
            }
        // Close the Scanner
        scan.close();
        //program
        int totalDistance = 0;
        //Using DFS for flood fill algorithm:
        System.out.println(dfs(table,visited,rows,columns,0,0,totalDistance));
}
}


