class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = prerequisites.length;
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < V; i++){
                int a = prerequisites[i][0];
                int b = prerequisites[i][1];
                adj.get(b).add(a);
                indegree[a]++;
        }

        int count = 0;
        int[] ans = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
                count++;
            }
        }
        int i = 0;
        while(!q.isEmpty()){
            int u = q.poll();
            ans[i++] = u;
            for(int v : adj.get(u)){
                 indegree[v]--;
                 if(indegree[v] == 0){
                    q.offer(v);
                    count++;
                 }
            }
        }
        if(count == numCourses){
           return ans;
        }
        return new int[] {};
    }
}