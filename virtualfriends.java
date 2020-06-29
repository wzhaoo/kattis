import java.util.*;
import java.io.*;

public class virtualfriends {
    public static int[] parent;
    public static HashMap<String, Integer> map;
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int T = Integer.parseInt(input.readLine());
        for(int t = 0; t<T; t++){
            int N = Integer.parseInt(input.readLine());
            int index = 0;
            map = new HashMap<String, Integer>();
            parent = new int[200000];
            Arrays.fill(parent, -1);
            for(int n = 0; n<N; n++){
                StringTokenizer st= new StringTokenizer(input.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                if(!map.containsKey(a)) map.put(a, index++);
                if(!map.containsKey(b)) map.put(b, index++);
                int i = union(a, b);
                output.println(i);
            }
        }
        output.close();
    }
    public static int find(int index){
        if(parent[index]<0) return index;
        return find(parent[index]);
    }
    public static int union(String a, String b){
        int i = find(map.get(a));
        int j = find(map.get(b));
        if(i == j) return Math.abs(parent[i]);
        if(parent[i]<=parent[j]){
            parent[i]+=parent[j];
            parent[j] = i;
            return Math.abs(parent[i]);
        }
        else{
            parent[j]+=parent[i];
            parent[i] = j;
            return Math.abs(parent[j]);
        }
    }
}