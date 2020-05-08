import java.util.*;
import java.io.*;

public class touchdown{

    public static void main(String[] args) throws Exception{

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int n = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        int position = 0;
        int downs = 0;
        int counter = 0;
        boolean printed = false;

        for(int i = 0; i<n; i++){
            int play = Integer.parseInt(st.nextToken());
            counter+=play;
            downs+=1;
            if(counter>=10){
                counter = 0;
                downs = 0;
            }
            else if(downs%4 == 0){
                output.println("Nothing");
                printed = true;
                break;
            }
            
            position+=play;
            if(position>=80){
                output.println("Touchdown");
                printed = true;
                break;
            }
            else if(position<=-20){
                output.println("Safety");
                printed = true;
                break;
            }
        }

        if(!printed){
            output.println("Nothing");
        }

        output.close();

    }
}