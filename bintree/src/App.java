public class App {
    public static void main(String[] args) throws Exception {
        BinaryTree my_tree = new BinaryTree();
        my_tree.addNode(7);
        my_tree.addNode(5);
        my_tree.addNode(14);
        my_tree.addNode(1);
        my_tree.addNode(6);
        my_tree.addNode(16);
        my_tree.addNode(10);

        //my_tree.crawl(BinaryTree.TraversalMethods.PRE);
        my_tree.crawl(BinaryTree.TraversalMethods.IN);
        // my_tree.crawl(BinaryTree.TraversalMethods.POST);
        
        System.out.println("-----\n");

        System.out.println(my_tree.contains(2));
        my_tree.printLeaves();
        my_tree.getMaxDepth();

        System.out.println("------\n");
        my_tree.convertToLL();
        my_tree.crawl(BinaryTree.TraversalMethods.IN);
    }
}
