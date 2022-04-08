package assignment_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PrisonWalls {

    private int nSize, mSize;

    private ArrayList<Integer> counter = new ArrayList<>();

    private int[][] matrix;


    public static void main(String[] args) throws IOException {
      PrisonWalls prisonWalls = new PrisonWalls();
      prisonWalls.run();
      //prisonWalls.printOut();
        System.out.println("hello");

    }




    private void run() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        nSize = Integer.parseInt(input.readLine());
        mSize = Integer.parseInt(input.readLine());
        matrix = new int[mSize][nSize];


        int removals = Integer.parseInt(input.readLine());

        for (int i = 0; i < removals; i++) {
            String[] str= input.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);


            removeWall(n, m);
            System.out.println();
            System.out.println("n: " + n + ", m: " + m);
            printOut();
            System.out.println();
            System.out.println();


        }
    }



    private void removeWall(int n, int m) {
        matrix[m][n] = 1;
        if (!counter.contains(m)) {
            counter.add(m);
        }
    }



    private void printOut() {
        for (int i = 0; i < this.mSize; i++) {
            for (int j = 0; j < this.nSize; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
