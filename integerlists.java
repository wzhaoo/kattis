import java.util.*;
import java.io.*;

public class integerlists {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int T = Integer.parseInt(input.readLine());
        for(int t = 0; t<T; t++){
            String line = input.readLine();
            int D = 0;
            for(int i = 0; i<line.length(); i++){
                if(line.charAt(i) == 'D') D++;
            }
            int N = Integer.parseInt(input.readLine());
            if(D>N){
                output.println("error");
                input.readLine();
                continue;
            }
            String s = input.readLine();
            StringTokenizer st = new StringTokenizer(s.substring(1, s.length()-1), ",");
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            for(int n = 0; n<N; n++) numbers.add(Integer.parseInt(st.nextToken()));
            boolean forwards = true;
            int start = 0;
            int end = numbers.size();
            for(int i = 0; i<line.length(); i++){
                if(line.charAt(i) == 'R') forwards = !forwards;
                else{
                    if(forwards) start++;
                    else end--;
                }
            }
            output.print("[");
            if(forwards){
                for(int i = start; i<end; i++){
                    output.print(numbers.get(i));
                    if(i!=end-1) output.print(",");
                }
            }   
            else{
                for(int i = end-1; i>=start; i--){
                    output.print(numbers.get(i));
                    if(i!=start) output.print(",");
                }
            }
            output.println("]");
        }
        output.close();
    }
}