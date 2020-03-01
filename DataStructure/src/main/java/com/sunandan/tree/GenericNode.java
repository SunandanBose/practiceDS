package com.sunandan.tree;

class GenericNode<T>{
    T data;
    GenericNode<T> right;
    GenericNode<T> left;
    GenericNode(T data){
        this.data = data;
    }
}
