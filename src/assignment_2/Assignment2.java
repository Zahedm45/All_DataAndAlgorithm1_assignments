package assignment_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Assignment2 {


    public static void main(String[] args) throws IOException {
        String[] arr = new Assignment2().run();
        LinkedList linkedList = new LinkedList();

        for (String s : arr) {
            String[] command = s.split(" ");

            switch (command[0]) {
                case "R" -> {
                    linkedList.addRightNode(command[1]);
                }
                case "L" -> {
                    linkedList.addLeftNode(command[1]);
                }
                case "E" -> {
                    System.out.println(linkedList.extractMidNode().value);

                }

            }
        }

    }


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
