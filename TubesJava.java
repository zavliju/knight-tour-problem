/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesjava;

import java.util.Scanner;

/**
 *
 * @author Zavli J
 */
public class TubesJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        int N;
        int pil = 1;
        while(pil == 1){
            System.out.print("Masukkan ukuran chess board: ");
            N = s.nextInt();
            if(N <= 0) System.out.println("Ukuran Chessboard harus positif!");
            else if(N > 8) System.out.println("Ukuran Chessboard maksimal 8x8!");
            else{
                KnightTour kt = new KnightTour(N);
                kt.solveKT();
                System.out.print("Coba lagi? [1/0]: ");
                pil = s.nextInt();
            }
        }
        System.out.println("Exit..");
    }
    
}
