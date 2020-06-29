import java.util.*;
import java.io.*;

public class whatdoesthefoxsay {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int T = Integer.parseInt(input.readLine());
        for(int t = 0; t<T; t++){
            String[] str = input.readLine().split(" ");
            String line;
            while(true){
                line = input.readLine();
                if(line.equals("what does the fox say?")){
                    for(String s: str) {
                        if(s.length()>0) output.print(s + " ");
                    }
                    break;
                }
                else{
                    String[] sub = line.split(" ");
                    String s = sub[2];
                    for(int i = 0; i<str.length; i++){
                        if(str[i].equals(s)){
                            str[i] = "";
                        }
                    }
                }
            }
        }
        output.close();
    }
}