package com.raj.graph;
import java.util.*;
import java.util.stream.Collectors;

class Node<T> {
    T data;
    List<Node<T>> edges;

    public Node(T data){
        this.data = data;
        this.edges = new LinkedList<>();
    }

    public void addEdge(Node<T> edge){
        edges.add(edge);
    }

    @Override
    public String toString(){
        String output = "";
        for(int i= 0 ; i<edges.size(); i++){
            output += edges.get(i).data.toString(); 
        }
        output = this.data.toString() + " - - > "+ output;
        return output;
    }
    
}

public class Graph<T>{
    List<Node<T>> nodes = new LinkedList<>();
    
    public void add(T value){
        Node<T> node = new Node<T>(value);
        boolean match = nodes.stream().anyMatch(x -> x.data == value);
        if(!match)
            nodes.add(node);
    }
    public Graph(){
    }

    public Node<T> connectTwoNodes(T fromNode, T toNode){
        Optional<Node<T>> node_1 = getNode(fromNode);
        Optional<Node<T>> node_2 = getNode(toNode);
        if(node_1.isPresent() && node_2.isPresent()){
            node_1.get().addEdge(node_2.get());
            return node_1.get();
        }
        return null;
        
    }

    public boolean pathExists(T fromNode, T toNode){
        Optional<Node<T>> node_1 = getNode(fromNode);
        Optional<Node<T>> node_2 = getNode(toNode);
        if(!node_1.isPresent() || !node_2.isPresent()){
            return false;
        }
        return node_1.get().edges.stream().anyMatch(x -> x == node_2.get());
    }

    @Override
    public String toString(){
        String output = "";
        for(int i=0;i<nodes.size();i++){
            output += nodes.get(i).toString()+"\n";
        }
        return output;
    }

    public Optional<Node<T>> getNode(T node){
        for(int i = 0; i < nodes.size(); i++){
            if(nodes.get(i).data.equals(node)){
                return Optional.of(nodes.get(i));
            }
        }
        return Optional.empty();
    }

    public  boolean edgeExists(T root, T edge){
        Optional<Node<T>> node = getNode(root);
        Optional<Node<T>> edgeNode = getNode(edge);
        if(node.isPresent() && edgeNode.isPresent()){
            return node.get().edges.contains(edgeNode.get());
        }
        return false;
    }

}