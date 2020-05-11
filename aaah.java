import java.util.*;
import java.io.*;

public class aaah {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        String s = input.readLine();
        String S = input.readLine();
        if(s.length()<S.length()) output.println("no");
        else output.println("go");
        output.close();
    }
}