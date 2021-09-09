package coffee_and_tea.coding_exercise.data_structure.map;

import java.util.*;

public class OrderMapImplUsingBinarySearchTree<Key extends Comparable<Key>, Value> implements OrderMap<Key, Value> {

    private Node root = null;

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null || node.key.compareTo(key) == 0) {
            node = new Node();
            node.key = key;
            node.value = value;
        } else if (node.key.compareTo(key) < 0) {
            node.right = put(node.right, key, value);
        } else {
            node.left = put(node.left, key, value);
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    private int size(Node node) {
        if (node == null) return 0;
        return node.size;
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
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) return null;
        else if (node.key.compareTo(key) < 0) {
            node.right = delete(node.right, key);
        } else if (node.key.compareTo(key) > 0) {
            node.left = delete(node.left, key);
        } else if (node.key.compareTo(key) == 0) {
            if (node.left == null && node.right == null) return null;
            else if (node.left == null) return node = node.right;
            else if (node.right == null) return node = node.left;
            else {
                Node minRight = min(node.right);
                node = delete(node, minRight.key);
                node.key = minRight.key;
                node.value = minRight.value;
            }
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    private Node min(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    @Override
    public boolean contains(Key key) {
        Node current = root;
        while (current != null) {
            if (current.key.compareTo(key) == 0) return true;
            else if (current.key.compareTo(key) < 0) current = current.right;
            else current = current.left;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return size(root);
    }

    @Override
    public Iterable<Key> keys() {
        List<Key> keys = new ArrayList<>();
        inOrder(keys, root);
        return keys;
    }

    private void inOrder(List<Key> keys, Node node) {
        if (node == null) return;
        inOrder(keys, node.left);
        keys.add(node.key);
        inOrder(keys, node.right);
    }

    @Override
    public Key min() {
        if (root == null) return null;
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.key;
    }

    @Override
    public Key max() {
        if (root == null) return null;
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.key;
    }

    @Override
    public Key floor(Key key) {
        Node floorNode = floor(root, key);
        if (floorNode != null) return floorNode.key;
        return null;
    }

    private Node floor(Node node, Key key) {
        if (node == null) return null;
        else if (node.key.compareTo(key) == 0) return node;
        else if (node.key.compareTo(key) > 0) return floor(node.left, key);
        else {
            Node rightFloor = floor(node.right, key);
            if(rightFloor != null) return rightFloor;
            else return node;
        }
    }

    @Override
    public Key ceiling(Key key) {
        Node ceilingNode = ceiling(root, key);
        if(ceilingNode != null) return ceilingNode.key;
        return null;
    }

    private Node ceiling(Node node, Key key) {
        if (node == null) return null;
        else if (node.key.compareTo(key) == 0) return node;
        else if (node.key.compareTo(key) < 0) return ceiling(node.right, key);
        else {
            Node leftCeiling = ceiling(node.left, key);
            if(leftCeiling != null) return leftCeiling;
            else return node;
        }
    }

    @Override
    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node node, Key key) {
        if(node == null) return 0;
        else if(node.key.compareTo(key) == 0) return size(node.left);
        else if(node.key.compareTo(key) < 0) return size(node.left) + rank(node.right, key) + 1;
        else return rank(node.left, key);
    }

    @Override
    public Key select(int k) {
        return select(root, k);
    }

    private Key select(Node node, int k) {
        if (node == null) return null;
        else if(node.size < k + 1 ) return null;
        else if(size(node.left) == k) return node.key;
        else if(size(node.left) >= k + 1) return select(node.left, k);
        else return select(node.right, k - 1 - size(node.left));
    }

    @Override
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if(node == null) return null;
        if(node.left == null) return node.right;
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node node) {
        if(node == null) return null;
        if(node.right == null) return node.left;
        node.right = deleteMax(node.right);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public int size(Key lo, Key hi) {
        return size(root, lo, hi);
    }

    private int size(Node node, Key lo, Key hi) {
        if(node == null) return 0;
        else if(node.key.compareTo(lo) < 0) return size(node.right, lo, hi);
        else if(node.key.compareTo(hi) > 0) return size(node.left, lo, hi);
        else return size(node.left, lo, hi) + 1 + size(node.right, lo, hi);
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        List<Key> keys = new ArrayList<>();
        inOrder(keys, root, lo, hi);
        return keys;
    }

    private void inOrder(List<Key> keys, Node node, Key lo, Key hi) {
        if(node == null) return;
        else if(node.key.compareTo(lo) < 0) inOrder(keys, node.right, lo, hi);
        else if(node.key.compareTo(hi) > 0) inOrder(keys, node.left, lo, hi);
        inOrder(keys, node.left, lo, hi);
        keys.add(node.key);
        inOrder(keys, node.right, lo, hi);
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

    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int size;
        private int level;
    }
}
