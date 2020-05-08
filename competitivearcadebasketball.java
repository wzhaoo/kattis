import java.util.*;
import java.math.*;
import java.io.*;

public class competitivearcadebasketball{
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(in.readLine());

        int participants = Integer.parseInt(st.nextToken());
        int pointsNeeded = Integer.parseInt(st.nextToken());
        int numLines = Integer.parseInt(st.nextToken());
        ArrayList<String> winners = new ArrayList<String>();
        boolean printed = false;

        Map<String,Integer> m = new HashMap<String,Integer>();
        for(int i = 0; i < participants; i++){
            m.put(in.readLine(), 0);
        }
        for(int i = 0; i < numLines; i++){
            StringTokenizer st2 = new StringTokenizer(in.readLine());
            String sub = st2.nextToken();
            m.put(sub, m.get(sub)+Integer.parseInt(st2.nextToken()));
            if(m.get(sub)>=pointsNeeded && !winners.contains(sub)) {
                winners.add(sub);
            }
        }
        for(String s: winners){
            out.println(s+" wins!");
        }
        
        if(winners.isEmpty()) out.println("No winner!");
        out.close();
    }
}
