package org.example.dijkstra;

import java.util.*;

public class Node {

    private String name;

    // shortest path
    private List<Node> shortestPath = new ArrayList<>();

    // infinity distance simulation to other node
    private Integer distance = Integer.MAX_VALUE;

    // to associate adjacent nodes with edge length
    Map<Node, Integer> adjacentNodes = new HashMap<>();

    // add destination to.addDestination(from, distance)
    // example nodeYerushalayim.addDestination(nodeParis, 350);
    public void addDestination(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Node{" + "name='" + name + '\'');
        if (!shortestPath.isEmpty()) result.append(", shortestPath=").append(shortestPath);
        if (!distance.equals(0)) result.append(", distance=").append(distance);
        result.append('}');
        return result.toString();

    }
}
