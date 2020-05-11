import java.util.*;
import java.io.*;

public class fizzbuzz {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        for(int i = 1; i<=n; i++){
            if(i%x == 0 && i%y == 0) output.println("FizzBuzz");
            else if(i%x == 0) output.println("Fizz");
            else if(i%y == 0) output.println("Buzz");
            else output.println(i);
        }
        output.close();
    }
}