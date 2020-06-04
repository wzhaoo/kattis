import java.util.*;
import java.io.*;

public class lastfactorialdigit {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int N = Integer.parseInt(input.readLine());
        for(int n = 0; n<N; n++){
            int x = Integer.parseInt(input.readLine());
            int p = x;
            for(int i = x-1; i>1; i--){
                p*=i;
            }
            output.println(p%10);
        }
        output.close();
    }
}