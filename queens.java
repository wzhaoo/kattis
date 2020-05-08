import java.util.*;
import java.io.*;

public class queens {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int[][] grid = new int[8][8];
        boolean b = true;
        for(int i = 0; i<8; i++){
            String line = input.readLine();
            for(int j = 0; j<8; j++){
                grid[i][j] = line.charAt(j);
            }
        }
        int count = 0;
        for(int i = 0; i<8; i++){
            outer:
            for(int j = 0; j<8; j++){
                if(grid[i][j] == '*'){
                    count++;
                    for(int r = 0; r<8; r++){
                        if(grid[r][j] == '*' && r!=i){
                            b = false;
                            break outer;
                        }
                    }
                    for(int c = 0; c<8; c++){
                        if(grid[i][c] == '*' && c!=j){
                            b = false;
                            break outer;
                        }
                    }
                    for(int x = -7; x<8; x++){
                        if(x == 0) continue;
                        if(i+x>=0 && i+x<8 && j+x>=0 && j+x<8 && grid[i+x][j+x] == '*'){
                            b = false;
                            break outer;
                        }
                    }
                    for(int x = -7; x<8; x++){
                        if(x == 0) continue;
                        if(i+x>=0 && i+x<8 && j-x>=0 && j-x<8 && grid[i+x][j-x] == '*'){
                            b = false;
                            break outer;
                        }
                    }
                    /*for(int x = 1; x<8; x++){
                        if(i-x<0 || j-x<0) break;
                        if(grid[i-x][j-x] == '*'){
                            b = false;
                            break outer;
                        }
                    }
                    for(int x = 1; x<8; x++){
                        if(i+x>=8 || j+x>=8) break;
                        if(grid[i+x][j+x] == '*'){
                            b = false;
                            break outer;
                        }
                    }
                    for(int x = 1; x<8; x++){
                        if(i-x<0 || j+x>=8) break;
                        if(grid[i-x][j+x] == '*'){
                            b = false;
                            break outer;
                        }
                    }
                    for(int x = 1; x<8; x++){
                        if(i+x>=8 || j-x<0) break;
                        if(grid[i+x][j-x] == '*'){
                            b = false;
                            break outer;
                        }
                    }*/
                }
            }
        }
        if(count!=8) b = false;
        if(b) output.println("valid");
        else output.println("invalid");
        output.close();
    }
}
