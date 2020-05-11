import java.util.*;
import java.io.*;

public class spavanac {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        if(M-45<0) output.println(((((H-1)%24)+24)%24) + " " + ((M+15)%60));
        else output.println(H + " " + (M-45));
        output.close();
    }
}