import java.util.*;
import java.io.*;

public class backspace {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        String line = input.readLine();
        char[] str = line.toCharArray();
        int count = 0;
        for(int i = line.length()-1;i>=0; i--){
            if(line.charAt(i) == '<'){
                str[i] = ' ';
                count++;
            }
            else if(count>0){
                str[i] = ' ';
                count--;
            }
        }
        line = new String(str);
        output.println(line.replaceAll(" ", ""));
        output.close();
    }
}