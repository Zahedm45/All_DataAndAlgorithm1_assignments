package assignment_2;

import assignment_1.Assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Assignment2 {



    public static void main(String[] args) throws IOException {
        new Assignment2().run();


    }


    private void run() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));



        int n = Integer.parseInt(input.readLine());

        //String[] strArr = new String[n];
        LinkedList linkedList = new LinkedList();

        for (int i = 0; i < 1000; i++) {
            String[] line = input.readLine().split(" ");
            String operation = line[0];


            switch (operation) {
                case "R" -> {
                    int value = Integer.parseInt(line[1]);
                    linkedList.addRightNode(value);
                }
                case "L" -> {
                    int value = Integer.parseInt(line[1]);
                    linkedList.addLeftNode(value);
                }
                case "E" -> {
                    //Node node = linkedList.extractMidNode();
                    linkedList.pritNode();
                    linkedList.setMidNode();
                    linkedList.pritNode();

                }
            }
            //linkedList.pritNode();

        }
        //linkedList.pritNode();

    }

}
