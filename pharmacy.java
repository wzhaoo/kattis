import java.util.*;
import java.math.*;
import java.io.*;

public class pharmacy{
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int prescriptions = Integer.parseInt(st.nextToken());
        int numberOfTechnicians = Integer.parseInt(st.nextToken());
        int technicians = numberOfTechnicians;
        int remoteTime = 0;
        int storeTime = 0;
        int remotes = 0;
        int stores = 0;
        int lastTime = 1;

        for(int i = 0; i<prescriptions; i++){
            st = new StringTokenizer(input.readLine());
            int timePassed=(Integer.parseInt(st.nextToken())-lastTime)*numberOfTechnicians;
            technicians+= timePassed;
            if(technicians<=0){
                
            }
        }
    }
}