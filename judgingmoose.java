import java.util.*;
import java.io.*;

public class judgingmoose {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if(a == 0 && b == 0) output.println("Not a moose");
        else if(a == b) output.println("Even " + (a*2));
        else output.println("Odd " + (Math.max(a, b) * 2));
        output.close();
    }
}