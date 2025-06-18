class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BST {
    Node root;

    // Insertion in BST
    Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.key)
            root.left = insert(root.left, key);
        else if (key > root.key)
            root.right = insert(root.right, key);

        return root;
    }

    // Deletion in BST
    Node delete(Node root, int key) {
        if (root == null) return null;

        if (key < root.key)
            root.left = delete(root.left, key);
        else if (key > root.key)
            root.right = delete(root.right, key);
        else {
            // Node with one or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children: get inorder successor (smallest in right subtree)
            root.key = minValue(root.right);
            root.right = delete(root.right, root.key);
        }

        return root;
    }

    // Find min value (used in deletion)
    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    // Inorder Traversal (Left, Root, Right)
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    // Preorder Traversal (Root, Left, Right)
    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Postorder Traversal (Left, Right, Root)
    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key + " ");
        }
    }

    // Driver code
    public static void main(String[] args) {
        BST tree = new BST();

        int[] values = {50, 30, 20, 40, 70, 60, 80};

        for (int val : values)
            tree.root = tree.insert(tree.root, val);

        System.out.println("Inorder traversal:");
        tree.inorder(tree.root);  // 20 30 40 50 60 70 80

        System.out.println("\nPreorder traversal:");
        tree.preorder(tree.root); // 50 30 20 40 70 60 80

        System.out.println("\nPostorder traversal:");
        tree.postorder(tree.root); // 20 40 30 60 80 70 50

        // Delete a node
        System.out.println("\n\nDeleting node 20");
        tree.root = tree.delete(tree.root, 20);
        System.out.println("Inorder after deletion:");
        tree.inorder(tree.root);  // 30 40 50 60 70 80
    }
}
