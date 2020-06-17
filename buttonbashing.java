import java.util.*;
import java.io.*;

public class buttonbashing {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int T = Integer.parseInt(input.readLine());
        for(int t = 0; t<T; t++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            int N = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            boolean[] possible = new boolean[3601];
            possible[0] = true;
            int[] buttons = new int[N];
            int[] presses = new int[3601];
            Arrays.fill(presses, Integer.MAX_VALUE);
            presses[0] = 0;
            st = new StringTokenizer(input.readLine());
            for(int n = 0; n<N; n++) {
                buttons[n] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(buttons);
            Queue<Integer> q = new LinkedList<Integer>();
            q.add(0);
            while(!q.isEmpty()){
                int sub = q.poll();
                for(int i = 0; i<N; i++){
                    int sum = Math.max(0, Math.min(sub+buttons[i], 3600));
                    possible[sum] = true;
                    if(presses[sum]>presses[sub]+1){
                        presses[sum] = presses[sub]+1;
                        q.add(sum);
                    }
                }
            }
            for(int i = time; i<3601; i++){
                if(possible[i]){
                    output.println(presses[i] + " " + (i-time));
                    break;
                }
            }
        }
        output.close();
    }
}