package tubesjava;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Zavli J
 */
public class KnightTour {
    private static int N;

    public KnightTour(int N) {
        this.N = N;
    }

    public int getN() {
        return N;
    }

    public void setN(int N) {
        this.N = N;
    }
 
    //fungsi untuk cek bahwa x dan y adalah index yang valid untuk chessboard N*N
    static boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && x < N && y >= 0 &&
                y < N && sol[x][y] == -1);
    }
 
    //fungsi untuk cetak solusi matrix sol[N][N]
    static void printSolution(int sol[][]) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }
 
    //fungsi untuk menyelesaikan Knight Tour
    //menggunakan fungsi solveKTUtil()
    //return nilai false jika tidak ada solusi yang ditemukan
    //solusi yang ada bisa saja lebih dari satu
    //fungsi ini mencetak solusi yang paling feasible
    static boolean solveKT() {
        int sol[][] = new int[N][N];
 
        //inisialisasi matrix solusi dengan nilai -1
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                sol[x][y] = -1;
 
        //xMove[] dan yMove[] mendefinisikan gerak dari Knight (Kuda)
        //xMove[] adalah gerak lanjutan dari koordinat x
        //yMove[] adalah gerak lanjutan dari koordinat y
        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};
        
        //posisi awal kuda ditaruh pada matrix[0][0]
        sol[0][0] = 0;
 
        //mulai tour dari koordinat 0,0 dan jelajahi chessboard menggunakan fungsi solveKTUtil()
        if (!solveKTUtil(0, 0, 1, sol, xMove, yMove)) {
            System.out.println("Solusi tidak ditemukan!");
            return false;
        } else
            printSolution(sol);
        return true;
    }
 
    //fungsi rekursif untuk menyelesaikan masalah Knight Tour
    static boolean solveKTUtil(int x, int y, int movei,
                               int sol[][], int xMove[],
                               int yMove[]) {
        int k, next_x, next_y;
        if (movei == N * N)
            return true;
 
        //coba semua gerak lanjutan dari current coordinate x,y
        for (k = 0; k < N; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if (isSafe(next_x, next_y, sol)) {
                sol[next_x][next_y] = movei;
                if (solveKTUtil(next_x, next_y, movei + 1,
                                sol, xMove, yMove)){
                    return true;
                }
                else{
                    sol[next_x][next_y] = -1;// backtracking
                }
            }
        }
 
        return false;
    }
}
