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




        int initialStrength = arr[arr.length-1];
        any(arr, initialStrength);
    }

    private void any(int[] arr, int initialStrength) {



        for (int i = initialStrength; i > 0; i--) {

            int initJumps = isPossible(arr, i);
            if (initJumps == jumps) {
                System.out.println(i);
                return;
            }
        }


/*        if (initJumps == jumps) {
            System.out.println(initialStrength);
            return;

        } else if (initJumps < jumps) {
            initialStrength = initialStrength / 2;
            any(arr, initialStrength);

        } else {
            initialStrength = initialStrength + (initialStrength / 2);
            any(arr, initialStrength);
        }*/


    }

    private int isPossible(int[] arr, int strength) {
        int heightAndStrength = arr[0] + strength;
        int jumps = 0;

        for (int i = 1; i < arr.length; i++) {
            //int currValue = arr[i];
            if ( (heightAndStrength < arr[i] || i == arr.length -1) && ((i+strength) >= arr[i]) ) {
                heightAndStrength = arr[i-1] + strength;
                jumps++;

            }

            /*else if (i == arr.length -1) {
                heightAndStrength = arr[i-1] + strength;
                jumps++;
            }*/
        }

        return jumps;
    }

}
