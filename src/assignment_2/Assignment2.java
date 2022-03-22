package assignment_2;

import assignment_1.Assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Assignment2 {


    public static void main(String[] args) throws IOException {
        new Assignment1().run();
    }


    private void run() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] str = in.readLine().split(" ");

        int n = Integer.parseInt(str[0]);

    }

}
