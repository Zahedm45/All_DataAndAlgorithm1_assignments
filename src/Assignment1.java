import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.constant.Constable;
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
        any(arr, 1, initialStrength);
    }


    private void any(int[] arr, int lowStrength, int topStrength) {
        counter++;
//        System.out.println(counter);
        int mid = (lowStrength + topStrength) / 2;


        int initJumps = isPossible(arr, mid);

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
            any(arr, mid+1, topStrength);

        } else if ( initJumps == 0) {
            any(arr, mid+1, topStrength);


        } else {
            any(arr, lowStrength, mid-1);

        }
    }


    private int isPossible(int[] arr, int strength) {
//        int heightAndStrength = arr[0] + strength;
        A last = new A(1, arr[0]);
        int jumpCounter = 0;

        for (int j = 1; j < arr.length; j++) {

            int i = last.index;
            int hi = last.height;
            int hj = arr[j];


            if ( (i + strength >= j+1) && (hi+strength >= hj)) {

                if (j == arr.length-1) {
                    last = new A(j+1, hj);
                    jumpCounter++;

                } else if ( !(i + strength >= j+2) || !(hi+strength >= arr[j+1])) {

                    last = new A(j+1, hj);
                    jumpCounter++;

                }

            } else {
                return 0;
            }
        }

        return jumpCounter;
    }
}


class A {
    int index;
    int height;
    public A(int index, int height) {
        this.index = index;
        this.height = height;
    }
}
