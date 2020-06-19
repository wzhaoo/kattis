import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int i;
    double d;
    public Node(int i, double d){
        this.i = i;
        this.d = d;
    }
    public int compareTo(Node n){
        return Double.compare(this.d, n.d);
    }
}

public class islandhopping {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int T = Integer.parseInt(input.readLine());
        for(int t = 0; t<T; t++){
            int N = Integer.parseInt(input.readLine());
            double[] x = new double[N];
            double[] y = new double[N];
            for(int n = 0; n<N; n++){
                StringTokenizer st = new StringTokenizer(input.readLine());
                x[n] = Double.parseDouble(st.nextToken());
                y[n] = Double.parseDouble(st.nextToken());
            }
            boolean[] visited = new boolean[N];
            double cost = 0;
            PriorityQueue<Node> pq = new PriorityQueue<Node>();
            pq.add(new Node(0, 0));
            int visitCount = 0;
            while(visitCount<N){
                Node n = pq.poll();
                if(visited[n.i]) continue;
                visited[n.i] = true;
                visitCount++;
                cost+=n.d;
                for(int i = 0; i<N; i++){
                    if(i == n.i) continue;
                    if(!visited[i]){
                        pq.add(new Node(i, Math.hypot(Math.abs(x[n.i]-x[i]), Math.abs(y[n.i]-y[i]))));
                    }
                }
            }
            output.println(cost);
        }
        output.close();
    }
}