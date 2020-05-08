import java.util.*;
import java.io.*;
import java.math.*;

public class climbingworm {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int count = 0;
        int position = 0;
        while(position<c){
            position+=a;
            count++;
            if(position>=c){
                System.out.println(count);
                break;
            }
            position-=b;
        }
        
    }
    
}
