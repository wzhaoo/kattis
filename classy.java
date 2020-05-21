import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    String name;
    ArrayList<Integer> classes;
    public Node(String name, ArrayList<Integer> classes){
        this.name = name;
        this.classes = classes;
    }

    public int compareTo(Node n){
        for(int i = 0; i<10; i++){
            if(Integer.compare(this.classes.get(i), n.classes.get(i))!=0){
                return Integer.compare(this.classes.get(i), n.classes.get(i));
            }
        }
        return this.name.compareTo(n.name);
    }
}

public class classy {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int T = Integer.parseInt(input.readLine());
        for(int t = 0; t<T; t++){
            int N = Integer.parseInt(input.readLine());
            PriorityQueue<Node> pq = new PriorityQueue<Node>();
            for(int i = 0; i<N; i++){
                ArrayList<Integer> sub = new ArrayList<Integer>();
                StringTokenizer st = new StringTokenizer(input.readLine());
                String name = st.nextToken();
                name = name.replace(":", "");
                StringTokenizer st2 = new StringTokenizer(st.nextToken(), "-");
                while(st2.hasMoreTokens()){
                    String s = st2.nextToken();
                    if(s.equals("upper")) sub.add(1);
                    else if(s.equals("middle")) sub.add(2);
                    else sub.add(3);
                }
                Collections.reverse(sub);
                while(sub.size()<10) sub.add(2);
                pq.add(new Node(name, sub));
                st.nextToken();
            }
            for(int i = 0; i<N; i++) output.println(pq.poll().name);
            output.println("==============================");
        }
        output.close();
    }
}