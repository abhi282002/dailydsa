class Solution {
        List<String> res = new ArrayList<>();
        void solve(String curr, int n){
            if(curr.length() == 2 * n){
                if(isValid(curr)){
                    res.add(curr);
                }
                return;
            }
            solve(curr + "(", n);
            solve(curr + ")", n);
        }
        boolean isValid(String str){
            int count = 0;
            for(char c : str.toCharArray()){
                if(c == '(')
                    count++;
                else
                    count--;
                if(count < 0)
                    return false;
            }
            return count == 0;
        }
        public List<String> generateParenthesis(int n) {
            String curr = "";
            solve(curr,n);
            return res;
        }
}