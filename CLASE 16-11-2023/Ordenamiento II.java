import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
 
 
public class Main {
 
    public static void main(String[] args) {
        // TODO code application logic here
        PriorityQueue<Estudiante> q = new PriorityQueue<>(new ComparadorEstudiante());
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            Estudiante x = new Estudiante(in.nextInt(), in.nextInt(), in.next(), in.next());
            q.add(x);
        }
         
        while(q.size() > 0){
            System.out.println(q.poll());
        }
        System.out.println();
         
    }
     
}
 
class Estudiante {
    int matricula;
    int ci;
    String ape;
    String nombre;
 
    public Estudiante(int matricula, int ci, String ape, String nombre) {
        this.matricula = matricula;
        this.ci = ci;
        this.ape = ape;
        this.nombre = nombre;
    }
     
    public void mostrar(){
        System.out.println(toString());
    }
    @Override
    public String toString() {
        return ci + " " + matricula + " " + ape + " " + nombre;
    }
     
     
     
     
     
     
}
 
class ComparadorEstudiante implements Comparator<Estudiante> {
    @Override
    public int compare(Estudiante a, Estudiante b){
//        Integer.compare(x, y)
        int comApe = a.ape.compareTo(b.ape);
        if(comApe == 0){
            int comNom = b.nombre.compareTo(a.nombre);
            if(comNom == 0){
                int comMat = Integer.compare(a.matricula, b.matricula);
                if(comMat == 0){
                    return Integer.compare(a.ci, b.ci);
                }
                return comMat;
            }
            return comNom;
        }
         
        return comApe;
    }
}
 
class ComparadorInt implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b){
        return Integer.compare(b, a);
    }
}
