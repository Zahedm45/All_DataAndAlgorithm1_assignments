package assignment_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Assignment2 {



    public static void main(String[] args) throws IOException {
        String[] arr = new Assignment2().run();
        LinkedList linkedList = new LinkedList();

        for (String s : arr) {
            String[] command = s.split(" ");

            switch (command[0]) {
                case "R" -> {
                    //int value = Integer.parseInt(command[1]);
                    linkedList.addRightNode(command[1]);
                }
                case "L" -> {
                    //int value = Integer.parseInt(command[1]);
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

        LinkedList linkedList = new LinkedList();

        int n = Integer.parseInt(input.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < 1000; i++) {
            //arr[i] = input.readLine();
            String[] command = input.readLine().split(" ");

            switch (command[0]) {
                case "R" -> {
                    //int value = Integer.parseInt(command[1]);
                    linkedList.addRightNode(command[1]);
                }
                case "L" -> {
                    //int value = Integer.parseInt(command[1]);
                    linkedList.addLeftNode(command[1]);
                }
                case "E" -> {
                    System.out.println(linkedList.extractMidNode().value);

                }

                case "F" -> {
                    linkedList.pritNode();

                }

            }


        }
        return arr;
    }


}
