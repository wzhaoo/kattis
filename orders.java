import java.util.*;
import java.io.*;

public class orders {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int items = Integer.parseInt(input.readLine());
        int[] values = new int[items];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for(int i = 0; i<items; i++){
            values[i] = Integer.parseInt(st.nextToken());
        }
        int N = Integer.parseInt(input.readLine());
        int[] orders = new int[N];
        Arrays.sort(orders);
        ArrayList<ArrayList<Integer>> used = new ArrayList<ArrayList<Integer>>();
        int max = 0;
        st = new StringTokenizer(input.readLine());
        for(int i = 0; i<N; i++){
            orders[i] = Integer.parseInt(st.nextToken());
            if(orders[i]>max) max = orders[i];
        }
        for(int i = 0; i<max+1; i++) used.add(new ArrayList<Integer>());
        int[] possibilities = new int[max+1];
        int[] parent = new int[max+1];
        
        
        for(int i = 0; i<items; i++){
            int price = values[i];
            for(int j = 1; j<possibilities.length; j++){
                if(j>price && possibilities[j-price]!=0){
                    if(possibilities[j]<1){
                        parent[j] = i;
                    }
                    possibilities[j]++;
                    if(possibilities[j-price]>1) possibilities[j]++;
                }
                else if(j%price == 0){
                    possibilities[j]++;
                    parent[j] = i;
                }
            }
        }



        for(int i = 0; i<N; i++){
            int index = orders[i];
            if(possibilities[index] == 1){
                PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
                while(index>0){
                    pq.add(parent[index]+1);
                    index-=values[parent[index]];
                }
                while(!pq.isEmpty()){
                    output.print(pq.poll() + " ");
                }
                output.println();
            }
            else if(possibilities[index] > 1){
                output.println("Ambiguous");
            }
            else output.println("Impossible");
        }
        output.flush();
        output.close();
    }
}