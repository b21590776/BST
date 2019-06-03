import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.*;


public class Tree {

    public static Node root; //  tree's root

    public Tree() {this.root= null;} // tree constructor

// -------------------------------------------DELETE-TREE---------------------------------------------------------------
    void deleteTree(Node node) // to deleteSelecter existing tree before creating a new binary tree
    {
        root = null;    // null to deleteSelecter the tree
    }

// ---------------------------------------DELETE-NODE-------------------------------------------------------------------
    Node deleteNode(Node root, int value) {
    // reaching the node to be deleted
    if (root == null)
        return null;
    if (root.value > value) {
        root.left = deleteNode(root.left, value);
    } else if (root.value < value) {
        root.right = deleteNode(root.right, value);

    } else {
        // if node have two children
        if (root.left != null && root.right != null) {
            Node temp = root;
            // finding minimum element from right
            Node minNodeForRight = minvalue(temp.right);
            // replacing current node with minimum node from right subtree
            root.value = minNodeForRight.value;
            // deleting minimum node
            deleteNode(root.right, minNodeForRight.value);
            root.right = deleteNode(root.right, root.value);
        }
        // if node has only left child
        else if (root.left != null) {
            root = root.left;
        }
        // if node has only right child
        else if (root.right != null) {
            root = root.right;
        }
        // if node is a leaf node
        else
            root = null;
    }
    return root;
}
    // get minimum value in binary search tree
    Node minvalue(Node root) {
        if (root.left == null)
            return root;
        else {
            return minvalue(root.left);
        }
    }


    Node deleteSelecter(Node rot, String str)throws IOException {
        Node current = rot;
        if (str.equals("leftchild")) {
            Node b = current.left;
            if (b == null) {
                WriteFile.append("error");  //If there is no child on the left, it gives an error
            }
            else {
                WriteFile.append("Left Child of Root Deleted:");
                WriteFile.append(Integer.toString(b.value));
                root = deleteNode(current,b.value);
            }
        }
        if (str.equals("rightchild")) {
            Node a = current.right;
            if (a == null) {
                WriteFile.append("error");  //If there is no child on the right, it gives an error
            }
            else {
                WriteFile.append("Right Child of Root Deleted:");
                WriteFile.append(Integer.toString(a.value));
                root= deleteNode(current,a.value);
            }
        }
        if (str.equals("root")) {
            if (current == null) {
                WriteFile.append("error"); //If there is no root node, it gives an error
            }
            else {
                WriteFile.append("Root Deleted:");
                WriteFile.append(Integer.toString(current.value));
                root = deleteNode(current,current.value);
            }
        }
        return root;
    }

// -------------------------------------------DEL-ROOT------------------------------------------------------------------
    public void DelRoot() throws IOException {
        root = deleteSelecter(root,"root");
        WriteFile.append("\n");
    }
// -------------------------------------------DEL-ROOT-RC---------------------------------------------------------------
    public void DelRootRc() throws IOException {
        root = deleteSelecter(root,"rightchild");
        WriteFile.append("\n");

    }

// ------------------------------------------DEL-ROOT-LC----------------------------------------------------------------
    public void DelRootLc() throws IOException {
        root = deleteSelecter(root,"leftchild");
        WriteFile.append("\n");
    }

//--------------------------------------------CREATE-BST----------------------------------------------------------------


    public void CreateBST(String list) throws IOException {
        String[] list1 = list.split(","); // split given list
        int size = list1.length;
        int [] arr = new int [size];
        deleteTree(root);            //deletes existing tree
        for(int i=0; i<size; i++) {
            arr[i] = Integer.parseInt(list1[i]); // converting integer
            insert(arr[i]);                      // inserting to tree
        }
        WriteFile.append("BST created with elements:");
        Inorder(root);
        WriteFile.append("\n");
    }

    // it prints binary tree nodes in inorder
    void Inorder(Node node) throws IOException {
        if (node == null)
            return;
        // first go left child
        Inorder(node.left);
        // then print the data of node
        WriteFile.append(node.value + " ");
        // then go right child
        Inorder(node.right);
    }

