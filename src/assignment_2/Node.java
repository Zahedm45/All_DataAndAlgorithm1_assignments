package assignment_2;

public class Node {
    int value;
    String operation;
    Node rightNode;
    Node leftNode;

    public Node(Node leftNode, int value, String leftOrRight, Node rightNode) {
        this.value = value;
        this.operation = leftOrRight;
        this.leftNode = leftNode;
        this.rightNode = rightNode;

    }

}
