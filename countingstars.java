import java.util.*;
import java.io.*;

public class countingstars{
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        String line;
        int caseNum = 1;

        while((line = input.readLine())!=null&&line.length()>0){
            int starCount = 0;
            StringTokenizer st = new StringTokenizer(line);
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            char[][] grid = new char[r][c];

            for(int i = 0; i<r; i++){
                line = input.readLine();
                for(int j = 0; j<c; j++){
                    grid[i][j] = line.charAt(j);
                }
            }

            for(int i = 0; i<r; i++){
                for(int j = 0; j<c; j++){
                    if(grid[i][j] == '-'){
                        floodfill(grid, i, j);
                        starCount++;
                    }
                }
            }
            output.println("Case " + caseNum + ": " + starCount);
            caseNum++;
        }
        output.flush();
        output.close();
    }
    static void floodfill(char[][] grid, int x, int y){
        if(x>=grid.length || x<0 || y>=grid[0].length || y<0 || grid[x][y] == '#') return;
        grid[x][y] = '#';
        floodfill(grid, x+1, y);
        floodfill(grid, x-1, y);
        floodfill(grid, x, y+1);
        floodfill(grid, x, y-1);
    }
}