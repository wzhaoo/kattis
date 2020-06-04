import java.util.*;
import java.io.*;

public class tri {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        if(a == (b+c)) output.println(a + "=" + b + "+" + c);
        else if(a == (b-c)) output.println(a + "=" + b + "-" + c);
        else if(a == (b*c)) output.println(a + "=" + b + "*" + c);
        else if(a == (b/c)) output.println(a + "=" + b + "/" + c);
        else if(c == (a+b)) output.println(a + "+" + b + "=" + c);
        else if(c == (a-b)) output.println(a + "-" + b + "=" + c);
        else if(c == (a*b)) output.println(a + "*" + b + "=" + c);
        else if(c == (a/b)) output.println(a + "/" + b + "=" + c);
        output.close();
    }
}