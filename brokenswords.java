import java.util.*;
import java.math.*;
import java.io.*;

public class brokenswords {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        //TBLR
        int n = Integer.parseInt(in.readLine());
        int tb = 0, lr = 0;
        for(int i = 0; i < n; i++) {
            String s = in.readLine();
            tb -= Integer.parseInt(s.substring(0, 1)) - 1;
            tb -= Integer.parseInt(s.substring(1, 2)) - 1;
            lr -= Integer.parseInt(s.substring(2, 3)) - 1;
            lr -= Integer.parseInt(s.substring(3, 4)) - 1;
        }
        int count = 0;
        count=Math.min(tb, lr)/2;
        tb = tb-count*2;
        lr = lr - count*2;
        
        out.println(count + " " + tb + " " + lr);
        out.close();
    }
}
