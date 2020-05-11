import java.util.*;
import java.io.*;

public class oddities {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int N = Integer.parseInt(input.readLine());
        for(int i = 0; i<N; i++){
            int a = Integer.parseInt(input.readLine());
            if(a%2 == 0) output.println(a + " is even");
            else output.println(a + " is odd");
        }
        output.close();
    }
}