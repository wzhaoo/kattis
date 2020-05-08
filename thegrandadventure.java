import java.util.*;
import java.io.*;

public class thegrandadventure {
    public static void main(String[] args) throws Exception {
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(in.readLine());
        for(int i = 0; i<n; i++){
            boolean printed = false;
            Stack<Character> s = new Stack<Character>();
            String line = in.readLine();
            for(int c = 0; c < line.length(); c++){
                char sub = line.charAt(c);
                if(sub=='.') continue;
                if(sub == '$' || sub == '*' || sub == '|') s.push(sub);
                else{
                    if(s.isEmpty()){
                        printed = true;
                        break;
                    }
                    char str = s.pop();    
                    if(sub == 'b' && str!='$'){
                        printed = true;
                        break;
                    }
                    if(sub == 't' && str!= '|'){
                        printed = true;
                        break;
                    }
                    if(sub == 'j' && str!= '*'){
                        printed = true;
                        break;
                    }
                } 
            }
            if(!printed && s.isEmpty()) out.println("YES");
            else out.println("NO");
        }
        out.close();
    }
}