package com.lysenko;

import java.util.*;

public class App {
    static final int MAX_NODES = 256;

    public static int findLongestPath(List<int[]> graph, int n) {
        int min = 0;
        int k = 0;
        int counter = 0;
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < graph.size() - 1; i++) {

            int[] g = graph.get(i);
            min = Math.max(k, Math.min(g[0], g[1]));
            l.add(min);
            if (l.contains(min)) counter++;
        }
        return counter;
    }

    public static void main(String[] args) {
        // Get input froms stdin
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<int[]> edges = new ArrayList<>();
        int pos = 0;
        while ((pos = input.indexOf("(")) != -1) {
            int end_pos = input.indexOf(")", pos);
            String pair_str = input.substring(pos + 1, end_pos);
            String[] parts = pair_str.split(",");
            int[] edge = {Integer.parseInt(parts[0].trim()), Integer.parseInt(parts[1].trim())};
            edges.add(edge);
            input = input.substring(end_pos + 1);
        }

        int n = 0;
        for (int[] edge : edges) {
            n = Math.max(n, Math.max(edge[0], edge[1]));
        }
        n++;

        List<int[]> graph = edges;

        // Call candidate function
        int result = findLongestPath(graph, n);

        // Print result
        System.out.println(result);
    }
}
