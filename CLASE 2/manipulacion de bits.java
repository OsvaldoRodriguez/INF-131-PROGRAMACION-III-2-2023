import java.util.Scanner;
import java.util.Vector;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		
		
		
		
		
		while(in.hasNext()) {
			int y = in.nextInt();
			toBinary(y);
			System.out.println("verificando bit");
			
			int i = in.nextInt();
			System.out.println(check(y, i));
			int encendido = encender(y, i);
			System.out.println(encendido);
			toBinary(encendido);
			int apagado = apagar(y, i);
			System.out.println("despues de apagar " + apagado);
			toBinary(apagado);
			System.out.println("encender el bit menos significativo que este apagado");
			int res = encenderBitMenosSignificativo(y);
			System.out.println("despues de encender " + res);
			toBinary(res);
			int eficiente = solEficiente(y);
			System.out.println("despues de encender " + eficiente);
			toBinary(eficiente);
			
			int eficiente2 = solEfG2(y);
			System.out.println("despues de apagar un suffijo de unos " + eficiente2);
			toBinary(eficiente2);
			
			
		}
		
	}
	
	public static void toBinary(int x) {
		for(int i = 31; i >= 0; i--) {
			boolean a = ((1 << i) & x) != 0;
			if(a)
				System.out.print(1);
			else
				System.out.print(0);
		}
		System.out.println();
	}
	
	
	public static boolean check(int x, int i) {
		if((x & (1 << i)) != 0)
			return true;
		return false;
	}
	
	public static int encender(int x, int i) {
		return x | (1 << i);
	}
	
	public static int apagar(int x, int i) {
		return (x & ~(1 << i));
	}
	
	public static int cambiar(int x, int i) {
		return (x ^ (1 << i));
	}
	
	public static int cambiar_largo(int x, int i) {
		if(check(x, i)) 
			return apagar(x, i);
		return encender(x, i);
	}
	
	
	public static int encenderBitMenosSignificativo(int x) {
		for(int i = 0; i <= 31; i++) {
			if(check(x, i) == false) {
				return encender(x, i);
			}
		}
		return x;
	}
	
	public static int solEficiente(int x) {
		return x | (x + 1);
	}
	
	public static int solEfG2(int x) {
		return x & (x + 1);
	}
	
	public static int solLentoG2(int x) {
		for(int i = 0; i <= 31; i++) {
			if(check(x, i) == false) {
				for(int j = 0; j < i; j++) {
					x = apagar(x, i);
				}
				break;
			}
		}
		return x;
	}
}
