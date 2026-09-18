class Solution {
    boolean checkBi(int u,ArrayList<ArrayList<Integer>> adj, int[] color, int currColor){
        color[u] = currColor;
        for(int v : adj.get(u)){
            if(color[v] == currColor) return false;

            if(color[v] == -1){
                if(checkBi(v,adj,color,1 - currColor) == false){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
         int V = graph.length;
         int[] color = new int[V];
         Arrays.fill(color, - 1);

         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

         for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
         }

       for(int u = 0; u < V; u++) {
            for(int v : graph[u]) {
                adj.get(u).add(v);
            }
        }


         for(int i = 0; i < V; i++){
             if(color[i] == -1){
                if(checkBi(i, adj ,color ,1) == false){
                    return false;
                }
             }
         }   

         return true;
    }
}