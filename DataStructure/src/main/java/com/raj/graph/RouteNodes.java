package com.raj.graph;

class RouteNodes{
    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        graph.add("a");
        graph.add("b"); 
        graph.add("c");
        graph.add("d");
        graph.add("e");

        graph.connectTwoNodes("a", "b");
        graph.connectTwoNodes("b", "c");
        graph.connectTwoNodes("d", "e");
        graph.connectTwoNodes("d", "b");
        graph.connectTwoNodes("e", "a");

        System.out.println(graph.pathExists("a", "b")); 
        System.out.println(graph.pathExists("a", "e")); 
        System.out.println(graph.pathExists("a", "z")); 
        System.out.println(graph.pathExists("x", "z")); 
        System.out.println(graph);

    }
}