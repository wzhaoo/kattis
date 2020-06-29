import java.util.*;
import java.io.*;

public class unionfind {
    public static int[] nums;
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        nums = new int[N];
        Arrays.fill(nums, -1);
        for(int q = 0; q<Q; q++){
            st = new StringTokenizer(input.readLine());
            if(st.nextToken().equals("?")){
                int a = find(Integer.parseInt(st.nextToken()));
                int b = find(Integer.parseInt(st.nextToken()));
                if(a == b) output.println("yes");
                else output.println("no");
            }
            else{
                int a = find(Integer.parseInt(st.nextToken()));
                int b = find(Integer.parseInt(st.nextToken()));
                union(a, b);
            }
        }
        output.close();
    }
    public static int find(int i){
        if(nums[i]<0){
            return i;
        }
        return find(nums[i]);
    }
    public static void union(int i, int j){
        int a = find(i);
        int b = find(j);
        if(a == b) return;
        if(nums[a] <= nums[b]){
            nums[a]+=nums[b];
            nums[b] = a;
        }
        else{
            nums[b]+=nums[a];
            nums[a] = b;
        }
    }
}