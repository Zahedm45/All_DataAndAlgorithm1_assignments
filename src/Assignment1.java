import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Assignment1 {


    public static void main(String[] args) throws IOException {
        new Assignment1().run();
    }


    private void run() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] str = in.readLine().split(" ");



        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);


        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(in.readLine());

        System.out.println(n + " " + m);
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }


        for (int i : a) {
            System.out.println(i);
        }


    }

}
