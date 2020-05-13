import java.util.*;
import java.io.*;

public class robotsonagrid {
    public static char[][] grid;
    public static int N;
    public static long[][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        N = Integer.parseInt(input.readLine());
        grid = new char[N][N];
        dp = new long[N][N];
        for(int i = 0; i<N; i++){
            String line = input.readLine();
            Arrays.fill(dp[i], -1);
            for(int j = 0; j<N; j++){
                grid[i][j] = line.charAt(j);
            }
        }
        dp[N-1][N-1] = 1;
        long paths = path(0, 0);
        if(paths>0) output.println(paths);
        else{
            floodfill(0, 0);
            if(grid[N-1][N-1] == '@') output.println("THE GAME IS A LIE");
            else output.println("INCONCEIVABLE");
        }
        output.close();
    }
    public static void floodfill(int r, int c){
        if(r>=N || r<0 || c>=N || c<0 || grid[r][c] == '#' || grid[r][c] == '@') return;
        grid[r][c] = '@';
        floodfill(r+1, c);
        floodfill(r-1, c);
        floodfill(r, c+1);
        floodfill(r, c-1);
    }
    public static long path(int r, int c){
        count++;
        if(r>=N || r<0 || c>=N || c<0 || grid[r][c] == '#') return 0;
        else if(dp[r][c] != -1) return dp[r][c];
        dp[r][c] = (path(r+1, c) + path(r, c+1))%Integer.MAX_VALUE;
        return dp[r][c];
    }
}