import java.util.*;
import java.io.*;

public class gcpc {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int curr = 1;
        int[] solved = new int[N+1];
        int[] penalty = new int[N+1];
        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
        map.put(0, new HashSet<Integer>());
        for(int m = 0; m<M; m++){
            st = new StringTokenizer(input.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            solved[t]++;
            penalty[t]+=p;
            if(!map.containsKey(solved[t])){
                map.put(solved[t], new HashSet<Integer>());
            }
            map.get(solved[t]).add(t);
            if(solved[t]!=1) map.get(solved[t]-1).remove(t);
            if(t == 1){
                for(int team: map.get(solved[t])){
                    if(penalty[t]<=penalty[team] && team!=t) curr--;
                }
                for(int team: map.get(solved[t]-1)){
                    if(penalty[t]-p>penalty[team]) curr--;
                }
            }
            else if(solved[t] == solved[1]+1 && penalty[1] <= penalty[t]-p){
                curr++;
            }
            else if(solved[t] == solved[1] && penalty[t]<penalty[1]){
                curr++;
            }
            output.println(curr);
        }
        output.close();
    }
}