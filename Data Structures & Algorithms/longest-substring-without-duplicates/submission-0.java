class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0;
        boolean vis[] = new boolean[128];
        int maxLen = 0;
        while(r < s.length()) {

            if(!vis[s.charAt(r)]) {
                vis[s.charAt(r)] = true;
                maxLen = Math.max(maxLen, r - l + 1);
                r++;
            } else {
                vis[s.charAt(l)] = false;
                l++;
            }
        }

        return maxLen;
    }
}
