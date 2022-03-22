package assignment_2;

public class LinkedList {
    //private Node node;

    private Node leftNode ;
    private Node midNode;
    private Node rightNode;

    private int leftSideNodeSize = 0;
    private int rightSideNodeSize = 0;


    public LinkedList(int value) {
        this.midNode = new Node(null, value, null);
        this.rightSideNodeSize = 1;
        //pritNode();

    }




    public void addRightNode(int value) {

        if (rightNode != null) {
            Node newNode = new Node(rightNode, value, null);
            rightNode.rightNode = newNode;
            rightNode = newNode;
            midNode = midNode.rightNode;


        } else {
            rightNode = new Node(midNode, value, null);
            midNode.rightNode = rightNode;

        }

        rightSideNodeSize++;
    }




    public void addLeftNode(int value) {
        if (leftNode != null) {
            Node newNode = new Node(null, value, leftNode);
            leftNode.leftNode = newNode;
            leftNode = newNode;

        } else {
            leftNode = new Node(null, value, midNode);
            midNode.leftNode = leftNode;
        }
        leftSideNodeSize++;
        midNode = midNode.leftNode;

    }



    public void pritNode(){
        Node temp = midNode.leftNode;
        System.out.print("from mid's left node to end: ");
        while (temp != null) {
            System.out.println(temp.value + " ");
            temp = temp.leftNode;
        }

        System.out.println("\nMid node: " + midNode.value);

        System.out.print("from mid node's right to the end: ");
        temp = midNode.rightNode;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.rightNode;
        }

        System.out.println("left size: " + leftSideNodeSize + " right size: " + rightSideNodeSize);
        System.out.println();
    }


    public Node extractMidNode() {

        Node temp = midNode;

        if(midNode.rightNode != null ) {
            midNode.rightNode.leftNode = midNode.leftNode;
        }
        if (midNode.leftNode != null) {
            midNode.leftNode.rightNode = midNode.rightNode;
        }



        if (leftSideNodeSize >= rightSideNodeSize) {
            midNode = midNode.leftNode;
            leftSideNodeSize -= 1;

        } else {
            midNode = midNode.rightNode;
            rightSideNodeSize -= 1;
        }
        System.out.println("left size: " + leftSideNodeSize + " right size: " + rightSideNodeSize);
        return temp;
    }
}
