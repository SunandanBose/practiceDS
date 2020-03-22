package com.raj.graph;
import java.util.*;

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

    private Optional<Node<T>> getNode(T node){
        for(int i = 0; i < nodes.size(); i++){
            if(nodes.get(i).data.equals(node)){
                return Optional.of(nodes.get(i));
            }
        }
        return Optional.empty();
    }

}