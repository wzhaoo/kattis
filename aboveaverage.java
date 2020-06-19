import java.util.*;
import java.io.*;

public class aboveaverage {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int T = Integer.parseInt(input.readLine());
        for(int t = 0; t<T; t++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            double N = Integer.parseInt(st.nextToken());
            double sum = 0;
            ArrayList<Integer> nums = new ArrayList<Integer>();
            while(st.hasMoreTokens()){
                int sub = Integer.parseInt(st.nextToken());
                sum+=sub;
                nums.add(sub);
            }
            sum/=N;
            double count = 0;
            for(int i: nums){
                if(i>sum) count++;
            }
            double ans = count*100/N;
            output.format("%.3f", count*100/N);
            output.println("%");
        }
        output.close();
    }
}