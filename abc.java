import java.util.*;
import java.io.*;

public class abc {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(Integer.parseInt(st.nextToken()));
        nums.add(Integer.parseInt(st.nextToken()));
        nums.add(Integer.parseInt(st.nextToken()));
        Collections.sort(nums);
        String line = input.readLine();
        for(int i = 0; i<3; i++){
            if(line.charAt(i) == 'A') output.println(nums.get(0));
            else if(line.charAt(i) == 'B') output.println(nums.get(1));
            else output.println(nums.get(2));
        }
        output.close();
    }
}