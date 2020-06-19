import java.util.*;
import java.io.*;

public class tenkindsofpeople {
    public static char[][] grid;
    public static int[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        grid = new char[R][C];
        for(int r = 0; r<R; r++){
            String line = input.readLine();
            for(int c = 0; c<C; c++){
                grid[r][c] = line.charAt(c);
            }
        }
        int N = Integer.parseInt(input.readLine());
        visited = new int[R][C];
        for(int i = 0; i<R; i++) Arrays.fill(visited[i], -1);
        int group = 0;
        for(int r = 0; r<R; r++){
            for(int c = 0; c<C; c++){
                if(visited[r][c] == -1){
                    floodfill(r, c, group, grid[r][c]);
                    group++;
                }
            }
        }
        for(int n = 0; n<N; n++){
            st = new StringTokenizer(input.readLine());
            int startR = Integer.parseInt(st.nextToken())-1;
            int startC = Integer.parseInt(st.nextToken())-1;
            int endR = Integer.parseInt(st.nextToken())-1;
            int endC = Integer.parseInt(st.nextToken())-1;
            if(visited[startR][startC] == visited[endR][endC]){
                if(grid[endR][endC] == '1') output.println("decimal");
                else output.println("binary");
            }
            else output.println("neither");
        }
        output.close();
    }
    public static void floodfill(int r, int c, int group, char allowed){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || visited[r][c]!=-1 || grid[r][c]!=allowed) return;
        visited[r][c] = group;
        floodfill(r+1, c, group, allowed);
        floodfill(r-1, c, group, allowed);
        floodfill(r, c+1, group, allowed);
        floodfill(r, c-1, group, allowed);
    }
}