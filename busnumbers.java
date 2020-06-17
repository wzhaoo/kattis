import java.util.*;
import java.io.*;

public class busnumbers {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        ArrayList<Integer> nums = new ArrayList<Integer>();
        int N = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        for(int n = 0; n<N; n++){
            nums.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(nums);
        int index = 0;
        int count = 1;
        while(index<N){
            int curr = nums.get(index);
            if(index!=N-1){
                int next = nums.get(index+1);
                if(next-curr == 1){
                    count++;
                    index++;
                    continue;
                }
            }
            if(count == 2){
                output.print(nums.get(index-1) + " " + nums.get(index) + " ");
            }
            else if(count == 1){
                output.print(nums.get(index) + " ");
            }
            else{
                output.print(nums.get(index-count+1) + "-" + nums.get(index) + " ");
            }
            count = 1;
            index++;
        }
        output.close();
    }
}