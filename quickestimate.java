import java.util.*;
import java.io.*;

public class quickestimate {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int T = Integer.parseInt(input.readLine());
        for(int t = 0; t<T; t++){
            String line = input.readLine();
            output.println(line.length());
        }
        output.close();
    }
}