package testtasks.two;

import java.util.List;

public class Vertex implements Comparable<Vertex> {
    private final String name;
    private List<Edge> adjacencies;
    private int minDistance = Integer.MAX_VALUE;
    private Vertex previous;

    public Vertex(String argName) {
        name = argName;
    }

    public int compareTo(Vertex other) {
        return Integer.compare(minDistance, other.minDistance);
    }

    public String getName() {
        return name;
    }


    public int getMinDistance() {
        return minDistance;
    }

    public Vertex getPrevious() {
        return previous;
    }

    public List<Edge> getAdjacencies() {
        return adjacencies;
    }

    public void setAdjacencies(List<Edge> adjacencies) {
        this.adjacencies = adjacencies;
    }

    public void setMinDistance(int minDistance) {
        this.minDistance = minDistance;
    }

    public void setPrevious(Vertex previous) {
        this.previous = previous;
    }
}
