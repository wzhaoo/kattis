import java.util.*;
import java.io.*;
public class spiderman {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);

        int Q = Integer.parseInt(input.readLine());
        for(int q = 0; q<Q; q++){
            int N = Integer.parseInt(input.readLine());
            int[] distances = new int[N];
            StringTokenizer st = new StringTokenizer(input.readLine());
            int max = 0;
            for(int n = 0; n<N; n++){
                distances[n] = Integer.parseInt(st.nextToken());
                max+=distances[n];
            }
            int[][] grid = new int[N+1][max+1];
            for(int i = 0; i<N+1; i++) Arrays.fill(grid[i], max);
            grid[0][0] = 0;
            int[][] choices = new int[N+1][max+1];
            for(int i = 0; i<N; i++){
                for(int j = 0; j<max+1; j++){
                    int current = grid[i][j];
                    int up = j+distances[i];
                    int down = j-distances[i];
                    if(up<=max && grid[i+1][up]>Math.max(up, current)){
                        grid[i+1][up] = Math.max(up, current);
                        choices[i+1][up] = 1;
                    }
                    if(down>=0 && grid[i+1][down]>current){
                        grid[i+1][down] = current;
                        choices[i+1][down] = -1;
                    }
                }
            }
            String ans = "";
            if(grid[N][0] == max) output.println("IMPOSSIBLE");
            else{
                int position = 0;
                for(int i = N; i>0; i--){
                    if(choices[i][position] == 1){
                        position-=distances[i-1];
                        ans+="U";
                    }
                    else{
                        position+=distances[i-1];
                        ans+="D";
                    }
                }
                for(int i = ans.length()-1; i>=0; i--){
                    output.print(ans.charAt(i));
                }
                output.println();
            }
            
        }
        output.flush();
        output.close();
    }
}