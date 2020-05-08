import java.util.*;
import java.io.*;

class Node{
    int i;
    int d;
    public Node(int i, int d){
        this.i = i;
        this.d = d;
    }
}

public class shortestpath3{
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        String line;
        while((line = input.readLine())!=null){
            StringTokenizer st = new StringTokenizer(line);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());

            if(N == 0 && M == 0 && Q == 0 && S == 0) break;

            ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
            for(int n = 0; n<N; n++) adjList.add(new ArrayList<Integer>());
            for(int m = 0; m<M; m++){
                st = new StringTokenizer(input.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                adjList.get(a).add(b);
                adjList.get(a).add(c);
            }

            int[] queries = new int[Q];
            for(int q = 0; q<Q; q++) queries[q] = Integer.parseInt(input.readLine());

            int[] distances = new int[N];
            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[S] = 0;
            boolean[] visited = new boolean[N];
            Arrays.fill(visited, false);
            Queue<Node> q = new LinkedList<Node>();
            for(int k = 0; k<N-1; k++){
                q.add(new Node(S, 0));
                while(!q.isEmpty()){
                    Node n = q.poll();
                    if(visited[n.i]) continue;
                    visited[n.i] = true;
                    for(int j = 0; j<adjList.get(n.i).size(); j+=2){
                        int index = adjList.get(n.i).get(j);
                        int distance = distances[n.i] + adjList.get(n.i).get(j+1);
                        if(distance<distances[index]){
                            distances[index] = distance;
                        }
                        q.add(new Node(index, distances[index]));
                    }
                    
                }
                Arrays.fill(visited, false);
            }

            /*for(int k = 0; k<N-1; k++){
                for(int i = 0; i<N; i++){
                    for(int j = 0; j<adjList.get(i).size(); j+=2){
                        int index = adjList.get(i).get(j);
                        int distance = distances[i] + adjList.get(i).get(j+1);
                        if(distance<distances[index]){
                            distances[index] = distance;
                        }
                    }
                }
            }*/

            int[] sub = new int[N];
            for(int i = 0; i<N; i++) sub[i] = distances[i];
            /*for(int i = 0; i<N; i++){
                for(int j = 0; j<adjList.get(i).size(); j+=2){
                    int index = adjList.get(i).get(j);
                    int distance = distances[i] + adjList.get(i).get(j+1);
                    if(distance<distances[index]){
                        distances[index] = distance;
                    }
                }
            }
            */
            for(int k = 0; k<N-1; k++){
                q.add(new Node(S, 0));
                while(!q.isEmpty()){
                    Node n = q.poll();
                    if(visited[n.i]) continue;
                    visited[n.i] = true;
                    for(int j = 0; j<adjList.get(n.i).size(); j+=2){
                        if(n.d==Integer.MIN_VALUE){
                            distances[adjList.get(n.i).get(j)] = Integer.MIN_VALUE;
                            q.add(new Node(adjList.get(n.i).get(j), distances[adjList.get(n.i).get(j)]));
                            continue;
                        }
                        int index = adjList.get(n.i).get(j);
                        int distance = distances[n.i] + adjList.get(n.i).get(j+1);
                        if(distance<distances[index]){
                            distances[index] = Integer.MIN_VALUE;
                        }
                        q.add(new Node(index, distances[index]));
                    }
                    
                }
                Arrays.fill(visited, false);
            }


            for(int x = 0; x<Q; x++){
                if(distances[queries[x]]<sub[queries[x]]) output.println("-Infinity");
                else if(distances[queries[x]] == Integer.MAX_VALUE) output.println("Impossible");
                else output.println(distances[queries[x]]);
            }
            output.println();
        }
        output.flush();
        output.close();
    }
}