import java.util.*;
import java.io.*;

public class pot {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int N = Integer.parseInt(input.readLine());
        int sum = 0;
        for(int i = 0; i<N; i++){
            String line = input.readLine();
            sum+=(int)Math.pow(Integer.parseInt(line.substring(0, line.length()-1)), Integer.parseInt(line.substring(line.length()-1)));
        }
        output.println(sum);
        output.close();
    }
}