import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            int u = time[0]; // Source node
            int v = time[1]; // Target node
            int w = time[2]; // Time (weight)
            graph.computeIfAbsent(u, x -> new ArrayList<>()).add(new int[]{v, w});
        }
        int[] dist = new int[n + 1]; 
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, k}); 
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int timeTaken = current[0];
            int u = current[1];
            if (timeTaken > dist[u]) {
                continue;
            }
            if (graph.containsKey(u)) {
                for (int[] neighbor : graph.get(u)) {
                    int v = neighbor[0]; 
                    int travelTime = neighbor[1]; 
                    if (dist[u] + travelTime < dist[v]) {
                        dist[v] = dist[u] + travelTime;
                        pq.offer(new int[]{dist[v], v});
                    }
                }
            }
        }
        int maxDelay = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; // Not all nodes can receive the signal
            }
            maxDelay = Math.max(maxDelay, dist[i]);
        }

        return maxDelay;
    }
}
