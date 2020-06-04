import java.util.*;
import java.io.*;

public class sevenwonders {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        String line = input.readLine();
        int[] cards = new int[3];
        for(int i = 0; i<line.length(); i++){
            if(line.charAt(i) == 'T') cards[0]++;
            else if(line.charAt(i) == 'G') cards[1]++;
            else cards[2]++;
        }
        int sum = 0;
        sum+=7*Math.min(cards[0], Math.min(cards[1], cards[2]));
        sum+=cards[0]*cards[0] + cards[1]*cards[1] + cards[2]*cards[2];
        output.println(sum);
        output.close();
    }
}