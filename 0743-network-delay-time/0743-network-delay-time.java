class Pair{
    int dist;
    int v;
    Pair(int dist,int v){
        this.dist = dist;
        this.v = v;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(
    (a, b) -> Integer.compare(a.dist, b.dist)
);
            for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new Pair(wt, v));
        }
        int[] result = new int[n + 1];
        Arrays.fill(result,Integer.MAX_VALUE);

        result[k] = 0;
        pq.offer(new Pair(0,k));

        while(!pq.isEmpty()){
            Pair top = pq.poll();
            int d = top.dist;
            int u = top.v;
            for(Pair newDest : adj.get(u)){
                int dist = newDest.dist;
                int v = newDest.v;
                if(d + dist < result[v]){
                    result[v] = d + dist;
                    pq.offer(new Pair(d + dist,v));
                }
            }
        }

        int ans = Integer.MIN_VALUE;

        for(int i = 1; i <= n; i++){
            ans = Math.max(ans,result[i]);
        }

        return ans != Integer.MAX_VALUE ? ans : - 1;
    }
}