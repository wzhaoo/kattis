import java.util.*;
import java.io.*;

public class cetvrta {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(input.readLine());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(input.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());
        int x4;
        int y4;
        if(x1 == x2) x4 = x3;
        else if(x2 == x3) x4 = x1;
        else if(x1 == x3) x4 = x2;
        else x4 = x1;
        if(y1 == y2) y4 = y3;
        else if(y2 == y3) y4 = y1;
        else if(y1 == y3) y4 = y2;
        else y4 = y1;
        output.println(x4 + " " + y4);
        output.close();
    }
}