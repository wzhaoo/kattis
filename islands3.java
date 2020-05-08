import java.util.*;
import java.io.*;

public class islands3 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] grid = new char[R][C];
        int Lcount = 0;
        for(int r = 0; r<R; r++){
            String line = input.readLine();
            for(int c = 0; c<C; c++){
                grid[r][c] = line.charAt(c);
                if(grid[r][c] == 'L') Lcount++;
            }
        }
        if(Lcount == 0){
            output.println(0);
        }
        else{
            int count = 0;
            for(int r = 0; r<R; r++){
                for(int c = 0; c<C; c++){
                    if(grid[r][c] == 'L'){
                        count++;
                        floodfill(grid, r, c);
                    }
                }
            }
            output.println(count);
        }
        output.flush();
        output.close();

    }

    static void floodfill(char[][] grid, int x, int y){
        if(x>=grid.length || x<0 || y>=grid[0].length || y<0 || grid[x][y] == 'W') return;
        grid[x][y] = 'W';
        floodfill(grid, x+1, y);
        floodfill(grid, x-1, y);
        floodfill(grid, x, y+1);
        floodfill(grid, x, y-1);
    
    }
}