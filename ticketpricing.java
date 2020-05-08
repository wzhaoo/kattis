import java.util.*;
import java.io.*;

public class ticketpricing {
    public static int[][] maxes;
    public static ArrayList<ArrayList<Integer>> weeks;
    public static int N;
    public static int sp = Integer.MAX_VALUE;
    public static int m = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int seats = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken())+1;
        weeks = new ArrayList<ArrayList<Integer>>();
        for(int n = 0; n<N; n++){
            st = new StringTokenizer(input.readLine());
            ArrayList<Integer> sub = new ArrayList<Integer>();
            while(st.hasMoreTokens()) sub.add(Integer.parseInt(st.nextToken()));
            weeks.add(sub);
        }
        maxes = new int[N][seats+1];
        //int z = maxPrice(0, 0, seats);
        int m = maxPrice(0, seats);
        output.println(m);
        output.println(sp);
        output.close();

    }

    public static int maxPrice(int currWeek, int ticketsLeft){
        if(currWeek == N || ticketsLeft == 0) return 0;
        else if(maxes[currWeek][ticketsLeft]!=0) return maxes[currWeek][ticketsLeft];
        ArrayList<Integer> current = weeks.get(currWeek);
        int n = current.get(0);
        int maxAdd = 0;
        for(int i = 1; i<n+1; i++){
            int price = current.get(i);
            int tickets = Math.min(ticketsLeft, current.get(i+n));
            int sub = price*tickets + maxPrice(currWeek+1, ticketsLeft-tickets);
            if(sub>maxAdd) {
                maxAdd = sub;
                if(currWeek == 0)
                    sp = price;
            }
            else if(sub == maxAdd && currWeek == 0)
                sp = Math.min(sp, price);
        }
        maxes[currWeek][ticketsLeft] = maxAdd;
        return maxAdd;
    }
}