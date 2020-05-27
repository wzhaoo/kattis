import java.util.*;
import java.io.*;

public class dicecup {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] sums = new int[N+M+1];
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=M; j++){
                sums[i+j]++;
            }
        }
        int max = 0;
        ArrayList<Integer> maxes = new ArrayList<Integer>();
        for(int i = 0; i<N+M+1; i++){
            if(sums[i]>max){
                maxes.clear();
                maxes.add(i);
                max = sums[i];
            }
            else if(sums[i] == max) maxes.add(i);
        }
        Collections.sort(maxes);
        for(int i = 0; i<maxes.size(); i++) output.println(maxes.get(i));
        output.close();
    }
}