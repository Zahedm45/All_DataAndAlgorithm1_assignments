import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Assignment1 {

    int jumps;
    public static void main(String[] args) throws IOException {
        new Assignment1().run();
    }



    private void run() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] str = in.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        jumps = Integer.parseInt(str[1]);

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(in.readLine());


        for (int i = 0; i < n; i++) {
            String s = st.nextToken();
            arr[i] = Integer.parseInt(s);
        }

        // start with an initial(estimated) strength(S).
        int initialStrength = arr[arr.length-1];
        if (arr.length == 2) {
            int i = arr[1] - arr[0];
            if ( i == 0) {
                i = 1;
            }
            System.out.println(i);
        } else {

            NodeB sameMid = new NodeB(0, 0);
            findTheStrength(arr, 1, initialStrength, sameMid);
        }
    }



// a binary search is implemented in this methode
    private void findTheStrength(int[] arr, int lowStrength, int topStrength, NodeB sameResult) {
        int mid = (int) (((lowStrength + topStrength) / 2) + 0.5);


        int initJumps = getJumps(arr, mid);
//        System.out.println("jumps: " + initJumps + ", top: " + topStrength + ", low: " + lowStrength + ", mid: " + mid);

        if (initJumps == sameResult.lastMid) {
            sameResult.counter++;

            if (sameResult.counter > 9) {
                System.out.println(mid + 1);
                return;
            }
        } else {
            sameResult = new NodeB(0, initJumps);
        }

        if (initJumps == jumps) {
            printOutThePreciseStrength(arr, mid);

        } else if (initJumps > jumps) {
            findTheStrength(arr, mid+1, topStrength, sameResult);

        } else if ( initJumps == 0) {
            findTheStrength(arr, mid+1, topStrength, sameResult);

        } else {
            findTheStrength(arr, lowStrength, mid-1, sameResult);

        }
    }

    // just to check if the desired jump is achievable with less strength(S)
    private void printOutThePreciseStrength(int [] arr, int mid) {
        for (int i = mid; i > (mid-100); i--) {

            if (getJumps(arr, i) == jumps) {
                if (getJumps(arr, i-1) != jumps) {
                    System.out.println(i);
                    return;
                }
            }
        }
    }


    // A linear searching algorithm is implement to find the path with the given strength(S)
    private int getJumps(int[] arr, int strength) {
        int jumpCounter = 0;

        NodeA lastNode = new NodeA(1, arr[0]);
        int i = lastNode.index;
        int hi = lastNode.height;

        for (int j = 1; j < arr.length; j++) {

            int hj = arr[j];
            if ( ( i + strength >= j+1) && (hi+strength >= hj) ) {

                if (j == arr.length-1) {
                     jumpCounter++;
                     return jumpCounter;

                } else if ( ( i + strength >= j+2) && (hi+strength >= arr[j+1]) ) {
                    // do nothing...
                } else {
                    lastNode = new NodeA(j+1, hj);
                    i = lastNode.index;
                    hi = lastNode.height;
                    jumpCounter++;
                }

            } else {
                return 0;
            }
        }

        return 0;
    }
}


class NodeA {
    int index;
    int height;
    public NodeA(int index, int height) {
        this.index = index;
        this.height = height;
    }


}


class NodeB{
    int counter, lastMid;
    public NodeB(int counter, int lastMid) {
        this.counter = counter;
        this.lastMid = lastMid;
    }
}

