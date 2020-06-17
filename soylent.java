import java.util.*;
import java.io.*;

public class soylent {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int T = Integer.parseInt(input.readLine());
        for(int t = 0; t<T; t++){
            int N = Integer.parseInt(input.readLine());
            if(N%400!=0) output.println((N/400 + 1));
            else output.println(N/400);
        }
        output.close();
    }
}