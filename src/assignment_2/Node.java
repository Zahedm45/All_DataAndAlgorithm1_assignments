package assignment_2;

public class Node {
    String value;
    String operation;
    Node rightNode;
    Node leftNode;

    public Node(Node leftNode, String value, String leftOrRight, Node rightNode) {
        this.value = value;
        this.operation = leftOrRight;
        this.leftNode = leftNode;
        this.rightNode = rightNode;

    }

}

class Command {
    String operation;
    int value;

    public Command(String operation, int value) {
        this.operation = operation;
        this.value = value;
    }
}
