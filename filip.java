import java.util.*;
import java.io.*;

public class filip {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int max = 0;
        for(int i = 0; i<2; i++){
            StringBuilder sb = new StringBuilder(st.nextToken());
            sb.reverse();
            int x = Integer.parseInt(sb.toString());
            if(x>max) max = x;
        }
        output.println(max);
        output.close();
    }
}