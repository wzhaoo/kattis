import java.util.*;
import java.io.*;

public class restaurant {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        String line;
        int T = 0;
        while((line = input.readLine()) != null && line.length()>0){
            int N = Integer.parseInt(line);
            if(N == 0) break;
            if(T!=0) output.println();
            T++;
            int a = 0;
            int b = 0;
            for(int i = 0; i<N; i++){
                StringTokenizer st = new StringTokenizer(input.readLine());
                String action = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if(action.equals("DROP")){
                    output.println("DROP 2 " + num);
                    b+=num;
                }
                else if(action.equals("TAKE")){
                    if(a>=num){
                        a-=num;
                        output.println("TAKE 1 " + num);
                    }
                    else{
                        if(a!=0){
                            output.println("TAKE 1 " + a);
                            num-=a;
                            a = 0;
                        }
                        output.println("MOVE 2->1 " + b);
                        output.println("TAKE 1 " + num);
                        a+=b-num;
                        b = 0;
                    }
                }
            }
        }
        output.close();
    }
}