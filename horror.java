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

public class horror {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i<N; i++) adjList.add(new ArrayList<Integer>());
        int[] distances = new int[N];
        boolean[] visited = new boolean[N];
        Arrays.fill(distances, Integer.MAX_VALUE);
        st = new StringTokenizer(input.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        for(int h = 0; h<H; h++){
            int i = Integer.parseInt(st.nextToken());
            distances[i] = 0;
            pq.add(new Node(i, 0));
        }
        for(int i = 0; i<L; i++){
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        while(!pq.isEmpty()){
            Node n = pq.poll();
            if(visited[n.i]) continue;
            visited[n.i] = true;
            for(int i = 0; i<adjList.get(n.i).size(); i++){
                if(distances[adjList.get(n.i).get(i)]>n.d+1){
                    distances[adjList.get(n.i).get(i)] = n.d+1;
                    pq.add(new Node(adjList.get(n.i).get(i), n.d+1));
                }
            }
        }
        int max = 0;
        int index = 0;
        for(int i = 0; i<N; i++){
            if(distances[i]>max){
                max = distances[i];
                index = i;
            }
        }
        output.println(index);
        output.close();
    }
}