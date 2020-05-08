import java.util.*; 
public class mathhomework{
        
    public static void main(String[] args) throws Exception{
        
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int legs = Integer.parseInt(st.nextToken());
        boolean printed = false;
        
        for(int i = 0; i<=legs; i++){
            for(int j = 0; j<=legs; j++){
                for(int k = 0; k<=legs; k++){
                    if(i*a + j*b + k*c == legs){
                        System.out.println(i + " " + j + " " + k);
                        printed = true;
                    }
                }
            }
        }
        if(!printed) System.out.println("impossible");
        
    }
    
}
