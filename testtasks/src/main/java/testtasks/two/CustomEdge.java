package testtasks.two;

import java.util.Objects;

public class CustomEdge {

    private int vertexIndex;
    private int weight;

    public CustomEdge(int vertexIndex, int weight) {
        this.vertexIndex = vertexIndex;
        this.weight = weight;
    }

    public int getVertexIndex() {
        return vertexIndex;
    }

    public void setVertexIndex(int vertexIndex) {
        this.vertexIndex = vertexIndex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "CustomEdge{" +
                "vertexIndex=" + vertexIndex +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomEdge that = (CustomEdge) o;
        return vertexIndex == that.vertexIndex && weight == that.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertexIndex, weight);
    }
}
