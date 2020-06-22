import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int i;
    int d;
    int g;
    public Node(int i, int d, int g){
        this.i = i;
        this.d = d;
        this.g = g;
    }
    public int compareTo(Node n){
        return Integer.compare(this.d, n.d);
    }
}

public class fulltank {
    public static int[] prices;
    public static int[][] distances;
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(input.readLine());
        prices = new int[N];
        for(int i = 0; i<N; i++) prices[i] = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i<N; i++) adjList.add(new ArrayList<Integer>());
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
            adjList.get(a).add(c);
            adjList.get(b).add(a);
            adjList.get(b).add(c);
        }
        int Q = Integer.parseInt(input.readLine());
        for(int q = 0; q<Q; q++){
            st = new StringTokenizer(input.readLine());
            int C = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            distances = new int[N][C+1];
            for(int i = 0; i<N; i++) Arrays.fill(distances[i], Integer.MAX_VALUE);
            distances[start][0] = 0;
            PriorityQueue<Node> pq = new PriorityQueue<Node>();
            pq.add(new Node(start, 0, 0));
            boolean printed = false;
            while(!pq.isEmpty()){
                Node n = pq.poll();
                if(n.d>distances[n.i][n.g]) continue;
                if(n.i == end) {
                    output.println(n.d);
                    printed = true;
                    break;
                }
                if(n.g<C && n.d + prices[n.i] < distances[n.i][n.g+1]){
                    distances[n.i][n.g+1] = n.d + prices[n.i];
                    pq.add(new Node(n.i, n.d+prices[n.i], n.g+1));
                }
                for(int i = 0; i<adjList.get(n.i).size(); i+=2){
                    int index = adjList.get(n.i).get(i);
                    int newGas = n.g - adjList.get(n.i).get(i+1);
                    if(newGas>=0 && n.d<distances[index][newGas]){
                        distances[index][newGas] = n.d;
                        pq.add(new Node(index, n.d, newGas));
                    }
                }
            }
            if(!printed) output.println("impossible");
        }
        output.close();
    }
}