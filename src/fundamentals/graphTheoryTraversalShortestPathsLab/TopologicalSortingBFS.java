package fundamentals.graphTheoryTraversalShortestPathsLab;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TopologicalSortingBFS {
    public static void main(String[] args) {

    }

    public static List<String> topSort(Map<String, List<String>> graph) {
        Map<String, Integer> getDependenciesCount = getDependenciesCount(graph);

        List<String> sorted = new ArrayList<>();

        while (!graph.isEmpty()) {
            String key = graph.keySet()
                    .stream()
                    .filter(k -> getDependenciesCount.get(k) == 0)
                    .findFirst()
                    .orElse(null);

            if (key == null) {
                break;
            }

            for (String child : graph.get(key)) {
                getDependenciesCount.put(child, getDependenciesCount.get(child) - 1);
            }

            sorted.add(key);
            graph.remove(key);
        }

        if (!graph.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return sorted;
    }

    public static Map<String, Integer> getDependenciesCount(Map<String, List<String>> graph) {
        Map<String, Integer> dependenciesCount = new LinkedHashMap<>();

        for (Map.Entry<String, List<String>> node : graph.entrySet()) {
            dependenciesCount.putIfAbsent(node.getKey(), 0);
            for (String child : node.getValue()) {
                dependenciesCount.putIfAbsent(child, 0);
                dependenciesCount.put(child, dependenciesCount.get(child) + 1);
            }
        }

        return dependenciesCount;
    }
}
