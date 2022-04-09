package assignment_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PrisonWalls {

    private int nSize, mSize;

    private ArrayList<Integer> counter = new ArrayList<>();
    private int[][] matrix;
    private Graph graph;


    public static void main(String[] args) throws IOException {
      PrisonWalls prisonWalls = new PrisonWalls();
      prisonWalls.run();
      //prisonWalls.printOut();

    }




    private void run() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        nSize = Integer.parseInt(input.readLine());
        mSize = Integer.parseInt(input.readLine());
        matrix = new int[mSize][nSize];



        int removals = Integer.parseInt(input.readLine());
        graph = new Graph(nSize * mSize);


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

            if (findPath()) {
                System.out.println("Path is found " + i+1);
                return;
            }


        }
    }



    private void removeWall(int n, int m) {
        matrix[m][n] = 1;
        if (!counter.contains(m)) {
            counter.add(m);
        }

        int vertexNum = (nSize*m) + n;

        if (m < mSize-1) {
            if (matrix[m+1][n] == 1) {
                int vNum2 = (nSize * (m+1)) + n;
                graph.addEdge(vertexNum, vNum2);
            }
        }

        if (m > 0) {
            if (matrix[m-1][n] == 1) {
                int vNum2 = (nSize * (m-1)) + n;
                graph.addEdge(vertexNum, vNum2);
            }
        }


        if (n < nSize-1) {
            if (matrix[m][n+1] == 1) {
                graph.addEdge(vertexNum, vertexNum+1);
            }
        }


        if (n > 0) {
            if (matrix[m][n-1] == 1) {
                graph.addEdge(vertexNum, vertexNum-1 );
            }
        }


    }


 /*   private boolean findPath() {
        if (counter.size() != mSize){
            return false;
        }

        return dsf(0, 0);

    }


    private boolean dsf(int m, int n) {
        boolean isPathFound = false;

        if (m >= mSize-1) {
            System.out.println("returned");
            return true;
        }

        if (matrix[m+1][n] == 1) {
           isPathFound = dsf(m+1, n);
        }

        if (!isPathFound && n < nSize-1) {
            if (matrix[m][n+1] == 1) {
               isPathFound = dsf(m, n+1);
            }
        }


        if (!isPathFound && n > 0) {
            if (matrix[m][n-1] == 1) {
               isPathFound = dsf(m, n-1);
            }
        }

        return isPathFound;
    }
*/

    private void printOut() {
        for (int i = 0; i < this.mSize; i++) {
            for (int j = 0; j < this.nSize; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
























class Graph{
    int vertex;
    ArrayList<ArrayList<Integer>> graph;

    public Graph(int vertex) {
        this.vertex = vertex;
        graph = new ArrayList<>();

        for (int i = 0; i < vertex; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void addEdge(int vertexA, int vertexB){
        graph.get(vertexA).add(vertexB);
        graph.get(vertexB).add(vertexA);
    }


    public void printGraph() {
        for (int i = 0; i < vertex; i++) {
            System.out.println("Vertex: " + i);

            for (int x : graph.get(i)) {
                System.out.print(" -> " + x);
            }
            System.out.println();
        }
    }
}
