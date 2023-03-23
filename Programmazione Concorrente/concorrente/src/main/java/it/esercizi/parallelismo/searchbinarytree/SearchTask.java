package it.esercizi.parallelismo.searchbinarytree;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SearchTask implements Runnable{

    private Node node;
    private int value;
    boolean found;

    public SearchTask(Node node, int value) {
        this.node = node;
        this.value = value;
        found = false;
    }

    @Override
    public void run() {
        if (node == null) {
            return;
        }
        if (node.value == value) {
            found = true;
            return;
        }
        if (node.left != null) {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            SearchTask task = new SearchTask(node.left, value);
            executor.submit(task);
            executor.shutdown();
            while (!executor.isTerminated()) {}
            if (task.found) {
                found = true;
                return;
            }
        }
        if (node.right != null) {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            SearchTask task = new SearchTask(node.right, value);
            executor.submit(task);
            executor.shutdown();
            while (!executor.isTerminated()) {}
            if (task.found) {
                found = true;
                return;
            }
        }
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(3);
        root.left.right = new Node(8);
        root.right.left = new Node(15);
        root.right.right = new Node(25);

        BinaryTreeSearch search = new BinaryTreeSearch(root);
        int value = 8;
        int numThreads = 2;
        boolean found = search.search(value, numThreads);
        if (found) {
            System.out.println("Value " + value + " found.");
        } else {
            System.out.println("Value " + value + " not found.");
        }
    }
}
