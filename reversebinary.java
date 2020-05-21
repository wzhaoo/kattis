import java.util.*;
import java.io.*;

public class reversebinary {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int n = Integer.parseInt(input.readLine());
        StringBuilder s = new StringBuilder(Integer.toBinaryString(n));
        s.reverse();
        String rev = s.toString();
        int b = Integer.parseInt(rev, 2);
        output.println(b);
        output.close();

    }
}