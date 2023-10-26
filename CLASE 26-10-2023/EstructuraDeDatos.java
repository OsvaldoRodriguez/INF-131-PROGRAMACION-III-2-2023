import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Comparador implements Comparator<Integer> {
	@Override
	public int compare(Integer a, Integer b) {
		// 0 si son iguales
		// -1 si a es menor a b
		// 1 si a es mayor a b
		int suma = Integer.compare(suma(a), suma(b));
		if(suma == 0) {
			return Integer.compare(a, b);
		}
		return suma;	
	}
	
	public int suma(int a) {
		int sum = 0;
		while(a > 0) {
			sum += a % 10;
			a /= 10;
		}
		return sum;
	}
}

public class Main {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ListasEnlazadas();
//		solucionBancoVitalicio();
//		solucionColeccionNumeros();
//		solucionAgregar();
		sobrecargandoComparador();
		
	}
	
	public static void sobrecargandoComparador() {
		PriorityQueue<Integer> q = new PriorityQueue<>(new Comparador());
		int n = in.nextInt();
		while(n-- > 0) {
			int y = in.nextInt();
			q.offer(y);
		}
		
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
	}
	
	
	public static void solucionAgregar() {
		while(in.hasNext()) {
			// min heap (ordena crecientemente)
			PriorityQueue<Long> q = new PriorityQueue<>();
			int n = in.nextInt();
			if(n == 0)
				break;
			while(n-- > 0) {
				long y = in.nextLong();
				q.offer(y);
			}
			
			long ans_total = 0;
			while(q.size() >= 2) {
				long min1 = q.poll();
				long min2 = q.poll();
				long suma = min1 + min2;
				ans_total += suma;
				q.offer(suma);
			}
			System.out.println(ans_total);
			
		}
	}
	public static void solucionColeccionNumeros() {
//		
//				Guardar    MostrarGrande		Eliminar
//		LiskedList      	 	O(1)	        O(n)		  	O(n)
//		Stack					O(1)			O(n)		  	O(n)
//		Queue 					O(1)			O(n)			O(n)
//		PriorityQueue 			O(log n)		O(1)			O(log n)
//		
//		MinHeap (min) -> sobrecargar el operador
//		max => guardar los numeros en negativo
//		
//		
//		
//		Q <= 10^5
//		
//		* Mostrar
//		* Eliminar
//		* Guardar
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		while(in.hasNext()) {
			char op = in.next().charAt(0);
			if(op == 'S') {
				int x = in.nextInt();
				q.offer(-x); // log(n)
			}else if(op == 'A') {
				if(q.size() > 0) {
					int x = -q.peek(); // O(1)
					System.out.println(x);
				}else{
					System.out.println("Error");
				}
			}else if(op == 'R') {
				if(q.size() > 0)  // O(1)
					q.poll();
				else{
					System.out.println("Error");
				}
			}else if(op == 'I') {
				if(q.size() > 0) {
					int inc = in.nextInt();
					int valor = -q.poll();  // O(log n)
					valor += inc;
					q.offer(-valor);
				}else {
					System.out.println("Error");
				}
			}else if(op == 'D') {
				if(q.size() > 0) {
					int dec = in.nextInt();
					int valor = -q.poll(); // O(log n)
					valor -= dec;
					q.offer(-valor);
				}else
					System.out.println("Error");
			}else if(op == 'T'){
				break;
			}
		}
	}
	
	public static void solucionBancoVitalicio() {
		int n, m, p;
		while(in.hasNext()) {
			n = in.nextInt();
			m = in.nextInt();
			p = in.nextInt();
			int acaba = 0;
			for(int i = 0; i < n; i++) {
				int tiempo = in.nextInt();
				char prioridad = in.next().charAt(0);
				int mx = Math.max(acaba, tiempo);
				if(mx + p <= m) {
					System.out.println(mx + p);
					acaba = mx + p;
				}else {
					System.out.println("Mil disculpas, regrese mañana");
				}
				
			}
		}
	}
	public static void ListasEnlazadas() {
		LinkedList<Integer> A = new LinkedList<>();
		LinkedList<Integer> B = new LinkedList<>();
		
		int n = in.nextInt();
		for(int i = 0; i < n; i++) {
			int y = in.nextInt();
			A.add(y);
		}
		int m = in.nextInt();
		for(int i = 0; i < m; i++) {
			int y = in.nextInt();
			B.add(y);
		}
		
		ListIterator<Integer> it = A.listIterator();
		while(it.hasNext()) {
			Integer elem = it.next();
//			System.out.print(elem + ", ");
			ListIterator<Integer> it2 = B.listIterator();
			while(it2.hasNext()) {
				Integer elem2 = it2.next();
				System.out.println("L1 " + elem + ", L2 " + elem2);
			}
			System.out.println();
		}
		System.out.println();
	}

}
