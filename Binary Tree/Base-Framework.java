// BASE CODE -> 

import java.util.*;

public class BinaryTree {
    static class Node { // NESTED CLASS -> TO CREATE THE OBJECTS : NODE
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data; // THIS REFERS TO THE CURRENT CALLING OBJECT
            this.left = null;
            this.right = null;
        }
    }

    static int idx = -1;
    public static Node buildTree(int nodes[]) {
        idx++;
        if (nodes[idx] == -1) {
            return null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("ENTER TOTAL NUMBER OF NODES :");
        int len = sc.nextInt();
        int nodes[] = new int[len];
        System.out.println("ENTER THE DATA OF THE NODES :");
        for (int i = 0; i < len; i++)
            nodes[i] = sc.nextInt();
        sc.close();

        Node root = buildTree(nodes);
        System.out.println(root.data); // TO CHECK TREE CONSTRUCTION
    }
}
