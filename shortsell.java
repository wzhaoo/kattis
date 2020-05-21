import java.util.*;
import java.io.*;

public class shortsell {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(input.readLine());
        int[] prices = new int[N];
        for(int i = 0; i<N; i++) prices[i] = Integer.parseInt(st.nextToken());
        int maxProfit = 0;
        int currProfit = 0;
        for(int i = 0; i<N; i++){
            currProfit-=K;
            if(prices[i]*100 - K > currProfit) currProfit = prices[i]*100 - K;
            else if(currProfit - prices[i]*100>maxProfit) maxProfit = currProfit - prices[i]*100;
        }
        output.println(maxProfit);
        output.close();
    }
}