import java.util.*;
import java.io.*;

public class speedlimit {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        String line;
        while((line = input.readLine()) != null){
            int N = Integer.parseInt(line);
            if(N == -1) break;
            int sum = 0;
            int prev = 0;
            for(int n = 0; n<N; n++){
                StringTokenizer st = new StringTokenizer(input.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                sum+=a*(b-prev);
                prev = b;
            }
            output.println(sum + " miles");
        }
        output.close();
    }
}