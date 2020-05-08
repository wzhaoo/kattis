import java.util.*;
import java.io.*;

public class phonelist {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int T = Integer.parseInt(input.readLine());
        for(int t = 0; t<T; t++){
            int N = Integer.parseInt(input.readLine());
            ArrayList<String> numbers = new ArrayList<String>();
            for(int n = 0; n<N; n++) numbers.add(input.readLine());
            Collections.sort(numbers);
            boolean printed = false;
            for(int i = 0; i<N-1; i++){
                String a = numbers.get(i);
                String b = numbers.get(i+1);
                if(a.length()<b.length()){
                    if(b.startsWith(a)){
                        output.println("NO");
                            printed = true;
                            break;
                    }
                }
            }
            
            if(!printed) output.println("YES");
        }
        output.close();
    }
}