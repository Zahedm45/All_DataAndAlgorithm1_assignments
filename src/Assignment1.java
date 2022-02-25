import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.StringTokenizer;

public class Assignment1 {


    public static void main(String[] args) throws IOException {
        new Assignment1().run();
    }


    private void run() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] str = in.readLine().split(" ");



        int n = Integer.parseInt(str[0]);
        int strength = Integer.parseInt(str[1]);


        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(in.readLine());




        for (int i = 0; i < n; i++) {

            String s = st.nextToken();
            System.out.println(s + " and " + Integer.parseInt(s));
            a[i] = Integer.parseInt(s);
        }


/*        for (int i : a) {
            System.out.println(i);
        }*/



/*        int heightAndStrength = a[0] + strength;
        int counter = 0;


        for (int i = 1; i < a.length-1; i++) {

            if (heightAndStrength < i) {
                heightAndStrength = a[i-1] + strength;
                counter++;
            }
        }


        System.out.println(counter);*/
    }

}
