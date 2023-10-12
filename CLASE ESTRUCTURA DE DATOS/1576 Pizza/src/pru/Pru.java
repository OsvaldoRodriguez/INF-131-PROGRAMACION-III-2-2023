/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pru;

import java.util.Scanner;

/**
 *
 * @author AREA PROGRAMACION
 */
public class Pru {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt(); // tamanio del array
            int A[] = new int [2 * n + 1];
            for(int i = 0; i < n; i++){
                A[i] = in.nextInt();
                A[n + i] = A[i];
            }
            int ans = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++){
                int s1 = 0;
                for(int j = 0; j < n; j++){
                    s1 += A[j + i];
                    int s2 = 360 - s1;
                    if(ans > Math.abs(s1 - s2))
                        ans = Math.abs(s1 - s2);
                }
            }
            
            System.out.println(ans);
        }
    }
    
}
