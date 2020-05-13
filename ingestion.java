import java.util.*;
import java.io.*;

public class ingestion {
    public static int[][] dp;
    public static int[] capacities;
    public static int[] calories;
    public static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        dp = new int[N][N];
        for(int i = 0; i<N; i++) Arrays.fill(dp[i], -1);
        capacities = new int[N];
        calories = new int[N];
        st = new StringTokenizer(input.readLine());
        for(int i = 0; i<N; i++){
            capacities[i] = C;
            C=C*2/3;
            calories[i] = Integer.parseInt(st.nextToken());
        }
        int ans = ingest(0, 0);
        output.println(ans);
        
        output.close();
    }
    public static int ingest(int index, int cindex){
        if(index>=N || cindex>=N) return 0;
        else if(dp[index][cindex]!=-1) return dp[index][cindex];
        int ret = 0;
        int current = Math.min(capacities[cindex], calories[index]);
        ret = Math.max(ret, current + ingest(index+1, cindex+1));
        ret = Math.max(ret, ingest(index+1, Math.max(0, cindex-1)));
        ret = Math.max(ret, ingest(index+2, 0));
        dp[index][cindex] = ret;
        return ret;
    }
}