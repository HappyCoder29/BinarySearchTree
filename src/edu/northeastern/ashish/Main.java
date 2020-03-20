package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(4);
        bst.insert(5);
        bst.insert(6);
        bst.insert(7);
        bst.insert(8);

//        bst.insert(8);
//        bst.insert(3);
//        bst.insert(10);
//        bst.insert(1);
//        bst.insert(6);
//        bst.insert(14);
//        bst.insert(4);
//        bst.insert(7);
//        bst.insert(13);

       // bst.deleteNode(3);
        bst.levelOrder();


        System.out.println("");


        //bst.printInRange(5,11);

        //Node node = bst.findKthLargest(3);

//        BST bst1 = new BST();
//        BST bst2 = new BST();
//
//        Integer[] arr = {1,3,5,7,9,11,13};
//        bst1.createBalancedBSTFromSortedArray(arr);
//        System.out.println("BST1 Level Order");
//        bst1.levelOrder();
//
//        Integer[] arr2 = {2,4,6,8,10,12,14};
//        bst2.createBalancedBSTFromSortedArray(arr2);
//        System.out.println("BST2 Level Order");
//        bst2.levelOrder();
//
//        System.out.println("Merged Level Order");
//        bst.mergeTwoBSTNodes(bst1.root, bst2.root);
//        bst.levelOrder();
//


//
//        bst.levelOrder();
//
//        bst.convertBinaryTreeToBST();
//        bst.levelOrder();

//        Integer[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
//        bst.createBalancedBSTFromSortedArray(arr);
//        bst.levelOrder();

//        bst.insert(8);
//        bst.insert(3);
//        bst.insert(10);
//        bst.insert(1);
//        bst.insert(6);
//        bst.insert(14);
//        bst.insert(4);
//        bst.insert(7);
//        bst.insert(13);

      //  System.out.println(bst.findPairSumEqualX(34));

//        Integer[] arr = bst.storeValuesInArray();
//        for (Integer i : arr) {
//            System.out.print(i + ", ");
//        }
//        System.out.println("");

       // bst.preOrder();
       // bst.reverseInOrder();

       // System.out.println(bst.getSmallest());

        //bst.levelOrder();


    }
}
