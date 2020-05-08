import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    double i;
    double f;
    public Node(double i, double f){
        this.i = i;
        this.f = f;
    }
    public int compareTo(Node n){
        return Double.compare(this.f, n.f);
    }
}

public class getshorty{
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        String line;

        while((line = input.readLine())!=null && line.length()>0){
            StringTokenizer st = new StringTokenizer(line);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if(N == 0 && M == 0) break;
            ArrayList<ArrayList<Double>> adjList = new ArrayList<ArrayList<Double>>();
            for(int n = 0; n<N; n++) adjList.add(new ArrayList<Double>());
            for(int m = 0; m<M; m++){
                st = new StringTokenizer(input.readLine());
                double a = Double.parseDouble(st.nextToken());
                double b = Double.parseDouble(st.nextToken());
                double c = Double.parseDouble(st.nextToken());
                adjList.get((int)a).add(b);
                adjList.get((int)a).add(c);
                adjList.get((int)b).add(a);
                adjList.get((int)b).add(c);
            }
            double[] factors = new double[N];
            Arrays.fill(factors, 0);
            PriorityQueue<Node> pq = new PriorityQueue<Node>();
            pq.add(new Node(0, 1));
            while(!pq.isEmpty()){
                Node n = pq.poll();
                if(n.f<=factors[(int)n.i]) continue;
                factors[(int)n.i] = n.f;

                for(int i = 0; i<adjList.get((int)n.i).size(); i+=2){
                    double factor = n.f*adjList.get((int)n.i).get((int)i+1);
                    if(factor>factors[adjList.get((int)n.i).get(i).intValue()]){
                        pq.add(new Node(adjList.get((int)n.i).get((int)i), factor));
                    }
                }
            }
            output.println(String.format("%.4f",factors[N-1]));
        }
        output.flush();
        output.close();
    }
}