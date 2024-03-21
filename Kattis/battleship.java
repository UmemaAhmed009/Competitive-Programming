import java.util.*;
public class battleship {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i =0; i< t; i++){
            int w = scan.nextInt();
            int h = scan.nextInt();
            int n = scan.nextInt();

            int p1_ships = 0;
            int p2_ships = 0;

            //initializing 2-d array for deployment map of each player
            char[][] deploymentMap1 = new char[h][w];
            char[][] deploymentMap2 = new char[h][w];
            //looping for each player to store values
            String s = scan.nextLine();
            for(int j =0; j<2; j++){
                for(int row =0; row < h; row++){
                    s= scan.nextLine();
                    for(int column=0; column<w; column++){
                        char c =s.charAt(column);
                        if(j==0){
                            if(c < '_'){
                                p1_ships++;
                            }
                            deploymentMap1[row][column] = c;
                        }
                        else{
                            if(c < '_'){
                                p2_ships++;
                            }
                            deploymentMap2[row][column] = c;
                        }
                    }
                }
            }
            int turn = 1;
            h--;
            char shot =0;
            boolean lastTurn = false;
            for(int j=0; j<n;j++){
                int x = scan.nextInt();
                int y = scan.nextInt();
                if(turn == 1){
                    shot = deploymentMap2[h-y][x];
                    if(shot == '#'){
                        deploymentMap2[h-y][x] = '_';
                        p2_ships--;
                        if(p2_ships ==0){
                            turn = 2;
                            lastTurn = true;
                        }
                        continue;
                    }
                    else{
                        turn = 2;
                    }
                }
                else{
                    shot = deploymentMap1[h-y][x];
                    if(shot == '#'){
                        deploymentMap1[h-y][x] = '_';
                        p1_ships--;
                    }
                    else{
                        turn = 1;
                    }
                }
                if(lastTurn){
                    break;
                }
                if(p1_ships==0 || p2_ships==0){
                    break;
                }
            }
            if(p2_ships>0 && p1_ships==0){
                System.out.println("player two wins");
            }
            else if (p1_ships>0 && p2_ships==0){
                System.out.println("player one wins");
            }
            else{
                System.out.println("draw");
            }
        }
    }
}
