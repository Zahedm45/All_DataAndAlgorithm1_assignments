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

    public void addRightNode(int value) {
        totalNodeSize += 1;

        if (head == null) {
            addFirstNode(value, MOVE_RIGHT);

        } else {
            tail.rightNode = new Node(tail, value, MOVE_RIGHT,null);
            tail = tail.rightNode;
            rightSideNodeSize += 1;
            System.out.println("total size: " + totalNodeSize +" right size: "+ rightSideNodeSize +"  left: " + leftSideNodeSize);
            if (totalNodeSize > 2) {
                if (rightSideNodeSize > leftSideNodeSize + 1) {
                    midNode = midNode.rightNode;
                    rightSideNodeSize--;
                    leftSideNodeSize++;
                }


            }

        }
        System.out.println("total size: " + totalNodeSize +" right size: "+ rightSideNodeSize +"  left: " + leftSideNodeSize);

    }


    public void addLeftNode(int value) {
        totalNodeSize += 1;
        if (head == null) {
            addFirstNode(value, MOVE_LEFT);

        } else {
            head.leftNode = new Node(null, value,MOVE_LEFT, head);
            head = head.leftNode;
            leftSideNodeSize++;


            if (totalNodeSize > 1) {
                if (leftSideNodeSize > rightSideNodeSize){
                    midNode = midNode.leftNode;
                    leftSideNodeSize--;
                    rightSideNodeSize++;
                }


            }
        }

    }


    private void addFirstNode(int value, String leftOrRight) {
        tail = new Node(null, value, leftOrRight, null);
        midNode = head = tail;

    }

/*

    private void moveMidNode(String rightOrLeft) {
         Node temp = midNode;
         midNode.rightNode.leftNode = midNode.leftNode;
         midNode.leftNode.rightNode = midNode.rightNode;

         if (rightOrLeft.equals(MOVE_RIGHT)) {
             midNode = temp.rightNode;
         } else if (rightOrLeft.equals(MOVE_LEFT)) {
             midNode = temp.leftNode;
         }

    }
*/


/*
     void setMidNode(){
        System.out.println("total nodes: " + totalNodeSize + " mid node at: " + midNodeAt);

        if (totalNodeSize > 2) {
            int n = totalNodeSize / 2;
            if (n > midNodeAt) {
                Node temp = midNode;
                int i = 0;
                while ( i < n) {
                    temp = temp.rightNode;
                    i++;
                    midNodeAt++;

                }
                midNode = temp;
            }


        }




*/
/*         if (leftSideNodeSize > rightSideNodeSize) {
             Node temp = midNode;
             while (rightSideNodeSize + 1  < leftSideNodeSize) {
                 temp = temp.leftNode;
                 rightSideNodeSize++;
                 leftSideNodeSize--;
             }
             midNode = temp;
         } else if (rightSideNodeSize > leftSideNodeSize) {
             Node temp = midNode;
             while (rightSideNodeSize - 2 > leftSideNodeSize) {
                 temp = temp.rightNode;
                 rightSideNodeSize--;
                 leftSideNodeSize++;
             }
             midNode = temp;
         }*//*





         System.out.println("total nodes: " + totalNodeSize + " mid node at: " + midNodeAt);

     }
*/



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
