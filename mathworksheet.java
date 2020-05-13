import java.util.*;
import java.io.*;

public class mathworksheet {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        String line;
        int T = 0;
        while((line = input.readLine())!=null){
            int N = Integer.parseInt(line);
            if(N == 0) break;
            if(T != 0){
                output.println();
            }
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            int maxLength = 0;
            for(int n = 0; n<N; n++){
                StringTokenizer st = new StringTokenizer(input.readLine());
                int A = Integer.parseInt(st.nextToken());
                String s = st.nextToken();
                int a = Integer.parseInt(st.nextToken());
                int B = 0;
                if(s.equals("*")) B = A * a;
                else if(s.equals("+")) B = A + a;
                else B = A - a;
                if(Integer.toString(B).length()>maxLength) maxLength = Integer.toString(B).length();
                numbers.add(B);
            }

            String s = String.format("%"+maxLength+"s",numbers.get(0));
            for(int i = 1; i < numbers.size(); i++){
                if((s + " " + String.format("%"+maxLength+"s",numbers.get(i))).length()>50){
                    output.println(s);
                    s = String.format("%"+maxLength+"s",numbers.get(i));
                }
                else s += " " + String.format("%"+maxLength+"s",numbers.get(i));
            }
            if(line.length()>0) output.println(s);
            /*
            int spaces = 0;
            boolean sp = false;
            for(int i = 0; i<N; i++){
                if(!sp && i!=0){
                    spaces = 0;
                    output.println();
                }
                int a = numbers.get(i);
                int len = Integer.toString(a).length();
                String x = "";
                for(int j = 0; j<maxLength-len; j++) s+=" ";
                if(spaces+maxLength<=50) {
                    output.print(s + Integer.toString(a));
                    spaces+=maxLength;
                    if(spaces+maxLength+1<=50 && i!=N-1){
                        output.print(" ");
                        spaces++;
                        sp = true;
                    }
                    else sp = false;
                }
                
            }*/
            T++;
        }
        output.close();
    }
}