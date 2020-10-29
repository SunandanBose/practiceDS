package com.sunandan.tree;

public class SubtreeOfAnotherTree {

    public boolean isSubtree(Node T, Node S) {
        if(T == null)
            return false;
        if(compare(T, S)){
            return true;
        }
        return isSubtree(T.left, S) || isSubtree(T.right, S);
    }

    private boolean compare(Node T, Node S){
        if(S == null && T != null)
            return false;
        if(S == null)
            return true;
        if(T == null || T.data != S.data)
            return false;
        boolean left = compare(T.left, S.left);
        boolean right = compare(T.right, S.right);
        return left && right;
    }

}
