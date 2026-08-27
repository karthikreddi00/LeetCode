class Solution {

    public String lexGreaterPermutation(String s, String target) {

        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int n = Math.min(s.length(), target.length());
        for (int i = 0; i < n; i++) {
            int cur = target.charAt(i) - 'a';
            if (freq[cur] == 0) {
                break;
            }
            freq[cur]--;
            sb.append(target.charAt(i));
        }
        for (int i = sb.length(); i < target.length(); i++) {
            int cur = target.charAt(i) - 'a';
            for (int j = cur + 1; j < 26; j++) {
                if (freq[j] > 0) {
                    sb.append((char) ('a' + j));
                    freq[j]--;
                    appendRemaining(sb, freq);
                    return sb.toString();
                }
            }
            break;
        }
        while (sb.length() > 0) {
            char last = sb.charAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            freq[last - 'a']++;
            int targetChar = target.charAt(sb.length()) - 'a';
            for (int j = targetChar + 1; j < 26; j++) {
                if (freq[j] > 0) {
                    sb.append((char) ('a' + j));
                    freq[j]--;
                    appendRemaining(sb, freq);
                    return sb.toString();
                }
            }
        }
        return "";
    }
    private void appendRemaining(StringBuilder sb, int[] freq) {
        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                sb.append((char) ('a' + i));
                freq[i]--;
            }
        }
    }
}