import java.util.*;
import java.io.*;

public class dyslectionary {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        String line;
        boolean fin = false;
        while((line = input.readLine()) != null){
            ArrayList<String> words = new ArrayList<String>();
            int max = 0;
            while(true){
                if(line == null){
                    fin = true;
                    break;
                } 
                else if(line.length() == 0){
                    break;
                }
                words.add(new StringBuilder(line).reverse().toString());
                if(line.length()>max) max = line.length();
                line = input.readLine();
            }
            Collections.sort(words);
            for(String word: words){
                for(int i = 0; i<max-word.length(); i++) output.print(" ");
                output.println(new StringBuilder(word).reverse().toString());
            }
            if(!fin) output.println();
        }
        output.close();
    }
}