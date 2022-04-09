package assignment_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PrisonWalls {

    private int nSize, mSize;

    //private ArrayList<Integer> counter;
    int counterSize;
    private boolean[][] matrix;
    private Graph graph;
    boolean isFirstDFS;
    boolean[] allM;

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
        matrix = new boolean[mSize][nSize];
        //counter = new ArrayList<>();
        allM = new boolean[mSize];



        int removals = Integer.parseInt(input.readLine());
        graph = new Graph(nSize * mSize);
        ArrayList<String> str = new ArrayList<>();

        for (int i = 0; i < removals; i++) {
            str.add(input.readLine());
        }

        frontLineVertices = nSize;
        backLineVertices = (nSize * (mSize - 1)) - 1;
        isFirstDFS = true;


        visitedVertices = new boolean[nSize*mSize];
        for (int i = 0; i < removals; i++) {
            String[] str2 = str.get(i).split(" ");
            int n = Integer.parseInt(str2[0]);
            int m = Integer.parseInt(str2[1]);

            if (removeWall(n, m)) {
                System.out.println(i+1);
                System.exit(0);
            }

/*            System.out.println();
            System.out.println("n: " + n + ", m: " + m);
            printOut();
            System.out.println();
            System.out.println("Graph");

            graph.printGraph();
            System.out.println();*/
/*            if (findPath()) {
                System.out.println(i+1);
                System.exit(0);
            }

            System.out.println();
            System.out.println();*/
        }
    }


    private boolean removeWall(int n, int m) {

        if (!allM[m]) {
            allM[m] = true;
            counterSize++;
        }


        int vertexNum = (nSize*m) + n;

        boolean linkFound = false;

        matrix[m][n] = true;
        if (n < nSize-1) {
            if (matrix[m][n + 1]) {
                graph.addEdge(vertexNum, vertexNum+1);
                if (visitedVertices[vertexNum+1]) {
                    linkFound = true;
                }
            }
        }


        if (n > 0) {
            if (matrix[m][n-1]) {
                graph.addEdge(vertexNum, vertexNum-1 );
                if (visitedVertices[vertexNum -1]) {
                    linkFound = true;
                }
            }
        }


        if (m > 0) {
            if (matrix[m-1][n]) {
                int vNum2 = (nSize * (m-1)) + n;
                graph.addEdge(vertexNum, vNum2);
                if (visitedVertices[vNum2]) {
                    linkFound = true;
                }
            }
        }

        if (m < mSize-1) {
            if (matrix[m+1][n]) {
                int vNum2 = (nSize * (m+1)) + n;
                graph.addEdge(vertexNum, vNum2);
                if (visitedVertices[vNum2]) {
                    linkFound = true;
                }

            }
        }


        if (counterSize >= mSize) {
            if (linkFound || isFirstDFS) {
                visitedVertices = new boolean[nSize*mSize];
                isFirstDFS = false;
                return findPath();
            }
        }



        return linkFound;
    }





    private boolean findPath() {

        for (int i = 0; i < frontLineVertices; i++) {
            if (dsf(i)) {
                return true;
            }
        }

        return false;
    }

    private boolean dsf(int vertex) {
        if (vertex > backLineVertices) {
            return true;
        }

        visitedVertices[vertex] = true;

        for (int v :graph.undirectedGraph.get(vertex)) {
            if (!visitedVertices[v]) {
                //System.out.println("visted: " + v);
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
