import java.util.*;
import java.io.*;

class Node{
    double x;
    double y;
    double r;
    public Node(double x, double y, double r){
        this.x = x;
        this.y = y;
        this.r = r;
    }
    public boolean intersect(Node n){
        double distance = Math.sqrt(Math.pow(this.x - n.x, 2) + Math.pow(this.y - n.y, 2));
        double rad = this.r + n.r;
        if(distance<rad && distance + Math.min(this.r, n.r) >Math.max(this.r, n.r)) return true;
        return false;
    }
}

public class rings {
    public static ArrayList<Node> points = new ArrayList<Node>();
    public static boolean[] visited;
    public static int max = 1;
    public static int[] maxes;
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        String line;
        while((line = input.readLine()) != null){
            int N = Integer.parseInt(line);
            if(N == -1) break;
            visited = new boolean[N];
            maxes = new int[N];
            for(int n = 0; n<N; n++){
                StringTokenizer st = new StringTokenizer(input.readLine());
                points.add(new Node(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())));
            }
            int max = 1;
            for(int i = 0; i<N; i++){
                if(!visited[i]) adj(i);
            }
            for(int i = 0; i<N; i++) max = Math.max(max, maxes[i]);
            if(max!= 1) output.println("The largest component contains " + max + " rings.");
            else output.println("The largest component contains 1 ring.");
            output.println();
            points.clear();
        }
        output.close();
    }
    public static int adj(int index){
        if(visited[index]) return 0;
        int sum = 1;
        visited[index] = true;
        for(int i = 0; i<points.size(); i++){
            if(points.get(index).intersect(points.get(i))) {
                sum+=adj(i); 
            }
        }
        return maxes[index] = sum;

    }
}