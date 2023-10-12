/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1830.interseccion_listas;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author AREA PROGRAMACION
 */
public class Interseccion_listas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        
        int casos = in.nextInt();
        in.nextLine();
        while(casos-- > 0){
            String v[] = in.nextLine().split(" ");
            String v2[] = in.nextLine().split(" ");
            int F[] = new int [1000];
            int F2[] = new int [1000];
            for(int i = 0; i < v.length; i++){
                int valor = Integer.parseInt(v[i]);
                F[valor] += 1;
            }
            
            for(int i = 0; i < v2.length; i++){
                int valor = Integer.parseInt(v2[i]);
                F2[valor] += 1;
            }
            
            System.out.print("[");
            int i = 0;
            while(i < 1000){
                if(F[i] > 0 && F2[i] > 0){
                    System.out.print(i);
                    break;
                }
                i++;
            }
            i++;
            while(i < 1000){
                if(F[i] > 0 && F2[i] > 0){
                    System.out.print(", " + i);
                }
                i++;
            }
            System.out.println("]");
            
            
            
            
            
        }
        
//        int b = in.nextInt();
//        System.out.println("entero " + b);
//        in.nextLine();
//        String a = in.nextLine();
//        System.out.println("cadena " + a);
    }
    
}
