import java.io.*;
import java.util.*;

public class commercials {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(input.readLine());
        int maxSoFar = 0;
        int maxHere = 0;
        for(int i = 0; i<N; i++){
            maxHere = maxHere + Integer.parseInt(st.nextToken()) - P;
            if(maxHere<0) maxHere = 0;
            else if(maxHere>maxSoFar) maxSoFar = maxHere;
        }
        output.println(maxSoFar);
        output.close();
    }
}