import java.util.*;
import java.io.*;

class Point implements Comparable<Point>{
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int compareTo(Point p){
        int a = Integer.compare(this.y, p.y);
        if(a == 0) return Integer.compare(this.x, p.x);
        return a;
    }
}

public class convexhull {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        String line;
        while((line = input.readLine()) != null){
            int N = Integer.parseInt(line);
            if(N == 0) break;
            ArrayList<Point> points = new ArrayList<Point>();
            for(int i = 0; i<N; i++){
                StringTokenizer st = new StringTokenizer(input.readLine());
                points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            Collections.sort(points);
            ArrayList<Point> up = new ArrayList<Point>();
            ArrayList<Point> down = new ArrayList<Point>();
            for(int i = 0; i<N; i++){
                Point p = points.get(i);
                while(up.size()>1 && orientation(up.get(up.size()-2), up.get(up.size()-1), p) <= 0){
                    up.remove(up.size()-1);
                }
                while(down.size()>1 && orientation(down.get(down.size()-2), down.get(down.size()-1), points.get(points.size()-1-i)) <= 0){
                    down.remove(down.size()-1);
                }
                up.add(p);
                down.add(points.get(points.size()-1-i));
            }
            if(up.size()>1) up.remove(up.size()-1);
            if(down.size()>1) down.remove(down.size()-1);
            up.addAll(down);
            ArrayList<Point> ans = new ArrayList<Point>();
            for(int i = 0; i<up.size()-1; i++){
                Point a = up.get(i);
                Point b = up.get(i+1);
                if(a.x-b.x != 0 || a.y-b.y!=0) ans.add(a);
            }
            ans.add(up.get(up.size()-1));
            output.println(ans.size());
            for(int i = 0; i<ans.size(); i++){
                Point p = ans.get(i);
                output.println(p.x + " " + p.y);
            }
        }
        output.close();
    }
    public static int orientation(Point a, Point b, Point c){
        return (c.y-a.y)*(b.x-a.x) - (b.y-a.y)*(c.x-a.x);
    }
}