import java.util.*;
import java.io.*;

public class detaileddifferences {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int T = Integer.parseInt(input.readLine());
        for(int t = 0; t<T; t++){
            String a = input.readLine();
            String b = input.readLine();
            String c = "";
            for(int i = 0; i<a.length(); i++){
                if(a.charAt(i) == b.charAt(i)) c+=".";
                else c+="*";
            }
            output.println(a);
            output.println(b);
            output.println(c);
        }
        output.close();
    }
}