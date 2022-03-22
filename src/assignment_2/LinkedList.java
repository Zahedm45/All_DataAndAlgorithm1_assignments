package assignment_2;

public class LinkedList {
    //private Node node;

    private Node leftNode ;
    private Node midNode;
    private Node rightNode;

    private int leftSideNodeSize = 0;
    private int rightSideNodeSize = 0;


//    public LinkedList(int value) {
//        this.midNode = new Node(null, value, null);
//        this.rightSideNodeSize = 1;
//        //pritNode();
//
//    }




    public void addRightNode(int value) {


    }




    public void addLeftNode(int value) {

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

    }
}
