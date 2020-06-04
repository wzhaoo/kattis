import java.util.*;
import java.io.*;

public class easiest {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        String line;
        while((line = input.readLine()) != null){
            int N = Integer.parseInt(line);
            if(N==0) break;
            int p = 11;
            int n = check(N);
            while(true){
                if(check(N*p) == n){
                    output.println(p);
                    break;
                }
                p++;
            }
        }
        output.close();
    }
    public static int check(int num){
        int sum = 0;
        while(num!=0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
}