import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int x;
    int y;
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int compareTo(Node n){
        int i = Integer.compare(this.y, n.y);
        if(i == 0) return Integer.compare(this.x, n.x);
        return i;
    }
}

public class roberthood {
    public static int max = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int N = Integer.parseInt(input.readLine());
        ArrayList<Node> arr = new ArrayList<Node>();
        for(int n = 0; n<N; n++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.add(new Node(a, b));
        }
        if(N == 2){
            Node a = arr.get(0);
            Node b = arr.get(1);
            output.println(Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2)));
        }
        else{
            //points for coming up, wants bigger slope; upoints for coming down, wants smaller slope
            Collections.sort(arr);
            ArrayList<Node> points = new ArrayList<Node>();
            ArrayList<Node> upoints = new ArrayList<Node>();
            for(int i = 0; i<N; i++){
                Node n = arr.get(i);
                while(points.size()>1 && orientation(points.get(points.size()-2), points.get(points.size() - 1), n) <= 0){
                    points.remove(points.size() - 1);
                }
                while(upoints.size()>1 && orientation(upoints.get(upoints.size() - 2), upoints.get(upoints.size() -1), arr.get(arr.size() - 1 - i)) <= 0){
                    upoints.remove(upoints.size() - 1);
                }
                points.add(n);
                upoints.add(arr.get(arr.size() - i - 1));
            }
            points.addAll(upoints);
            double max = 0;
            for(int i = 0; i<points.size(); i++){
                for(int j = i+1; j<points.size(); j++){
                    double sub = Math.sqrt(Math.pow(points.get(i).x - points.get(j).x, 2) + Math.pow(points.get(i).y - points.get(j).y, 2));
                    if(sub>max) max = sub;
                }
            }
            output.println(max);
        }
        output.close();

    }
    public static int orientation(Node n1, Node n2, Node n3){
        return (n3.y - n1.y)*(n2.x-n1.x) - (n2.y-n1.y)*(n3.x-n1.x);
    }
}