import java.util.*;
import java.math.*;
import java.io.*;

public class goodmessages{

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);

        int shift = Integer.parseInt(input.readLine());
        String msg = input.readLine();
        int repetitions = Integer.parseInt(input.readLine());
        int borisCount = 0;

        for(int i = 0; i<repetitions; i++){
            msg = cipher(msg, shift);
            output.println(msg);
            int vowelCount = 0;
            int consCount = 0;
            for(int j = 0; j<msg.length(); j++){
                if(msg.charAt(j) == 'a' || msg.charAt(j) == 'e' || msg.charAt(j) == 'i' || msg.charAt(j) == 'o' || msg.charAt(j) == 'u' || msg.charAt(j) == 'y')
                    vowelCount++;
                else consCount++;
            }
            if(vowelCount*2<consCount) borisCount++;
        }
        output.println(borisCount + " " + (repetitions-borisCount));
        if(borisCount>repetitions-borisCount) output.println("Boris");
        else output.println("Colleague");

        output.close();

    }

    static String cipher(String message, int shift){
        String s = "";
        for(int i = 0; i<message.length(); i++){
            char c = (char)(message.charAt(i)+shift);
            if(c>'z') s+=(char)(c-26);
            else s+=c;
        }
        return s;
    }

}