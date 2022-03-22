package assignment_2;

public class Node {
    int value;
    Node rightNode;
    Node leftNode;

    public Node(Node leftNode, int value, Node rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;

    }

}
