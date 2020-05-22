import java.util.*;
import java.io.*;

public class modulo {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        Set<Integer> set = new HashSet<Integer>();
        String line;
        while((line = input.readLine()) != null && line.length()>0){
            int i = Integer.parseInt(line);
            set.add(i%42);
        }
        output.println(set.size());
        output.close();
    }
}