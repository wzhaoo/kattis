import java.util.*;
import java.io.*;
import java.math.*;
public class different{
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        String line;
    
        while((line = input.readLine())!=null){
            StringTokenizer st = new StringTokenizer(line);
            BigInteger a = new BigInteger(st.nextToken());
            BigInteger b = new BigInteger(st.nextToken());
            if(a.compareTo(b)>0) output.println(a.subtract(b));
            else output.println(b.subtract(a));
        }
        output.close();
    }
}