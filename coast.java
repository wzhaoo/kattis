import java.util.*;
import java.io.*;

public class coast {
    public static int[][] grid;
    public static int[][] visited;
    public static int R;
    public static int C;
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        grid = new int[R+2][C+2];
        visited = new int[R+2][C+2];
        for(int r = 1; r<R+1; r++){
            String line = input.readLine();
            for(int c = 1; c<C+1; c++){
                grid[r][c] = line.charAt(c-1) - '0';
            }
        }
        floodfill(0, 0);
        int sum = 0;
        for(int i = 1; i<R+1; i++){
            for(int j = 1; j<C+1; j++){
                if(visited[i][j]>0) sum+=visited[i][j];
            }
        }
        output.println(sum);
        output.close();
    }
    public static void floodfill(int r, int c){
        if(r<0 || r>R+1 || c<0 || c>C+1 || visited[r][c] == -1) return;
        if(grid[r][c] == 0){
            visited[r][c] = -1;
            floodfill(r+1, c);
            floodfill(r-1, c);
            floodfill(r, c+1);
            floodfill(r, c-1);
        }
        else{
            visited[r][c]+=1;
        }
    }
}