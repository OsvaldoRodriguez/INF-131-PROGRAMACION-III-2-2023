import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Grafos {
    
    // matriz de adyacencia
    static int G[][] = new int [1000][1000]; 
    //static Vector<Integer> [] ListaAdj = new Vector[1000]; 
    
    static ArrayList<Integer> [] ListaAdj = new ArrayList[1000]; 
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        // TODO code application logic here
        // cantidad de nodos del grafo
        int n = in.nextInt();
        // la cantidad de aristas 
        int m = in.nextInt();
//        matriz_adyacencia(n, m);
        
//        lista_adyacencia(n, m);
        convertir_lista_matriz(n, m);
    }
    
    public static void convertir_lista_matriz(int n, int m){
        for(int i = 1; i <= n; i++){
            int len = in.nextInt();
            for(int j = 0; j < len; j++){
                int v = in.nextInt();
                G[i][v] = 1;
            }
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++)
                System.out.print(G[i][j] + " ");
            System.out.println();      
        }
    }
    
    public static void matriz_adyacencia(int n, int m){
        for(int i = 0; i < m; i++){
            int u = in.nextInt();
            int v = in.nextInt();
            G[u][v] = 1; // hay una arista de u a v
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++)
                System.out.print(G[i][j] + " ");
            System.out.println();      
        }
        
        
    }
    
    public static void lista_adyacencia(int n, int m){
        
        for(int i = 1; i <= n; i++){
            // importante
            ListaAdj[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < m; i++){
            int u = in.nextInt();
            int v = in.nextInt();
            ListaAdj[u].add(v);
        }
        
        for(int i = 1; i <= n; i++){
            if(!ListaAdj[i].isEmpty()){
                
                System.out.print(i + " -> ");
                for(int v : ListaAdj[i]){
                    System.out.print(v + ",");
                }
                System.out.println();
            }
        }
        
    }
}
