package fundamentals.graphTheoryTraversalShortestPathsLab;

import java.util.*;

public class TopologicalSortingDFS {
    public static void main(String[] args) {

    }

    public static List<String> topSort(Map<String, List<String>> graph) {
        List<String> sorted = new ArrayList<>();

        Set<String> visited = new HashSet<>();
        Set<String> detectedCycles = new HashSet<>();

        for (Map.Entry<String, List<String>> node : graph.entrySet()) {
            dfs(node.getKey(), visited, graph, sorted, detectedCycles);
        }

        Collections.reverse(sorted);

        return sorted;
    }

    private static void dfs(String key, Set<String> visited, Map<String, List<String>> graph, List<String> sorted, Set<String> detectedCycles) {
        if (detectedCycles.contains(key)) {
            throw new IllegalArgumentException();
        }

        if (!visited.contains(key)) {
            visited.add(key);
            detectedCycles.add(key);

            for (String child : graph.get(key)) {
                dfs(child, visited, graph, sorted, detectedCycles);
            }

            detectedCycles.remove(key);
            sorted.add(key);
        }
    }
}
