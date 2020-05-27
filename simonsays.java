import java.util.*;
import java.io.*;

public class simonsays {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output= new PrintWriter(System.out);
        int N = Integer.parseInt(input.readLine());
        for(int i = 0; i<N; i++){
            String line = input.readLine();
            if(line.length() > 11 && line.substring(0, 11).equals("Simon says ")) output.println(line.substring(11));
        }
        output.close();
    }
}