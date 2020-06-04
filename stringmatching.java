import java.util.*;
import java.io.*;

public class stringmatching {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        String line;
        while((line = input.readLine()) != null && line.length()>0){
            String pattern = line;
            String text = input.readLine();
            int[] lps = new int[pattern.length()];
            makeLPS(pattern, pattern.length(), lps);
            int i = 0;
            int j = 0;
            while(i<text.length()){
                if(text.charAt(i) == pattern.charAt(j)){
                    i++;
                    j++;
                }
                if(j == pattern.length()){
                    output.print((i-j) + " ");
                    j = lps[j-1];
                }
                else if(i<text.length() && pattern.charAt(j) != text.charAt(i)){
                    if(j!=0) j = lps[j-1];
                    else i++;
                }
            }
            output.println();
        }
        output.close();
    }
    public static void makeLPS(String p, int N, int[] lps){
        int len = 0;
        int i = 1;
        while(i<N){
            if(p.charAt(i) == p.charAt(len)){
                lps[i++] = ++len;
            }
            else{
                if(len!=0) len = lps[len - 1];
                else lps[i++] = 0;
            }
        }
    }
}