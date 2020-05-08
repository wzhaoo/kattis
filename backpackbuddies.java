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

public class backpackbuddies{
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
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
        int[] distances = new int[N];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(0, 0));

        while(!pq.isEmpty()){
            Node n = pq.poll();
            for(int i = 0; i<adjList.get(n.i).size(); i+=2){
                int distance = n.d + adjList.get(n.i).get(i+1);
                if(distance<distances[adjList.get(n.i).get(i)]){
                    distances[adjList.get(n.i).get(i)] = distance;
                    pq.add(new Node(adjList.get(n.i).get(i), distance));
                }
            }
        }
        int knight = distances[N-1];
        if(knight%12 == 0) knight+=knight-12;
        else knight+=knight - knight%12;
        
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;
        pq.add(new Node(0, 0));
        while(!pq.isEmpty()){
            Node n = pq.poll();
            for(int i = 0; i<adjList.get(n.i).size(); i+=2){
                int distance = n.d;
                int prevTravelled = n.d%12;
                int actualDistance = prevTravelled + adjList.get(n.i).get(i+1);
                if(actualDistance<=12){
                    if(distance+adjList.get(n.i).get(i+1)<distances[adjList.get(n.i).get(i)]){
                        distances[adjList.get(n.i).get(i)] = distance+adjList.get(n.i).get(i+1);
                        pq.add(new Node(adjList.get(n.i).get(i), distance+adjList.get(n.i).get(i+1)));
                    }
                }
                else if(distance+adjList.get(n.i).get(i+1)-prevTravelled+12<distances[adjList.get(n.i).get(i)]){
                    distances[adjList.get(n.i).get(i)] = distance+adjList.get(n.i).get(i+1)-prevTravelled+12;
                    pq.add(new Node(adjList.get(n.i).get(i), distance+adjList.get(n.i).get(i+1)-prevTravelled+12));
                }
            }
        }
        int day = distances[N-1];
        if(day%12 == 0) day+=day-12;
        else day+=day-day%12;
        output.println();
        output.println(day-knight);
        output.close();
    }
}