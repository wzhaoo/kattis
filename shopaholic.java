import java.util.*;
import java.io.*;

public class shopaholic {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int N = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int n = 0; n<N; n++) nums.add(Integer.parseInt(st.nextToken()));
        Collections.sort(nums, Collections.reverseOrder());
        long sum = 0;
        for(int i = 2; i<N; i+=3){
            sum+=nums.get(i);
        }
        output.println(sum);
        output.close();

    }
}