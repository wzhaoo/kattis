import java.util.*;
import java.io.*;

public class sumkindofproblem {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int P = Integer.parseInt(input.readLine());
        for(int p = 0; p<P; p++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            int K = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int sum = 0;
            for(int i = 1; i<=N; i++){
                sum+=i;
            }
            output.println(K + " " + sum + " " + (sum*2-N) + " " + (sum*2));
        }
        output.close();
    }
}