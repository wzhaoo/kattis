import java.util.*;
import java.io.*;
import java.math.*;

public class cold{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = 0;
        while(sc.hasNextInt()){
            if(sc.nextInt()<0){
                count++;
            }
        }
        System.out.println(count);
    }
}
