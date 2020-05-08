import java.util.*;
import java.io.*;
import java.math.*;

public class addingwords{
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        Map<String, Integer> definitions = new HashMap<String, Integer>();
        Map<Integer, String> reverse = new HashMap<Integer, String>();
        String line;
        String sub;
        while((line = input.readLine()) != null){
            output.println(line);
            StringTokenizer st = new StringTokenizer(line);
            sub = st.nextToken();

            if(sub == "def"){
                String a = st.nextToken();
                int b = Integer.parseInt(st.nextToken());
                definitions.put(a, b);
                reverse.put(b, a);
            }
            else if(sub == "calc"){
                ArrayList<Integer> arr = new ArrayList<Integer>();
                boolean unknown = false; //true for +, false for -
                int sum = definitions.get(st.nextToken());
                while(st.hasMoreTokens()){
                    String a = st.nextToken();
                    if(a == "=") break;
                    String b = st.nextToken();
                    try{
                        sum+=Integer.parseInt(a + "1")*definitions.get(b);
                    }
                    catch(Exception e){
                        unknown = true;
                    }
                    output.print(a + " " + b + " ");
                }
                if(unknown) output.println("= unknown");
                else output.println("= " + reverse.get(sum));

            }
            else{
                definitions.clear();
                reverse.clear();
            }
            output.close();
        }
    }
}