import java.util.*;
import java.io.*;

public class bijele{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int place = 0;
        int[] chess = {1, 1, 2, 2, 2, 8};
        while(sc.hasNextInt()){
            int pieces = sc.nextInt();
            System.out.print(chess[place] - pieces);
            System.out.print(" ");
            place++;
        }
    }
}
