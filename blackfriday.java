import java.util.*;
import java.io.*;

public class blackfriday{
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int N = Integer.parseInt(input.readLine());
        int[] instances = new int[7];
        int[] counts = new int[7];
        Arrays.fill(instances, -1);
        int[] rolls = new int[N+1];
        StringTokenizer st=  new StringTokenizer(input.readLine());
        for(int i = 1; i<N+1; i++) rolls[i] = Integer.parseInt(st.nextToken());
        for(int i = 1; i<N+1; i++){
            counts[rolls[i]]++;
            instances[rolls[i]] = i;
        }
        int ans = -1;
        int max = 0;
        for(int i = 1; i<7; i++){
            if(counts[i] == 1 && i>max){
                ans = instances[i];
                max = i;
            }
        }
        if(ans == -1) output.println("none");
        else output.println(ans);
        output.close();
    }
}