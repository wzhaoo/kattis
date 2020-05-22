import java.util.*;
import java.io.*;

public class nasyhacks {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int T = Integer.parseInt(input.readLine());
        for(int t = 0; t<T; t++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            int no = Integer.parseInt(st.nextToken());
            int ad = Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());
            if(no>ad) output.println("do not advertise");
            else if(no<ad) output.println("advertise");
            else output.println("does not matter");
        }
        output.close();
    }
}