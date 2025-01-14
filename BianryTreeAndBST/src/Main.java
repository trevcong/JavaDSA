public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        System.out.println("In-order traversal:");
        bst.inOrderTraversal(bst.root);

        System.out.println("\nPre-order traversal:");
        bst.preOrderTraversal(bst.root);

        System.out.println("\nPost-order traversal:");
        bst.postOrderTraversal(bst.root);
    }
}