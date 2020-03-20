package edu.northeastern.ashish;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BST {
    public  Node root;

    public BST(){
       // init();
    }

    private void init(){
        root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

    }

    public void preOrder(){
        preOrder(root);
        System.out.println("");
    }

    private void preOrder(Node node){
        if(node != null){
            System.out.print(node.data + ", ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    public void inOrder(){
        inOrder(root);
        System.out.println("");
    }

    private void inOrder(Node node){
        if(node != null){
            inOrder(node.left);
            System.out.print(node.data + ", ");
            inOrder(node.right);
        }
    }

    public void reverseInOrder(){
        reverseInOrder(root);
        System.out.println("");
    }

    private void reverseInOrder(Node node){
        if(node != null){
            reverseInOrder(node.right);
            System.out.print(node.data + ", ");
            reverseInOrder(node.left);
        }
    }
    public void postOrder(){
        postOrder(root);
        System.out.println("");
    }

    private void postOrder(Node node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + ", ");
        }
    }

    public void insert(int data){
        Node node = new Node(data);

        if(root == null)
        {
            root = node;
            return;
        }

        Node parent = null;
        Node curr = root;

        while(curr != null){
            parent = curr;
            if(curr.data > data){
                curr = curr.left;
            }else
            {
                curr = curr.right;
            }
        }

        if(parent.data > data)
            parent.left = node;
        else
            parent.right = node;

    }

    public Integer getSmallest(){
        if(root == null)
            return  Integer.MAX_VALUE;
        return getSmallest(root);
    }


    public void deleteNode(int data){
        root = deleteNode(root, data);
    }

    private Node deleteNode(Node node, int data){
        if(node == null)
            return null;

        if(data < node.data)
            node.left = deleteNode(node.left, data);
        else if(data > node.data)
            node.right = deleteNode(node.right, data);
        else{

            // when both or just one node is null
            if(node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;

            node.data = getMinNode(node.right).data;
            node.right = deleteNode(node.right, node.data);

        }
        return  node;
    }


    private Node getMinNode(Node node){
        Node current = node;
        while(current.left != null)
            current = current.left;
        return  current;
    }

    private Integer getSmallest(Node node){
        if(node.left == null)
            return  node.data;
        return  getSmallest(node.left);
    }

    public Integer getLargest(){
        if(root == null)
            return  Integer.MIN_VALUE;
        return getLargest(root);
    }

    private Integer getLargest(Node node){
        if(node.right == null)
            return  node.data;
        return  getLargest(node.right);
    }

    public void levelOrder(){
        if(root == null)
            return;

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        queue.add(null);

        while(queue.size() != 0){

            Node node = queue.remove();

            if(node != null ){
                System.out.print(node.data + " ,");
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }else{
                System.out.println("");
                if(queue.size() == 0)
                    break;
                queue.add(null);
            }
        }
        System.out.println("");
    }


    public int size(){
        return  size(root);
    }
    private int size(Node node){
        if(node == null)
            return  0;

        return  1 + size(node.left) + size(node.right);
    }


    public Integer[] storeValuesInArray(){
        int size = size();
        Integer[] arr = new Integer[size];
        IntStore ptr = new IntStore(0);

        storeValuesInArray(root, arr, ptr);
        return  arr;
    }

    public void storeValuesInArray(Node node, Integer[] arr, IntStore ptr){
        if(node != null){
            storeValuesInArray(node.left, arr, ptr);

            arr[ptr.value] = node.data;
            ptr.value ++;

            storeValuesInArray(node.right, arr, ptr);
        }

    }

    public void createBalancedBSTFromSortedArray(Integer[] arr){
        if(arr == null || arr.length == 0)
            return;
        root = createBalancedBSTFromSortedArray(arr, 0, arr.length -1);
    }
    private Node createBalancedBSTFromSortedArray(Integer[] arr, int start, int end){

        if(start > end)
            return  null;

        int mid = (start + end)/2;
        Node node = new Node(arr[mid]);

        node.left = createBalancedBSTFromSortedArray(arr, start, mid -1);
        node.right = createBalancedBSTFromSortedArray(arr, mid +1, end);
        return  node;
    }

    public void convertBinaryTreeToBST(){
        if(root == null)
            return;

        int size = size();
        Integer[] arr = storeValuesInArray();

        Arrays.sort(arr);
        IntStore ptr = new IntStore(0);
        arrayToBST(root, arr, ptr );
    }

    private void arrayToBST(Node node, Integer[] arr, IntStore ptr){

        if(node != null){
            arrayToBST(node.left, arr, ptr);
            node.data = arr[ptr.value];
            ptr.value ++;
            arrayToBST(node.right, arr, ptr);
        }

    }

    public boolean findPairSumEqualX(int x){
        int size = size();

        if(size <= 1)
            return false;

        Integer[] arr = storeValuesInArray();
        int start = 0;
        int end = arr.length -1;
        while(start < end){
            if(arr[start] + arr[end] == x){
                return true;
            }else  if(arr[start] + arr[end] < x){
                start ++;
            }else{
                end --;
            }
        }
        return false;
    }
    private Integer[] mergeSortedArrays(Integer[] arr1, Integer[] arr2){
        Integer[] merged = new Integer[arr1.length + arr2.length];

        int ptr1 = 0;
        int ptr2 = 0;
        int ptr = 0;
        while(ptr1 < arr1.length  && ptr2 < arr2.length){
            if(arr1[ptr1] < arr2[ptr2]){
                merged[ptr++] = arr1[ptr1++];
            }
            else{
                merged[ptr++] = arr2[ptr2++];
            }
        }

        while(ptr1 < arr1.length ){
            merged[ptr++] = arr1[ptr1++];
        }
        while(ptr2 < arr2.length ){
            merged[ptr++] = arr2[ptr2++];
        }

        return  merged;
    }

    public void  mergeTwoBSTNodes(Node node1, Node node2){
        if(node1 == null){
            root = node2;
            return;
        }
        if(node2 == null ){
            root = node1;
            return;
        }


        int size1 = size(node1);
        int size2 = size(node2);
        IntStore ptr = new IntStore(0);
        Integer[] arr1 = new Integer[size1];
        Integer[] arr2 = new Integer[size2];

        storeValuesInArray(node1, arr1, ptr);
        ptr.value = 0;
        storeValuesInArray(node2, arr2, ptr);

        Integer[] merged = mergeSortedArrays(arr1, arr2);

        root = createBalancedBSTFromSortedArray(merged, 0, merged.length-1);
    }

    public Node findKthLargest(int k){
        if(root == null || k < 1)
            return null;
        IntStore ptr = new IntStore(0);
        RefStore<Node> nodePtr = new RefStore<Node>(null);
        findKthLargest(root, k, ptr, nodePtr);

        return  nodePtr.value;
    }

    private void findKthLargest(Node node, int k, IntStore ptr, RefStore<Node> nodePtr){

        if(node != null){
            findKthLargest(node.right, k, ptr, nodePtr);
            ptr.value ++;
            if(ptr.value == k){
                nodePtr.value = node;
                return;
            }
            findKthLargest(node.left, k, ptr, nodePtr);

        }
    }

    public Node findKthSmallest(int k){
        if(root == null || k < 1)
            return null;
        IntStore ptr = new IntStore(0);
        RefStore<Node> nodePtr = new RefStore<Node>(null);
        findKthSmallest(root, k, ptr, nodePtr);

        return  nodePtr.value;
    }

    private void findKthSmallest(Node node, int k, IntStore ptr, RefStore<Node> nodePtr){

        if(node != null){
            findKthSmallest(node.left, k, ptr, nodePtr);
            if(ptr.value == k){
                nodePtr.value = node;
                return;
            }
            ptr.value ++;

            findKthSmallest(node.right, k, ptr, nodePtr);

        }
    }

    public void printInRange(int low, int high){
        printInRange(root, low, high);
        System.out.println("");
    }
    private void printInRange(Node node, int low, int high){
        if(node != null){
            printInRange(node.left, low, high);

            if(node.data > high)
                return;

            if(node.data >= low && node.data <=high)
                System.out.print(node.data + " ,");


            printInRange(node.right, low, high);

        }
    }


}
