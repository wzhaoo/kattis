import java.util.*;
import java.io.*;

public class grassseed {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        double C = Double.parseDouble(input.readLine());
        int N = Integer.parseInt(input.readLine());
        double sum = 0;
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            sum+=a*b;
        }
        sum*=C;
        output.println(sum);
        output.close();
    }
}