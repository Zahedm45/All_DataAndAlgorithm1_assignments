package assignment_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PrisonWalls {

    private int x, y;

    private Wall removedWalls;


    public static void main(String[] args) throws IOException {
        //String[] arr = new PrisonWalls().run();

    }




    private ArrayList<Sub> run() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        x = Integer.parseInt(input.readLine());
        y = Integer.parseInt(input.readLine());

        int n = Integer.parseInt(input.readLine());


        ArrayList<Sub> arrList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] str= input.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            //arrList.add(new Sub(x, y));


        }
        return arrList;
    }



    private void addRemovedWall(int x, int y) {
        if (removedWalls == null) {
            Wall wall = new Wall(x, y, null, null, null, null);
            return;
        }

        Wall temp = removedWalls;
        while (temp.down != null) {
            if (temp.x == x) {

            }

            temp = temp.down;
        }


    }

}

class Sub{
    int x, y;

    public Sub(int x, int y) {
        this.x = x;
        this.y = y;
    }
}