class Solution {
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // If the node was already cloned, return its clone.
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Clone the node.
        Node clone = new Node(node.val, new ArrayList<>());
        visited.put(node, clone);

        // Clone all the neighbors recursively.
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}
