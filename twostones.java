import java.util.*;
import java.io.*;

public class twostones {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int N = Integer.parseInt(input.readLine());
        if(N%2 == 0) output.println("Bob");
        else output.println("Alice");
        output.close();
    }
}