import java.util.*;
import java.io.*;

public class qaly {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int N = Integer.parseInt(input.readLine());
        double sum = 0;
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            sum+=Double.parseDouble(st.nextToken()) * Double.parseDouble(st.nextToken());
        }
        output.println(sum);
        output.close();
    }
}