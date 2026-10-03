class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> indexStack = new Stack<>();
        Stack<Character> characterStack = new Stack<>();

        indexStack.push(-1);

        int maxLength = 0;

        for(int i = 0; i < s.length(); i++){
           if(s.charAt(i) == '('){
              indexStack.push(i);
              characterStack.push('(');
           }else{
              if(!characterStack.isEmpty() && characterStack.peek() == '('){
                  characterStack.pop();
                  indexStack.pop();
                  int len = i - indexStack.peek();
                  maxLength = Math.max(maxLength,len);
              }else{
                 indexStack.push(i);
              }
           }
        }
        return maxLength;
    }
}