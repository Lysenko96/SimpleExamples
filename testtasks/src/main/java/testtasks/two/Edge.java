package testtasks.two;

public class Edge {
    private final Vertex target;
    private final int weight;

    public Edge(Vertex argTarget, int argWeight) {
        target = argTarget;
        weight = argWeight;
    }

    public Vertex getTarget() {
        return target;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "target=" + target +
                ", weight=" + weight +
                '}';
    }
}
