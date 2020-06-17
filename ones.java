import java.util.*;
import java.io.*;

public class ones {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        String line;
        
        while((line = input.readLine()) != null){
            int N = Integer.parseInt(line);
            int x = 1%N;
            int ans = 1;
            while(x!=0){
                x = (x*10+1)%N;
                ans++;
            }
            output.println(ans);
        }
        output.close();
    }
}