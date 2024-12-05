package testtasks.two;

import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;


public class TaskTwo {
    public static void computePaths(Vertex source) {
        source.setMinDistance(0);
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Edge e : u.getAdjacencies()) {
                Vertex v = e.getTarget();
                int weight = e.getWeight();
                int distanceThroughU = u.getMinDistance() + weight;
                if (distanceThroughU < v.getMinDistance()) {
                    vertexQueue.remove(v);

                    v.setMinDistance(distanceThroughU);
                    v.setPrevious(u);
                    vertexQueue.add(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        // mark all the vertices
        List<Vertex> vertices = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int s = Integer.parseInt(input.nextLine());
        Map<Integer, List<CustomEdge>> edgesByCity = new HashMap<>();
        // the number of tests
        for (int i = 0; i < s; i++) {
            int n = Integer.parseInt(input.nextLine());
            // the number of cities
            for (int l = 0; l < n; l++) {
                // city NAME
                String city = input.nextLine();
                Vertex vertex = new Vertex(city);
                vertices.add(vertex);
                // the number of neighbors of city NAME
                int p = Integer.parseInt(input.nextLine());
                for (int j = 0; j < p; j++) {
                    // [nr - index of a city connected to NAME (the index of the first city is 1)]
                    // [cost - the transportation cost]
                    String nr = input.nextLine();
                    int vertexIndex = Integer.parseInt(nr.split(" ")[0]);
                    int vertexWeight = Integer.parseInt(nr.split(" ")[1]);
                    edgesByCity.computeIfAbsent(l + 1, r -> new ArrayList<>()).add(new CustomEdge(vertexIndex, vertexWeight));
                }

            }
            // the number of paths to find
            int r = Integer.parseInt(input.nextLine());
            edgesByCity.forEach((k, v) -> {
                int idx = k - 1;
                Vertex vertex = vertices.get(idx);
                vertex.setAdjacencies(v.stream()
                        .map(e -> new Edge(vertices.get(e.getVertexIndex()-1), e.getWeight()))
                        .collect(Collectors.toList()));
            });
            // NAME1 NAME2 [NAME1 - source, NAME2 - destination]
            for (int m = 0; m < r; m++) {
                String path = input.nextLine();
                String source = path.split(" ")[0];
                String destination = path.split(" ")[1];
                computePaths(Objects.requireNonNull(vertices.stream().filter(v -> v.getName().equalsIgnoreCase(source)).findAny().orElse(null)));
                Vertex dest = Objects.requireNonNull(vertices.stream().filter(v -> v.getName().equalsIgnoreCase(destination)).findAny().orElse(null));
                System.out.println(dest.getMinDistance());
            }
        }
    }
}
