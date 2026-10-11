class Solution {
    List<List<Integer>> graph;
    Set<Integer> visited;

    public boolean validTree(int n, int[][] edges) {
        graph = new ArrayList<>();
        visited = new HashSet<>();

        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int edge[] : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        if(!dfs(0, -1)) 
            return false;
        
        return n == visited.size();
    }

    private boolean dfs(int node, int parent) {
        if(visited.contains(node))
            return false;
        
        visited.add(node);
        for(int nei : graph.get(node)) {
            if(nei == parent) 
                continue;
            
            if(!dfs(nei, node))
                return false;
        }

        return true;
    }
}
