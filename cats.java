import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int i;
    int d;
    public Node(int i, int d){
        this.i = i;
        this.d = d;
    }
    public int compareTo(Node n){
        return Integer.compare(this.d, n.d);
    }
}

public class cats {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int T = Integer.parseInt(input.readLine());
        for(int t = 0; t<T; t++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            int M = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i<C; i++) adjList.add(new ArrayList<Integer>());
            for(int i = 0; i<C*(C-1)/2; i++){
                st = new StringTokenizer(input.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                adjList.get(a).add(b);
                adjList.get(a).add(c);
                adjList.get(b).add(a);
                adjList.get(b).add(c);
            }
            boolean[] visited = new boolean[C];
            PriorityQueue<Node> pq = new PriorityQueue<Node>();
            pq.add(new Node(0, 0));
            int cost = 0;
            boolean printed = false;
            int visitCount = 0;
            while(!pq.isEmpty() && visitCount<C){
                Node n = pq.poll();
                if(visited[n.i]) continue;
                visited[n.i] = true;
                cost+=n.d;
                visitCount++;
                for(int i = 0; i<adjList.get(n.i).size(); i+=2){
                    if(!visited[adjList.get(n.i).get(i)]){
                        pq.add(new Node(adjList.get(n.i).get(i), adjList.get(n.i).get(i+1)));
                    }
                }
            }
            if(cost+C<=M) output.println("yes");
            else output.println("no");
        }
        output.close();
    }
}