    public void insert(int number){     // this method inserts the given number in tree
        Node newNode = new Node(number); // Creates a new node containing the new number
        if(root == null){
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while(true){
            parent = current;
            if(number < current.value){
                current = current.left;
                if(current == null){ // reaching the leaf node
                    // If the new number is less then the leaf node key it
                    // assigns the new node to its left child
                    parent.left = newNode;
                    return;
                }
            }else{
                current = current.right;
                if(current==null){  // reaching the leaf node
                    // else assign the new node its right child
                    parent.right = newNode;
                    return;
                }
            }
        }
    }
// ----------------------------------------------BSTH-------------------------------------------------------------------

public static Node CreateBSTH(int rot, int depth) { // recursively full binary search tree creater method
        Node left, right;

        if (depth == 0) {
            return new Node(null,null,rot);
        } else {
            left = CreateBSTH((int) (rot - Math.pow(2, depth - 1)), depth - 1);  // left child's value
            right = CreateBSTH((int) (rot + Math.pow(2, depth - 1)), depth - 1); // right child's value
            return new Node(left,right,rot);    // adding new node to tree
        }
    }

    public void CreateBSTH(int depth) throws IOException  // recursive helper method
    {
        deleteTree(root);                      // deletes existing tree
        if (depth<=0){
            WriteFile.append("error");
        }else {
            root = CreateBSTH((int) Math.pow(2, depth), depth); // it sends initial root value (Math.pow(2, depth)) and
            // depth, then recursive method add nodes to full tree according to root value and depth
            WriteFile.append("A full BST created with elements:");
            Inorder(root);
            WriteFile.append("\n");
        }
    }


// ------------------------------------LEAVES---------------------------------------------------------------------------

    static List<Integer> leaves = new ArrayList<Integer>(); // array list for collecting leaves

    static void findLeaves(Node root)  // binary search tree leaf nodes or leaves finds recursive method
    {
        if(root==null) // if null return back
            return;
        if (root.left == null && root.right == null) {
            leaves.add(root.value);  // if node has no child add the leaves array list
        }
        findLeaves(root.left);      // go left
        if (root.left == null && root.right == null) {
            leaves.add(root.value);
        }
        findLeaves(root.right);     // then go right
    }

    public void LeavesAsc()throws IOException {
        ArrayList<Integer> leavess = new ArrayList<Integer>();
        findLeaves(root);
        WriteFile.append("LeavesAsc:");
        for (Integer element : leaves) {
            if (!leavess.contains(element)) {
                leavess.add(element);
                WriteFile.append(element+" "); // printing leaves
            }
        }
        WriteFile.append("\n");
        leaves.clear();                 // clearing array list after added to file
    }
// ------------------------------------------PREORDER-------------------------------------------------------------------

    void Preorder(Node node) throws IOException {  // preorder printer
        if (node == null) // if null return back
            return;
        // first print node
        WriteFile.append(node.value + " ");
        // then recursively go on left subtree
        Preorder(node.left);
        // after recursively go on right subtree
        Preorder(node.right);
    }

    public void Preorder() throws IOException {  // recursive helper method
        WriteFile.append("Preorder:");
        Preorder(root);
        WriteFile.append("\n");

    }
// -------------------------------------WIDTH---------------------------------------------------------------------------


    int MaxWidth(Node node) // Function to search the maximum width in each level
    {
        int maxwidth = 0;
        int width;
        int h = Height(root); // height of tree


        // compare the width with maximum width in each height level
        for (int i = 1; i <= h; i++)
        {
            width = Width(node, i);
            if (width > maxwidth)
                maxwidth = width;
        }
        return maxwidth;
    }

    // Getting width of a given level recursively
    int Width(Node node, int level)
    {
        if (node == null)
            return 0;
        // This means it reach the selected level
        if (level == 1)
            return 1;
        else if (level > 1)
            // This means it has not reach the selected level so keep sending control down
            return Width(node.left, level - 1) + Width(node.right, level - 1);
        return 0;
    }
    public void FindWidth() throws IOException {
        WriteFile.append("Width:"+ MaxWidth(root));
        WriteFile.append("\n");
    }


// -----------------------------------------HEIGHT----------------------------------------------------------------------

    private int Height(Node node) { // recursively look select larger one and add 1 to its value
        if (node==null) {
            return(0);
        }
        else {
            int leftDepth = Height(node.left);
            int rightDepth = Height(node.right);
            // choosing the larger one
            return(Math.max(leftDepth, rightDepth) + 1);
        }
    }
    public void FindHeight() throws IOException { // recursive helper method
        WriteFile.append("Height:"+ (Height(root)-1));
        WriteFile.append("\n");
    }
}