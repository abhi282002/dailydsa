class Solution {
    public int scoreOfParentheses(String s) {
        
        int n = s.length();
        
        int score = 0;
        
        Stack<Integer> st = new Stack<>();
   
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '('){
                st.push(score);
                score = 0;
            }else{
                if(s.charAt(i - 1) == '('){
                    score = st.peek() + 1;
                }else{
                    score = st.peek() + (2 * score);
                }
                st.pop();
            }
        }

        return score;
    }
}