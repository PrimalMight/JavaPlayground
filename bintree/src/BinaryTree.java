import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BinaryTree {
    private Node root;
    public static enum TraversalMethods {
        PRE, IN, POST;
    }
    private boolean FINDER = false; // used in contains() method

    public void crawl(TraversalMethods method){
        crawl(root, method);
    }

    private Node crawl(Node node, TraversalMethods method){
        if (node == null) return null;
        switch(method){
            case PRE:
                System.out.println("" + node.getData() + " ");
                crawl(node.getLeft(), TraversalMethods.PRE);
                crawl(node.getRight(), TraversalMethods.PRE);
                return new Node(0);
            case IN:
                crawl(node.getLeft(), TraversalMethods.IN);
                System.out.println("" + node.getData() + " ");
                crawl(node.getRight(), TraversalMethods.IN);
                return new Node(0);
            case POST:
                crawl(node.getLeft(), TraversalMethods.POST);
                crawl(node.getRight(), TraversalMethods.POST);
                System.out.println("" + node.getData() + " ");
                return new Node(0);
            default:
                return null;
        }
    }
    
    public boolean contains(int data){
        Node node = root;
        boolean finder = false;
        
        if(node.getData() == data){
            FINDER = true;
        }     
        
        contains(node.getLeft(), data);
        contains(node.getRight(), data);
        
        if(FINDER == false) return FINDER;
        if(FINDER == true) FINDER = false; return !FINDER; // Reset FINDER to false;
    }

    private void contains(Node node, int data){
        if(node == null) return;

        if(node.getData() == data && FINDER == false){
            FINDER = true;
        }

        contains(node.getLeft(), data);
        contains(node.getRight(), data);

    }

    public void addNode(int data){
        if(root == null){ // Add root if non existent
            root = new Node(data);
            root.setLeft(null);
            root.setRight(null);
        }
        else{
            root = addRecursive(root, data);
        }
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.getData()) {
            if(current.getLeft() == null){
                current.setLeft(new Node(value));
            }
            else{
                addRecursive(current.getLeft(), value);
            }
        } else if (value > current.getData()) {
            if(current.getRight() == null){
                current.setRight(new Node(value));
            }
            else{
                addRecursive(current.getRight(), value);
            }
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public boolean isLeaf(Node node){
        if(node.getLeft() == null && node.getRight() == null) return true;
        return false;
    }

    // Wrapper
    public void printLeaves(){
        Node node = root;

        if(isLeaf(node)){
            System.out.println("Only root in tree (leaf):" + node.getData());
        }     
        
        System.out.println("\nLeaves:");
        printLeaves(node.getLeft());
        printLeaves(node.getRight());
    }

    // Recursion
    private void printLeaves(Node node){
        if(node == null) return;

        if(isLeaf(node)){
            System.out.println(node.getData());
        }

        printLeaves(node.getLeft());
        printLeaves(node.getRight());

    }

    public void getMaxDepth(){
        Node node = root;
        int depth = 1; // reset depth
        HashMap<Integer, ArrayList<Integer>> depthMap = new HashMap<Integer, ArrayList<Integer>>();
        ArrayList<Integer> rootVector = new ArrayList<Integer>();
        ArrayList<Integer> nodeVector = new ArrayList<Integer>();


        rootVector.add(node.getData());
        if(node.getLeft() != null) nodeVector.add(node.getLeft().getData());
        if(node.getRight() != null) nodeVector.add(node.getRight().getData());

        depthMap.put(0, rootVector);
        depthMap.put(depth, nodeVector);

        if(node.getLeft() != null) depthTraverse(node.getLeft(), depth+1, depthMap);
        if(node.getRight() != null) depthTraverse(node.getRight(), depth+1, depthMap);

        ArrayList<Integer> levels = new ArrayList<Integer>();
        for (Map.Entry<Integer,ArrayList<Integer>> entry : depthMap.entrySet()) {
            levels.add(entry.getKey());
        }

        System.out.println("Node(s) with highest depth is/are: ");
        for (Integer node_val : depthMap.get(Collections.max(levels))) {
            System.out.println(node_val);
        }
    }

    private void depthTraverse(Node node, int depth, HashMap<Integer, ArrayList<Integer>> depthMap){
        if(node == null) return;
        ArrayList<Integer> nodeVector = new ArrayList<Integer>();
        if(node.getLeft() != null) nodeVector.add(node.getLeft().getData());
        if(node.getRight() != null) nodeVector.add(node.getRight().getData()); // clear vector and add current nodes on specific depth level
        if(depthMap.containsKey(depth)){ // add current level nodes if level already exists
            for (Integer current_node : nodeVector) {
                depthMap.get(depth).add(current_node);
            }
        } else if(!nodeVector.isEmpty()) {
            depthMap.put(depth, nodeVector); // put current level with nodes into dictionary
        }

        depthTraverse(node.getLeft(), depth+1, depthMap);
        depthTraverse(node.getRight(), depth+1, depthMap);
    }

    public void convertToLL(){
        if (root == null)
            return;
        convertToLL(root);
    }

    // TODO: DOESNT WORK , FIX
    private void convertToLL(Node node){
        if (node.getLeft() != null) {
            convertToLL(node.getLeft());
            Node left = node.getLeft();
            while (left.getRight() != null)
                left = left.getRight();
            left.setRight(node);
            node.setLeft(left);
        }
        if (node.getRight() != null) {
            convertToLL(node.getRight());
            Node right = node.getRight();
            while (right.getLeft() != null)
                right = right.getLeft();
            right.setLeft(node);
            node.setRight(right);
        }
    }
}
