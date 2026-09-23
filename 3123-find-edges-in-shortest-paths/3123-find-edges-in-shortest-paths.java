class Pair{
    int w;
    int v;
    Pair(int w,int v){
        this.v = v;
        this.w = w;
    }
}
class Solution {
    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
int[] dijkstra(int n, int source) {

   PriorityQueue<Pair> pq =
    new PriorityQueue<>((a, b) -> Integer.compare(a.w, b.w));

    int[] dist = new int[n];
    boolean[] vis = new boolean[n];

    Arrays.fill(dist, Integer.MAX_VALUE);

    dist[source] = 0;

    pq.offer(new Pair(0, source));

    while (!pq.isEmpty()) {

        Pair p = pq.poll();

        int u = p.v;
        int wt = p.w;

        // If already processed, skip
        if (vis[u]) continue;

        vis[u] = true;

        for (Pair d : adj.get(u)) {

            int v = d.v;
            int edgeWt = d.w;

            if (wt + edgeWt < dist[v]) {
                dist[v] = wt + edgeWt;
                pq.offer(new Pair(dist[v], v));
            }
        }
    }

    return dist;
}

    public boolean[] findAnswer(int n, int[][] edges) {
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<Pair>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new Pair(w,v));
            adj.get(v).add(new Pair(w,u));
        }
 

        int[] fromSource = dijkstra(n, 0);
        int[] fromDest = dijkstra(n,n - 1);
        boolean[] result = new boolean[edges.length];
        Arrays.fill(result,false);

        for(int E = 0; E < edges.length; E++){
            int u = edges[E][0];
            int v = edges[E][1];
            int wt = edges[E][2];

            // int distFromSource = fromSource[u];
            // int distFromDest = fromDest[v];

       if (fromSource[u] != Integer.MAX_VALUE &&
    fromDest[v] != Integer.MAX_VALUE &&
    fromSource[u] + wt + fromDest[v] == fromSource[n - 1]) {
    
    result[E] = true;
}
            
            // distFromSource = fromSource[v];
            // distFromDest = fromDest[u];
            
     if (fromSource[v] != Integer.MAX_VALUE &&
    fromDest[u] != Integer.MAX_VALUE &&
    fromSource[v] + wt + fromDest[u] == fromSource[n - 1]) {
    
    result[E] = true;
}
        }
        
        return result;

    } 
}