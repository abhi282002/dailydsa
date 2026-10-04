class Solution {
    // boolean dfs(ArrayList<ArrayList<Integer>> adj,int u,int v,boolean[] vis){
    //     if(u == v) return true;  //u == v when we reach from u to v means we have connection
    //     vis[u] = true;
    //     for(int nei : adj.get(u)){
    //         if(!vis[nei]){
    //             if(dfs(adj,nei,v,vis)){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }
    int[] parent;
    int[] rank;
    int find(int x){
        if(x == parent[x]) return x;

       return parent[x] = find(parent[x]);
    }
    void union(int x, int y){
        int p_x = find(x);
        int p_y = find(y);
        if(p_x == p_y) return;
        if (rank[p_x] < rank[p_y]){
            parent[p_x] = p_y;
        }else if(rank[p_x] > rank[p_y]){
             parent[p_y] = p_x;
        }else{
            parent[p_x] = p_y;
            rank[p_y] = rank[p_y] + 1;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        // n + 1 because nodes are 1-based
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        parent = new int[n + 1];
        rank = new int[n + 1];

        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }

         for(int i = 0; i < n; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            //check if u and v are connected then there parent must be same so we can discard that u,v
            if(find(u) == find(v)){
               return new int[] {u,v};
            }
            union(u,v);
        }
        return new int[] {};
        // for(int i = 0; i < n; i++){
        //     int u = edges[i][0];
        //     int v = edges[i][1];

        //     boolean[] vis = new boolean[n + 1];

        //     //check u and v are in the graph or not if yes then check can we rearch u->v 
        //     if(adj.get(u) != null && adj.get(v) != null && dfs(adj,u,v,vis)){
        //         return new int[] {u,v};
        //     }

        //     adj.get(u).add(v);
        //     adj.get(v).add(u);
        // }

        // return new int[] {};
    }
}