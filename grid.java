import java.util.*;
import java.io.*;

class Node{
    int d;
    int r;
    int c;
    Node(int r, int c, int d){
        this.r = r;
        this.c = c;
        this.d = d;
    }
}

public class grid{
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] grid = new int[R][C];
        int[][] distGrid = new int[R][C];
        for(int r = 0; r<R; r++){
            String line = input.readLine();
            for(int c = 0; c<C; c++){
                grid[r][c] = line.charAt(c)-'0';
                distGrid[r][c] = Integer.MAX_VALUE;
            }
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(0,0,0));
        distGrid[0][0] = 0;
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};

        while(!q.isEmpty()){
            Node sub = q.poll();
            for(int dir = 0; dir<4; dir++){
                int ro = sub.r + grid[sub.r][sub.c]*dr[dir];
                int co = sub.c + grid[sub.r][sub.c]*dc[dir];

                if(ro>=0 && ro<R && co>=0 && co<C && 1 + sub.d < distGrid[ro][co]){
                    q.add(new Node(ro, co, sub.d+1));
                    distGrid[ro][co] = sub.d+1;
                }
            }
        }
        if(distGrid[R-1][C-1] == Integer.MAX_VALUE) output.println("-1");
        else output.println(distGrid[R-1][C-1]);

        output.flush();
        output.close();
    }
}