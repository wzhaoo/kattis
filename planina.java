import java.util.*;
import java.io.*;

public class planina {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int side = 2;
        int N = Integer.parseInt(input.readLine());
        for(int i = 0; i<N; i++){
            side+=side-1;
        }
        output.println(side*side);
        output.close();
    }
}