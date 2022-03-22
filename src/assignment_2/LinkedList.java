package assignment_2;

public class LinkedList {
    //private Node node;

/*    private Node leftNode ;
    private Node midNode;
    private Node rightNode;*/

    private Node head;
    private Node tail;



    private int leftSideNodeSize = 0;
    private int rightSideNodeSize = 0;

    public void addRightNode(int value) {
        if (head == null) {
            addFirstNode(value);

        } else {
            tail.rightNode = new Node(tail, value, null);
            tail = tail.rightNode;

        }
    }


    public void addLeftNode(int value) {
        if (head == null) {
            addFirstNode(value);
        } else {
            head.leftNode = new Node(null, value, head);
            head = head.leftNode;
        }
    }


    private void addFirstNode(int value) {
        tail = new Node(null, value, null);
        head = tail;
    }







    public void pritNode(){
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.rightNode;
        }

    }




/*
    public void addRightNode(int value) {
        if (midNode == null) {
            midNode = new Node(null, value, null);

        } else {

            if (rightNode == null) {
                rightNode = new Node(midNode, value, null);
                midNode.rightNode = rightNode;

            } else {
                Node newNode = new Node(rightNode, value, null);
                rightNode.rightNode = newNode;
                rightNode = newNode;

                midNode = midNode.rightNode;

            }

        }

        rightSideNodeSize++;
    }




    public void addLeftNode(int value) {
        if (midNode == null) {
            midNode = new Node(null, value, null);

        } else {
            if (leftNode == null) {
                leftNode = new Node(null, value, midNode);
                midNode.leftNode = leftNode;

            } else {

                Node newNode = new Node(null, value, leftNode);
                leftNode.leftNode = newNode;
                leftNode = newNode;

            }

            midNode = midNode.leftNode;
            leftSideNodeSize++;
        }
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

        if (midNode.leftNode != null && midNode.rightNode != null) {
            midNode.leftNode.rightNode = temp.rightNode;
            midNode.rightNode.leftNode = temp.leftNode;

        } else if (midNode.rightNode != null) {
            midNode.rightNode = null;

        } else if (midNode.leftNode != null) {
            midNode.leftNode = null;
        }


        if (leftSideNodeSize >= rightSideNodeSize) {
            midNode = midNode.leftNode;
            leftSideNodeSize--;
        } else {
            midNode = midNode.rightNode;
            rightSideNodeSize--;
        }

       return temp;
    }*/
}
