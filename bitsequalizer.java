import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int i;
    String s;
    int c;
    public Node(int i, String s, int c){
        this.i = i;
        this.s = s;
        this.c = c;
    }
    public int compareTo(Node n){
        return Integer.compare(this.c, n.c);
    }
}

public class bitsequalizer {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int T = Integer.parseInt(input.readLine());
        for(int t = 1; t<=T; t++){
            output.print("Case " + t + ": ");
            String a = input.readLine();
            String b = input.readLine();
            if(a.length()!=b.length()){
                output.println(-1);
                continue;
            }
            int a1 = 0;
            int b1 = 0;
            int aq = 0;
            for(int i = 0; i<a.length(); i++){
                if(a.charAt(i) == '1') a1++;
                else if(a.charAt(i) == '?') aq++;
                if(b.charAt(i) == '1') b1++;
            }
            if(a1>b1){
                output.println(-1);
                continue;
            }
            if(a1 == b1){   //take away 1s that don't need to swap, then convert ?s to 0s
                for(int i = 0; i<a.length(); i++){
                    if(a.charAt(i) == 1 && b.charAt(i) == 1) a1--;
                }
                int count = a1 + aq;
                output.println(count);
                continue;
            }
            else if(a1 + aq == b1){     //convert ?s to 1s, swap necessary 1s
                int count = aq;
                for(int i = 0; i<a.length(); i++){
                    if((a.charAt(i) == '1' || a.charAt(i) == '?') && b.charAt(i)!= '1') count++;
                }
                output.println(count);
                continue;
            }
            else if(a1 + aq<b1){    //convert optimal 0s and ?s to 1s, convert remaining ?s to 0s, swap remaining original 1s
                int count = 0;
                StringBuilder sb = new StringBuilder(a);
                int rem1 = b1 - a1;
                int good1 = 0;
                for(int i = 0; i<a.length(); i++){
                    if(rem1 > 0 && b.charAt(i) == '1' && sb.charAt(i) != '1'){
                        if(sb.charAt(i) == '?') aq--;
                        sb.setCharAt(i, '1');
                        count++;
                        rem1--;
                    }
                    else if(b.charAt(i) == '1' && sb.charAt(i) == '1') good1++;
                }
                count+=aq;
                for(int i = 0; i<a.length()l i++){
                    if(b.charAt(i) == '1' && sb.charAt(i)!= '1') count++;
                }
                
                output.println(count);
                continue;
                
            }
            else{   //a1+aq>b1      convert optimal ?s to 1s, then nonoptimal ?s, then ?s to 0s, swap the rest
                int count = 0;
                int convq = 0;
                int rem1 = b1-a1;
                StringBuilder sb = new StringBuilder(a);
                for(int i = 0; i<a.length(); i++){
                    if(b.charAt(i) == '1'){
                        if(sb.charAt(i) == '?' && rem1>0){
                            sb.setCharAt(i, '1');
                            convq++;
                            count++;
                            rem1--;
                        }
                    }
                }
                int good1 = 0;
                for(int i = 0; i<a.length(); i++){
                    if(sb.charAt(i) == '?' && rem1>0){
                        sb.setCharAt(i, '1');
                        count++;
                    }
                    else if(sb.charAt(i) == '?'){
                        sb.setCharAt(i, '0');
                        count++;
                    }
                }
                for(int i = 0; i<a.length(); i++){
                    if(b.charAt(i) == '1' && sb.charAt(i) != '1') count++;
                }
                output.println(count);
                continue;
            }
           
        }
        output.close();
    }
}