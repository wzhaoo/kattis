import java.util.*;
import java.awt.Point;
import java.io.*;

class Node{
    double x;
    double y;
    public Node(double x, double y){
        this.x = x;
        this.y = y;
    }
}

public class segementdistance {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int N = Integer.parseInt(input.readLine());
        for(int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            Point a = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Point b = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Point c = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Point d = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            if(a.equals(b) && c.equals(d)){
                output.printf("%.2f", a.distance(c));
                output.println();
                continue;
            }
            else if(a.equals(b)){
                output.printf("%.2f", distance(c, d, a));
                output.println();
                continue;
            }
            else if(c.equals(d)){
                output.printf("%.2f", distance(a, b, c));
                output.println();
                continue;
            }
            int o1 = orientation(a, b, c);
            int o2 = orientation(a, b, d);
            int o3 = orientation(c, d, a);
            int o4 = orientation(c, d, b);
            if(o1 != o2 && o3 != o4){
                output.println("0.00");
                continue;
            }
            output.printf("%.2f", Math.min(Math.min(distance(a, b, c), distance(a, b, d)), Math.min(distance(c, d, a), distance(c, d, b))));
            output.println();
        }
        output.close();
    }
    public static int orientation(Point n1, Point n2, Point n3){
        int ret = (n3.y - n1.y)*(n2.x-n1.x) - (n2.y-n1.y)*(n3.x-n1.x);
        if(ret == 0) return 0;
        else if(ret>0) return 1;
        else return -1;
    }
    public static boolean between(Point a, Point b, Point c){
        if(c.getX()<=Math.max(a.getX(), b.getX()) && c.getY()>=Math.min(a.getX(), b.getX()) && c.getY()<=Math.max(a.getY(), b.getY()) && c.getY()>=Math.min(a.getY(), b.getY()))
            return true;
        return false;
    }
    public static double distance(Point a, Point b, Point c){
        Node ab = new Node(b.getX()-a.getX(), b.getY()-a.getY());
        Node bc = new Node(c.getX()-b.getX(), c.getY()-b.getY());
        Node ac = new Node(c.getX()-a.getX(), c.getY()-a.getY());
        double d1 = ab.x*bc.x + ab.y*bc.y;
        double d2 = ab.x*ac.x + ab.y*ac.y;
        if(d1> 0){
            return Math.sqrt(Math.pow(b.getX() - c.getX(), 2) + Math.pow(b.getY() - c.getY(), 2));
        }
        else if(d2<0){
            return Math.sqrt(Math.pow(a.getX() - c.getX(), 2) + Math.pow(a.getY() - c.getY(), 2));
        }
        else{
            return Math.abs(ab.x*ac.y - ab.y*ac.x)/Math.sqrt(Math.pow(ab.x, 2) + Math.pow(ab.y, 2));
        }
    }
}
