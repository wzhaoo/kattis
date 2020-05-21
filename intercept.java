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

public class intercept {
    public static boolean[] visited;
    public static int[] parent;
    public static int[] low;
    public static int[] disc;
    public static int time = 0;
    public static boolean[] ap;
    public static Set<Node> s = new HashSet<Node>();
    public static ArrayList<ArrayList<Integer>> nodes = new ArrayList<ArrayList<Integer>>();
    public static ArrayList<ArrayList<Node>> used = new ArrayList<ArrayList<Node>>();
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for(int n = 0; n<N; n++) {
            adjList.add(new ArrayList<Integer>());
            used.add(new ArrayList<Node>());
        }
        for(int m = 0; m<M; m++){
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
            adjList.get(a).add(c);
        }
        st = new StringTokenizer(input.readLine());
        int S = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[] distances = new int[N];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[S] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(S, 0));
        while(!pq.isEmpty()){
            Node n = pq.poll();
            if(distances[n.i]<n.d) continue;
            for(int i = 0; i<adjList.get(n.i).size(); i+=2){
                int index = adjList.get(n.i).get(i);
                int distance = n.d + adjList.get(n.i).get(i+1);
                if(distance<distances[index]){
                    distances[index] = distance;
                    pq.add(new Node(index, distance));
                    used.get(index).clear();
                    used.get(index).add(new Node(n.i, index));
                }
                else if(distance == distances[index]){
                    used.get(index).add(new Node(n.i, index));
                }
            }
        }

        for(int i = 0; i<N; i++) nodes.add(new ArrayList<Integer>());
        revdfs(T);
        for(Node n: s){
          nodes.get(n.i).add(n.d);
          nodes.get(n.d).add(n.i);
        }
        visited = new boolean[N];
        parent = new int[N];
        low = new int[N];
        Arrays.fill(low, -1);
        disc = new int[N];
        ap = new boolean[N];
        for(int i = 0; i<N; i++) if(!visited[i]) dfs(i);

        for(int i = 0; i<N; i++){
            if(ap[i] || i == S || i==T) output.print(i + " ");
        }

        output.close();

    }

    public static void revdfs(int index){
      for(Node n: used.get(index)){
        if(!s.contains(n)){
          s.add(n);
          revdfs(n.i);
        }
      }
    }

    public static void dfs(int index){
        int children = 0;
        visited[index] = true;
        disc[index] = low[index] = ++time;
        for(int i = 0; i<nodes.get(index).size(); i++){
            int v = nodes.get(index).get(i);
            if(!visited[v]){
                children++;
                parent[v] = index;
                dfs(v);
                low[index] = Math.min(low[index], low[v]);
                if(low[v]>=disc[index]) ap[index] = true;
            }
            else if(parent[index] != v) low[index] = Math.min(low[index], disc[v]);
        }
    }
}