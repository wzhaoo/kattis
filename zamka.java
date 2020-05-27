import java.util.*;
import java.io.*;

public class zamka {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int L = Integer.parseInt(input.readLine());
        int D = Integer.parseInt(input.readLine());
        int X = Integer.parseInt(input.readLine());
        int min = 0;
        int max = 0;
        for(int i = L; i<=D; i++){
            int num = i;
            int sum = 0;
            while(num!=0){
                sum+=num%10;
                num/=10;
            }
            if(sum == X){
                min = i;
                break;
            }
        }

        for(int i = D; i>=L; i--){
            int num = i;
            int sum = 0;
            while(num!=0){
                sum+=num%10;
                num/=10;
            }
            if(sum == X){
                max = i;
                break;
            }
        }

        output.println(min);
        output.println(max);
        output.close();
    }
}