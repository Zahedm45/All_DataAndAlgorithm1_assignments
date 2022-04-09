package assignment_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class PrisonWalls {

    private int nSize, mSize;

    private ArrayList<Integer> counter = new ArrayList<>();
    private int[][] matrix;
    private Graph graph;

    boolean[] visitedVertices;
    int backLineVertices, frontLineVertices;

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



            if (findPath()) {
                System.out.println();
                System.out.println("n: " + n + ", m: " + m);
                printOut();
                System.out.println();
                System.out.println("Graph");

                graph.printGraph();
                System.out.println();


                System.out.println(i+1);
                System.exit(0);
            }
        }






    }




    private boolean findPath() {
        if (counter.size() < mSize) {
            System.out.println("heeeellll");
            return false;
        }

        frontLineVertices = nSize;
        backLineVertices = (nSize * (mSize - 1)) - 1;

        visitedVertices = new boolean[nSize*mSize];
        for (int i = 0; i < frontLineVertices; i++) {
            if (dsf(i)) {
                return true;
            }
        }

        return false;
    }

    private boolean dsf(int vertex) {
        if (vertex > backLineVertices) {
            System.out.println("visited vertex return: " + vertex);
            return true;
        }

        visitedVertices[vertex] = true;
        System.out.println("visited vertex: " + vertex);

        for (int v :graph.undirectedGraph.get(vertex)) {
            if (!visitedVertices[v]) {
               if (dsf(v)) {
                   return true;
               }
            }
        }

        return false;
    }


    private void printOut() {
        for (int i = 0; i < this.mSize; i++) {
            for (int j = 0; j < this.nSize; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }





    private void removeWall(int n, int m) {
        matrix[m][n] = 1;
        if (!counter.contains(m)) {
            counter.add(m);
        }

        int vertexNum = (nSize*m) + n;



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

    }
}
























class Graph{
    int vertex;
    ArrayList<ArrayList<Integer>> undirectedGraph;

    public Graph(int vertex) {
        this.vertex = vertex;
        undirectedGraph = new ArrayList<>();

        for (int i = 0; i < vertex; i++) {
            undirectedGraph.add(new ArrayList<>());
        }
    }

    public void addEdge(int vertexA, int vertexB){
        undirectedGraph.get(vertexA).add(vertexB);
        undirectedGraph.get(vertexB).add(vertexA);
    }


    public void printGraph() {
        for (int i = 0; i < vertex; i++) {
            System.out.print("Vertex: " + i);

            for (int x : undirectedGraph.get(i)) {
                System.out.print(" -> " + x);
            }
            System.out.println();
        }
    }
}
