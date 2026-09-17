class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right;
        int freq[] = new int[26];
        int ans = 0;
        int maxFreq = 0;

        for(right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            freq[ch-'A']++;
            maxFreq = Math.max(maxFreq, freq[ch-'A']);

            while((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left)-'A']--;
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
