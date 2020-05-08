import java.util.*;

import java.io.*;

public class pivot {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int N = Integer.parseInt(input.readLine());
        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for(int n = 0; n<N; n++) numbers[n] = Integer.parseInt(st.nextToken());
        int count = 0;
        int[] maxes = new int[N];
        int[] mins = new int[N];
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<N; i++){
            max = Math.max(max, numbers[i]);
            maxes[i] = max;
        }
        for(int i = N-1; i>=0; i--){
            min = Math.min(min, numbers[i]);
            mins[i] = min;
        }
        for(int i = 0; i<N; i++){
            if(numbers[i]>=maxes[i] && numbers[i]<=mins[i]) count++;
        }

        output.println(count);
        output.close();
    }
}