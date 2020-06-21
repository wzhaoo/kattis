import java.util.*;
import java.io.*;

public class server {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int sum = 0;
        int tasks = 0;
        st = new StringTokenizer(input.readLine());
        for(int n = 0; n<N; n++){
            int sub = Integer.parseInt(st.nextToken());
            sum+=sub;
            if(sum<=T) tasks++;
            else break;
        }
        output.println(tasks);
        output.close();
    }
}