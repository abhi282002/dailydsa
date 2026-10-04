class Solution {
    List<List<Integer>> bridge;
    int timer;
    void dfs(int u, int parent, List<List<Integer>> adj, boolean[] vis, int[] tin, int[] low){
        vis[u] = true;
        low[u] = tin[u] = timer;
        timer++;
        for(int v : adj.get(u)){
            if(v == parent) continue;
            if(!vis[v]){
                dfs(v, u, adj, vis, tin, low);
                low[u] = Math.min(low[u], low[v]);  //update while returing v -> u whichever min time take into u
                //check for the bridge
                if(tin[u] < low[v]){
                    List<Integer> res = new ArrayList<>();
                    res.add(u);
                    res.add(v);

                    bridge.add(res);
                }

            }else{
                low[u] = Math.min(low[u], low[v]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        bridge = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        timer = 1;
        boolean[] vis = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
      for (List<Integer> connection : connections) {
        int u = connection.get(0);
        int v = connection.get(1);

         adj.get(u).add(v);
         adj.get(v).add(u);
       }   
        dfs(0, -1, adj, vis, tin, low);
        return bridge;
    }
}