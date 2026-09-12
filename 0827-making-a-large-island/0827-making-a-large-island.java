class DSU{
    int[] parent;
    int[] size;
    DSU(int n){
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    int find(int x){
        if(x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    void unionSize(int u,int v){
        int up = find(u);
        int vp = find(v);
        if(up == vp) return;
        if(size[up] < size[vp]){
            parent[up] = vp;
            size[vp] += size[up];
        }else if(size[vp] < size[up]){
            parent[vp] = up;
            size[up] += size[vp];
        }else{
            parent[up] = vp;
            size[vp] += size[up];
        }
    }
}
class Solution {
    boolean isValid(int row,int col,int n){
        return row >= 0 && row < n && col >= 0 && col < n;
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DSU ds = new DSU(n * n);

        int cnt = 0;

        //step1 - Connect All the Component
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == 0) continue;
                int[] rd = {-1, 0, 1, 0};
                int[] cd = {0, 1, 0, -1};
                for(int i = 0; i < 4; i++){
                    int nr = row + rd[i];
                    int nc = col + cd[i];
                    if(isValid(nr,nc,n) && grid[nr][nc] == 1){
                        int noOfNode = row * n + col;
                        int adjNodeNo = nr * n + nc;
                        ds.unionSize(noOfNode,adjNodeNo);
                    }
                }      
            }
        }

        int result = Integer.MIN_VALUE;

        //step2 - try to convert every 0 to 1 and check size
           for(int row = 0; row < n; row++){
                for(int col = 0; col < n; col++){
                if(grid[row][col] == 0) {
                    int[] rd = {-1, 0, 1, 0};
                    int[] cd = {0, 1, 0, -1};
                    Set<Integer> st = new HashSet<>();
                    for(int i = 0; i < 4; i++){
                        int nr = row + rd[i];
                        int nc = col + cd[i];
                        if(isValid(nr,nc,n) && grid[nr][nc] == 1){
                            int adjNodeNo = nr * n + nc;
                            int adjNodeNoParent = ds.find(adjNodeNo);
                            st.add(adjNodeNoParent);
                        }
                    } 
                    int total = 0;
                    for(int comp : st){
                        total += ds.size[comp];
                    }
                    result = Math.max(result,total + 1);
               }
            }
        }

        for(int cell = 0; cell < n * n; cell++){
            result = Math.max(result,ds.size[ds.find(cell)]);
        }
        return result;
}
}