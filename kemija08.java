import java.util.*;
import java.io.*;

public class kemija08 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        String line = input.readLine();
        String ans = "";
        int index = 0;
        while(index<line.length()){
            char c = line.charAt(index);
            ans+=c;
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                index+=2;
            }
            index++;
        }
        output.println(ans);
        output.close();
    }
}