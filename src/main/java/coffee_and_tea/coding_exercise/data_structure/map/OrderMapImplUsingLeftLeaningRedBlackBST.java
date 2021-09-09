package coffee_and_tea.coding_exercise.data_structure.map;

import java.util.ArrayDeque;
import java.util.Queue;

public class OrderMapImplUsingLeftLeaningRedBlackBST<Key extends Comparable<Key>, Value> implements OrderMap<Key, Value> {
    
    private Node root = null;
    
    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if(node == null) return new Node(key, value, RED);
        int cmp = key.compareTo(node.key);
        if(cmp < 0) node.left = put(node.left, key, value);
        else if(cmp > 0) node.right = put(node.right, key, value);
        else if(cmp == 0) node.value = value;

        if(isRed(node.right) && !isRed(node.left))  node = rotateLeft(node);
        if(isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        if(isRed(node.left) && isRed(node.right)) flipColors(node);

        return node;
    }

    @Override
    public Value get(Key key) {
        Node current = root;
        while (current != null) {
            if (current.key.compareTo(key) == 0) return current.value;
            else if (current.key.compareTo(key) < 0) current = current.right;
            else current = current.left;
        }
        return null;
    }

    @Override
    public void delete(Key key) {

    }

    @Override
    public boolean contains(Key key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterable<Key> keys() {
        return null;
    }

    @Override
    public Key min() {
        return null;
    }

    @Override
    public Key max() {
        return null;
    }

    @Override
    public Key floor(Key key) {
        return null;
    }

    @Override
    public Key ceiling(Key key) {
        return null;
    }

    @Override
    public int rank(Key key) {
        return 0;
    }

    @Override
    public Key select(int k) {
        return null;
    }

    @Override
    public void deleteMin() {

    }

    @Override
    public void deleteMax() {

    }

    @Override
    public int size(Key lo, Key hi) {
        return 0;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    @Override
    public void print() {
        Queue<Node> queue = new ArrayDeque<>() ;
        root.level = 0;
        queue.offer(root);
        int currentLevel = 0;
        System.out.println("================= start ====================");
        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(current.level != currentLevel)   System.out.println("\nCurrent level: " + currentLevel++);
            System.out.print("Node(Key:" + current.key + ", Value: " + current.value + ")\t");
            if(current.left != null) {
                current.left.level = current.level+1;
                queue.offer(current.left);
            }
            if(current.right != null) {
                current.right.level = current.level+1;
                queue.offer(current.right);
            }
        }
        System.out.println("\n================= end ====================");
    }
    
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color =h.color;
        h.color = RED;
        return x;
    }
    
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x; 
    }
    
    private void flipColors(Node h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
    
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    
    private boolean isRed(Node x) {
        if(x == null) return false;
        return x.color == RED;
    }
    
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        boolean color;
        int level;

        public Node(Key key, Value value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }
}
