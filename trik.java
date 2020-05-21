import java.util.*;
import java.io.*;

public class trik {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        String line = input.readLine();
        int[] arr = new int[3];
        arr[0] = 1;
        for(int i = 0; i<line.length(); i++){
            if(line.charAt(i) == 'A'){
                int sub = arr[0];
                arr[0] = arr[1];
                arr[1] = sub;
            }
            else if(line.charAt(i) == 'B'){
                int sub = arr[1];
                arr[1] = arr[2];
                arr[2] = sub;
            }
            else{
                int sub = arr[0];
                arr[0] = arr[2];
                arr[2] = sub;
            }
        }
        for(int i = 0; i<3; i++){
            if(arr[i] == 1) output.println(i+1);
        }
        output.close();
    }
}