import java.util.*;
import java.io.*;

public class babelfish {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        HashMap<String, String> dict = new HashMap<String, String>();
        String line;
        while((line = input.readLine()) != null && line.length()>0){
            StringTokenizer st = new StringTokenizer(line);
            String a = st.nextToken();
            String b = st.nextToken();
            dict.put(b, a);
        }
        while((line = input.readLine()) != null && line.length()>0){
            if(dict.containsKey(line)) output.println(dict.get(line));
            else output.println("eh");
        }
        output.close();
    }
}