class Node {
    int value;  // node value
    Node left;  // left child
    Node right; // right child

    // constructor for binary search tree
    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }

    // this constructor for full binary search tree
    Node(Node left, Node right,int value) {
        this.value = value;
        this.right = right;
        this.left = left;
    }

}