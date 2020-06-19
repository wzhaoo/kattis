import java.util.*;
import java.io.*;

public class pizza2 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        double noCheese = a*a - (a-b)*(a-b);
        double ans = 100 - noCheese/(a*a)*100;
        output.println(ans);
        output.close();
    }
}