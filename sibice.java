import java.util.*;
import java.io.*;

public class sibice {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        double hyp = Math.hypot(H, W);
        for(int n = 0; n<N; n++){
            int x = Integer.parseInt(input.readLine());
            if(x<=H || x<=W || x<=hyp) output.println("DA");
            else output.println("NE");
        }
        output.close();
        
    }
}