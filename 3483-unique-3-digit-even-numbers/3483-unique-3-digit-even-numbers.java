class Solution {
    public int totalNumbers(int[] digits) {
        int count = 0;
     int n = digits.length;

    Map<Integer, Integer> mp = new HashMap<>();

    for (int digit : digits) {
        mp.put(digit, mp.getOrDefault(digit, 0) + 1);
    }

        for(int i = 1; i <= 9; i++){
            if(mp.getOrDefault(i,0) <= 0) continue;
             mp.put(i, mp.getOrDefault(i, 0) - 1);
             for(int j = 0; j <= 9; j++){
                if (mp.getOrDefault(j, 0) <= 0) continue;
                mp.put(j, mp.getOrDefault(j, 0) - 1);
                for(int k = 0; k <= 9; k++){
                    if(mp.getOrDefault(k,0) <= 0  || k % 2 != 0) continue;
                    mp.put(k, mp.getOrDefault(k, 0) - 1);
                    int digit = i * 100 + j * 10 + k;

                        count++;
                
                    mp.put(k, mp.getOrDefault(k, 0) + 1);
                }
                  mp.put(j, mp.getOrDefault(j, 0) + 1);
             }
             mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        return count;
    }
}