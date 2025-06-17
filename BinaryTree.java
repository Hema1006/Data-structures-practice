import java.util.LinkedList;
import java.util.Queue;
class Node {
    int data;
    Node left, right;

    public Node(int value) {
        data = value;
        left = right = null;
    }
}
public class BinaryTree {
    Node root;
    void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }
    void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }
    void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }
    void delete(int key) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            if (root.data == key) root = null;
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node target = null, temp = null;
        while (!q.isEmpty()) {
            temp = q.poll();
            if (temp.data == key)
                target = temp;

            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);
        }
        if (target != null) {
            int x = temp.data; 
            deleteDeepest(temp);
            target.data = x;
        }
    }
    void deleteDeepest(Node delNode) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp == delNode) {
                temp = null;
                return;
            }
            if (temp.left != null) {
                if (temp.left == delNode) {
                    temp.left = null;
                    return;
                } else {
                    q.add(temp.left);
                }
            }
            if (temp.right != null) {
                if (temp.right == delNode) {
                    temp.right = null;
                    return;
                } else {
                    q.add(temp.right);
                }
            }
        }
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.print("Inorder before deletion: ");
        tree.inorder(tree.root);
        System.out.println();

        tree.delete(2); // Delete node with value 2

        System.out.print("Inorder after deletion: ");
        tree.inorder(tree.root);
        System.out.println();
    }
}
