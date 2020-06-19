import java.util.*;
import java.io.*;

public class prinova {
    public static int[] nums;
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int N = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        nums = new int[N];
        for(int i = 0; i<N; i++) nums[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(nums);
        st = new StringTokenizer(input.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if(a%2 == 0) a++;
        if(b%2 == 0) b--;
        int bestDistance = Math.abs(nearest(a)-a);
        int best = a;
        int sub = Math.abs(nearest(b)-b);
        if(sub>bestDistance){
            best = b;
            bestDistance = sub;
        }
        for(int i = 0; i<N-1; i++){
            int mid = (nums[i]+nums[i+1])/2;
            if(mid%2==0) mid-=1;
            if(mid<a) continue;
            if(mid>b) break;
            if(Math.abs(mid-nums[i])>bestDistance){
                bestDistance = Math.abs(mid-nums[i]);
                best = mid;
            }
        }
        output.println(best);
        output.close();
        
    }
    public static int nearest(int i){
        int ret = i;
        int min = 1000000000;
        for(int num: nums){
            if(Math.abs(i-num)<min){
                min = Math.abs(i-num);
                ret = num;
            }
        }
        return ret;
    }
}