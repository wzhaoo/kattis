import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int i;
    int d;
    boolean b;
    public Node(int i, int d, boolean b){
        this.i = i;
        this.d = d;
        this.b = b;
    }
    public int compareTo(Node n){
        return Integer.compare(this.d, n.d);
    }
}

public class bumped{
public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for(int n = 0; n<N; n++) adjList.add(new ArrayList<Integer>());
        for(int m = 0; m<M; m++){
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
            adjList.get(a).add(c);
            adjList.get(b).add(a);
            adjList.get(b).add(c);
        }
        for(int f = 0; f<F; f++){
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
            adjList.get(a).add(0);
        }

        int[] distances = new int[N];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[S] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(S, 0, false));

        while(!pq.isEmpty()){
            Node n = pq.poll();
            ArrayList<Node> planes = new ArrayList<Node>();
            if(n.d>distances[n.i]) continue;
            for(int i=0; i<adjList.get(n.i).size(); i+=2){
                int distance = n.d+adjList.get(n.i).get(i+1);
                int index = adjList.get(n.i).get(i);
                if(distance<distances[index]){
                    if(distance == n.d && n.b) continue;
                    else if(distance == n.d) {
                        planes.add(new Node(index, distance, true));
                    }
                    else if (n.b){
                        planes.add(new Node(index, distance, true));
                    }
                    else{
                        pq.add(new Node(index, distance, false));
                        distances[index] = distance;
                    }
                }
                else if(distance == distances[index] && !n.b){
                    pq.add(new Node(index, distance, false));
                    distances[index] = distance;
                }
                
            }
            for(Node plane: planes){
                if(distances[plane.i]>plane.d){
                    pq.add(plane);
                    distances[plane.i] = plane.d;
                }
            }

        }
        output.println(distances[T]);
        output.flush();
        output.close();
    }
}