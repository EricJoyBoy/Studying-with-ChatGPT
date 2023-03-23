package it.esercizi.parallelismo.searchbinarytree;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BinaryTreeSearch {
    private Node root;

    public BinaryTreeSearch(Node root) {
        this.root = root;
    }

    public boolean search(int value, int numThreads) {
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        SearchTask task = new SearchTask(root, value);
        executor.submit(task);
        executor.shutdown();
        while (!executor.isTerminated()) {}
        return task.found;
}
}