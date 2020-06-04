import java.io.*;
import java.util.*;

public class quickbrownfox {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        String a = "abcdefghijklmnopqrstuvwxyz";
        int N = Integer.parseInt(input.readLine());
        ArrayList<Character> missing = new ArrayList<Character>();
        for (int i = 0; i < N; i++) {
            for (char c : a.toCharArray()) {
                missing.add(c);
            }
            String str = input.readLine();
            str = str.toLowerCase();
            for (int j = 0; j < str.length(); j++) {
                Character c = str.charAt(j);
                missing.remove(c);
            }
            if (missing.isEmpty()) {
                output.println("pangram");
            }
            else {
                output.print ("missing ");
                for (int j = 0; j < missing.size(); j++) {
                    output.print(missing.get(j));
                }
                output.println();
            }
            missing.clear();
        }
        output.close();
    }
}