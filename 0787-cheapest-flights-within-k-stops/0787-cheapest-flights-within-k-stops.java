class Pair{
    int dest;
    int cost;
    Pair(int dest,int cost){
        this.dest = dest;
        this.cost = cost;
    }
}

class Tuple{
    int k;
    int node;
    int cost;
    Tuple(int k,int node,int cost){
        this.k = k;
        this.node = node;
        this.cost = cost;
    }
}


class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
    // Create n adjacency lists
for(int i = 0; i < n; i++){
    adj.add(new ArrayList<>());
}

// Add flights
for(int i = 0; i < flights.length; i++){
    int u = flights[i][0];
    int v = flights[i][1];
    int price = flights[i][2];

    adj.get(u).add(new Pair(v, price));
}
       Queue<Tuple> q = new LinkedList<>();
       int[] dest = new int[n];
       for(int i = 0; i < n; i++){
         dest[i] = Integer.MAX_VALUE;
       }

       dest[src] = 0;
       q.offer(new Tuple(0,src,0));

       while(!q.isEmpty()){
           Tuple tp = q.poll();
           int stops = tp.k;
           int cost = tp.cost;
           int u = tp.node;
           for(Pair v : adj.get(u)){
               int wt = v.cost;
               int destination = v.dest;
               if(stops > k) continue;
               if(cost + wt < dest[destination] && stops <= k){
                   dest[destination] = cost + wt; 
                   q.offer(new Tuple(stops + 1,destination,cost + wt));
               }
           }
       }
          if(dest[dst] == Integer.MAX_VALUE){
              return -1;
           }
           return dest[dst];
    }
}