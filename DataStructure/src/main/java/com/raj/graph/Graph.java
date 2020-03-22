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
        Node<T> node_1 = getNode(fromNode);
        Node<T> node_2 = getNode(toNode);
        if(node_1 != null && node_2 != null){
            node_1.addEdge(node_2);
            return node_1;
        }
        return null;
        
    }

    private Node<T> getNode(T node){
        for(int i = 0; i < nodes.size(); i++){
            if(nodes.get(i).data.equals(node)){
                return nodes.get(i);
            }
        }
        return null;
    }

    @Override
    public String toString(){
        String output = "";
        for(int i=0;i<nodes.size();i++){
            output += nodes.get(i).toString()+"\n";
        }
        return output;
    }

}