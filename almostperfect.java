import java.util.*;
import java.io.*;

class almostperfect {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        String line;
        while((line = input.readLine()) != null && line.length()>0){
            int n = Integer.parseInt(line);
            output.print(n);
            double sq = Math.sqrt(n);
            int sum = 1;
            if(sq == (int)sq) sum+=sq;
            for(int i = 2; i<sq; i++){
                if(n%i == 0){
                    sum+=i;
                    sum+=n/i;
                }
            }
            if(n-sum == 0) output.println(" perfect");
            else if(Math.abs(n-sum)<=2) output.println(" almost perfect");
            else output.println(" not perfect");
        }
        output.close();
    }
}