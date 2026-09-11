class Solution {
    boolean dfs(ArrayList<ArrayList<Integer>> adj,int u,int v,boolean[] vis){
        if(u == v) return true;
        vis[u] = true;
        for(int nei : adj.get(u)){
            if(!vis[nei]){
                if(dfs(adj,nei,v,vis)){
                    return true;
                }
            }
        }
        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        // n + 1 because nodes are 1-based
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            boolean[] vis = new boolean[n + 1];

            if(dfs(adj,u,v,vis)){
                return new int[] {u,v};
            }

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return new int[] {};
    }
}