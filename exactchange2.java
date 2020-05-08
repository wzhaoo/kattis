import java.io.*;
import java.util.*;

public class exactchange2{
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);

        int cases = Integer.parseInt(input.readLine());
        for(int z = 0; z<cases; z++){
            int total = Integer.parseInt(input.readLine());
            int N = Integer.parseInt(input.readLine());
            int[][] table = new int[N+1][total+1];
            int[][] valuetable = new int[N+1][total + 1];
            int[] values = new int[N];

            int sum = 0;
            for(int i = 0; i<N; i++){
                values[i] = Integer.parseInt(input.readLine());
                sum+=values[i];
            }
            int[] possibilities = new int[sum+1];
            Arrays.sort(values);

            ArrayList<Integer> previous = new ArrayList<Integer>();
            for(int i = 0; i<N; i++){
                int value = values[i];
                possibilities[value] = 1;
                HashSet<Integer> temp = new HashSet<Integer>();
                temp.add(value);
                for(int s: previous){
                    int newsum = value+s;
                    if(possibilities[newsum] == 0){
                        possibilities[newsum] = possibilities[s]+1;
                        temp.add(newsum);
                    }
                    else if(possibilities[newsum]> possibilities[s]+1){
                        possibilities[newsum] = possibilities[s] + 1;
                    }
                }
                for(int a: temp) previous.add(a);
            }

            for(int i = total; i<possibilities.length; i++){
                if(possibilities[i]!=0){
                    output.println(i+ " " + possibilities[i]);
                    break;
                }
            }

            /*for(int i = 0; i<N; i++){
                table[i][0] = 0;
                table[0][i] = 0;
                valuetable[i][0] = 0;
                valuetable[0][i] = 0;
                values[i] = Integer.parseInt(input.readLine());
            }
            
            int min = values[0];
            for(int i = 1; i<N; i++){
                for(int j = min; j<total+1; j+=min){
                    if(values[i]<=j){
                        if(table[i-1][j])
                        table[i][j] = Math.min(table[i-1][j], 1+table[i][j-values[i]]);
                        valuetable[i][j] = Math.max(valuetable[i-1][j], values[i]+valuetable[i][j-values[i]]);
                    }
                    else{
                        table[i][j] = table[i-1][j];
                        valuetable[i][j] = valuetable[i-1][j];
                    }
                }
            }
            int coins = table[N-1][total];
            int given = valuetable[N-1][total];
            if(given == total){
                output.print(given + " " + coins);
            }
            else{
                output.println(given+min + " " + coins);
            }
            */

        }
        output.flush();
        output.close();
    }
}