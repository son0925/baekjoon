import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BinaryTree tree = new BinaryTree();


        while (true) {
            try {
                tree.insert(Integer.parseInt(br.readLine()));
            } catch (Exception e) {
                break;
            }
        }
        tree.print(tree.root);
    }
}

class Node {
    Node left;
    Node right;
    int value;

    public Node(int value) {
        this.value = value;
    }
}


class BinaryTree {
    Node root;

    public BinaryTree() {

    }

    public void insert(int value) {
        Node node = new Node(value);

        if (root == null) {
            root = node;
            return;
        }

        Node curNode = root;

        while(true) {

            if (curNode.value > value) {
                if (curNode.left == null) {
                    curNode.left = node;
                    break;
                } else {
                    curNode = curNode.left;
                }
            }

            else {
                if (curNode.right == null) {
                    curNode.right = node;
                    break;
                } else {
                    curNode = curNode.right;
                }
            }
        }
    }

    public void print(Node curNode) {
        if (curNode == null) return;

        print(curNode.left);
        print(curNode.right);
        System.out.println(curNode.value);
    }
}