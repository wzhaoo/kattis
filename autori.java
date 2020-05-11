import java.util.*;
import java.io.*;

public class autori {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine(), "-");
        while(st.hasMoreTokens()){
            output.print(st.nextToken().charAt(0));
        }
        output.close();
    }
}