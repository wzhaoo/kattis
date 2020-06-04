import java.util.*;
import java.io.*;

public class oddmanout {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int T = Integer.parseInt(input.readLine());
        for(int t= 1; t<=T; t++){
            int N = Integer.parseInt(input.readLine());
            StringTokenizer st = new StringTokenizer(input.readLine());
            long sum = 0;
            ArrayList<Integer> nums = new ArrayList<Integer>();
            for(int n = 0; n<N; n++){
                nums.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(nums);
            for(int n = 0; n<N; n++){
                if(n%2 == 0) sum+=nums.get(n);
                else sum-=nums.get(n);
            }
            output.println("Case #" + t + ": " + Math.abs(sum));
        }
        output.close();
    }
}