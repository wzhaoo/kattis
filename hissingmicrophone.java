import java.util.*;
import java.io.*;

public class hissingmicrophone {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        String line = input.readLine();
        boolean printed = false;
        for(int i = 0; i<line.length()-1; i++){
            if(line.charAt(i) == 's' && line.charAt(i+1) == 's'){
                printed = true;
                break;
            }
        }
        if(printed) output.println("hiss");
        else output.println("no hiss");
        output.close();
    }
}