import java.util.*;
import java.io.*;

public class gamerank {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        String line = input.readLine();
        int consecutive = 0;
        int rank = 25;
        int stars = 0;
        for(int i = 0; i<line.length(); i++){
            if(line.charAt(i) == 'L'){
                if(rank<20 || (rank == 20 && stars!=0)) stars--;
                if(stars<0){
                    rank++;
                    stars = reqStars(rank) - 1;
                }
                consecutive = 0;
            }
            else{
                consecutive++;
                stars++;
                if(consecutive >= 3 && rank<=25 && rank>=6) stars++;
                if(stars>reqStars(rank)){
                    stars-=reqStars(rank);
                    rank--;
                }
            }
            if(rank == 0) break;
        }
        if(rank == 0) output.println("Legend");
        else output.println(rank);
        output.close();
    }
    public static int reqStars(int rank){
        if(rank<=25 && rank>=21) return 2;
        else if(rank<=20 && rank>=16) return 3;
        else if(rank<=15 && rank>=11) return 4;
        else return 5;
    }
}