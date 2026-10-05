class Pair{
    int x;
    int y;
    int dist;
    Pair(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

class Solution {
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

        if(rank[p_x] > rank[p_y]){
           parent[p_y] = p_x;
        }else if(rank[p_x] < rank[p_y]){
           parent[p_x] = p_y;
        }else{
           parent[p_y] = p_x;
           rank[p_x] = rank[p_x] + 1; 
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int V = points.length;
        parent = new int[V];
        rank = new int[V];
        
        for(int i = 0; i < V; i++){
            parent[i] = i;
        }

        ArrayList<Pair> edges = new ArrayList<>();
        
        for(int i = 0; i < V; i++){
            for(int j = i + 1; j < V; j++){
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                int d = Math.abs(x1 - x2) + Math.abs(y1 - y2);

               edges.add(new Pair(i, j, d));
            }
        }

        Collections.sort(edges,(a,b)->Integer.compare(a.dist,b.dist));
        int sum = 0;
        int count = 0;
        for (Pair edge : edges) {

            int x = edge.x;
            int y = edge.y;
            int dist = edge.dist;
             
             int parent_x = find(x);
             int parent_y = find(y);

             if(parent_x != parent_y){
                union(x,y);
                sum += dist;
                count++;

                // MST has V - 1 edges
                if (count == V - 1) {
                    break;
                }
             }
        }
        return sum;
    }
}