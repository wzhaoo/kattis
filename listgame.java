import java.util.*;
import java.io.*;

public class listgame {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        long N = Long.parseLong(input.readLine());
        int sq = (int)Math.sqrt((double)N);
        int count = 0;
        int x = 2;
        while(x<=sq && N>1 && N>=x){
            while(N%x == 0){
                N/=x;
                count++;
            }
            x++;
        }
        if(N>1) count++;
        
        output.println(count);
        output.close();
    }
}