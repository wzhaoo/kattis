import java.io.*;
import java.util.*;

public class secretchamber{
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] grid = new boolean[26][26];
        for(int n = 0; n<N; n++){
            st = new StringTokenizer(input.readLine());
            char a = st.nextToken().charAt(0);
            int A = a - 'a';
            char b = st.nextToken().charAt(0);
            int B = b - 'a';
            grid[A][B] = true;
        }
        for(int i = 0; i < 26; i++) grid[i][i] = true;
        for(int i = 0; i<26; i++){
            for(int j = 0; j<26; j++){
                for(int k = 0; k<26; k++){
                    if(grid[j][i] && grid[i][k]){
                        grid[j][k] = true;
                    }
                }
            }
        }

        for(int m = 0; m<M; m++){
            st = new StringTokenizer(input.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            if(a.length()!=b.length()){
                output.println("no");
                continue;
            }
            boolean printed = false;
            for(int i = 0; i<a.length(); i++){
                if(grid[a.charAt(i) - 'a'][b.charAt(i) - 'a']) continue;
                else{
                    output.println("no");
                    printed = true;
                    break;
                }
            }
            if(!printed) output.println("yes");
        
        }
        output.close();
    }
}