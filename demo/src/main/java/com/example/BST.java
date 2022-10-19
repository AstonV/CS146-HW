package com.example;

// import Queue and LinkedList for Printing BST level Order line by line

import java.util.LinkedList;
import java.util.Queue;

// creating Node class for left and right nodes of BST
class Node {

    //class members
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

class BST {
    // Function to perform inorder traversal on the tree
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        inorder(root.right);
    }

    // Recursive function to insert a key into a BST
    public static Node insert(Node root, int key) {
        // if the root is null, create a new node and return it
        if (root == null) {
            return new Node(key);
        }

        // if the given key is less than the root node, recur for the left subtree
        if (key < root.data) {
            root.left = insert(root.left, key);
        }
        // if the given key is more than the root node, recur for the right subtree
        else {
            root.right = insert(root.right, key);
        }

        return root;
    }

    // Helper function to return the sum of all nodes present in a binary tree
    public static int findSum(Node root) {
        if (root == null) {
            return 0;
        }
        return root.data + findSum(root.left) + findSum(root.right);
    }

    // Function to modify the BST such that every key is updated to
    // contain the sum of all greater keys
    public static int update(Node root, int sum) {
        // base case
        if (root == null) {
            return sum;
        }

        // update the left subtree
        sum = update(root.left, sum);

        // modify the sum to contain the sum of all greater keys
        sum = sum - root.data;

        // update the root to contain the sum of all greater keys
        root.data += sum;

        // update the right subtree
        sum = update(root.right, sum);

        return sum;
    }

    public static void main(String[] args) {
        int[] keys = {5, 3, 2, 8, 4, 6, 10};

        Node root = null;
        for (int key : keys) {
            root = insert(root, key);
        }

        System.out.println("");
        // this function below will print question tree
        // remove this below function call line if you dont want to print question BST
        printOutputBSTLineByLine(root);

        int sum = findSum(root);
        update(root, sum);
        System.out.println("\n");
        inorder(root);

        // this function below will print output tree
        // BST to contain the sum of all greater keys, including the key itself.
        printOutputBSTLineByLine(root);

    }

    // To Print BST as asked in question we have to print nodes in level order
    // Below is function that will print level order traversal line by line
    // Iterative method to do level order traversal line by line

    // Here We count the nodes at current level.
    // And for every node, we enqueue its children to queue.
    static void printOutputBSTLineByLine(Node root) {

        // Base Case no nodes at root
        if (root == null)
            return;

        // Create an empty queue for level order traversal
        // We will store nodes in this queue for later use
        Queue<Node> queue = new LinkedList<Node>();

        // Enqueue Root and initialize height
        queue.add(root);


        while (true) {
            // nodeCount indicates number of nodes at current level
            int nodeCount = queue.size();

            if (nodeCount == 0)
                break;

            // Dequeue all nodes of current level and Enqueue all
            // nodes of next level
            while (nodeCount > 0) {

                // The peek() method of Queue returns the element at the front the container
                // (returns the head of the queue)
                Node node = queue.peek();
                System.out.print(node.data + " ");
                queue.remove();

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);

                nodeCount--;
            }
            System.out.println();
        }
    }
}






