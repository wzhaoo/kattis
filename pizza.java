import java.util.*;
import java.io.*;

public class pizza {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int T = Integer.parseInt(input.readLine());
        for(int t = 0; t<T; t++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            int C = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int[][] grid = new int[R][C];
            for(int r = 0; r<R; r++){
                st = new StringTokenizer(input.readLine());
                for(int c = 0; c<C; c++){
                    grid[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            int minR = Integer.MAX_VALUE;
            int bestR = 0;
            for(int i = 0; i<R; i++){
                int sum = 0;
                for(int r = 0; r<R; r++){
                    for(int c = 0; c<C; c++){
                        sum+=manDist(i, 0, r, c) * grid[r][c];
                    }
                }
                if(sum>minR) break;
                bestR = i;
                minR = sum;
            }
            int min = Integer.MAX_VALUE;
            for(int i = 0; i<C; i++){
                int sum = 0;
                for(int r = 0; r<R; r++){
                    for(int c = 0; c<C; c++){
                        sum+=manDist(bestR, i, r, c) * grid[r][c];
                    }
                }
                if(sum>min) break;
                min = sum;
            }
            output.println(min + " blocks");
        }
        output.close();
    }
    public static int manDist(int x1, int y1, int x2, int y2){
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }
}