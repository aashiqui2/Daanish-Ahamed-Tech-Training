class BinarySearchTree {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int key) {
            data = key;
            left = right = null;
        }
    }
    Node root;
    BinarySearchTree ()
    {
        root=null;
    }
    public void BuildTree(int key)
    {
        root=insert(root,key);
    }
    public Node insert(Node root,int key)//null,30
    {
        if(root==null)
        {
            return new Node(key);
        }
        if(key<root.data)
        {
            root.left=insert(root.left, key);
        }
        else{
            root.right=insert(root.right, key);
        }
        return root;

    }
    public void PrintInorder()
    {
        Inorder(root);
    }
    public void  Inorder(Node root)
    {
        if(root==null)
        {
            return;
        }
        Inorder(root.left);
        System.out.print(root.data+" ");
        Inorder(root.right);
    }
    public void PrintPreorder()
    {
        preorder(root);
    }
    public void  preorder(Node root)
    {
        if(root==null)
        {
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }public void PrintPostorder()
    {
        postorder(root);
    }
    public void  postorder(Node root)
    {
        if(root==null)
        {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
}

public class BST {
    public static void main(String[] args) {
        BinarySearchTree  bst=new BinarySearchTree();
        bst.BuildTree(50);
        bst.BuildTree(30);
        bst.BuildTree(20);
        bst.BuildTree(40);
        bst.BuildTree(70);
        bst.BuildTree(60);
        bst.BuildTree(80);
        bst.PrintInorder();
        bst.PrintPostorder();
        bst.PrintPreorder();
    }
}
