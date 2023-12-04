package com.sunandan.tree;

import java.util.HashMap;
import java.util.Map;

public class CloneBinaryTree {

    private Map<RandomNodeTree, RandomNodeTree> cache = null;

    public RandomNodeTree cloneTree(RandomNodeTree tree) {
        cache = new HashMap<>();
        copy(tree);
        copyNextAndRandom(tree);
        return cache.get(tree);
    }

    public void copy(RandomNodeTree tree) {
        if (tree == null) return;
        cache.put(tree, new RandomNodeTree(tree.data));
        copy(tree.left);
        copy(tree.right);
    }

    public void copyNextAndRandom(RandomNodeTree tree) {
        if (tree == null) return;
        cache.get(tree).left = cache.get(tree.left);
        cache.get(tree).right = cache.get(tree.right);
        cache.get(tree).random = cache.get(tree.random);
        copyNextAndRandom(tree.left);
        copyNextAndRandom(tree.right);
    }

}
