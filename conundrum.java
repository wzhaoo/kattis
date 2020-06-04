import java.util.*;
import java.io.*;

public class conundrum {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        String line = input.readLine();
        int count = 0;
        for(int i = 0; i<line.length(); i++){
            if(i%3 == 0){
                if(line.charAt(i)!='P') count++;
            }
            else if(i%3 == 1){
                if(line.charAt(i)!='E') count++;
            }
            else{
                if(line.charAt(i)!='R') count++;
            }
        }
        output.println(count);
        output.close();
    }
}