import java.util.*;
import java.io.*;
public class simon{
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int T = Integer.parseInt(input.readLine());
        for(int t = 0; t<T; t++){
            String s = input.readLine();
            if(s.startsWith("simon says ")) output.println(s.substring(11, s.length()));
            else output.println();
        }
        output.close();
    }
}
