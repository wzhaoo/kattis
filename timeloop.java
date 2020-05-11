import java.util.*;
import java.io.*;

public class timeloop {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int N = Integer.parseInt(input.readLine());
        for(int i = 1; i<= N; i++) output.println(i + " Abracadabra");
        output.close();
    }
}