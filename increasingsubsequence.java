import java.util.*;
import java.io.*;

public class increasingsubsequence {
    public static ArrayList<Integer> numbers = new ArrayList<Integer>();
    public static ArrayList<String> ans = new ArrayList<String>();
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        String line;
        while((line = input.readLine()) != null){
            if(line.equals("0")) break;
            StringTokenizer st = new StringTokenizer(line);
            int N = Integer.parseInt(st.nextToken());
            for(int n = 0; n<N; n++){
                numbers.add(Integer.parseInt(st.nextToken()));
                ans.add("");
            }
            int max = 0;
            String s = "";
            for(int i = 0; i<N; i++){
                String sub = sequenceHelper(i);
                if(sub.length()>s.length()){
                    s = sub;
                    st = new StringTokenizer(s);
                    max = st.countTokens();
                }
                else if(sub.split(" ").length == s.split(" ").length){
                    String[] a = sub.split(" ");
                    String[] b = s.split(" ");
                    for(int j = 0; j<a.length; j++){
                        int A = Integer.parseInt(a[j]);
                        int B = Integer.parseInt(b[j]);
                        if(A == B) continue;
                        else if(A<B){
                            s = sub;
                            break;
                        }
                        else break;
                    }
                }
            }
            output.println(max + " " + s);
            numbers.clear();
            ans.clear();
        }
        output.close();
    }
    public static String sequenceHelper(int index){
        if(index>=numbers.size()) return "";
        else if(ans.get(index).length()!=0) return ans.get(index);
        String ret = "";
        int maxLength = 0;
        for(int i = index+ 1; i<numbers.size(); i++){
            if(numbers.get(i)>numbers.get(index)){
                String sub = sequenceHelper(i);
                if(sub.split(" ").length>maxLength){
                    maxLength = sub.split(" ").length;
                    ret = sub;
                }
                else if(sub.split(" ").length == ret.split(" ").length){
                    String[] a = sub.split(" ");
                    String[] b = ret.split(" ");
                    for(int j = 0; j<a.length; j++){
                        int A = Integer.parseInt(a[j]);
                        int B = Integer.parseInt(b[j]);
                        if(A == B) continue;
                        else if(A<B){
                            ret = sub;
                            break;
                        }
                        else break;
                    }
                }
            }
            
        }
        ans.set(index, numbers.get(index) + " " + ret);
        return numbers.get(index) + " " + ret;
    }
}