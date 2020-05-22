import java.io.*;
import java.util.*;

public class everywhere {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int T = Integer.parseInt(input.readLine());
        for(int t= 0; t<T; t++){
            int N = Integer.parseInt(input.readLine());
            Set<String> s = new HashSet<String>();
            for(int i = 0; i<N; i++){
                s.add(input.readLine());
            }
            int count=  0;
            for(String str: s) count++;
            output.println(count);
        }
        output.close();
    }
}