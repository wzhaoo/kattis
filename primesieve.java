import java.util.*;
import java.io.*;

public class primesieve {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        BitSet primes = new BitSet(N+1);
        primes.set(2, N+1, true);
        int count = N-1;
        for(int i = 2; i<=Math.ceil(Math.sqrt(N)); i++){
            if(primes.get(i)){
                for(int j = i*i; j<=N; j+=i){
                    if(primes.get(j)){
                        count--;
                    }
                    primes.set(j, false);
                }
            }
        }
        output.println(count);
        for(int i = 0; i<Q; i++){
            if(primes.get(Integer.parseInt(input.readLine()))) output.println("1");
            else output.println("0");
        }
        /*Set<Integer> primes = new HashSet<Integer>();
        primes.add(2);
        outer:
        for(int i = 3; i<N+1; i++){
            for(int prime: primes){
                if(i%prime == 0){
                    continue outer;
                }
            }
            primes.add(i);
        }
        output.println(primes.size());
        for(int i = 0; i<Q; i++){
            if(primes.contains(Integer.parseInt(input.readLine()))) output.println("1");
            else output.println("0");
        }*/
        output.close();
    }
}