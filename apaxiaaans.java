import java.util.*;
import java.io.*;

public class apaxiaaans {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        String s = input.readLine();
        String ret = "";
        char prev = ' ';
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)!=prev){
                ret+=s.charAt(i);
            }
            prev = s.charAt(i);
        }
        output.println(ret);
        output.close();
    }
}