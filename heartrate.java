import java.util.*;
import java.io.*;

public class heartrate {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int N = Integer.parseInt(input.readLine());
        for(int n = 0; n<N; n++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            double b = Double.parseDouble(st.nextToken());
            double p = Double.parseDouble(st.nextToken());
            double actual = 60*b/p;
            double min = actual - 60/p;
            double max = actual  + 60/p;
            output.println(min + " " + actual + " " + max);
        }
        output.close();
    }
}