package assignment_3;

public class Wall {
    int x, y;
    Wall right, left, up, down;

    public Wall(int x, int y, Wall right, Wall left, Wall up, Wall down) {
        this.x = x;
        this.y = y;
        this.right = right;
        this.left = left;
        this.up = up;
        this.down = down;
    }
}
