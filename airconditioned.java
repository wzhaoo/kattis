import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int a;
    int b;
    public Node(int a, int b){
        this.a = a;
        this.b = b;
    }
    public int compareTo(Node n){
        int ret = Integer.compare(this.a, n.a);
        if(ret == 0) return Integer.compare(this.b, n.b);
        return ret;
    }
}

public class airconditioned {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int N = Integer.parseInt(input.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            pq.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int temp = pq.peek().b;
        int count = 1;
        while(!pq.isEmpty()){
            Node n = pq.poll();
            if(n.a<=temp){
                if(n.b<=temp){
                    temp = n.b;
                }
            }
            else{
                temp = n.b;
                count++;
            }
        }
        output.println(count);
        output.close();
    }
}