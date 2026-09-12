class Node {
    long score = 0;
    List<Integer> idx;

    Node() {
        idx = new ArrayList<>();
    }
}

class Solution {

    int n;
    int[] nextIdx;
    Node[][] dp;

    int findNextIdx(List<List<Integer>> intervals, int target) {

        int l = 0;
        int r = intervals.size() - 1;

        int result = intervals.size();

        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (intervals.get(mid).get(0) > target) {
                result = mid;
                r = mid - 1;
            } 
            else {
                l = mid + 1;
            }
        }

        return result;
    }

    int compareLists(List<Integer> a, List<Integer> b) {

        int minLen = Math.min(a.size(), b.size());

        for (int i = 0; i < minLen; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return Integer.compare(a.get(i), b.get(i));
            }
        }

        return Integer.compare(a.size(), b.size());
    }

    Node solve(List<List<Integer>> intervals, int i, int k) {

        if (k == 0 || i >= n) {
            return new Node();
        }

        if (dp[i][k] != null) {
            return dp[i][k];
        }
        // Skip current interval
        Node skip = solve(intervals, i + 1, k);

        // Take current interval
        int j = nextIdx[i];

        int wt = intervals.get(i).get(2);
        int idx = intervals.get(i).get(3);

        Node temp = solve(intervals, j, k - 1);

        Node take = new Node();

        take.score = wt + temp.score;

        // Copy temp's indices
        take.idx = new ArrayList<>(temp.idx);

        // Add current interval
        take.idx.add(idx);

        // We need indices in sorted order for lexicographical comparison
        Collections.sort(take.idx);

        Node result;

        if (skip.score > take.score) {
            result = skip;
        }
        else if (skip.score < take.score) {
            result = take;
        }
        else {
            // Choose lexicographically smaller list
            result = compareLists(take.idx, skip.idx) < 0
                    ? take
                    : skip;
        }

        return dp[i][k] =  result;
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        n = intervals.size();

        nextIdx = new int[n];

        dp = new Node[n + 1][5];

        // for(int i = 0; i < n; i++){
        //     Arrays.fill(dp, - 1);
        // }

        // Add original index
        for (int i = 0; i < n; i++) {
            intervals.get(i).add(i);
        }

        // Sort by start time
        intervals.sort(
            (a, b) -> Integer.compare(a.get(0), b.get(0))
        );

        // Find next non-overlapping interval
        for (int i = 0; i < n; i++) {

            nextIdx[i] = findNextIdx(
                intervals,
                intervals.get(i).get(1)
            );
        }

        List<Integer> ans = solve(intervals, 0, 4).idx;

        return ans.stream()
                   .mapToInt(Integer::intValue)
                   .toArray();
    }
}