package assignment_2;

public class LinkedList {
    //private Node node;

/*    private Node leftNode ;
    private Node midNode;
    private Node rightNode;*/

    private Node head;
    private Node tail;
    private Node midNode;

    private final static String MOVE_RIGHT = "right";
    private final static String MOVE_LEFT = "left";


    private int leftSideNodeSize = 0;
    private int rightSideNodeSize = 0;
    private int totalNodeSize = 0;
    //private int midNodeAt = 0;

    public void addRightNode(String value) {
        totalNodeSize += 1;

        if (head == null) {
            addFirstNode(value, MOVE_RIGHT);

        } else {
            tail.rightNode = new Node(tail, value, MOVE_RIGHT,null);
            tail = tail.rightNode;
            rightSideNodeSize += 1;
            System.out.println("total size: " + totalNodeSize +" right size: "+ rightSideNodeSize +"  left: " + leftSideNodeSize);
            if (totalNodeSize > 2) {
                if (totalNodeSize % 2 != 0) {
                    midNode = midNode.rightNode;
                }


/*                if (rightSideNodeSize > leftSideNodeSize + 1) {
                    midNode = midNode.rightNode;
                    rightSideNodeSize--;
                    leftSideNodeSize++;
                }*/


            }

        }
        //System.out.println("total size: " + totalNodeSize +" right size: "+ rightSideNodeSize +"  left: " + leftSideNodeSize);

    }


    public void addLeftNode(String value) {
        totalNodeSize += 1;
        if (head == null) {
            addFirstNode(value, MOVE_LEFT);

        } else {
            head.leftNode = new Node(null, value,MOVE_LEFT, head);
            head = head.leftNode;
            leftSideNodeSize++;


            if (totalNodeSize > 1) {
                if (totalNodeSize % 2 == 0) {
                    midNode = midNode.leftNode;
                }


/*                if (leftSideNodeSize > rightSideNodeSize){
                    midNode = midNode.leftNode;
                    leftSideNodeSize--;
                    rightSideNodeSize++;
                }*/


            }
        }

    }


    private void addFirstNode(String value, String leftOrRight) {
        tail = new Node(null, value, leftOrRight, null);
        midNode = head = tail;

    }






    public Node extractMidNode() {
        Node temp = midNode;


        if (totalNodeSize == 1) {
            midNode = head = tail = null;
            totalNodeSize = 0;
            return temp;

        } else if (totalNodeSize == 2) {
            head = midNode = midNode.rightNode;
            totalNodeSize = 1;
            leftSideNodeSize = rightSideNodeSize = 0;

        } else if (totalNodeSize > 2) {


            midNode.leftNode.rightNode = midNode.rightNode;
            midNode.rightNode.leftNode = midNode.leftNode;
            totalNodeSize--;


            if (totalNodeSize % 2 == 0) {
                midNode = midNode.leftNode;
                leftSideNodeSize--;
                rightSideNodeSize++;
            } else {
                midNode = midNode.rightNode;
                leftSideNodeSize++;
                rightSideNodeSize--;

            }
        }
        return temp;
    }




    public void pritNode(){
        Node temp = head;
        while (temp != null) {

            if (temp == midNode) {
                System.out.println(temp.value + " mid");

            } else  {
                System.out.println(temp.value);
            }

            temp = temp.rightNode;
        }

    }


}
