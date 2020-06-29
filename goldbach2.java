import java.util.*;
import java.io.*;

public class goldbach2 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        ArrayList<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        for(int i = 3; i<=32000; i++){
            if(isPrime(i)) primes.add(i);
        }
        int T = Integer.parseInt(input.readLine());
        for(int t = 0; t<T; t++){
            int num = Integer.parseInt(input.readLine());
            int count = 0;
            ArrayList<Integer> ans = new ArrayList<Integer>();
            int half = num/2+1;
            int i = 0;
            while(primes.get(i)<half){
                if(primes.contains(num-primes.get(i))){
                    ans.add(primes.get(i));
                    count++;
                }
                i++;
            }
            output.println(num + " has " + count + " representation(s)");
            for(int j = 0; j<ans.size(); j++){
                output.println(ans.get(j) + "+" + (num-ans.get(j)));
            }
            output.println();
        }
        output.close();
    }
    public static boolean isPrime(int n){
        for(int i = 2; i<(int)(Math.sqrt(n)+1); i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}