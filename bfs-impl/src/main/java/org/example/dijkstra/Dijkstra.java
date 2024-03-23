package org.example.dijkstra;

import java.util.*;

public class Dijkstra {

    public static void main(String[] args) {
        Node nodeParis = new Node("Paris");
        Node nodeNewYork = new Node("New York");
        Node nodeRome = new Node("Rome");
        Node nodeMilan = new Node("Milan");
        Node nodeTelAviv = new Node("Tel Aviv");
        Node nodeYerushalayim = new Node("Yerushalayim");

        nodeParis.addDestination(nodeYerushalayim, 200);
//        nodeParis.addDestination(nodeYerushalayim, 350);
        nodeParis.addDestination(nodeRome, 200);

//        nodeNewYork.addDestination(nodeMilan, 400);
        nodeNewYork.addDestination(nodeTelAviv, 500);
//        nodeNewYork.addDestination(nodeRome, 450)

        nodeMilan.addDestination(nodeYerushalayim, 500);
        nodeMilan.addDestination(nodeNewYork, 400);
//        nodeMilan.addDestination(nodeNewYork, 400);
//        nodeMilan.addDestination(nodeYerushalayim, 500);

        nodeRome.addDestination(nodeMilan, 150);
        nodeRome.addDestination(nodeNewYork, 450);
//        nodeRome.addDestination(nodeParis, 200);

        nodeTelAviv.addDestination(nodeNewYork, 500);

        nodeYerushalayim.addDestination(nodeMilan, 500);
//        nodeYerushalayim.addDestination(nodeParis, 200);
        nodeYerushalayim.addDestination(nodeParis, 350);

        Graph graph = new Graph();

        graph.addNode(nodeParis);
        graph.addNode(nodeNewYork);
        graph.addNode(nodeMilan);
        graph.addNode(nodeRome);
        graph.addNode(nodeTelAviv);
        graph.addNode(nodeYerushalayim);

        Graph result = Dijkstra.calculateShortestPathFromSource(graph, nodeParis);
        Set<Node> nodes = result.getNodes();

        for(Node n : nodes) {
            System.out.println("From: " + n.getName());
            Integer total = n.getDistance();
            for (Node shortPath : n.getShortestPath().reversed()) {
                System.out.println("Visited: " + shortPath.getName() + " with distance: " + (total - shortPath.getDistance()));
            }
            System.out.println();
        }

    }

    public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (!unsettledNodes.isEmpty()) {
            // node with the smallest distance from a set of unsettled nodes
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            StringBuilder sb = new StringBuilder();
            // for-each by adjacent nodes and calculate minimum distance
            for (Map.Entry<Node, Integer> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
                // to get node distance evaluation
                Node adjacentNode = adjacencyPair.getKey();
                // get edge weight
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    // to set the shortest path to adjacentNode
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            // add visited current node
            settledNodes.add(currentNode);
        }
        return graph;
    }

    private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        // infinity distance simulation to other node
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node : unsettledNodes) {
            int nodeDistance = node.getDistance();
            // to find the lowest distance
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;

    }

    private static void calculateMinimumDistance(Node evaluationNode,
                                                 Integer edgeWeight, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        // if distance with weight less then evaluation distance
        if (sourceDistance + edgeWeight < evaluationNode.getDistance()) {
            // node set distance with weight
            evaluationNode.setDistance(sourceDistance + edgeWeight);
            List<Node> shortestPath = new ArrayList<>(sourceNode.getShortestPath());
            // add source node to the shortest path
            shortestPath.add(sourceNode);
            // evaluation node set shortest path
            evaluationNode.setShortestPath(shortestPath);
        }
    }
}