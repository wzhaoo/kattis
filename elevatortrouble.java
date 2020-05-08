import java.util.*;
import java.io.*;

class Node {
    int i;
    int d;
    public Node(int i, int d){
        this.i = i;
        this.d = d;
    }
}

public class elevatortrouble{

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int F = Integer.parseInt(st.nextToken());   //floors
        int S = Integer.parseInt(st.nextToken()) -1;   //start
        int G = Integer.parseInt(st.nextToken()) -1;   //end
        int U = Integer.parseInt(st.nextToken());   //up
        int D = Integer.parseInt(st.nextToken());   //down

        //ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        //for(int f = 0; f<F; f++) adjList.add(new ArrayList<Integer>());
        boolean[] visited = new boolean[F];
        Arrays.fill(visited, false);
        int[] distances = new int[F];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[S] = 0;

        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(S, 0));
        while(!q.isEmpty()){
            Node n = q.poll();
            if(visited[n.i]) continue;
            visited[n.i] = true;
            if(n.i+U<F){
                if(n.d+1<distances[n.i+U]){
                    distances[n.i+U] = n.d+1;
                    q.add(new Node(n.i+U, n.d+1));
                }
            }
            if(n.i-D>=0){
                if(n.d+1<distances[n.i-D]){
                    distances[n.i-D] = n.d+1;
                    q.add(new Node(n.i-D, n.d+1));
                }
            }
        }

        if(distances[G] == Integer.MAX_VALUE){
            output.println("use the stairs");
        }
        else{
            output.println(distances[G]);
        }
        output.flush();
        output.close();
    }

        //System.out.println(adjList.size());
        //System.out.println(adjList.get(1).size());
        //floorHelper(visited, adjList, S, U, D);

        //Arrays.fill(visited, false);
        //visited[S] = true;
        /*PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(S, 0));
        int[] distances = new int[F];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[S] = 0;
        while(!pq.isEmpty()){
            Node n = pq.poll();
            if(n.d>distances[n.i]) continue;
            for(int i = 0; i<adjList.get(n.i).size(); i+=2){
                int index = adjList.get(n.i).get(i);
                if(visited[index]) continue;
                int distance = n.d + adjList.get(n.i).get(i+1);
                if(distance<distances[index]){
                    distances[index] = distance;
                    pq.add(new Node(index, distance));
                }
            }
        }
        */  
       
        
    /*
    public static void floorHelper(boolean[] visits, ArrayList<ArrayList<Integer>> floorplan, int floor, int up, int down){
        if(visits[floor]) return;

        int button = 1;
        int current = floor+up;
        System.out.println(current + " " +  floorplan.size());
        while(current<floorplan.size()){
            floorplan.get(floor).add(current);
            floorplan.get(floor).add(button);
            visits[floor] = true;
            floorHelper(visits, floorplan,  current, up, down);
            current+=up;
            button++;
        }
        
        for(int i = 0; i<floorplan.get(floor).size(); i++){
            System.out.print(floorplan.get(floor).get(i) + " ");
        }
        System.out.println();
        button = 1;
        current = floor-down;
        while(current>0){
            floorplan.get(floor).add(current);
            floorplan.get(floor).add(button);
            visits[floor] = true;
            floorHelper(visits, floorplan,  current, up, down);
            current-=down;
            button++;
        }
        for(int i = 0; i<floorplan.get(floor).size(); i++){
            System.out.print(floorplan.get(i).get(i) + " ");
        }
        System.out.println();

    }
    */

}
