import java.util.*;
import java.io.*;

public class knapsack{
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        String line;
        while((line = input.readLine())!=null && line.length()>0){
            StringTokenizer st = new StringTokenizer(line);
            int C = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            //get the maximum value with a weight under C
            int[] values = new int[N];
            int[] weights = new int[N];

            for(int i = 0; i<N; i++){
                st = new StringTokenizer(input.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                values[i] = a;
                weights[i] = b;
            }

            int[][] max = new int[N+1][C+1];
            for(int i = 0; i<max.length; i++) Arrays.fill(max[i], -1);
            for(int i = 0; i<=N; i++){
                for(int j = 0; j<=C; j++){
                    if(i == 0 || j==0) max[i][j] = 0;
                    else if(weights[i-1]<=j){
                        max[i][j] = Math.max(values[i-1]+max[i-1][j-weights[i-1]], max[i-1][j]);
                    }
                    else max[i][j] = max[i-1][j];
                }
            }

            ArrayList<Integer> indices = new ArrayList<Integer>();
            int sub = C;
            for(int i = N; i>0; i--){
                if(max[i][sub]!=max[i-1][sub]){
                    indices.add(i-1);
                    sub-=weights[i-1];
                }
            }
            output.println(indices.size());
            for(int i = 0; i<indices.size(); i++){
                output.print(indices.get(i) + " ");
            }
            output.println();
            
        }
        output.flush();
        output.close();
    }
}