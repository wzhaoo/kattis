import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int i;
    int d;
    int o;
    public Node(int i, int d, int o){
        this.i = i;
        this.d = d;
        this.o = o;
    }

    public int compareTo(Node n){
        if(((Integer)this.d).compareTo(n.d) == 0){
            return -1 * ((Integer)this.o).compareTo(n.o);
        }
        else return ((Integer)this.d).compareTo(n.d);
    }

}

public class bigtruck{
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(input.readLine());

        int[] objects = new int[N];
        int[] objectsMax = new int[N];
        Arrays.fill(objectsMax, 0);
        int[] distances = new int[N];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i<N; i++){
            objects[i] = Integer.parseInt(st.nextToken());
            adjList.add(new ArrayList<Integer>());
        }
        int M = Integer.parseInt(input.readLine());
        for(int m = 0; m<M; m++){
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
            adjList.get(a).add(c);
            adjList.get(b).add(a);
            adjList.get(b).add(c);
        }

        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(0, 0, objects[0]));
        while(!pq.isEmpty()){
            Node n = pq.poll();
            if(n.d>distances[n.i]) continue;
            for(int i = 0; i<adjList.get(n.i).size(); i+=2){
                int index = adjList.get(n.i).get(i);
                int distance = n.d + adjList.get(n.i).get(i+1);
                int object = n.o+objects[index];
                if(distance<distances[index]){
                    pq.add(new Node(index, distance, object));
                    distances[index] = distance;
                    objectsMax[index] = object;
                }
                else if(distance == distances[index] && object>objectsMax[index]){
                    pq.add(new Node(index, distance, object));
                    objectsMax[index] = object;
                }
            }
        }
        if(distances[N-1] == Integer.MAX_VALUE){
            out.println("impossible");
            out.flush();
            out.close();
        }
        else{
            out.println(distances[N-1] + " " + objectsMax[N-1]);
            out.flush();
            out.close();
        }
    }
}