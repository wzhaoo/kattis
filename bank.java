import java.util.*;
import java.io.*;

public class bank {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> times = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i<T; i++) times.add(new ArrayList<Integer>());
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(input.readLine());
            int money = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            times.get(time).add(money);
        }
        int sum = 0;
        PriorityQueue<Integer> choices = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i = T-1; i>=0; i--){
            choices.addAll(times.get(i));
            if(!choices.isEmpty()) sum+=choices.poll();
        }
        output.println(sum);
        output.close();
    }
}