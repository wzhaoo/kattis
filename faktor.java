import java.util.*;
import java.io.*;

public class faktor {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        if(n == 1 || m == 1) output.println(m);
        else{
            int total = n*(m-1)+1;
            output.println(total);
        }
        output.close();
    }
}