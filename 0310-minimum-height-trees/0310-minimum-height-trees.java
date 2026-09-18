class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int[] indegree = new int[n];

        ArrayList<Integer> ans = new ArrayList<Integer>();

        if(n <= 1){
            ans.add(0);
            return ans;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            indegree[u]++;
            indegree[v]++;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for(int i = 0; i < n; i++){
            if(indegree[i] == 1){
               q.offer(i);
            }
        }


        while(n > 2){
            int size = q.size();
            n -= size;
            while(size-- > 0){
                int u = q.poll();
                for(int v : adj.get(u)){
                    indegree[v]--;
                    if(indegree[v] == 1){
                        q.offer(v);
                    }
                }
            }
        }
      
    
        while(!q.isEmpty()){
            ans.add(q.poll());
        }

        return ans;
    }
}