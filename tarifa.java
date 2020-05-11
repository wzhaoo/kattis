import java.util.*;
import java.io.*;

public class tarifa {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int X = Integer.parseInt(input.readLine());
        int N = Integer.parseInt(input.readLine());
        int sum = 0;
        for(int i = 0; i<N; i++){
            sum+=X - Integer.parseInt(input.readLine());
        }
        output.println(sum+X);
        output.close();
    }
}