package com.raj.graph;

import java.util.*;
import java.util.stream.Collectors;

class Node<T> {
    T data;
    List<Node<T>> children;

    public Node(T data) {
        this.data = data;
        this.children = new LinkedList<>();
    }

    public void addEdge(Node<T> edge) {
        children.add(edge);
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < children.size(); i++) {
            output += children.get(i).data.toString();
        }
        output = this.data.toString() + " - - > " + output;
        return output;
    }

}

public class Graph<T> {
    List<Node<T>> nodes = new LinkedList<>();

    public Graph() {
    }

    public List<T> getNodes() {
        return nodes.stream().map(x -> x.data).collect(Collectors.toList());
    }

    public void add(T value) {
        Node<T> node = new Node<T>(value);
        boolean match = nodes.stream().anyMatch(x -> x.data == value);
        if (!match)
            nodes.add(node);
    }



    public Node<T> connectTwoNodes(T fromNode, T toNode) {
        Optional<Node<T>> node_1 = getNode(fromNode);
        Optional<Node<T>> node_2 = getNode(toNode);
        if (node_1.isPresent() && node_2.isPresent()) {
            node_1.get().addEdge(node_2.get());
            return node_1.get();
        }
        return null;
    }

    public void disconnectTwoNodes(T fromNode, T toNode) {
        Optional<Node<T>> node_1 = getNode(fromNode);
        Optional<Node<T>> node_2 = getNode(toNode);
        if (!node_1.isPresent() || !node_2.isPresent()) {
            return;
        }
        removeNodeEdge(node_1.get(), toNode);
    }

    private void removeNodeEdge(Node<T> node, T edgeToRemove) {
        List<Node<T>> edges = node.children;
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).data == edgeToRemove) {
                edges.remove(i);
            }
        }
    }


    private boolean pathExists(T fromNode, T toNode, Set<T> visited) {
        Optional<Node<T>> node_1 = getNode(fromNode);
        Optional<Node<T>> node_2 = getNode(toNode);
        if (!node_1.isPresent() || !node_2.isPresent()) {
            return false;
        }
        // TODO: This line is untested.
        visited.add(fromNode);
        if (edgeExists(fromNode, toNode)) {
            return true;
        }

        List<Node<T>> edges = getNode(fromNode).get().children;
        for (int i = 0; i < edges.size(); i++) {
            if (!isVisited(edges.get(i).data, visited)) {
                if (pathExists(edges.get(i).data, toNode, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isVisited(T node, Set<T> visited) {
        return visited.contains(node);
    }


    public boolean pathExists(T fromNode, T toNode) {
        Set<T> visitedList = new HashSet<>();
        return pathExists(fromNode, toNode, visitedList);
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < nodes.size(); i++) {
            output += nodes.get(i).toString() + "\n";
        }
        return output;
    }

    public Optional<Node<T>> getNode(T node) {
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).data.equals(node)) {
                return Optional.of(nodes.get(i));
            }
        }
        return Optional.empty();
    }

    public boolean edgeExists(T root, T edge) {
        Optional<Node<T>> node = getNode(root);
        Optional<Node<T>> edgeNode = getNode(edge);
        if (node.isPresent() && edgeNode.isPresent()) {
            return node.get().children.contains(edgeNode.get());
        }
        return false;
    }

    public List<T> getPath(T fromNode, T toNode) {
        Set<T> visitedList = new HashSet<>();
        List<T> path = getPath(fromNode,toNode,visitedList);
        return path;
    }

    private List<T> getPath(T fromNode, T toNode, Set<T> visited){
        Optional<Node<T>> node_1 = getNode(fromNode);
        Optional<Node<T>> node_2 = getNode(toNode);
        List<T> path = new ArrayList<>();
        path.add(fromNode);
        if (!node_1.isPresent() || !node_2.isPresent()) {
            return Collections.emptyList();
        }
        visited.add(fromNode);
        if (edgeExists(fromNode, toNode)) {
            path.addAll(Collections.singletonList(toNode));
            return path;
        }

        List<Node<T>> edges = getNode(fromNode).get().children;
        for (int i = 0; i < edges.size(); i++) {
            if (!isVisited(edges.get(i).data, visited)) {
                path.addAll(getPath(edges.get(i).data, toNode, visited));
                if(path.get(path.size()-1) == toNode)
                    return path;
            }
        }
        return Collections.emptyList();
    }

    public List<T> getEdgeList(T value){
        Optional<Node<T>> node = getNode(value);
        return node.get().children.stream().map(x -> x.data).collect(Collectors.toList());

    }
}