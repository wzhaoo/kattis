import java.util.*;
import java.io.*;

public class pet {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int t = 0;
        int max = 0;
        for(int i = 1; i<6; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            int sub = 0;
            for(int j = 0; j<4; j++) sub+=Integer.parseInt(st.nextToken());
            if(sub>max){
                max = sub;
                t = i;
            }
        }
        output.println(t + " " + max);
        output.close();
    }
}