import java.util.*;
import java.io.*;

public class batterup {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int N = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        double sum = 0;
        while(st.hasMoreTokens()){
            int i = Integer.parseInt(st.nextToken());
            if(i == -1) N--;
            else sum+=i;
        }
        output.println(sum/N);
        output.close();
    }
}