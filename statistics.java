import java.util.*;
import java.io.*;

public class statistics {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        String line;
        int T = 1;
        while((line = input.readLine()) != null){
            output.print("Case " + T + ": ");
            T++;
            StringTokenizer st = new StringTokenizer(line);
            int N = Integer.parseInt(st.nextToken());
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            while(st.hasMoreTokens()){
                int sub = Integer.parseInt(st.nextToken());
                if(sub<min) min = sub;
                if(sub>max) max = sub;
            }
            output.println(min + " " + max + " " + (max-min));
        }
        output.close();
    }
}