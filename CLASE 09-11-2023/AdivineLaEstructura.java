
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            Stack<Integer> pila = new Stack<Integer>();
            Queue<Integer> cola = new LinkedList<>();
            PriorityQueue<Integer> colap = new PriorityQueue<>();
            
            boolean flagCola = true;
            boolean flagPila = true;
            boolean flagHeap = true;
            while(n-- > 0){
                int ope = in.nextInt();
                int valor = in.nextInt();
                if(ope == 1){
                    pila.add(valor);
                    cola.add(valor);
                    colap.offer(-valor);
                }else{
                    // para la pila
                    if(!pila.empty()){
                        int elim = pila.pop();
                        if(elim != valor){
                            flagPila = false;
                        }
                    }
                    
                    // para la cola
                    if(cola.size() > 0){
                        int elim = cola.poll();
                        if(elim != valor){
                            flagCola = false;
                        }
                    }
                    
                    // para la cola de prioridad
                    if(colap.size() > 0){
                        int elim = -colap.poll();
                        if(elim != valor){
                            flagHeap = false;
                        }
                    }
                    
                    
                }
            }
            // AQUI YA SE HICIERON TODAS LAS OPERACIONES
            String ans = "";
            if(flagPila && !flagCola && !flagHeap)
                ans = "stack";
            else if(!flagPila && flagCola && !flagHeap)
                ans = "queue";
            else if(!flagPila && !flagCola && flagHeap)
                ans = "priority queue";
            else if(!flagPila && !flagCola && !flagHeap)
                ans = "impossible";
            else
                ans = "not sure";
            
            System.out.println(ans);
            
        }
    }
    
}
