import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Assignment1 {

    int jumps, counter;
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


        int initialStrength = arr[arr.length-1];
        any(arr, 1, initialStrength, 0);
    }

    NodeB lastResult;

    private void any(int[] arr, int lowStrength, int topStrength, int zeroCounter) {
//        System.out.println(counter);
        int mid = (int) (((lowStrength + topStrength) / 2) + 0.5);


        int initJumps = isPossible(arr, mid);
//        System.out.println("jumps: " + initJumps + ", top: " + topStrength + ", low: " + lowStrength + ", mid: " + mid);


        if (zeroCounter > 10) {
            System.out.println(lastResult.strength);
            return;
        }

        if (initJumps == jumps) {

            for (int i = mid; i > (mid-100); i--) {

                if (isPossible(arr, i) == jumps) {
                    if (isPossible(arr, i-1) != jumps) {
                        System.out.println(i);
                        return;
                    }
                }
            }

        } else if (initJumps > jumps) {
            lastResult = new NodeB(initJumps, mid);
            zeroCounter = 0;
            any(arr, mid+1, topStrength, zeroCounter);

        } else if ( initJumps == 0) {
            zeroCounter++;
            any(arr, mid+1, topStrength, zeroCounter);


        } else {
            lastResult = new NodeB(initJumps, mid);
            zeroCounter = 0;
            any(arr, lowStrength, mid-1, zeroCounter);

        }
    }


    private int isPossible(int[] arr, int strength) {
//        int heightAndStrength = arr[0] + strength;
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

                } else {

                    lastNode = new NodeA(j+1, hj);
                    i = lastNode.index;
                    hi = lastNode.height;
                    jumpCounter++;
                }



/*                if (j == arr.length-1) {
                    lastNode = new A(j+1, hj);
                    jumpCounter++;

                } else if ( !(i + strength >= j+2) || !(hi+strength >= arr[j+1])) {

                    lastNode = new A(j+1, hj);
                    jumpCounter++;

                }*/

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
    int jumps, strength;
    public NodeB(int jumps, int strength) {
        this.jumps = jumps;
        this.strength = strength;
    }
}



/*
else if ( !(i + strength >= j+2) || !(hi + strength >= arr[j+1]) ) {

        last = new A(j+1, hj);
        i = last.index;
        hi = last.height;
        jumpCounter++;
        }*/
