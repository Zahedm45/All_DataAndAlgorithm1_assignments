package assignment_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrisonWalls {





    private String[] run() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.readLine();
        }
        return arr;
    }

}
