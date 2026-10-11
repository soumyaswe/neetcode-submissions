class Solution {
    List<List<Integer>> graph;
    boolean visited[];

    public int countComponents(int n, int[][] edges) {
        graph = new ArrayList<>();
        visited = new boolean[n];

        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int edge[] : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int components = 0;

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(i);
                components++;
            }
        }

        return components;
    }

    private void dfs(int node) {
        visited[node] = true;

        for(int nei : graph.get(node)) {
            if(!visited[nei])
                dfs(nei);
        }
    } 
}
