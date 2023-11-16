
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0){
            int n = in.nextInt();
            Queue<Integer> q = new LinkedList <Integer>();
            Queue<Integer> descartados = new LinkedList <Integer>();
            
            for(int i = 1; i <= n; i++){
                q.add(i);
            }
            
            while(q.size() > 1){
                int des = q.poll();
                descartados.add(des);
                int sig = q.poll();
                q.add(sig);
            }
            
            System.out.print("Cartas desechadas:");
            while(descartados.size() > 0){
                int elem = descartados.poll();
                System.out.print(" " + elem);
            }
            
            System.out.println("\nCarta sobrante: " + q.poll());
        }
    }
    
}
