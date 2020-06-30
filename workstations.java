import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int t;
    int s;
    public Node(int t, int s){
        this.t = t;
        this.s = s;
    }
    public int compareTo(Node n){
        int a = Integer.compare(this.t, n.t);
        if(a == 0) return Integer.compare(n.t, this.t);
        return a;
    }
}

public class workstations {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(input.readLine());
            pq.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        PriorityQueue<Integer> stations = new PriorityQueue<Integer>();
        int count = 0;
        outer: while(!pq.isEmpty()){
            Node n = pq.poll();
            while(!stations.isEmpty()){
                if(stations.peek()+M<n.t) {
                    stations.poll();
                }
                else if(stations.peek()<=n.t){
                    int i = stations.poll();
                    stations.add(n.t+n.s);
                    continue outer;
                }
                else{
                    count++;
                    stations.add(n.t+n.s);
                    continue outer;
                }
            }
            stations.add(n.t+n.s);
            count++;
        }
        output.println(N-count);
        output.close();
    }
}