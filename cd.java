import java.util.*;
import java.io.*;

public class cd {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        while(true){
            StringTokenizer st = new StringTokenizer(input.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if(N == 0 && M == 0) break;
            int[] jack = new int[N];
            int[] jill = new int[M];
            for(int n = 0; n<N; n++) jack[n] = Integer.parseInt(input.readLine());
            for(int m = 0; m<M; m++) jill[m] = Integer.parseInt(input.readLine());
            int max = Math.max(N, M);
            int i1 = 0;
            int i2 = 0;
            int count = 0;
            while(i1<N && i2<M){
                if(jack[i1] == jill[i2]){
                    count++;
                    i1++;
                    i2++;
                }
                else if(jack[i1] < jill[i2]){
                    i1++;
                }
                else i2++;
            }
            output.println(count);
        }
        output.close();
    }
}