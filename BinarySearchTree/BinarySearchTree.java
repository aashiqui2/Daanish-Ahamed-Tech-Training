import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    public void insert(int key) {
        root = insertRecursive(root, key);
    }

    public Node insertRecursive(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.data) {
            root.left = insertRecursive(root.left, key);
        } else {
            root.right = insertRecursive(root.right, key);
        }
        return root;
    }

    public void inorder() {
        inorderRecursive(root);
    }

    public void preorder() {
        preorderRecursive(root);
    }

    public void postorder() {
        postorderRecursive(root);
    }

    public void preorderRecursive(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorderRecursive(root.left);
        preorderRecursive(root.right);
    }

    public void inorderRecursive(Node root) {
        if (root == null) {
            return;
        }
        inorderRecursive(root.left);
        System.out.print(root.data + " ");
        inorderRecursive(root.right);
    }

    public void postorderRecursive(Node root) {
        if (root == null) {
            return;
        }
        postorderRecursive(root.left);
        postorderRecursive(root.right);
        System.out.print(root.data + " ");
    }

    public void findLevel() {
        levelorder(root);
    }

    public int countNodes() {
        return countnodes(root);
    }

    public int findHeight() {
        return height(root);
    }

    public int findSum() {
        return sumnodes(root);
    }

    public void levelorder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node currentNode = q.remove();
            if (currentNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currentNode.data + " ");
                if (currentNode.left != null) {
                    q.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    q.add(currentNode.right);
                }
            }
        }
    }

    public int countnodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftNodes = countnodes(root.left);
        int rightNodes = countnodes(root.right);

        return leftNodes + rightNodes + 1;
    }

    public int sumnodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sumnodes(root.left);
        int rightSum = sumnodes(root.right);
        return leftSum + rightSum + root.data;
    }

    public int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isFound(int key) {
        return searchRec(root, key);
    }

    public boolean searchRec(Node root, int key) {
        if (root == null || root.data == key) {
            return root != null;
        }
        if (root.data < key) {
            return searchRec(root.right, key);
        }
        return searchRec(root.left, key);
    }


    public void delete(int key) {
        root = deleteRec(root, key);
    }

    public Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.data) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.data) {
            root.right = deleteRec(root.right, key);
        } else {
            

            // Case 1: Node has no child (leaf node)
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: Node has one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 3: Node has two children
            root.data = minValue(root.right);

            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    public int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            root = root.left;
            minValue = root.data;
        }
        return minValue;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println("Preorder Traversal:");
        bst.preorder();
        System.out.println();

        System.out.println("Inorder Traversal:");
        bst.inorder();
        System.out.println();

        System.out.println("Postorder Traversal:");
        bst.postorder();
        System.out.println();

        System.out.println("Level Order Traversal:");
        bst.findLevel();

        System.out.println("Height of Tree: " + bst.findHeight());
        System.out.println("Sum of Nodes: " + bst.findSum());
        System.out.println("Is 60 in the tree? " + bst.isFound(60));
        System.out.println("Is 25 in the tree? " + bst.isFound(25));

        bst.delete(70);
        System.out.println("Inorder Traversal after deleting 60:");
        bst.inorder();
        System.out.println();
    }
}
