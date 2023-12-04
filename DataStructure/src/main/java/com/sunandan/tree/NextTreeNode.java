package com.sunandan.tree;

public class NextTreeNode {
    public int val;
    public NextTreeNode left;
    public NextTreeNode right;
    public NextTreeNode next;

    public NextTreeNode() {}

    public NextTreeNode(int _val) {
        val = _val;
    }

    public NextTreeNode(int _val, NextTreeNode _left, NextTreeNode _right, NextTreeNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};