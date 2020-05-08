import java.util.*;
import java.io.*;

class Node
{
    int i;
    int d;
    public Node(int i, int d)
    {
        this.i = i;
        this.d = d;
    }
}

public class wheresmyinternet{
    
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer stt = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(stt.nextToken()); //number of houses
        int M = Integer.parseInt(stt.nextToken()); //number of cables

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= N; i++) adjList.add(new ArrayList<Integer>());
        for(int i = 0; i < M; i++)
        {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        Queue<Node> q = new LinkedList<Node>();
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        q.add(new Node(1,0));
        while(!q.isEmpty())
        {
            Node nod = q.poll();
            for(int j : adjList.get(nod.i))
            {
                if(nod.d+1<dist[j])
                {
                    dist[j] = nod.d+1;
                    q.add(new Node(j,dist[j]));
                }
            }
        }
        //Check which values are infinite
        boolean printed = false;
        for(int i = 1; i<=N; i++){
            if(dist[i] == Integer.MAX_VALUE){
                output.println(i);
                printed = true;
            }
        }
        if(!printed) output.println("Connected");
        output.close();
    }
}

