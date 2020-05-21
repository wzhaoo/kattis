import java.util.*;
import java.io.*;

public class a1paper {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine()) - 1;
        int[] pieces = new int[N];
        StringTokenizer st = new StringTokenizer(input.readLine());
        int max = 0;
        int num = (int)Math.pow(2, N);
        int sub = num;
        for(int n = 0; n<N; n++){
            int p = Integer.parseInt(st.nextToken());
            sub/=2;
            max+=p*sub;
            pieces[n] = p;
        }
        if(max < num) System.out.println("impossible");
        else{
            int sum = 0;
            int high = num;
            int index = 0;
            
            for (int i = 0; i <pieces.length; i++){
                num /= 2;
                sum += num * pieces[i];
                
                if (sum >= high){
                    index = i;
                    pieces[index] -= sum - high;
                    break;
                }
            }
            
            double length = 0;
            double constant = Math.pow(2 , -((2 * index + 3.0) / 4));
            double root2 = Math.sqrt(2);
            
            for (int i = index; i >= 0; i--){
                length += (pieces[i] / 2) * constant;
                if (i == 0)
                    break;
                pieces[i - 1] += pieces[i] / 2;
                constant *= root2;
            }
            
            System.out.printf("%.6f" , length);
            
        }
    }
}