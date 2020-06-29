import java.util.*;
import java.io.*;

public class maxcolinear {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        String line;
        while((line = input.readLine()) != null){
            int N = Integer.parseInt(line);
            if(N == 0) break;
            double[] x = new int[N];
            double[] y = new int[N];
            for(int i = 0; i<N; i++){
                StringTokenizer st = new StringTokenizer(input.readLine());
                x[i] = Double.parseDouble(st.nextToken());
                y[i] = Double.parseDouble(st.nextToken());
            }
            double[][] grid = new double[N][N];
            for(int i = 0; i<N; i++){
                for(int j = 0; j<N; j++){
                    if(i == j) continue;

                }
            }
            /*int count = 1;
            for(int i = 0; i<N; i++){
                for(int j = i+1; j<N; j++){
                    int sub = 2;
                    int dx = x[j]-x[i];
                    int dy = y[j]-y[i];
                    for(int k =j+1; k<N; k++){
                        int dx2 = x[k]- x[j];
                        int dy2 = y[k] - y[j];
                        if(dx*dy2 == dx2*dy) sub++;
                    }
                if(sub>count) count = sub;
                }
                
            }*/
            output.println(count);
        }
        output.close();
    }
}