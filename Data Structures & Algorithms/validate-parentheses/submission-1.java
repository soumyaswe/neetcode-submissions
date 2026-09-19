class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0) return true;

        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()) {
            if(ch == '(' || ch == '{' || ch == '[') 
                st.push(ch);
            else if(ch == ')' || ch == '}' || ch == ']') {
                if(st.isEmpty())
                    return false;
                
                if((ch == ')' && st.peek() != '(') || (ch == '}' && st.peek() != '{') || 
                    (ch == ']' && st.peek() != '['))
                    return false;
                else
                    st.pop();
            }
        }

        return st.isEmpty();
    }
}
